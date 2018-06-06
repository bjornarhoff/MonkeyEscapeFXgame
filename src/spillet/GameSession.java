package spillet;

import Controller.MenuController;
import javafx.animation.AnimationTimer;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import spillet.Levels.LevelFour;
import spillet.Levels.LevelOne;
import spillet.Levels.LevelThree;
import spillet.Levels.LevelTwo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Klasse som generer en gamesession. Her blir alle objekten instansiert og et objekt av typen
 * gamesession blir startet ved spillets start. Denne klassen inneholder motoren til spillet.
 */
public class GameSession {

    private MenuController controller;
    private String gameState;
    private Pane gameView;
    private ObservableList<Node> nodeList;
    public Canvas canvas;
    public AnimationTimer timer;
    private GraphicsContext gc;
    private final int WIDTH = 650;
    private final int HEIGHT = 650;
    private Monkey monkey;
    private long timeLstFrm;
    private ArrayList<String> collision = new ArrayList<>();
    private LevelOne levelOne = new LevelOne();
    private LevelTwo levelTwo = new LevelTwo();
    private LevelFour levelFour = new LevelFour();
    private LevelThree levelThree = new LevelThree();
    private int currentLevel = 1;
    private int score = 0;
    private GameState save = new GameState();
    private static AudioClip sound = new AudioClip(GameSession.class.getResource("/Audio/sound.mp3").toString());
    private static AudioClip clip = new AudioClip(GameSession.class.getResource("/Audio/power.mp3").toString());


    /**
     * Constructor for gamesession
     * @param gameView pane
     * @param controller meny
     */
    public GameSession(Pane gameView, MenuController controller) {
        this.gameView = gameView;
        this.nodeList = gameView.getChildren();
        this.gameState = "running";
        this.controller = controller;

        sound.setCycleCount(AudioClip.INDEFINITE);
        sound.play();
        setScene();
        Timer();
    }

    /**
     * Animation timer
     */
    private void Timer() {
        timer = new AnimationTimer() {

            @Override
            public void handle(long now) {


                if (System.nanoTime() - timeLstFrm > 1E9 / 60) {

                    Input.Input(gameView.getScene());
                    handleGameStateInput(Input.getInput());

                    if (gameState.equals("running")) {
                        renderLevel();
                        monkey.move(Input.getInput(), getGS(), collision);
                        timeLstFrm = System.nanoTime();
                        save.setGameState(score, currentLevel, monkey.getX(), monkey.getY(), levelOne.getFruitList(),
                                levelTwo.getFruitList(), levelThree.getFruitList(), levelFour.getFruitList());
                    }
                }
            }
        };
        timer.start();
    }

    /**
     * Denne metoden danner layoyt-pane som man legger canvas og dermed animasjonene.
     *
     */
    public void setScene() {
        Pane pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);

        for (Node node : nodeList) {
            if (("gameCanvas").equals(node.getId())) {
                this.canvas = (Canvas) node;
            }
            setNodeVisible("gameCanvas");
        }

        gc = canvas.getGraphicsContext2D();
        monkey = new Monkey(15, 15);
    }

    /**
     * Denne metoden itererer gjennom nodelisten og setter metoden som synlig eller ikke.
     *
     * @param nodeID fxID for noden som skal settes synlig elelr ikke.
     */
    private void setNodeVisible(String nodeID) {
        for (Node node : nodeList) {
            if (nodeID.equals(node.getId())) {
                node.setVisible(true);
            } else {
                node.setVisible(false);
            }
        }
    }

    /**
     * Metode som fjerner og reanimerer levelet fra currentLevel og
     * animerer avataren (currentLevel).
     */
    public void renderLevel() {
        gc.clearRect(0, 0, WIDTH, HEIGHT);
        gc.fillRect(0, 0, WIDTH, HEIGHT);
        gc.setFill(Color.BLACK);


        if (getCurrentLevel() == 1) {
            levelIterator(levelOne.getWallList(), levelOne.getFruitList(), levelOne.getEnemyList(), levelOne.getGate(), 2, 585, 10);
            levelOne.getGate().render(gc);
        } else if (getCurrentLevel() == 2) {
            levelIterator(levelTwo.getWallList(), levelTwo.getFruitList(), levelTwo.getEnemyList(), levelTwo.getGate(), 3, 575, 550);
            levelTwo.getGate().render(gc);
        } else if (getCurrentLevel() == 3) {
            levelIterator(levelThree.getWallList(), levelThree.getFruitList(), levelThree.getEnemyList(), levelThree.getGate(), 4, 580, 595);
            levelThree.getGate().render(gc);
        } else if (getCurrentLevel() == 4) {
            levelIterator(levelFour.getWallList(), levelFour.getFruitList(), levelFour.getEnemyList(), levelFour.getGate(), 1, 10, 10);
            levelFour.getGate().render(gc);
        }
        // Tegner avatar
        monkey.render(gc);

    }


    /**
     * Denne metoden tar inn arraylister med objekter som skal animeres fra currentLevel. Den innholder
     * i tillegg parametere for hvor apen skal animeres da man progresserer til neste level.
     *
     * @param wallArrayList - liste med vegger
     * @param fruitArrayList - liste med frukter
     * @param enemyArrayList - liste med fiender
     * @param gate - gateobjekt
     * @param level - currentLevel
     * @param x x-posisjon
     * @param y y-posisjon
     */
    public void levelIterator(ArrayList<Wall> wallArrayList, ArrayList<Fruit> fruitArrayList, ArrayList<Enemy> enemyArrayList, Gate gate, int level, double x, double y) {
        wallArrayList.forEach(p -> p.render(gc));
        fruitArrayList.forEach(p -> p.render(gc));
        enemyArrayList.forEach(p -> p.render(gc));
        gate.render(gc);

        collisionIterator(wallArrayList);
        fruitIterator(fruitArrayList);
        enemyIterator(enemyArrayList);
        gateCollision(gate, level, x, y);
    }

    /**
     * Denne metoden gir logikken for kollisjon med portene til neste level. Gitt at alle bananer er samlet inn (score = 500)
     * vil man bli sendt til neste level. Den innholder i tillegg logikken for kollisjon med siste port som gir noden "Win".
     *
     * @param gate gateobjekt
     * @param level currentLevel
     * @param x x-posisjon
     * @param y y-posisjon
     */
    public void gateCollision(Gate gate, int level, double x, double y) {
        if (monkey.collide(gate) && score > 400 && (currentLevel == 1 || currentLevel == 2 || currentLevel == 3)) {
            setCurrentLevel(level);
            monkey.setX(x);
            monkey.setY(y);
            score = 0;
        } else if (monkey.collide(gate) && currentLevel == 4 && score > 400) {
            setNodeVisible("Win");
        }

        if (score == 500) {
            Image image = new Image("IMG/opengate.png");
            gate.setImage(image);
        }

        if (monkey.collisionLeft(gate) && score < 500) {
            collision.add("CollisionLeft");
        }

        if (monkey.collisionRight(gate) && score < 500) {
            collision.add("CollisionRight");
        }

        if (monkey.collisionBottom(gate) && score < 500) {
            collision.add("CollisionBottom");
        }

        if (monkey.collisionTop(gate) && score < 500) {
            collision.add("CollisionTop");
        }
    }


    /**
     * Denne metoden itererer gjennom arraylistene med vegger og detekterer kollisjon mellom spiller og vegg og setter
     * kollisjon som blir brukt i metoden for bevegelse av avataren.
     *
     * @param wallList liste med vegger
     */
    public void collisionIterator(ArrayList<Wall> wallList) {
        collision.clear();
        Iterator<Wall> hinderIterator = wallList.iterator();
        while (hinderIterator.hasNext()) {

            Wall wall = hinderIterator.next();

            if (monkey.collisionLeft(wall)) {
                collision.add("CollisionLeft");
            }

            if (monkey.collisionRight(wall)) {
                collision.add("CollisionRight");
            }

            if (monkey.collisionBottom(wall)) {
                collision.add("CollisionBottom");
            }

            if (monkey.collisionTop(wall)) {
                collision.add("CollisionTop");
            }
        }
    }

    /**
     * Denne metoden itererer gjennom listen av frukter og detekterer kollisjon mellom frukt og spiller.
     * Ved kollisjon vil frukten forsvinne og inkrementere score med 100.
     *
     * @param fruitList liste med frukter
     */
    public void fruitIterator(ArrayList<Fruit> fruitList) {
        Iterator<Fruit> fruktIterator = fruitList.iterator();
        while (fruktIterator.hasNext()) {
            Fruit fruit = fruktIterator.next();

            if (monkey.collide(fruit) && fruit.getExist()) {
                fruit.setExist(false);
                bananaSound();
                fruit.getExist();
                score += 100;
            }
        }
    }

    /**
     * Denne metoden itererer gjennom en liste med Strings returnert fra fil og setter om fruktene fantes ved lagring eller ikke.
     *
     * @param fruitList liste med frukter
     * @param fruitGetter String array med statusen til frukter
     */
    public void fruitSetter(ArrayList<Fruit> fruitList, String[] fruitGetter) {

        int x = 0;
        Iterator<Fruit> fruktIterator = fruitList.iterator();
        while (fruktIterator.hasNext()) {
            Fruit fruit = fruktIterator.next();

            fruit.setExist(Boolean.parseBoolean(fruitGetter[x]));
            x++;
        }
    }

    /**
     * Denne metoden iterer gjennom fiender og starter metoden for patruljering til hver enkelt, samt
     * styrer logikken for hva som skjer ved kollisjon mellom spiller og fiender.
     *
     * @param enemyList liste med fiender
     */
    public void enemyIterator(ArrayList<Enemy> enemyList) {
        Iterator<Enemy> fiendeIterator = enemyList.iterator();
        while (fiendeIterator.hasNext()) {
            Enemy enemy = fiendeIterator.next();

            enemy.bounce();

            if (monkey.collide(enemy)) {
                score = 0;
                timer.stop();

                for (Node node : nodeList) {
                    if (("gameOver").equals(node.getId())) {
                        node.setVisible(true);
                        canvas.setVisible(false);
                        timer.stop();
                        sound.stop();
                    }
                }
            }
        }
    }

    /**
     * Setter currentLevel
     *
     * @param currentLevel currentLevel
     */
    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    /**
     * Setter score
     *
     * @param score score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Getter currentLevel
     *
     * @return currentLevel
     */
    public int getCurrentLevel() {
        return this.currentLevel;
    }

    /**
     * Spiller av en lyd da bananer samles inn.
     */
    private void bananaSound() {
        clip.play();
    }


    /**
     *
     * Arraylist som sjekker input. Pauser spillet (til menyen)
     * @param input gamestate
     */
    public void handleGameStateInput(ArrayList<String> input) {
        for (String string : input) {
            if ((string.equals("p") || string.equals("P") || string.equals("ESCAPE")) && gameState.equals("running")) {
                pause();
                setNodeVisible("ingameMenuButtons");
            }
        }
    }

    /**
     * Pause method
     */
    public void pause() {
        if (gameState.equals("running")) {
            gameState = "pause";
            sound.stop();
        } else {
            gameState = "running";
            sound.play();
        }
    }

    /**
     * Denne metoden lagrer spillet i GameState klassen og skriver gamestate til fil.
     * Metoden tar inn int i som parameter som gir hvilken knapp som har blitt pressed
     * og dermed hvilken fil som skal skrives til.
     *
     * @param i hvilken save man skal save i
     */
    public void saveGame(int i) {
        save.saveGame(i);
    }

    /**
     * Denne metoden lagrer spillet i GameState klassen og skriver gamestate til fil.
     * Metoden tar inn int i som parameter som gir hvilken knapp som har blitt pressed
     * og dermed hvilekn fil som skal leses fra.
     * Det som returneres settes i gamesession.
     *
     * @param i hvilken save man skal save i
     */
    public void loadGame(int i) {
        save.loadGame(i);
        setCurrentLevel(save.getCurrentLevel());
        setScore(save.getScore());
        monkey.setX(save.getMonkeyX());
        monkey.setY(save.getMonkeyY());
        fruitSetter(levelOne.getFruitList(), save.getFruitLevelOne());
        fruitSetter(levelTwo.getFruitList(), save.getFruitLevelTwo());
        fruitSetter(levelThree.getFruitList(), save.getFruitLevelThree());
        fruitSetter(levelFour.getFruitList(), save.getFruitLevelFour());
    }


    /**
     * Getter GameSession
     * @return GameSession
     */
    public GameSession getGS() {
        return this;
    }
}

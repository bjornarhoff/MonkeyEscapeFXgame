package spillet.Levels;

import spillet.Enemy;
import spillet.Fruit;
import spillet.Gate;
import spillet.Wall;

import java.io.Serializable;
import java.util.ArrayList;

public class LevelTwo implements Serializable {

    private final int WIDTH = 650;
    private final int HEIGHT = 650;
    private ArrayList<Wall> wallList;
    private ArrayList<Enemy> enemyList;
    private ArrayList<Fruit> fruitList;

    private Wall wall1, wall2, wall3, wall4, wall5, wall6, wall7, wall8, wall9, wall10, wall11, wall12, wall13, wall14, wall15,wall16,wall17;
    private Enemy enemy1, enemy2, enemy3, enemy4, enemy5, enemy6, enemy7;
    private Fruit fruit1, fruit2, fruit3, fruit4, fruit5;
    private Gate gate;

    public LevelTwo () {

        // MAP
        gate = new Gate(0,577,10,70);

        wall1 = new Wall(0, 0, 10, HEIGHT-65); // LEFT WALL
        wall2 = new Wall(0, 0, WIDTH, 10); // TOP WALL
        wall3 = new Wall(WIDTH - 10, 0, 10, HEIGHT); // RIGHT WALL
        wall4 = new Wall(0, 640, WIDTH, 10); // BOTTOM WAll

        wall5 = new Wall(580, 0, 10, 70); //  Entry wall
        wall6 = new Wall(430, 70, 160, 10); // Top right box
        wall7 = new Wall(430, 70, 10, 510); // Left side of right box
        wall8 = new Wall(60, 70, 320, 10); // Top horizontal wall
        wall9 = new Wall(370, 70, 10, 90); // Short vertical top middle
        wall10 = new Wall(370, 210, 10, 150); // Little longer vertical middle
        wall11= new Wall(370, 410, 10, 170); // Vertical down middle
        wall12 = new Wall(305, 150, 75, 10); // Very short horizontal top middle
        wall13 = new Wall(305, 150, 10, 130); // Vertical middle
        wall14 = new Wall(130, 350, 185, 160); // Box
        wall15 = new Wall(60, 70, 10, 210); // Vertical top left
        wall16 = new Wall(60, 350, 10, 230); // Vertical down left
        wall17 = new Wall(130, 570,240, 10); // Horizontal down left







        wallList = new ArrayList<>();
        wallList.add(wall1);
        wallList.add(wall2);
        wallList.add(wall3);
        wallList.add(wall4);
        wallList.add(wall5);
        wallList.add(wall6);
        wallList.add(wall7);
        wallList.add(wall8);
        wallList.add(wall9);
        wallList.add(wall10);
        wallList.add(wall11);
        wallList.add(wall12);
        wallList.add(wall13);
        wallList.add(wall14);
        wallList.add(wall15);
        wallList.add(wall16);
        wallList.add(wall17);



        // ENEMY
        enemy1 = new Enemy(10,290, 6,0,330,290);
        enemy2 = new Enemy(325, 168, 0,6, 300,520);
        enemy3 = new Enemy(15, 15, 9, 0, 540,15);
        enemy4 = new Enemy(460, 380, 0, 5, 450, 580);
        enemy5 = new Enemy(520, 240, 0, 5, 500, 400);
        enemy6 = new Enemy(600, 170, 0 , 5, 570, 340);
        enemy7 = new Enemy(600, 380, 0,5, 600, 580);

        enemyList = new ArrayList<>();
        enemyList.add(enemy1);
        enemyList.add(enemy2);
        enemyList.add(enemy3);
        enemyList.add(enemy4);
        enemyList.add(enemy5);
        enemyList.add(enemy6);
        enemyList.add(enemy7);


        // FRUITS
        fruit1 = new Fruit(600, 380);
        fruit2 = new Fruit(600 ,610);
        fruit3 = new Fruit( 540, 30);
        fruit4 = new Fruit(330,110);
        fruit5 = new Fruit(20,25);

        fruitList = new ArrayList<>();
        fruitList.add(fruit1);
        fruitList.add(fruit2);
        fruitList.add(fruit3);
        fruitList.add(fruit4);
        fruitList.add(fruit5);

    }

    public ArrayList<Wall> getWallList() {
        return wallList;
    }

    public ArrayList<Enemy> getEnemyList() {
        return enemyList;
    }

    public ArrayList<Fruit> getFruitList() {
        return fruitList;
    }

    public Gate getGate() {
        return gate;
    }
}


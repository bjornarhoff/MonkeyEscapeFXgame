package spillet.Levels;


import spillet.Enemy;
import spillet.Fruit;
import spillet.Gate;
import spillet.Wall;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Dette er et tentativt forsøk på å konstruere spillerbrettet utenfor launcherklassen "Launcher". Det skal etterhvert
 * opprettes en del spillerbrett og det vil være veldig bedre med en klasse som genererer disse.
 *
 * @Gaute, @Eirik, @Bjørnar
 */

public class LevelThree implements Serializable {

    private final int WIDTH = 650;
    private final int HEIGHT = 650;
    private ArrayList<Wall> wallList;
    private ArrayList<Enemy> enemyList;
    private ArrayList<Fruit> fruitList;

    private Wall wall1, wall2, wall3, wall4, wall5, wall6, wall7, wall8, wall9, wall10, wall11, wall12, wall13, wall14;
    private Enemy enemy1, enemy2, enemy3, enemy4, enemy5;
    private Fruit fruit1, fruit2, fruit3, fruit4, fruit5;
    private Gate gate;


    public LevelThree() {
        wall1 = new Wall(0, 0, WIDTH-80, 10); // TOP
        wall2 = new Wall( 640, 0, 10, HEIGHT); // Right wall
        wall3 = new Wall(0, 0, 10, HEIGHT); // Left wall
        wall4 = new Wall(0, 640, WIDTH, 10); // Bottom wall

        wall5 = new Wall(540, 580, 100, 10); // Entry horizontal bottom right


        gate = new Gate(570, 0, 70, 10); // Finish line


        wallList = new ArrayList<>();
        wallList.add(wall1);
        wallList.add(wall2);
        wallList.add(wall3);
        wallList.add(wall4);
        wallList.add(wall5);



        enemy1 = new Enemy(20,360, 7,0,320,400);  // Horizontal left
        enemy2 = new Enemy(165, 450, 2,7, 325,575); // Zig Zag in the box
        enemy3 = new Enemy(415, 135, 0, 5, 200,500); // Vertical middle lane
        enemy4 = new Enemy(500, 100, 4, 5, 575, 500); // Right side
        enemy5 = new Enemy(215, 20, 0, 4, 300, 135); // Top one

        enemyList = new ArrayList<>();
        enemyList.add(enemy1);
        enemyList.add(enemy2);
        enemyList.add(enemy3);
        enemyList.add(enemy4);
        enemyList.add(enemy5);


        fruit1 = new Fruit(175, 600); // Middle bottom box
        fruit2 = new Fruit(425 ,350); // Right middle vertical lane
        fruit3 = new Fruit( 550, 150); // Right side
        fruit4 = new Fruit(15,400); // Left middle
        fruit5 = new Fruit(35,600); // left bottom corner

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

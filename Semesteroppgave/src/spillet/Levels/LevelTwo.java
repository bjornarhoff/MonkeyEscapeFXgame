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
    private Enemy enemy1, enemy2, enemy3;
    private Fruit fruit1, fruit2, fruit3, fruit4, fruit5;
    private Gate gate;

    public LevelTwo () {

        // MAP
        gate = new Gate(0,530,10,100);

        wall1 = new Wall(0, 0, 10, HEIGHT); // LEFT WALL
        wall2 = new Wall(80, 0, WIDTH, 10); // TOP WALL
        wall3 = new Wall(WIDTH - 10, 0, 10, HEIGHT); // RIGHT WALL
        wall4 = new Wall(0, HEIGHT - 10, 575, 10); // BOTTOM WAll

        wall5 = new Wall(80, 0, 10, 200);
        wall6 = new Wall(80, 510, 10, 70);
        wall7 = new Wall(155, 370, 160, 10);
        wall8 = new Wall(155, 370, 10, 120);
        wall9 = new Wall(190, 80, 10, 190);
        wall10 = new Wall(315, 180, 10, 200);
        wall11 = new Wall(540, 80, 10, 200);
        wall12 = new Wall(440, 130, 10, 100);
        wall13 = new Wall(283, 520, 200, 10);
        wall14 = new Wall(283, 450, 10, 130);
        wall15 = new Wall(540, 410, 100, 10);
        wall16 = new Wall (565,550,10,90 );
        wall17 = new Wall (400,350,80,10);

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
        enemy1 = new Enemy(20,440, 7,0,320,400);
        enemy2 = new Enemy(320, 168, 0,6, 300,600);
        enemy3 = new Enemy(200, 100, 0, 4, 200,500);

        enemyList = new ArrayList<>();
        enemyList.add(enemy1);
        enemyList.add(enemy2);
        enemyList.add(enemy3);


        // FRUITS
        fruit1 = new Fruit(450, 450);
        fruit2 = new Fruit(420 ,100);
        fruit3 = new Fruit( 50, 300);
        fruit4 = new Fruit(10,400);
        fruit5 = new Fruit(100,500);

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


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

    private Wall wall1, wall2, wall3, wall4, wall5, wall6, wall7, wall8, wall9, wall10, wall11, wall12, wall13, wall14, wall15, wall16, wall17, wall18, wall19, wall20, wall21, wall22, wall23, wall24, wall25, wall26, wall27, wall28, wall29, wall30;
    private Enemy enemy1, enemy2, enemy3, enemy4, enemy5;
    private Fruit fruit1, fruit2, fruit3, fruit4, fruit5;
    private Gate gate;


    public LevelThree() {
        wall1 = new Wall(0, 0, WIDTH-80, 10); // TOP
        wall2 = new Wall( 640, 0, 10, HEIGHT); // Right wall
        wall3 = new Wall(0, 0, 10, HEIGHT); // Left wall
        wall4 = new Wall(0, 640, WIDTH, 10); // Bottom wall

        wall5 = new Wall(400, 580, 240, 10); // Entry horizontal bottom right
        wall6 = new Wall(475, 0, 10, 300); // Long vertical  up right
        wall7 = new Wall(475, 350, 10, 180); // Long vertical down right
        wall8 = new Wall(200, 580, 150, 10); // Horizontal down middle
        wall9 = new Wall(60, 580, 90, 10); // Horizontal down left
        wall10 = new Wall(60, 450, 10, 130); // Vertical down left
        wall11 = new Wall(60, 260, 10, 140); // Vertical middle left
        wall12 = new Wall(60, 80, 10, 110); // Vertical top left
        wall13 = new Wall(120, 80, 100, 10); // Horizontal top left
        wall14 = new Wall(270, 80, 120, 10); // Horizontal top middle
        wall15 = new Wall(270, 90, 10, 50); // Short vertical middle
        wall16 = new Wall(270, 140, 205, 10); // Horizontal top right
        wall17 = new Wall(120, 140, 100, 10); // Horizontal second top middle
        wall18 = new Wall(120, 140, 10, 50); // Vertical second top left
        wall19 = new Wall(220, 140, 10, 60); // Vertical top second middle
        wall20 = new Wall(220, 200, 205, 10); // Horizontal up middle
        wall21 = new Wall(415, 140, 10, 60); // Short vertical right middle
        wall22 = new Wall(320, 200, 10, 60); // Short vertical middle divider
        wall23 = new Wall(120, 260, 50, 10); // Short vertical left middle
        wall24 = new Wall(220, 260, 150, 10); // Horizontal bottom divider middle





        gate = new Gate(570, 0, 70, 10); // Finish line


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
        wallList.add(wall18);
        wallList.add(wall19);
        wallList.add(wall20);
        wallList.add(wall21);
        wallList.add(wall22);
        wallList.add(wall23);
        wallList.add(wall24);




        enemy1 = new Enemy(75,80, 0,4,75,500);  // Horizontal left
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

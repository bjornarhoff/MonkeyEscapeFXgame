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

public class LevelOne implements Serializable {

    private final int WIDTH = 650;
    private final int HEIGHT = 650;
    private ArrayList<Wall> wallList;
    private ArrayList<Enemy> enemyList;
    private ArrayList<Fruit> fruitList;

    private Wall wall1, wall2, wall3, wall4, wall5, wall6, wall7, wall8, wall9, wall10, wall11, wall12, wall13, wall14, wall15, wall16, wall17, wall18, wall19;
    private Enemy enemy1, enemy2, enemy3,enemy4,enemy5;
    private Fruit fruit1, fruit2, fruit3, fruit4, fruit5;
    private Gate gate;

    public LevelOne() {

        // MAP
        gate = new Gate(570,640,70,10);

        wall1 = new Wall(0, 0, 10, HEIGHT);  // Left wall
        wall2 = new Wall(0, 0, WIDTH, 10); // Top wall
        wall3 = new Wall(WIDTH - 10, 0, 10, HEIGHT); // Right wall
        wall4 = new Wall(0, HEIGHT - 10, 575, 10); // Bottom wall

        wall5 = new Wall(60, 0, 10, 185); // Entry vertical wall
        wall6 = new Wall(60, 235, 10, 150); // Vertical left side
        wall7 = new Wall(0, 435, 150, 10); // horizontal left side
        wall8 = new Wall(200, 435, 140, 10); // Horizontal down middle
        wall9 = new Wall(0, 500, 115, 10); // Horizontal down left
        wall10 = new Wall(165, 500, 115, 10); // horizontal downdown middle
        wall11 = new Wall(330, 435, 10, 155); // Vertical down middle
        wall12 = new Wall(165, 500, 10, 140); // Vertical down left
        wall13 = new Wall(480, 200, 10, 450); // Vertical right side of box
        wall14 = new Wall(330, 200, 10, 185); // Left side of box
        wall15 = new Wall(330, 200, 150, 10); // Top of box
        wall16 = new Wall(120, 130, 160, 255); // Big box


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





        // ENEMY
        enemy1 = new Enemy(20,450, 6,0,290,400);
        enemy2 = new Enemy(290, 10, 0, 5, 290, 380);
        enemy3 = new Enemy(350, 210, 5, 3, 440, 590);


        enemyList = new ArrayList<>();
        enemyList.add(enemy1);
        enemyList.add(enemy2);
        enemyList.add(enemy3);



        // FRUIT
        fruit1 = new Fruit(590, 460);
        fruit2 = new Fruit(430 ,305);
        fruit3 = new Fruit( 595, 95);
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

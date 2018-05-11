package spillet.Levels;


import spillet.Enemy;
import spillet.Fruit;
import spillet.Wall;

import java.util.ArrayList;

/**
 * Dette er et tentativt forsøk på å konstruere spillerbrettet utenfor launcherklassen "Launcher". Det skal etterhvert
 * opprettes en del spillerbrett og det vil være veldig bedre med en klasse som genererer disse.
 *
 * @Gaute, @Eirik, @Bjørnar
 */

public class LevelThree {

    private final int WIDTH = 650;
    private final int HEIGHT = 650;
    private ArrayList<Wall> wallList;
    private ArrayList<Enemy> enemyList;
    private ArrayList<Fruit> fruitList;

    private Wall wall1, wall2, wall3, wall4, wall5, wall6, wall7, wall8, wall9, wall10, wall11, wall12, wall13, wall14;
    private Enemy enemy1, enemy2, enemy3, enemy4, enemy5;
    private Fruit fruit1, fruit2, fruit3, fruit4, fruit5;


    public LevelThree() {
        wall1 = new Wall(85, 0, WIDTH, 10); // TOP
        wall2 = new Wall(WIDTH - 10, 0, 10, HEIGHT); // Right wall
        wall3 = new Wall(0, 0, 10, HEIGHT); // Left wall
        wall4 = new Wall(0, HEIGHT - 10, 575, 10); // Bottom wall

        wall5 = new Wall(75, 500, 10, 250);  // Left bottom corner
        wall6 = new Wall(150, 425, 10, 250); // Second left bottom corner
        wall7 = new Wall(0, 425, 75, 10); // Short one, left bottom corner
        wall8 = new Wall(85, 0, 10, 150); // Top left corner
        wall9 = new Wall(385, 315, 10, 250); // Vertical right side of the bottom box
        wall10 = new Wall(225, 425, 160, 10); // Horizontal top of the bottom box
        wall11 = new Wall(485, 125, 10, 440); // Long vertical right side
        wall12 = new Wall(170, 200, 225, 115); // Big box
        wall13 = new Wall(385, 125, 10, 85); // Little one on top of box
        // wall14 = new Wall(0, 0, 85, 10); // Finish line


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
        //wallList.add(wall14);


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
}

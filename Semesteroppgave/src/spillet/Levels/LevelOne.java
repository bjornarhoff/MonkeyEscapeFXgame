package spillet.Levels;


import spillet.Enemy;
import spillet.Fruit;
import spillet.Gate;
import spillet.Wall;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Dette er klassen som generer level 1 i spillet
 *
 * @Gaute, @Eirik, @Bjørnar
 */
public class LevelOne implements Serializable {

    private final int WIDTH = 650;
    private final int HEIGHT = 650;
    private ArrayList<Wall> wallList;
    private ArrayList<Enemy> enemyList;
    private ArrayList<Fruit> fruitList;

    private Wall wall1, wall2, wall3, wall4, wall5, wall6, wall7, wall8, wall9, wall10, wall11, wall12, wall13, wall14, wall15, wall16, wall17, wall18, wall19, wall20, wall21, wall22;
    private Enemy enemy1, enemy2, enemy3,enemy4,enemy5, enemy6;
    private Fruit fruit1, fruit2, fruit3, fruit4, fruit5;
    private Gate gate;

    /**
     * Konstruktør som instansierer objektene i level 1. Vegger, porter, frukter blir generert og puttet i arraylister.
     */
    public LevelOne() {
        gate = new Gate(570,640,70,10);

        wall1 = new Wall(0, 0, 10, HEIGHT);  // Left wall
        wall2 = new Wall(0, 0, WIDTH, 10); // Top wall
        wall3 = new Wall(WIDTH - 10, 0, 10, HEIGHT); // Right wall
        wall4 = new Wall(0, HEIGHT - 10, 570, 10); // Bottom wall

        wall5 = new Wall(60, 10, 10, 175); // Entry vertical wall
        wall6 = new Wall(60, 235, 10, 150); // Vertical left side
        wall7 = new Wall(10, 435, 140, 10); // horizontal left side
        wall8 = new Wall(200, 435, 140, 10); // Horizontal down middle
        wall9 = new Wall(10, 500, 105, 10); // Horizontal down left
        wall10 = new Wall(165, 500, 115, 10); // horizontal downdown middle
        wall11 = new Wall(330, 435, 10, 155); // Vertical down middle
        wall12 = new Wall(165, 500, 10, 140); // Vertical down left
        wall13 = new Wall(480, 200, 10, 440); // Vertical right side of box
        wall14 = new Wall(330, 200, 10, 185); // Left side of box
        wall15 = new Wall(330, 200, 150, 10); // Top of box
        wall16 = new Wall(120, 130, 160, 255); // Big box
        wall17 = new Wall(410, 10, 10, 70); // Top middle
        wall18 = new Wall(410, 130, 10, 70); // Top low middle
        wall19 = new Wall(350, 70, 10, 70); // Short vertical top middle
        wall20 = new Wall(480, 70, 10, 70); // Top of little box up right
        wall21 = new Wall(480, 70, 100, 10); // Vertical little box up right
        wall22 = new Wall(480, 130, 100, 10); //Bottom of little box up right

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

        enemy1 = new Enemy(20,450, 6,0,290,400);
        enemy2 = new Enemy(290, 10, 0, 5, 290, 380);
        enemy3 = new Enemy(350, 210, 5, 3, 440, 590);
        enemy4 = new Enemy(80, 10, 0, 5,130, 380);
        enemy5 = new Enemy(600, 15, 0, 3, 600, 150);
        enemy6 = new Enemy(500, 200, 6,4, 600, 590);

        enemyList = new ArrayList<>();
        enemyList.add(enemy1);
        enemyList.add(enemy2);
        enemyList.add(enemy3);
        enemyList.add(enemy4);
        enemyList.add(enemy5);
        enemyList.add(enemy6);

        fruit1 = new Fruit(15, 610); // Bottom left
        fruit2 = new Fruit(180 ,610); // Bottom middle
        fruit3 = new Fruit( 80, 15); // Top left
        fruit4 = new Fruit(440,220); // Middle right
        fruit5 = new Fruit(500,90); // Top right

        fruitList = new ArrayList<>();
        fruitList.add(fruit1);
        fruitList.add(fruit2);
        fruitList.add(fruit3);
        fruitList.add(fruit4);
        fruitList.add(fruit5);
    }

    /**
     * Returnerer arraylisten med vegger
     * @return ArraList<Wall>
     */
    public ArrayList<Wall> getWallList() {
        return wallList;
    }

    /**
     * Returnerer arraylisten med fiender
     * @return ArraList<Enemy>
     */
    public ArrayList<Enemy> getEnemyList() {
        return enemyList;
    }

    /**
     * Returnerer arraylisten med vegger
     * @return ArraList<Fruit>
     */
    public ArrayList<Fruit> getFruitList() {
        return fruitList;
    }

    /**
     * Returnerer porten til neste nivå
     * @return Gate
     */
    public Gate getGate() {
        return gate;
    }
}

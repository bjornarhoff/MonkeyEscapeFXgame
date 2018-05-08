package spillet;


import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Dette er et tentativt forsøk på å konstruere spillerbrettet utenfor launcherklassen "main". Det skal etterhvert
 * opprettes en del spillerbrett og det vil være veldig bedre med en klasse som genererer disse.
 *
 * @Gaute, @Eirik, @Bjørnar
 */

public class LevelOne {

    private final int WIDTH = 650;
    private final int HEIGHT = 650;
    private ArrayList<Hinder> bane;
    private ArrayList<Fiende> fiende;
    private ArrayList<Frukt> frukt;

    private Hinder tre1, tre2, tre3, tre4, tre5, tre6, tre7, tre8, tre9, tre10, tre11, tre12, tre13, tre14, tre15;
    private Fiende fiende1, fiende2,fiende3;
    private Frukt frukt1,frukt2,frukt3,frukt4,frukt5;


    public LevelOne() {

        tre1 = new Hinder(111, 500, 10, 150);
        tre2 = new Hinder(0, 396, 290, 10);
        tre3 = new Hinder(0, 0, 10, HEIGHT);
        tre4 = new Hinder(210, 550, 110, 10);
        tre5 = new Hinder(0, 0, WIDTH, 10);
        tre6 = new Hinder(WIDTH - 10, 0, 10, HEIGHT);
        tre7 = new Hinder(0, HEIGHT - 10, 575, 10);
        tre8 = new Hinder(200, 190, 10, 70);
        tre9 = new Hinder(103, 85, 10, 100);
        tre10 = new Hinder(280, 145, 220, 10);
        tre11 = new Hinder(570, 75, 10, 100);
        tre12 = new Hinder(510, 420, 50, 10);
        tre13 = new Hinder(550, 520, 100, 10);
        tre14 = new Hinder(400, 270, 10, 400);
        tre15= new Hinder(575, 610, 10, 40);

        bane = new ArrayList<>();
        bane.add(tre1);
        bane.add(tre2);
        bane.add(tre3);
        bane.add(tre4);
        bane.add(tre5);
        bane.add(tre6);
        bane.add(tre7);
        bane.add(tre8);
        bane.add(tre9);
        bane.add(tre10);
        bane.add(tre11);
        bane.add(tre12);
        bane.add(tre13);
        bane.add(tre14);
        bane.add(tre15);

        fiende1 = new Fiende(20,440, 7,0,320,400);
        fiende2 = new Fiende (320, 168, 0,6, 300,600);
        fiende3 = new Fiende (200, 100, 0, 4, 200,500);

        fiende = new ArrayList<>();
        fiende.add(fiende1);
        fiende.add(fiende2);
        fiende.add(fiende3);


        frukt1 = new Frukt(450, 450);
        frukt2 = new Frukt(420 ,100);
        frukt3 = new Frukt( 50, 300);
        frukt4 = new Frukt(10,400);
        frukt5 = new Frukt(100,500);

        frukt = new ArrayList<>();
        frukt.add(frukt1);
        frukt.add(frukt2);
        frukt.add(frukt3);
        frukt.add(frukt4);
        frukt.add(frukt5);

    }

    public ArrayList<Hinder> getBane() {
        return bane;
    }

    public ArrayList<Fiende> getFiende() {
        return fiende;
    }

    public ArrayList<Frukt> getFrukt() {
        return frukt;
    }
}

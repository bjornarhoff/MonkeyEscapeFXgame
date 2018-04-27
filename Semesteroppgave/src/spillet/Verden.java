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

public class Verden {


    private List<Hinder> bane = new ArrayList<>();

    private Hinder tre1, tre2, tre3, tre4, tre5, tre6, tre7, tre8, tre9, tre10, tre11, tre12, tre13, tre14, tre15;


    public void Verden() {

    tre1 = new Hinder(111, 500, 10, 150);
    tre2 = new Hinder(0, 396, 290, 10);
    bane.add(tre1);
    bane.add(tre2);
    }

    public void animer(GraphicsContext gc) {
        bane.forEach(p -> p.render(gc));
    }



}

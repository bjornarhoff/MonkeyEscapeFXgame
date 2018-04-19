package Launcher;

import Display.Display;
import GFX.SpriteSheet;
import KeyControl.KeyInput;
import States.GameState;
import States.State;

import javax.net.ssl.KeyManager;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

    public String title;
    public int width, height;
    private boolean runTime;

    private Display display;
    public Thread thread;

    private BufferStrategy bs;
    private Graphics g;
    private BufferedImage image;
    private SpriteSheet spriteSheet;
    private KeyInput keyInput;



    // States
    private State gameState;


        // Konstruktør
    public Game (String title, int width, int height) {
        this.title=title;
        this.width = width;
        this.height = height;
        keyInput = new KeyInput();

    }


        // Thread
    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyInput);
        image = GFX.ImageLoader.loadImage("/Images/monkey.png");
        // spriteSheet = new SpriteSheet(image);
        // gameState = new GameState();

    }


        // Oppdaterer variable etc
    private void update () {
        keyInput.update();

    }


        // "Tegner" på nytt
    private void draw (){
        bs = display.getCanvas().getBufferStrategy(); // BufferStrategy(forteller pc hvordan den skal tegne)
        if(bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g=bs.getDrawGraphics(); // DrawGraphics kan tegne det meste

        // Tegner
        g.setColor(Color.red);
        g.fillRect(0,0,width,height);
        g.setColor(Color.yellow);
        g.fillOval(300,300,50,50);
        g.drawLine(50,70,10,22);
        g.draw3DRect(400,300,140,130,true);
        g.setColor(Color.blue);
        g.fillRect(111,90,100,120);

        g.drawImage(image,50,50,50,50,null);
       // g.drawImage(spriteSheet.cut(100,50,200,200),5,5, 50,50,null);



        // Viser til skjerm
        bs.show();
        g.dispose();
    }






    //  Gameloop
    public void run() {
        init();

        int fps = 60;
        double timePrTick = 1000000000/ fps;  // 1 sekund i nano.
        double delta = 0;
        long now;
        long nano = System.nanoTime(); // Returnerer nano tid på tiden nå
        long timer = 0;
        int ticks = 0;


        while (runTime) {
            now = System.nanoTime();
            delta += (now-nano)/ timePrTick; // Forteller når datamaskinen skal kalle på "draw" metoden
            timer += now - nano;
            nano = now;

            if(delta >= 1) {
                update();
                draw();
                ticks++;
                delta--;
            }

            // Sjekker om gameloop gir riktige verdier etter 1 sekund
            if (timer>=1000000000){
                System.out.println("Ticks and Frames: " + ticks);
                ticks=0;
                timer=0;
            }
        }

        stop();
    }



    public KeyInput getKeyInput() {
        return keyInput;
    }



    // Synchronized blir brukt på Threads direkte, sånn at ingenting går galt
    public synchronized void start() {
        if(runTime)
            return;
        runTime = true;
        thread = new Thread(this);
        thread.start(); // Kaller på metoden "Run" ovenfor
    }

    public synchronized void stop() {
        if(!runTime)
            return;
        runTime = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


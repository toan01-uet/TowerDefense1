package Game;

import Display.Display;
import Entity.Enemy;
import State.AbstractState;
import State.GameState;
import DrawImage.*;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

    ///for display
    private Display display;
    private int width;
    private String title;
    private int height;

    ///for thread+game loop
    private Thread thread;
    private boolean running = false;

    ///for image && graphic
    private BufferStrategy bs;
    private Graphics g;

    ///State
    private AbstractState gameState;


    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    public void init() {
        display = new Display(title, width, height);
        TileImage.init();
        gameState=new GameState(this);
        AbstractState.setCurrentState(gameState);
    }



    public void update() {
        if(AbstractState.getCurrentState()!=null){
            AbstractState.getCurrentState().update();
        }


    }

    public void draw() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        if(AbstractState.getCurrentState()!=null) {
            AbstractState.getCurrentState().draw(g);
        }

        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        /// get ready
        init();
        ///game loop
        int fps = 60;
        double timePerTick = 1000000000/fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks=0;
        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                update();
                draw();
                ticks++;
                delta--;
            }

            if (timer >= 1000000000) {
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
        stop();
    }


public synchronized void start() {
        if (running == true) return;
        running = true;
        thread = new Thread(this);
        thread.start();
        }

public synchronized void stop() {
        if (running == false) return;
        try {
        thread.join();
        } catch (InterruptedException e) {
        e.printStackTrace();
        }
        }
        }

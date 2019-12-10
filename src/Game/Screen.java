package Game;

import Entity.Bullet.Bullet;
import Entity.Enemy.BossEnemy;
import Entity.Enemy.Enemy;
import Entity.Enemy.ListEnemy;
import Entity.Tower.ListTower;
import Entity.Tower.Remove;
import Entity.Tower.Shop;
import Entity.Tower.Upgrade;
import Handler.MouseHandler;
import Map.Map;
import Map.SpawnPoint;
import Sound.Sound;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

public class Screen extends JPanel implements Runnable {

    public static int fpsFrame = 0, fps = 1000000;

    public Thread thread = new Thread(this);

    public static int myWidth, myHeight;

    public boolean isFirst = true;

    public static SpawnPoint spawnPoint;

    public static Map map;
    public static Frame frame;

    public ListEnemy listEnemy;
    public static ListTower listTower;

    public static Shop shop;
    public static Player player;
    public static Remove remove;
    public static Upgrade upgrade;
    public static Wave wave;
    public static int flagWave = 1;

    public int timeFrame = 1000, timeDelay = 1000;

    public static boolean isPauseGame = true;
    public static boolean running = true;

    public static int flagMenu = 0;
    public static PauseGame pauseGame;
    public static MenuGame menuGame;

    public static ArrayList<ArrayList<Bullet>> bullets = new ArrayList<>();


    public Screen(Frame frame) {
        this.frame = frame;
        thread.start();

        frame.addMouseListener(new MouseHandler());
        frame.addMouseMotionListener(new MouseHandler());

        menuGame = new MenuGame();
    }

    public void define() {
        map = new Map("Level/mission1.nhatminh");
        listEnemy = new ListEnemy();
        listTower = new ListTower();
        shop = new Shop();
        remove = new Remove();
        upgrade = new Upgrade();
        pauseGame = new PauseGame();
        wave = new Wave();

        player = new Player();
        spawnPoint = new SpawnPoint();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g.clearRect(0, 0, frame.getWidth(), frame.getHeight());

        if (isFirst) {
            myWidth = getWidth();
            myHeight = getHeight();
            Sound.play(Sound.backgroundSound);
            define();
        }
        isFirst = false;
        if (flagMenu == 1 || isPauseGame == false) {
            map.draw(g);

            if(flagWave == 1){
                listEnemy.setTimeBorn(200);
                listEnemy.setAmount(20);
                if (listEnemy.isCreateNewEnemy()) {
                    listEnemy.addEnemy(listEnemy.createSmallerEnemy());
                }
                System.out.println(listEnemy.enemyList.size());
                if(listEnemy.getNumberEnemyBorn() >= 20) {
                    listEnemy.setNumberEnemyBorn(0);
                    flagWave = 2;
                }
            } else if(flagWave == 2){
                listEnemy.setTimeBorn(300);
                listEnemy.setAmount(15);
                if (listEnemy.isCreateNewEnemy()) {
                    listEnemy.addEnemy(listEnemy.createNormalEnemy());
                }
                if(listEnemy.getNumberEnemyBorn() >= 15) {
                    listEnemy.setNumberEnemyBorn(0);
                    flagWave = 3;
                }
            } else if(flagWave == 3){
                listEnemy.setTimeBorn(400);
                listEnemy.setAmount(10);
                if (listEnemy.isCreateNewEnemy()) {
                    listEnemy.addEnemy(listEnemy.createTankerEnemy());
                }
                if(listEnemy.getNumberEnemyBorn() >= 10) {
                    listEnemy.setNumberEnemyBorn(0);
                    flagWave = 4;
                }
            } else if(flagWave == 4){
                listEnemy.setTimeBorn(500);
                listEnemy.setAmount(5);
                if (listEnemy.isCreateNewEnemy()) {
                    listEnemy.addEnemy(listEnemy.createBossEnemy());
                }
                if(listEnemy.getNumberEnemyBorn() >= 5) flagWave = 0;
            }

            if (!listEnemy.enemyList.isEmpty()) {
                listEnemy.delete();
                listEnemy.draw(g2d);
            }

            for (ArrayList<Bullet> bullet : bullets) {
                for (Bullet b : bullet) {

                    b.move();
                    b.draw(g2d);
                }
                if (!listTower.towerList.isEmpty()) {
                    listTower.attackEnemy(listEnemy.enemyList, bullet);
                    listTower.draw(g2d);
                }
                if (!listEnemy.enemyList.isEmpty()) {
                    listEnemy.beAttacked(bullet);
                }

            }

            shop.draw(g2d);
            remove.draw(g2d);
            upgrade.draw(g2d);
            pauseGame.draw(g2d);
            wave.draw(g2d);

        }
        if (flagMenu == 0 || flagMenu == 2 || flagMenu == 3 || isPauseGame == true || flagMenu == 4) {
            menuGame.draw(g2d);
        }
        if(player.health <= 0){
            flagMenu = 4;
        }
    }


    public void run() {
        while (running) {
            repaint();


            try {
                Thread.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
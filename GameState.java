package State;

import Entity.*;
import Game.Game;
import Map.map;

import java.awt.*;
import java.util.ArrayList;


public class GameState extends AbstractState {
    private ArrayList<Enemy> testEnemy = new ArrayList<Enemy>();
    private Tower testTower = new BasicTower(64*7,64*5);
//  private Tower testTower2= new BasicTower(64*7,64*7);
    private ArrayList<Bullet> bulletss= new ArrayList<>(100);
    private Map.map mapTest;
    public GameState(Game game) {
        super(game);
        mapTest = new map("res/map01.txt");
        for(int i=0;i<2;i++){
            testEnemy.add(new Plane(0,64*3,1+0.3*i));
        }
//        testTower.setTarget(testEnemy.get(0));
       testTower.setTarget(testEnemy.get(1));
//        testTower2.setTarget(testEnemy.get(0));
    }

    @Override
    public void update() {
        if(!testEnemy.isEmpty()) {
            for(int i=1;i>=0;i--){
                testEnemy.get(i).update();
                if(testEnemy.get(i).visible==false){
                    //testEnemy.remove(i);
                }
            }
        }
        testTower.update();
//        testTower2.update();

//       buttle.update(0
    }

    @Override
    public void draw(Graphics g) {
        mapTest.draw(g);
        if(!testEnemy.isEmpty()){
            for(int i=1;i>=0;i--){
                if(testEnemy.get(i).visible==true){
                    testEnemy.get(i).draw(g);
                }
            }
        }
        testTower.draw(g);
//        testTower2.draw(g);
    }



}

package Entity.Enemy;

import Entity.Bullet.Bullet;
import Game.Screen;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ListEnemy {
    public List<Enemy> enemyList = new ArrayList<>();

    int spawnTime = 1;
    int timeBorn;
    int amount = 15;
    int numberEnemyBorn = 0;

    public void addEnemy(Enemy enemy){
        enemy.inGame = true;
        enemyList.add(enemy);
    }

    public void delete(){
        for(int i = 0; i < enemyList.size(); i++){
            if(enemyList.get(i).getHp() <= 0){
                Screen.player.money += enemyList.get(i).getRewardMoney();
                enemyList.remove(i);
            }
        }
    }

    public boolean isCreateNewEnemy(){
        if(spawnTime -- == 0 && amount-- > 0){
            spawnTime = timeBorn;
            numberEnemyBorn++;
            return true;
        }
        return false;
    }

    public Enemy createNormalEnemy(){
        return new NormalEnemy(0, 0, 64, 64);
    }
    public Enemy createSmallerEnemy(){return new SmallerEnemy(0, 0, 64, 64);}
    public Enemy createTankerEnemy(){return new TankerEnemy(0, 0, 64, 64);}
    public Enemy createBossEnemy(){return new BossEnemy(0, 0, 64, 64);}

    public void draw(Graphics2D graphics2D){
        for(Enemy enemy : enemyList){
            enemy.draw(graphics2D);
        }
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public void beAttacked(ArrayList<Bullet> bullets) {
        for(Enemy enemy : enemyList){
            for(int i = 0; i < bullets.size(); i++){
                if(enemy.beAttacked(bullets.get(i))){
                    bullets.remove(i);
                }
            }
        }
    }

    public int getTimeBorn() {
        return timeBorn;
    }

    public void setTimeBorn(int timeBorn) {
        this.timeBorn = timeBorn;
    }

    public int getNumberEnemyBorn() {
        return numberEnemyBorn;
    }

    public void setNumberEnemyBorn(int numberEnemyBorn) {
        this.numberEnemyBorn = numberEnemyBorn;
    }
}

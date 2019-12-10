package Entity.Tower;

import Entity.Bullet.Bullet;
import Entity.Bullet.MachineGunTowerBullet;
import Entity.Bullet.NormalTowerBullet;
import Entity.Bullet.SniperTowerBullet;
import Entity.Enemy.Enemy;
import Game.Value;
import Sound.Sound;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class MachineGunTower extends Tower {

    private Image bodyTower = new ImageIcon("res/BodyMachineGunTower.png").getImage();
    private long timeAttack;


    public MachineGunTower(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.setType("MachineGunTower");
        this.setRange(Value.MACHINE_GUN_TOWER_RANGE);
        this.setAttackSpeed(Value.MACHINE_GUN_TOWER_ATTACK_SPEED);
        this.setPrice(Value.MACHINE_GUN_TOWER_PRICE);
    }

    public void attackEnemy(ArrayList<Bullet> bullets){
        long TIME = System.currentTimeMillis();
        if(TIME - timeAttack < getAttackSpeed()) return;
        timeAttack = TIME;
        Bullet bullet =  bullet = new MachineGunTowerBullet(this, getCenter().x, getCenter().y, Value.SIZE_TILE, Value.SIZE_TILE, getAngle());;

        if(getxDistance() <= 0 && getyDistance() <= 0) setFlag(1);
        else if(getxDistance() <= 0 && getyDistance() >= 0) setFlag(2);
        else if(getxDistance() >= 0 && getyDistance() <= 0) setFlag(3);
        else if(getxDistance() >=0 && getyDistance() >= 0) setFlag(4);

        bullet.setFlag(getFlag());
        bullets.add(bullet);
        // may be add Sound Effect in here...
        Sound.play(Sound.normalBullet);

    }

    public void draw(Graphics2D g2d){

        super.draw(g2d);
        switch (getFlag()){
            case 1:
                g2d.rotate(getAngle() + Math.toRadians(-90), getCenter().x, getCenter().y);
                break;
            case 2:
                g2d.rotate(-getAngle() + Math.toRadians(270), getCenter().x, getCenter().y);
                break;
            case 3:
                g2d.rotate(-getAngle() + Math.toRadians(90), getCenter().x, getCenter().y);
                break;
            case 4:
                g2d.rotate(getAngle() + Math.toRadians(90), getCenter().x, getCenter().y);
                break;
        }
        g2d.drawImage(bodyTower, getxPos(), getyPos(), 64, 64, null);
        switch (getFlag()){
            case 1:
                g2d.rotate(-getAngle() + Math.toRadians(90), getCenter().x, getCenter().y);
                break;
            case 2:
                g2d.rotate(getAngle() + Math.toRadians(-270), getCenter().x, getCenter().y);
                break;
            case 3:
                g2d.rotate(getAngle() + Math.toRadians(-90), getCenter().x, getCenter().y);
                break;
            case 4:
                g2d.rotate(-getAngle() + Math.toRadians(-90), getCenter().x, getCenter().y);
                break;
        }
    }
}

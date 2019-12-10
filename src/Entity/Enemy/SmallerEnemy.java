package Entity.Enemy;

import Game.Value;

import javax.swing.*;
import java.awt.*;

public class SmallerEnemy extends Enemy {
    private Image enemy = new ImageIcon("res/SmallerEnemy.png").getImage();

    public SmallerEnemy(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.setArmor(Value.SMALLER_ENEMY_ARMOR);
        this.setRewardMoney(Value.SMALLER_ENEMY_REWARD);
        this.setSpeed(Value.SMALLER_ENEMY_SPEED);
        this.setHp(Value.SMALLER_ENEMY_HP);
        this.setDamage(Value.SMALLER_ENEMY_DAMAGE);
    }

    @Override
    public void draw(Graphics2D g2d) {
        //        g2d.rotate(getAngle(), getxPos() + Value.SIZE_TILE/2, getyPos() + Value.SIZE_TILE/2);
        g2d.drawImage(enemy, getxPos(), getyPos(), Value.SIZE_TILE, Value.SIZE_TILE, null);
//        g2d.rotate(-getAngle(), getxPos() + Value.SIZE_TILE/2, getyPos() + Value.SIZE_TILE/2);
        move();
    }
}

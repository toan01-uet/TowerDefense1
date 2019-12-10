package Entity.Enemy;

import Game.Value;

import javax.swing.*;
import java.awt.*;

public class TankerEnemy extends Enemy {
    private Image enemy = new ImageIcon("res/TankerEnemy.png").getImage();

    public TankerEnemy(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.setArmor(Value.TANKER_ENEMY_ARMOR);
        this.setRewardMoney(Value.TANKER_ENEMY_REWARD);
        this.setSpeed(Value.TANKER_ENEMY_SPEED);
        this.setHp(Value.TANKER_ENEMY_HP);
        this.setDamage(Value.TANKER_ENEMY_DAMAGE);
    }

    @Override
    public void draw(Graphics2D g2d) {
//        g2d.rotate(getAngle(), getxPos() + Value.SIZE_TILE/2, getyPos() + Value.SIZE_TILE/2);
        g2d.drawImage(enemy, getxPos(), getyPos(), Value.SIZE_TILE, Value.SIZE_TILE, null);
//        g2d.rotate(-getAngle(), getxPos() + Value.SIZE_TILE/2, getyPos() + Value.SIZE_TILE/2);
        move();
    }
}

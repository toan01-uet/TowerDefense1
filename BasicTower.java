package Entity;

import DrawImage.TileImage;

import java.awt.*;

public class BasicTower extends Tower {

    public BasicTower(double x, double y) {
        super(x, y);
        this.image= TileImage.images.get(250);
        this.setUnderImage(TileImage.images.get(250-23-23-23));

    }
    @Override
    public void draw(Graphics g){
        g.drawImage(this.getUnderImage(),(int)x,(int)y,null);
//        g.drawImage(this.image,(int)x,(int)y,null);

        if(canAttack()) {
            testBullet.draw(g);
            ((Graphics2D) g).rotate(getAngleOfRotation(), x + 32, y + 32);
            ((Graphics2D) g).drawImage(this.image, (int) x, (int) y, null);
        }else{
            ((Graphics2D) g).drawImage(this.image, (int) x, (int) y, null);

        }
    }
}

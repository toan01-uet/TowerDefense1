package Entity;

import java.awt.*;
import java.awt.image.BufferedImage;

abstract public class AbstractEntity implements GameEntity {
    protected double x, y;
    protected int width=64, height=64;
    public BufferedImage image;

    public AbstractEntity(double x, double y) {
        this.x=x;
        this.y=y;
    }


    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    @Override
    public  BufferedImage getImage(){
        return this.image;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(this.image,(int)this.x,(int)this.y,width,height,null);
    }

    @Override
    public void update() {

    }
}



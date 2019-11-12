package Entity;

import DrawImage.TileImage;

import java.awt.*;


public class Bullet extends AbstractEntity {
    private double speed;
    private double range;
    private double damage;
    private double direction;
    private double TargetX;
    private double TargetY;

    public void setTargetX(double targetX) {
        TargetX = targetX;
    }

    public void setTargetY(double targetY) {
        TargetY = targetY;
    }

    public Bullet(double x, double y) {
        super(x, y);
        this.image=TileImage.images.get(250+23);
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }
    public void setRange(double range) {
        this.range = range;
    }

    public double getRange() {
        return range;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getDamage() {
        return damage;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public double getDirection() {
        return direction;
    }


    @Override
    public void update(){
//        this.setX(this.getX() + this.getSpeed() * Math.sin(direction * Math.PI / 180));
//        this.setY(this.getY() - this.getSpeed() * Math.cos(direction * Math.PI / 180));
//        this.setY(target.getY());
//        this.setX(target.getX());
    }

    @Override
    public void draw(Graphics g){
        g.setColor(Color.RED);

        g.drawLine((int)this.x+32,(int)this.y+32,(int)this.TargetX+32,(int)this.TargetY+32);
        g.drawImage(this.getImage(), (int)TargetX,(int)TargetY, null);
    }


}

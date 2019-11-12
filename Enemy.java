package Entity;

import DrawImage.TileImage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

abstract public class Enemy extends AbstractEntity {
//    publicc boolean visible;
    protected double Healpoint=0;
    protected double speed=0;
    public boolean visible=true;
    protected boolean atTheEndPoint=false;
    protected boolean alive=true;


    protected Direction direction;

    public Enemy(double x, double y) {
        super(x, y);
    }

    protected List<Point> PointList = new ArrayList<>();

    public int degree;

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public int getDegree() {
        return degree;
    }
    enum Direction {
        LEFT(180), UP(270), RIGHT(0), DOWN(90);

        int degree;

        Direction(int i) {
            degree = i;
        }

        int getDegree() {
            return degree;
        }
    }
    public static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public void takeDamage(double damage) {
        Healpoint = Healpoint - damage;
        if (Healpoint <= 0) {
            alive = false;
            visible = false;
        }
    }

    public static final Point[] wayPoints = new Point[] {
            new Point(0 , 64*3),
            new Point(64*8 , 64*3),
            new Point(64*8, 9*64),
            new Point(64*14,64*9),
            new Point(64*14+1, 64*9),
    };

    public boolean checkEndPoint(){
        if(wayPointIndex==Enemy.wayPoints.length-1){
            visible=false;
            return true;
        }
        return false;
    }

    int wayPointIndex = 0;
    public Point getNextWayPoint() {
        if (wayPointIndex < Enemy.wayPoints.length - 1)
            return Enemy.wayPoints[++wayPointIndex];
        return null;
    }
    //
    void calculateDirection() {
        // Tinh huong di tiep theo cho Object
        checkEndPoint();
        if (wayPointIndex >= Enemy.wayPoints.length) {
            // Enemy den way point cuoi
            return;
        }


        Point currentWP = Enemy.wayPoints[wayPointIndex];
        if (Enemy.distance((int)x, (int)y, currentWP.getX(), currentWP.getY()) <= speed) {
            x = currentWP.getX();
            y = currentWP.getY();
            Point nextWayPoint = getNextWayPoint();
            if (nextWayPoint == null) return;
            double deltaX = nextWayPoint.getX() - x;
            double deltaY = nextWayPoint.getY() - y;
            if (deltaX > speed) direction = Direction.RIGHT;
            else if (deltaX < -speed) direction = Direction.LEFT;
            else if (deltaY > speed) direction = Direction.DOWN;
            else if (deltaY <= -speed) direction = Direction.UP;
        }
    }
    @Override
    public void update() {
        calculateDirection();
        switch (direction) {
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;

        }
        checkEndPoint();
    }
    @Override
    public void draw(Graphics g) {
        if(visible==false){
            g.drawString("GameLose",64,128);
        }
        g.drawImage(this.image,(int)this.x,(int)this.y,width,height,null);
    }

}

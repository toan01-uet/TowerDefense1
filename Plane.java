package Entity;

import DrawImage.TileImage;

public class Plane extends Enemy {


    public Plane(double x, double y) {
        super(x, y);
        this.image= TileImage.images.get(250+22-2);
        this.Healpoint=100;
        this.speed=1;
    }
    public Plane(double x, double y, double speed){
        super(x,y);
        this.image= TileImage.images.get(250+22-2);
        this.Healpoint=100;
        this.speed= speed;
    }



}

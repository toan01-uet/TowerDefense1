package Tile;

import DrawImage.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    public static  Tile[]  tiles= new Tile[200];
    public static  Tile Mountain = new Mountain(0);
    public static  Tile Road = new Road(1);

    protected BufferedImage texture;
    protected final int id;
    public boolean Moveable = false;
    public boolean Builalbe = false;

    protected Tile(BufferedImage texture, int id, boolean Moveable, boolean Builable) {
        this.texture = texture;
        this.id = id;
        this.Moveable = Moveable;
        this.Builalbe = Builable;
        tiles[id]=this;
    }

    public int getId() {
        return this.id;
    }

    public void setMoveable(boolean moveable) {
        Moveable = moveable;
    }

    public void setBuilalbe(boolean builalbe) {
        Builalbe = builalbe;
    }


    public void update() {

    }

    public void draw(Graphics g, int x, int y) {
        g.drawImage(texture,x,y,64,64,null);

    }


}

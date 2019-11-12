package Tile;

import DrawImage.TileImage;

public class Road extends Tile {
    public  Road(int id) {
        super(TileImage.images.get(22+23+5),id,false,true);
    }

}

package Map;

import Tile.Tile;

import java.awt.*;

public  class map {
    private int width, height;
    private int[][] tileMap;

    public map(String path){
        loadMap(path);

    }

    public void update(){

    }

    public void draw(Graphics g){
        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                getTile(y,x).draw(g,x*64,y*64);
            }
        }
    }
    public Tile getTile(int x,int y){
        Tile t = Tile.tiles[tileMap[x][y]];
        if(t ==null){
            return Tile.Mountain;
        }
        return t;
    }

    private void loadMap(String path){
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height= Utils.parseInt(tokens[1]);
        tileMap = new int[height][width];
        for(int x=0;x<tileMap.length;x++){
            for(int y=0;y<tileMap[0].length;y++){
                try {
                    tileMap[x][y] = Utils.parseInt(tokens[(y + x*width) + 2]);
                }catch(ArrayIndexOutOfBoundsException e){
                    System.out.print("caay");
                    e.printStackTrace();
                }
            }
        }
    }

}
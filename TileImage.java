package DrawImage;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TileImage {
    public static ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
    public static BufferedImage img=null;



    public static void init(){
        try {
            File fileImage = new File("res/Tilesheet/towerDefense_tilesheet.png");
            img = ImageIO.read(fileImage);
            SpriteSheet sheet = new SpriteSheet(img);
            for(int i=0;i<12;i++){
                for(int j=0;j<23;j++) {
                    try {
                        images.add(sheet.crop(j * 64, i * 64, 64, 64));
                    } catch (RasterFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        }

}

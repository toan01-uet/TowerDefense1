package Entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public interface GameEntity {
    double getX();
    double getY();
    void setX(double x);

    void setY(double y);

    void setImage(BufferedImage image);

    BufferedImage getImage();
    public abstract void draw(Graphics g);
    public abstract void update();


}

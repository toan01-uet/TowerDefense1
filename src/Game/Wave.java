package Game;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Wave {
    private int xMouse, yMouse;

    public void select(MouseEvent e){
        xMouse = e.getX() - (Screen.frame.getWidth() - Screen.myWidth - 8);
        yMouse = e.getY() - (Screen.frame.getHeight() - Screen.myHeight - 8);
        if(xMouse >= 1200 && xMouse <= 1200 + 128 && yMouse >= 640 && yMouse <= 640 + 64){
            Screen.flagWave += 1;
        }

    }

    public void draw(Graphics2D g2d){
        g2d.setColor(Color.GREEN);
        g2d.fillRect(1200, 640, 128, 64);
        g2d.setColor(Color.darkGray);
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        g2d.drawString("NEXT WAY", 1200 + 16, 640 + 32);
    }

}

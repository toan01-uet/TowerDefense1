
import Game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame {
    public MenuFrame(Game game) throws HeadlessException {
        JFrame Frame = new JFrame("Tower Defense");
        Frame.setBackground(Color.PINK);
        Frame.setVisible(true);
        Frame.setPreferredSize(new Dimension(GameConfig.MenuWIDTH, GameConfig.MenuHEIGHT));
        JButton PlayButton= new JButton("Play");
        PlayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.start();
                Frame.dispose();
            }
        });
        Frame.add(PlayButton);
        Frame.setResizable(false);
        Frame.setLocationRelativeTo(null);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.pack();
    }
}
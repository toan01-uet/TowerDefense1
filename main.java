import Game.Game;

public class main {
    public static void main(String[] arg) {
        Game game = new Game(GameConfig.gametitle,GameConfig.displayWIDTH,GameConfig.displayHEIGHT);
        new MenuFrame(game);
    }
}


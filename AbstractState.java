package State;

import Game.Game;

import java.awt.*;

public abstract class AbstractState {

    protected Game game;

    public AbstractState(Game game){
        this.game=game;
    }
    private static AbstractState currentState =null;

    public static void setCurrentState(AbstractState state){
        currentState = state;
    }

    public static AbstractState getCurrentState() {
        return currentState;
    }

    public abstract void update();

    public abstract void draw(Graphics g);

}

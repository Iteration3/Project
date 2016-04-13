package utilities;

import utilities.State.MainMenuState;
import utilities.State.State;

import java.awt.image.BufferedImage;

/**
 * Created by denzel on 4/11/16.
 */

/**
 * Responsibilities of GameStateManager is
 * keep a stack of states and check the current state for its view and controller
 */

public class GameStateManager {

    private State currentGameState;

    public GameStateManager() {
        setState(new MainMenuState());
    }

    public void setState(State newGameState) {
        if(currentGameState != newGameState) {
            currentGameState = newGameState;
            currentGameState.initMVC();
        }
    }

    public void update() {
        //TODO: function can throw error
        if(currentGameState != null) {
            currentGameState.setNextState(this);
            currentGameState.handleInput();
            currentGameState.update();
        }
        else {
            System.err.println("GameStateManager error: null game state");
        }

    }


    public void render(BufferedImage image) {
        //TODO: function can throw error
        if(currentGameState != null) {
            currentGameState.render(image);}
        else{
            System.err.println("GameStateManager error: null game state");
        }
    }
}

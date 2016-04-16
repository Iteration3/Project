package utilities;

import utilities.State.MainMenuState;
import utilities.State.State;

import java.awt.image.BufferedImage;

public class GameStateManager {

    private State currentGameState;

    public GameStateManager() {
        setState(new MainMenuState());
    }

    public void setState(State newGameState) {
        if(currentGameState != newGameState){
            currentGameState = newGameState;
            currentGameState.initMVC();
        }
    }

    public void update() {
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

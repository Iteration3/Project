package utilities;


import Main.InputManager;
import controllers.Controller;
import utilities.State.State;
import views.Canvas;
import views.View;

import java.util.Stack;

/**
 * Responsibilities of GameStateManager is
 * keep a stack of states and check the current state for its view and controller
 */

public class GameStateManager {

    //State
    private State state;


    //Stack of states
    private Stack<State> stateStack;

    public GameStateManager(){
        //initialize the stack of states
        stateStack = new Stack<>();
    }

    //Current View
    public View getCurrentView(){
        return stateStack.peek().getView();
    }

    //Current Controller
    public Controller getCurrentController(){
        return stateStack.peek().getController();
    }

    //change state
    public void changeState(State state){
        stateStack.add(state);
        //TODO: This should not be written like this
        getCurrentView().getCanvas().setActiveView(state.getView());
    }

    //remove state
    public void removeState(){
        stateStack.pop();
    }

    //update
    public void update(){

    }

    //render
    public void render(){
        getCurrentView().getCanvas().repaint();
    }

}

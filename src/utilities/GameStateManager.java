package utilities;

import controllers.Controller;
import views.View;

import java.util.Stack;

import java.awt.*;

/**
 * Created by denzel on 4/11/16.
 */

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

    //Current State
    public State getCurrentState(){
        return stateStack.peek();
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
        state.setActiveView(getCurrentView().getCanvas());
    }

    public void update(){
        getCurrentController().update();
    }

    //remove state
    public void removeState(){
        stateStack.pop();
    }
}

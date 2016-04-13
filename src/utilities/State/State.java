package utilities.State;

import controllers.Controller;
import models.StateModel.StateModel;
import utilities.GameStateManager;
import views.Canvas;
import views.View;

import java.awt.image.BufferedImage;

/**
 * Created by denzel on 4/11/16.
 */
//The state object couples the View and Controller
public abstract class State {

    protected Controller stateController;
    protected StateModel stateModel;
    protected View view;

    private State nextGameState;

    public void setMVC(StateModel sm, View view, Controller sc){
        this.stateController = sc;
        this.stateModel = sm;
        this.view = view;

        nextGameState = null;
    }

    public abstract void initMVC();

    //set it to return a state when it needs to change states
    public final void setNextState(GameStateManager gsm) {
        if(nextGameState != null){
            gsm.setState(nextGameState);
        }
    }

    protected final void changeGameState(State gs){
        nextGameState = gs;
    }

    public void handleInput(){
        if(stateController != null) {
            stateController.handleInput();
        }else {
            System.err.println("Current State has no Controller");
        }
    }

    public void update() {
        if (stateModel != null){
            stateModel.update();
            changeGameState(stateModel.nextState());
        }else {
            System.err.println("Current State has no Model");
        }
    }

    public void render(BufferedImage image){
        if(view != null) {
            view.render(image);
        }else {
            System.err.println("Current State has no View");
        }
    }
}

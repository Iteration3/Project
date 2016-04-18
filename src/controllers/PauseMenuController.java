package controllers;

import models.StateModel.PauseMenuModel;
import utilities.GameStateManager;
import utilities.KeyCommand.KeyCommand;
import utilities.State.State;
import views.View;

import java.awt.event.KeyEvent;

/**
 * Created by Andy on 4/16/2016.
 */
public class PauseMenuController extends Controller {

    private PauseMenuModel model;
    private int currentPoint;

    public PauseMenuController(PauseMenuModel model, GameStateManager gsm){
        super(gsm);
        this.model = model;
        currentPoint = 0;
    }

    public void updateModel(){}

    @Override
    public void loadKeyCommand() {
        keyMap.put(KeyEvent.VK_ESCAPE, new KeyCommand(){
            @Override
            public void execute() {
                statsStateTransition();
            }
        });

        keyMap.put(KeyEvent.VK_U, new KeyCommand(){
            @Override
            public void execute() {
                model.up();
            }
        });

        keyMap.put(KeyEvent.VK_J, new KeyCommand() {
            @Override
            public void execute() {
                model.down();
            }
        });
    }

    @Override
    public void updateModel() {

    }

    private void statsStateTransition() {
        gsm.removeState();
        View view = gsm.getCurrentView();
        Controller controller = gsm.getCurrentController();
        State state = new State(view, controller);
        gsm.changeState(state);
    }
}

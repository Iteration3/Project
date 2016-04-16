package controllers;

import models.StateModel.MainMenuModel;
import utilities.GameStateManager;
import utilities.KeyCommand;
import utilities.State.State;
import views.View;

import java.awt.event.KeyEvent;

/**
 * Created by clayhausen on 4/16/16.
 */
public class AvatarCreationViewController extends Controller {


    private AvatarCreationModel model;

    //Constructor of the AvatarCreationController
    public AvatarCreationViewController(MainMenuModel model, GameStateManager gsm){
        super(gsm);
        this.model = model;
    }



    @Override
    public void loadKeyCommand() {

        map.put(KeyEvent.VK_U, new KeyCommand(){
            @Override
            public void execute() {
                model.up();
            }
        });

        map.put(KeyEvent.VK_J, new KeyCommand() {
            @Override
            public void execute() {
                model.down();
            }
        });

        map.put(KeyEvent.VK_ENTER, new KeyCommand() {
            @Override
            public void execute() {
                if(model.getSelected() == MainMenuModel.MainMenuOption.Start){
                    // playStateTransition();
                }
            }
        });
    }

    // TODO change to appropriate state transition
    private void playStateTransition() {
        /*
        AvatarCreationModel model = new AvatarCreationModel();
        View view = new AvatarCreationView(model, gsm);
        Controller controller = new AvatarCreationController(model, gsm);
        State state = new State(view, controller);
        gsm.changeState(state);
        */
    }


}

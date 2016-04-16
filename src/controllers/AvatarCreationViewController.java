package controllers;

import models.StateModel.AvatarCreationModel;
import models.StateModel.MainMenuModel;
import models.StateModel.PlayStateModel;
import utilities.GameStateManager;
import utilities.KeyCommand;
import utilities.State.State;
import views.PlayStateView;
import views.View;

import java.awt.event.KeyEvent;

/**
 * Created by clayhausen on 4/16/16.
 */
public class AvatarCreationViewController extends Controller {


    private AvatarCreationModel model;

    //Constructor of the AvatarCreationController
    public AvatarCreationViewController(AvatarCreationModel model, GameStateManager gsm){
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
                playStateTransition();
            }
        });
    }

    // TODO change to appropriate state transition

    private void playStateTransition() {
        PlayStateModel model = new PlayStateModel();

        //TODO Fix the getter chain
        PlayStateView view = new PlayStateView(500,500,gsm.getCurrentView().getCanvas(),model);

        PlayStateController controller = new PlayStateController(gsm);
        State playState = new State(view,controller);
        gsm.changeState(playState);
    }


}

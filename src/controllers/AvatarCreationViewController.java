package controllers;

import models.Stat.Stat;
import models.StateModel.AvatarCreationModel;
import models.StateModel.PlayStateModel;
import utilities.GameStateManager;
import utilities.KeyCommand.KeyCommand;
import utilities.State.State;
import views.PlayStateView;

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
                if(model.getSelected() == AvatarCreationModel.AvatarCreationMenu.SMASHER){
                    playStateTransition();
                }
            }
        });
    }

    // TODO change to appropriate state transition
    private void playStateTransition() {

        PlayStateModel model = new PlayStateModel();
        PlayStateView view = new PlayStateView(500,500,gsm.getCurrentView().getCanvas(),model);
        PlayStateController controller = new PlayStateController(model,gsm);
        State playState = new State(view,controller);
        gsm.changeState(playState);
    }



}

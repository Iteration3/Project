package controllers;

import models.StateModel.AvatarCreationModel;
import utilities.GameStateManager;
import utilities.KeyCommand.KeyCommand;

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

        keyMap.put(KeyEvent.VK_ENTER, new KeyCommand() {
            @Override
            public void execute() {
                if(model.getSelected() == AvatarCreationModel.AvatarCreationMenu.SMASHER){
                    System.out.println("Selected Smasher");
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

package controllers;

import Main.InputManager;
import models.StateModel.MainMenuModel;
import utilities.GameStateManager;
import utilities.KeyCommand;
import utilities.State.State;
import views.View;

import java.awt.event.KeyEvent;

/**
 * Created by denzel on 4/11/16.
 */
public class MainMenuViewController extends Controller {


    private MainMenuModel model;

    //constructor of the mainMenuController
    public MainMenuViewController(MainMenuModel model, GameStateManager gsm){
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
                    avatarCreationStateTransition();
                }
            }
        });
    }

    private void avatarCreationStateTransition() {
        AvatarCreationModel model = new AvatarCreationModel();
        View view = new AvatarCreationView(model, gsm);
        Controller controller = new AvatarCreationController(model, gsm);
        State state = new State(view, controller);
        gsm.changeState(state);
    }


}

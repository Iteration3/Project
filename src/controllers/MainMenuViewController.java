package controllers;

import Main.InputManager;
import models.StateModel.MainMenuModel;
import utilities.GameStateManager;
import utilities.KeyCommand;
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
                    System.out.println("I am going to start");
                }
            }
        });
    }


}

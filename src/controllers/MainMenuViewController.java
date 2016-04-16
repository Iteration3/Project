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
    private GameStateManager gsm;

    //constructor of the mainMenuController
    public MainMenuViewController(MainMenuModel model, GameStateManager gsm){
        this.model = model;
        this.gsm = gsm;
    }

    @Override
    public void loadKeyCommand() {

        map.put(KeyEvent.VK_U, new KeyCommand(){
            @Override
            public void execute() {
                System.out.println("fuck everything");
            }
        });

        map.put(KeyEvent.VK_J, new KeyCommand() {
            @Override
            public void execute() {
                System.out.println("I'm Entering");
                model.down();
            }
        });

        map.put(KeyEvent.VK_ENTER, new KeyCommand() {
            @Override
            public void execute() {
                System.out.println("I'm Entering");
                model.select();
            }
        });

        System.out.println("Added the keys");
    }
}

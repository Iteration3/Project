package controllers;

import com.sun.org.apache.xpath.internal.SourceTree;
import models.StateModel.MainMenuModel;
import utilities.GameStateManager;
import utilities.KeyCommand;
import views.View;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by denzel on 4/11/16.
 */
public class MainMenuViewController extends Controller {

    private MainMenuModel model;

    //constructor of the mainMenuController
    public MainMenuViewController(MainMenuModel model){
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
                model.select();
            }
        });
    }
}

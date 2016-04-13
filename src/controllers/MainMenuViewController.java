package controllers;

import com.sun.org.apache.xpath.internal.SourceTree;
import utilities.GameStateManager;
import utilities.KeyCommand;
import views.View;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by denzel on 4/11/16.
 */
public class MainMenuViewController extends Controller {

    //constructor of the mainMenuController
    public MainMenuViewController(){

    }

    @Override
    public void loadKeyCommand() {

        map.put(KeyEvent.VK_9, new KeyCommand() {
            @Override
            public void execute() {
                System.out.println("Hello");
            }
        });

    }
}

package controllers;

import utilities.KeyCommand;
import views.View;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by denzel on 4/11/16.
 */


public abstract class Controller {

    // Hashmap of KeyEvents
    private HashMap<KeyEvent, KeyCommand> map;

    // HashList
    private HashSet<KeyCommand> pending;

    public Controller() {
        loadKeyCommand();
    }




    // update method
    public void update(){
        for(KeyCommand i : pending) {
            i.execute();
        }
    }

    // called by InputManager
    public void addCommand(KeyEvent event) {
        if ( map.containsKey(event) ) {
            pending.add( map.get(event) );
        }
    }

    public void removeCommand(KeyEvent event) {
        if ( map.containsKey(event) ) {
            pending.remove( map.get(event) );
        }
    }

    public abstract void loadKeyCommand();

}

package controllers;

import utilities.KeyCommand;

import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 * Created by denzel on 4/11/16.
 */

//TODO: I don't think controllers should extend the inputmanager. AI Controllers dont need input
public abstract class Controller{

    // Hashmap of KeyEvents
    protected HashMap<Integer, KeyCommand> map;

    public Controller() {
        map = new HashMap<>();
        loadKeyCommand();
    }

    // update method
    public void handleInput(KeyEvent e){
        map.get(e.getKeyCode()).execute();
    }

    public abstract void loadKeyCommand();
}
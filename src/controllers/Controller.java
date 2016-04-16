package controllers;

import utilities.GameStateManager;
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

    //GameStateManager
    protected GameStateManager gsm;

    public Controller( GameStateManager gsm) {
        map = new HashMap<>();
        this.gsm = gsm;
        loadKeyCommand();
    }

    // update method
    public void handleInput(KeyEvent e){
        map.get(e.getKeyCode()).execute();
    }

    public abstract void loadKeyCommand();
}
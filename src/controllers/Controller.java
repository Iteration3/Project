package controllers;

import utilities.GameStateManager;
import utilities.KeyCommand.KeyCommand;

import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 * Created by denzel on 4/11/16.
 */

//TODO: I don't think controllers should extend the inputmanager. AI Controllers dont need input
public abstract class Controller{

    // Hashmap of KeyEvents
    protected HashMap<Integer, KeyCommand> keyMap;

    //GameStateManager
    protected GameStateManager gsm;

    public Controller( GameStateManager gsm) {
        keyMap = new HashMap<>();
        this.gsm = gsm;
        loadKeyCommand();
    }

    // update method
    public void handleInput(KeyEvent e){
        keyMap.get(e.getKeyCode()).execute();
    }

    public abstract void loadKeyCommand();
}
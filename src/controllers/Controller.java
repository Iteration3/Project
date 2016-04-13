package controllers;

import Main.InputManager;
import Utilities.KeyCommand;

import java.util.HashMap;

/**
 * Created by denzel on 4/11/16.
 */
public abstract class Controller extends InputManager{

    // Hashmap of KeyEvents
    protected HashMap<Integer, KeyCommand> map;

    public Controller() {
        map = new HashMap<>();
        loadKeyCommand();
    }

    // update method
    public void handleInput(){


        for(Integer i: super.getActiveKey()){
            if(map.containsKey(i)){
                map.get(i).execute();
            }
        }
    }

    public abstract void loadKeyCommand();
}

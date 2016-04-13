package controllers;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import utilities.KeyCommand;


import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by denzel on 4/11/16.
 */
public abstract class Controller {

    // Hashmap of KeyEvents
    protected HashMap<Integer, KeyCommand> map;

    // HashList
    private HashSet<KeyCommand> pending;

    public Controller() {
        map = new HashMap<>();
        pending = new HashSet<>();
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

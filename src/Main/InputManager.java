package Main;

/**
 * Created by denzel on 4/11/16.
 */

import javafx.beans.Observable;
import utilities.GameStateManager;
import utilities.KeyCommand;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Observer;

/**
 * Responsibilities: to listen to key input and send to current controller
 */

public class InputManager{

    // HashList
    static HashSet<Integer> active = new HashSet<>();

    // called by InputManager
    static void addCommand(KeyEvent event) {
            active.add(event.getKeyCode());
    }
    static void removeCommand(KeyEvent event) {
            active.remove( event.getKeyCode());
    }

    protected static HashSet<Integer> getActiveKey(){
        return (HashSet<Integer>)active.clone();
    }
}

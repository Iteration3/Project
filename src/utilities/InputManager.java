package utilities;

/**
 * Created by denzel on 4/11/16.
 */

import javafx.beans.Observable;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observer;

/**
 * Responsibilities: to listen to key input and send to current controller
 */

public class InputManager implements KeyListener {

    //the veggies
    GameStateManager gsm;

    public InputManager(){

    }


    @Override
    public void keyPressed(KeyEvent e) {
        gsm.getCurrentController().addCommand(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        gsm.getCurrentController().removeCommand(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        gsm.getCurrentController().addCommand(e);
    }
}

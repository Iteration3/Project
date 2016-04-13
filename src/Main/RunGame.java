package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

/**
 * Created by denzel on 4/11/16.
 */



public class RunGame extends JFrame implements KeyListener{


    public static void main(String[] args){
        GameLoop game = new GameLoop();
        Thread thread = new Thread(game);
        thread.start();
    }

    public RunGame(){
        this.addKeyListener(this);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        InputManager.addCommand(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        InputManager.removeCommand(e);
    }
}


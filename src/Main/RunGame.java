package Main;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by denzel on 4/11/16.
 */
public class RunGame extends JFrame implements KeyListener{

    public static void main(String[] args){
        GameLoop game = new GameLoop();
        Thread thread = new Thread(game);
        thread.start();
    }

    @Override
    // method called internally by toolkit
    public void addNotify() {
        super.addNotify();
        setFocusable(true);
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

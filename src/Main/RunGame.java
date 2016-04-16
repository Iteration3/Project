package Main;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by denzel on 4/11/16.
 */
public class RunGame extends JFrame {

    public static void main(String[] args){
        GameLoop game = new GameLoop();
        Thread thread = new Thread(game);
        thread.start();
    }

    public RunGame(){

    }

}

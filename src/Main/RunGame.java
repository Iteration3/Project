package Main;

import javax.swing.*;
import java.awt.*;

/**
 * Created by denzel on 4/11/16.
 */



public class RunGame extends JFrame{

    public static void main(String[] args){

        GameLoop game = new GameLoop();
        Thread thread = new Thread(game);
        thread.start();

//        EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                RunGame ex = new RunGame();
//                ex.setVisible(true);
//            }
//        });
    }
}


package Main;

import javax.swing.*;

/**
 * Created by denzel on 4/11/16.
 */



public class RunGame extends JFrame {

    public static void main(String[] args){

        Thread thread = new Thread(new GameLoop());
        thread.start();

        Canvas canvas = new Canvas();



        RunGame gameFrame = new RunGame();
        gameFrame.setTitle("WTF Game");

        gameFrame.add(canvas);

        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

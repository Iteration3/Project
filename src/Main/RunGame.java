package Main;

import controllers.MainMenuViewController;
import models.StateModel.MainMenuModel;
import utilities.GameStateManager;
import utilities.State.State;
import views.Canvas;
import views.MainMenuView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by denzel on 4/11/16.
 */
public class RunGame extends JFrame implements ActionListener {


    //GameStateManager
    private GameStateManager gsm;
    private RunGame gameFrame;
    private Canvas canvas;
    private Timer timer;


    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                RunGame ex = new RunGame();
                ex.setVisible(true);
            }
        });
    }

    public RunGame(){
        init();
    }

    public void init(){

        //Instantiate the GameStateManager
        gsm = new GameStateManager();
        InputManager inputManager = new InputManager(gsm);
        canvas = new Canvas(inputManager);
        timer = new Timer(100,this);

        //Creating JFrame
        add(canvas);
        pack();

        //create the first state
        MainMenuModel mainMenuModel = new MainMenuModel();
        MainMenuView mainMenuView = new MainMenuView(300,300,canvas,mainMenuModel);
        MainMenuViewController mainMenuViewController = new MainMenuViewController(mainMenuModel,gsm);
        State mainMenuState = new State(mainMenuView,mainMenuViewController);

        setTitle("WTF Game");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //push the first state into the GSM
        gsm.changeState(mainMenuState);

        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //calls update
        gsm.updateModel();
        gsm.update(canvas);


    }
}

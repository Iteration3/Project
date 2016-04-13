package Main;

import controllers.MainMenuViewController;
import utilities.*;
import views.Canvas;
import views.MainMenuView;
import javax.swing.*;

/**
 * Created by denzel on 4/11/16.
 */


//The Game Loop
public class GameLoop implements Runnable{

    //GameStateManager
    private GameStateManager gsm;
    private RunGame gameFrame;
    private Canvas canvas = new Canvas(400,400);

    private final int FPS = 30;
    private final int TIME_PER_TICK = 1000/FPS;
    private long timePerTick;
    private boolean isRunning = true;

    public GameLoop(){

        //Instantiate the GameStateManager
        gsm = new GameStateManager();
        initFrame();
        gameFrame.add(canvas);
        gameFrame.pack();

        //create the first state
        //TODO: NOT HERE IN ITS OWN CLASS
        MainMenuView mainMenuView = new MainMenuView(500,500,canvas);
        MainMenuViewController mainMenuViewController = new MainMenuViewController();
        State mainMenu = new State(mainMenuView,mainMenuViewController);
        //TODO:--------------------------------------------------------


        //put that into the GameStateManager
        gsm.changeState(mainMenu);
    }

    public void initFrame(){
        gameFrame = new RunGame();
        gameFrame.setTitle("WTF Game");
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void run() {
        int fps = 30;
        timePerTick = 1000 / fps;

        long start;
        long elapsed;
        long wait;

        while(isRunning){

            start = System.currentTimeMillis();

            update();
            render();

            elapsed = System.currentTimeMillis() - start;
            wait = timePerTick - elapsed;

            if(wait > 0 ){
                try{
                    Thread.sleep(wait);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void update(){
        gsm.update();
    }
    //frame
    public void render(){
      //gsm.render();
    }

}

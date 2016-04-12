package Main;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import Utilities.GameStateManager;

/**
 * Created by denzel on 4/11/16.
 */
//The Game Loop
public class GameLoop implements Runnable {

    //GameStateManager
    GameStateManager gsm;

    //fps
    private int fps;

    //timePerTick
    private long timePerTick;

    //delta
    private long delta;

    //currentTime
    private long currentTime;

    //lastTime
    private long lastTime;

    //timer
    private long timer;

    //running flag
    private boolean running = false;


    @Override
    public void run() {

        fps = 30;
        timePerTick = 1000 / fps;
        delta = 0;
        lastTime = System.currentTimeMillis();
        timer = 0;


        running = true;
        long start;
        long elapsed;
        long wait;

        while(running){

            start = System.currentTimeMillis();

            //gsm.update();


            elapsed = System.currentTimeMillis() - start;
            wait = timePerTick - elapsed;

            if(wait > 0 ){
                try{
                    Thread.sleep(wait);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            //delta += (currentTime - lastTime)/timePerTick;
            //timer += currentTime - lastTime;
            //lastTime = currentTime;
            System.out.println(elapsed);
        }

    }
}

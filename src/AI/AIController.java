package AI;

import models.Entity.Entity;

/**
 * Created by denzel on 4/16/16.
 */


public abstract class AIController {

    //Whether the State Machine is running
    public enum States{
        SUCCESS,
        FAILURE,
        RUNNING
    }

    protected States currentState;

    public AIController(){

    }

    //starting function
    public void start(){
        this.currentState = States.RUNNING;
    }

    //Every subController will define the reset state
    public abstract void reset();

    //
}

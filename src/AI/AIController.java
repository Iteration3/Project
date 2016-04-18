package AI;

import models.Entity.Entity;
import models.Map.Map;
import models.Stat.Stat;

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
    private Entity entity;
    private Map map;

    public AIController(Entity entity, Map map){
        this.entity = entity;
        this.map = map;
    }


    protected Entity getEntity(){
        return entity;
    }

    protected Map getMap(){
        return map;
    }


    //starting function
    public void start(){
        this.currentState = States.RUNNING;
    }

    //Every subController will define the reset state
    public abstract void reset();

    //The actual behavior function that takes in the entity and map
    public abstract void act();

    //the other two states that the machine will be running on
    //succeed
    protected void succeed(){
        this.currentState = States.SUCCESS;
    }

    //failure
    protected void failure(){
        this.currentState = States.FAILURE;
    }

    //status check functions
    //isSuccess
    public boolean isSuccess(){
        return currentState.equals(States.SUCCESS);
    }

    //isFailure
    public boolean isFailure(){
        return currentState.equals(States.FAILURE);
    }

    //isRunning
    public boolean isRunning(){
        return currentState.equals(States.RUNNING);
    }
}

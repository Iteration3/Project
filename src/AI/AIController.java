package AI;

import models.Entity.Entity;

/**
 * Created by denzel on 4/16/16.
 */


public abstract class AIController {

    private Entity entity;
    private FSM fsm;

    //Takes in the entity to be AI'ed and the FSM to do the AI'ing
    public AIController(Entity entity){

        //this entity will be the one to be controlled
        this.entity = entity;
    }


    public void update(){

    }
}

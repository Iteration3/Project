package controllers;

import AI.AIController;
import AI.FSM;
import AI.FSMState;
import models.Entity.Entity;
import models.Entity.NPC;
import models.Entity.Pet;
import models.Map.Map;
import utilities.Location.Location;

/**
 * Created by denzel on 4/16/16.
 */
public class PetController extends AIController{

    public PetController(Pet pet,Map map){
        super(pet,map);
    }


    @Override
    public void reset() {

    }

    @Override
    public void act() {

        //Have the entity
        Pet pet = (Pet)getEntity();


        if(pet.getCurrentState() == Entity.States.WANDER){

            //change direction
            pet.getLocation().add(1,0,0);
            pet.getLocation().add(0,1,0);
            
            //check range of vision of tiles

            //if entity registered

            //change state to attack

            //else

            //state is wander

        }else{
        }

    }
}

package controllers;

import AI.AIController;
import AI.FSM;
import AI.FSMState;
import models.Entity.Avatar;
import models.Entity.Entity;
import models.Entity.NPC;
import models.Entity.Pet;
import models.Map.Map;
import models.Skill.Skill;
import utilities.Direction.Direction;
import utilities.Location.Location;

import java.util.Random;

/**
 * Created by denzel on 4/16/16.
 */
public class PetController extends AIController {


    public Locomotion petLoco;
    private Pet pet;
    private double rand;
    long wait = 300;
    long lastTimer = System.currentTimeMillis();

    public PetController(Pet pet, Map map, Avatar avatar) {
        super(pet, map);
        this.pet = pet;
        pet.setOwnership(avatar);
        //movement controller
        petLoco = new Amphibious(pet, map);

        rand = Math.random();
    }

    public Skill getSpecificSkill(int number){
        return pet.getOccupation().getSpecificSkills().get(number);
    }

    @Override
    public void reset() {

    }

    @Override
    public void act() {

        //Have the entity
        Pet pet = (Pet) getEntity();

        //Get Avatars Location
        Location avatarLocation = pet.getAvatarLocation();


        long nowTime = System.currentTimeMillis();
        if (pet.getCurrentState() == Entity.States.WANDER && nowTime - lastTimer > wait) {

            lastTimer = nowTime;

//            //TODO Sorry Austin..CANCER!!!!!!
//            if (pet.getLocation().getRow() < avatarLocation.getRow()) {
//
//                double num = Math.random();
//                if (num > 0.5)
//                    petLoco.move(Direction.NorthEast);
//                else if(num > 0.75)
//                    petLoco.move(Direction.SouthWest);
//                else
//                    petLoco.move(Direction.NorthWest);
//
//            } else if (pet.getLocation().getRow() > avatarLocation.getRow()) {
//
//                double num = Math.random();
//                if (num < 0.5)
//                    petLoco.move(Direction.South);
////                else if(num < 0.75)
////                    petLoco.move(Direction.SouthEast);
//                else
//                    petLoco.move(Direction.SouthWest);
//
//            } else if (pet.getLocation().getCol() < avatarLocation.getCol()) {
//                double num = Math.random();
//                if (num < 0.5)
//                    petLoco.move(Direction.NorthWest);
//                else
//                    petLoco.move(Direction.SouthWest);
//
//
//            } else if (pet.getLocation().getCol() > avatarLocation.getCol()) {
//                double num = Math.random();
//                if (num < 0.5)
//                    petLoco.move(Direction.NorthEast);
//                else
//                    petLoco.move(Direction.SouthEast);
//            }
        }
    }
}

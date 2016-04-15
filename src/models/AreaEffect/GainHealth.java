package models.AreaEffect;

import models.Entity.Entity;

/**
 * Created by Andy on 4/14/2016.
 */
public class GainHealth extends AreaEffect {

    int health;


    public void test(){
        getLocation();
        setLocation(loc);
    }

    public void execute(Entity e){
        System.out.println("Should add health.");
        healEntity(e);
    }

    private void healEntity(Entity e){

    }
}

package models.AreaEffect;

import models.Entity.Entity;
import utilities.Location.Location;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andy on 4/14/2016.
 */
public class GainHealth extends AreaEffect {

    int health;


   public GainHealth(Location l, int h){
       loc = l;
       health = h;
   }

    public void execute(Entity e){
        System.out.println("Should add health.");
        healEntity(e);
    }

    private void healEntity(Entity e){
        Map statChange = new HashMap<>();
        statChange.put("Life",10);
        e.modifyStats(statChange);
    }
}

package models.AreaEffect;

import models.Entity.Entity;
import utilities.Location.Location;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andy on 4/14/2016.
 */
public class LoseHealth extends AreaEffect {

    int healthLoss;
    public LoseHealth(Location l, int health){
        loc = l;
        healthLoss = health;
    }

    public void execute(Entity e){
        loseHealth(e);
    }

    private void loseHealth(Entity e){
        Map statChange = new HashMap<>();
        statChange.put("Life",-10);
        e.modifyStats(statChange);
    }

}

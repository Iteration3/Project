package models.AreaEffect;

import models.Entity.Entity;
import utilities.Location.Location;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andy on 4/14/2016.
 */
public class LevelUp extends AreaEffect {

    private double levels;

    public LevelUp(Location l, int lev){
        loc = l;
        levels = lev;
    }
    public void execute(Entity e){
        levelUp(e);
    }

    private void levelUp(Entity e){
        Map statChange = new HashMap<>();
        statChange.put("Level",1);
        e.modifyStats(statChange);
    }
}

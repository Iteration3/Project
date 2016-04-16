package models.AreaEffect;

import models.Entity.Entity;
import utilities.Location.Location;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andy on 4/14/2016.
 */
public class Trap extends AreaEffect {

    public Trap(Location l){
        loc = l;
    }
    public void execute(Entity e){
        trap(e);
    }

    private void trap(Entity e){
        Map statChange = new HashMap<>();
        statChange.put("Movement",-100);
        e.modifyStats(statChange);

        //okay so how the fuck do i do this. Need to wait a certain amount of time and then do something.
    }
}

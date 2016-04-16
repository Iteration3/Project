package models.AreaEffect;

import models.Entity.Entity;
import utilities.Location.Location;

/**
 * Created by Andy on 4/14/2016.
 */
public class FlowTile extends AreaEffect {

    private int flowRate;

    public FlowTile(Location l, int rate){
        loc = l;
        flowRate = rate;
    }

    public void execute(Entity e){
        flow(e);
    }

    private void flow(Entity e){
        //yeah I should probably figure this out.
        int x,y;
        Location temp = loc;
        y =temp.getCol();
        
        e.getLocation();
    }
}

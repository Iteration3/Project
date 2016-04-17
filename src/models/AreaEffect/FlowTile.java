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
        Location l = getMoveLocation();
        e.changeLocation(l);
    }

    

    private Location getMoveLocation(){
        int x,y,z;
        x = loc.getRow();
        y = loc.getCol()-1;
        z = loc.getHeight();
        Location temp = new Location(x,y,z);
        return temp;
    }
}

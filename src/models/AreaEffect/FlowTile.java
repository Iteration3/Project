package models.AreaEffect;

import models.Entity.Entity;
import utilities.Location.Location;

/**
 * Created by Andy on 4/14/2016.
 */
public class FlowTile extends AreaEffect {


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

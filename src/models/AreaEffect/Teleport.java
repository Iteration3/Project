package models.AreaEffect;

import models.Entity.Entity;
import utilities.Location.Location;

/**
 * Created by Andy on 4/14/2016.
 */
public class Teleport extends AreaEffect {
    Location toLoc;

    public Teleport(Location l){
        toLoc = l;
    }

    public void execute(Entity e){
        teleportEntity(e);
    }

    private void teleportEntity(Entity e){
        e.changeLocation(toLoc);
    }


}

package models.Entity;


import models.Occupation.*;
import models.StatContainer.*;

import java.awt.*;

public class Mount extends Entity {
    //
    public Mount(int level, Occupation occupation) {
        setName("Mount");
        //setLocation(new Location());
        //setDirection(models.Direction.South);
        setOccupation(occupation);
        setStats(new MountStats());
        setCurrentState(States.WANDER);
        //setInventory(new models.Inventory());
        //setEquipment(new models.Equipment());
    }

    @Override
    public Image getImage() {
        return null;
    }
}

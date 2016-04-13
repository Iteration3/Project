package models.Entity;


import models.Occupation.*;
import models.StatContainer.*;

public class Mount extends Entity {
    //
    public Mount(int level, Occupation occupation) {
        setName("Mount");
        //setLocation(new Location());
        //setDirection(models.Direction.South);
        setOccupation(occupation);
        setStats(new MountStats());
        //setInventory(new models.Inventory());
        //setEquipment(new models.Equipment());
    }
}

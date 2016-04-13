package models.Entity;


import models.Occupation.*;
import models.StatContainer.*;
import models.Inventory.*;

public class NPC extends Entity {
    //
    public NPC(int level, Occupation occupation) {
        setName("NPC");
        //setLocation(new Location());
        //setDirection(models.Direction.South);
        setOccupation(occupation);
        setStats(new NPCStats(occupationModifier(), level));
        setInventory(new Inventory(12));
        //setEquipment(new models.Equipment());
    }
}

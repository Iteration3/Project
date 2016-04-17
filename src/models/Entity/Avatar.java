package models.Entity;


import models.Occupation.*;
import models.StatContainer.*;
import models.Inventory.*;
import utilities.Location.Location;

public class Avatar extends Entity {
    //
    public Avatar(int level, Occupation occupation) {
        setName("Avatar");
        setLocation(new Location(0,0,0));
        setDirection(utilities.Direction.Direction.South);
        setOccupation(occupation);
        setStats(new AvatarStats(occupationModifier(), level));
        setInventory(new Inventory(12, 25));
        //setEquipment(new models.Equipment());
    }
}

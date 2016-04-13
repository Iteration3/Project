package models.Entity;


import models.Occupation.*;
import models.StatContainer.*;

public class Pet extends Entity {
    //
    public Pet(int level, Occupation occupation) {
        setName("Pet");
        //setLocation(new Location());
        //setDirection(models.Direction.South);
        setOccupation(occupation);
        setStats(new PetStats(occupationModifier(), level));
        //setInventory(new models.Inventory());
        //setEquipment(new models.Equipment());
    }
}

package Entity;

import Action.Action;
import Location.Location;
import Direction.Direction;
import Occupation.*;
import StatContainer.*;
import Item.*;

public class Pet extends Entity {
    //
    public Pet(int level, Occupation occupation) {
        setName("Pet");
        //setLocation(new Location());
        //setDirection(Direction.South);
        setOccupation(occupation);
        setStats(new PetStats(occupationModifier(), level));
        //setInventory(new Inventory());
        //setEquipment(new Equipment());
    }
}

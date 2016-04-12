package Entity;

import Action.Action;
import Location.Location;
import Direction.Direction;
import Occupation.*;
import StatContainer.*;
import Item.*;
import Inventory.*;

public class NPC extends Entity {
    //
    public NPC(int level, Occupation occupation) {
        setName("NPC");
        //setLocation(new Location());
        //setDirection(Direction.South);
        setOccupation(occupation);
        setStats(new NPCStats(occupationModifier(), level));
        setInventory(new Inventory(12));
        //setEquipment(new Equipment());
    }
}

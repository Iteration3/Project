package Entity;

import Action.Action;
import Location.Location;
import Direction.Direction;
import Occupation.*;
import StatContainer.*;
import Item.*;

public class NPC extends Entity {
    //
    public NPC(int level, Occupation occupation) {
        setName("NPC");
        //setLocation(new Location());
        //setDirection(Direction.South);
        setOccupation(occupation);
        setStats(new NPCStats(occupationModifier(), level));
        //setInventory(new Inventory());
        //setEquipment(new Equipment());
    }
}

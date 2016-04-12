package Entity;

import Action.Action;
import Location.Location;
import Direction.Direction;
import Occupation.*;
import StatContainer.*;
import Item.*;

public class Mount extends Entity {
    //
    public Mount(int level, Occupation occupation) {
        setName("Mount");
        //setLocation(new Location());
        //setDirection(Direction.South);
        setOccupation(occupation);
        setStats(new MountStats());
        //setInventory(new Inventory());
        //setEquipment(new Equipment());
    }
}

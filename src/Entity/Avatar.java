package Entity;

import Action.Action;
import Location.Location;
import Direction.Direction;
import Occupation.*;
import StatContainer.*;
import Item.*;

public class Avatar extends Entity {
    //
    public Avatar(int level, Occupation occupation) {
        setName("Avatar");
        //setLocation(new Location());
        //setDirection(Direction.South);
        setOccupation(occupation);
        setStats(new AvatarStats(occupationModifier(), level));
        //setInventory(new Inventory());
        //setEquipment(new Equipment());
    }
}

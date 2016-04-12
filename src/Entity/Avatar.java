package Entity;

import Action.Action;
import Location.Location;
import Direction.Direction;
import Occupation.*;
import StatContainer.*;
import Inventory.*;

public class Avatar extends Entity {
    //
    public Avatar(int level, Occupation occupation) {
        setName("Avatar");
        //setLocation(new Location());
        //setDirection(Direction.South);
        setOccupation(occupation);
        setStats(new AvatarStats(occupationModifier(), level));
        setInventory(new Inventory(12, 25));
        //setEquipment(new Equipment());
    }
}

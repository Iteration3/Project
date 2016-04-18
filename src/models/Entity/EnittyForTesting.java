package models.Entity;

import utilities.Direction.Direction;
import utilities.Location.Location;

import java.awt.*;

/**
 * Created by jcvarela on 4/16/2016.
 */
public class EnittyForTesting extends Entity{

    public void setLocation(Location loc){
        super.setLocation(loc);
    }

    public Direction getDirection(){return this.direction; }
    public void setDirection(Direction d){direction = d;}
}

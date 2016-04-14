package Utilities.Direction;

import utilities.Location.Location;

/**
 * Created by walkhard on 4/7/16.
 */
public enum Direction {
    //TODO: I DONT THINK THIS ONE SHOULD CREATE NEXT LOCATION

    North(new Location(-1,0,0), new Location(-1,0,0)),
    NorthWest(new Location(-1,-1,0), new Location(0,-1,0)),
    SouthWest(new Location(0,-1,0), new Location(1,-1,0)),
    South(new Location(1,0,0), new Location(1,0,0)),
    SouthEast(new Location(0,1,0), new Location(1,1,0)),
    NorthEast(new Location(-1,1,0), new Location(0,1,0));

    private Location evenCol;
    private Location oddCol;

    Direction(Location evenCol, Location oddCol){
        this.evenCol = evenCol;
        this.oddCol = oddCol;
    }

    public Location getNextLocation(Location now){
        Location move = (now.getCol()%2 == 0)?evenCol :oddCol;
        return now.add(move);
    }
}
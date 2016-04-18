package utilities.Direction;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import utilities.Location.Location;
import utilities.SaveLoad.Saveable;

/**
 * Created by walkhard on 4/7/16.
 */
public enum Direction implements Saveable {
    //TODO: I DONT THINK THIS ONE SHOULD CREATE NEXT LOCATION

    NorthWest(new Location(-1,-1,0), new Location(0,-1,0)),
    North(new Location(-1,0,0), new Location(-1,0,0)),
    NorthEast(new Location(-1,1,0), new Location(0,1,0)),
    SouthEast(new Location(0,1,0), new Location(1,1,0)),
    South(new Location(1,0,0), new Location(1,0,0)),
    SouthWest(new Location(0,-1,0), new Location(1,-1,0)),
    //TODO:SHOULD NOT BE HERE
    Up( new Location(0,0,1), new Location(0,0,1) ),
    Down( new Location(0,0,-1), new Location(0,0,-1) );

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

    @Override
    public Element generateXml(Document document) {
        Element element = document.createElement("direction");
        element.setTextContent(toString());
        return element;
    }

    public static Direction fromXmlElement(Element element) {
        return Direction.valueOf(element.getTextContent());
    }

    public static Direction counterCloclwise(Direction selected){
        int pos = selected.ordinal();
        if(pos == 0){
            return Direction.values()[Direction.values().length -3];
        }
        return Direction.values()[pos -1];
    }
    public static Direction clockwise(Direction selected){

        int pos = selected.ordinal();
        if(pos == Direction.values().length-3){
            return Direction.values()[0];
        }
        return Direction.values()[pos + 1];
    }
}

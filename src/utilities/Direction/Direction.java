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

    @Override
    public Element generateXml(Document document) {
        Element element = document.createElement("direction");
        element.setTextContent(toString());
        return element;
    }

    public static Direction fromXmlElement(Element element) {
        return Direction.valueOf(element.getTextContent());
    }
}
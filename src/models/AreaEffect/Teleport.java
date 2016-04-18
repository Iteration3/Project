package models.AreaEffect;

import models.Entity.Entity;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import models.Map.Map;
import utilities.Location.Location;

/**
 * Created by Andy on 4/14/2016.
 */
public class Teleport extends AreaEffect {
    Location toLoc;
    Map map;

    public Teleport(Location from,Location to, Map m){
        loc = from;
        toLoc = to;
        map = m;
    }

    public void execute(Entity e){
        teleportEntity(e);
    }

    private void teleportEntity(Entity e){
        e.changeLocation(toLoc);
       // map.getTileAt(loc).removeEntity();
        map.removeEntityAt(loc);
    }

    @Override
    public Element generateXml(Document doc) {
        Element element = doc.createElement("teleport-area-effect");
        element.appendChild(loc.generateXml(doc));
        element.appendChild(toLoc.generateXml(doc));
        return element;
    }

    @Override
    protected AreaEffect clone() {
        return new Teleport(loc, toLoc, map);
    }

    @Override
    protected void initWithXml(Element element) {
        Element location = (Element) element.getElementsByTagName("location").item(0);
        loc = Location.fromXmlElement(location);
        Element toLocation = (Element) element.getElementsByTagName("location").item(1);
        toLoc = Location.fromXmlElement(toLocation);
    }
}

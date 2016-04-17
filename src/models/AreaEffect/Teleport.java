package models.AreaEffect;

import models.Entity.Entity;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import utilities.Location.Location;

/**
 * Created by Andy on 4/14/2016.
 */
public class Teleport extends AreaEffect {
    Location toLoc;

    public Teleport(Location from,Location to){
        loc = from;
        toLoc = to;
    }

    public void execute(Entity e){
        teleportEntity(e);
    }

    private void teleportEntity(Entity e){
        e.changeLocation(toLoc);
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
        return new Teleport(loc, toLoc);
    }

    @Override
    protected void initWithXml(Element element) {
        Element location = (Element) element.getElementsByTagName("location").item(0);
        loc = Location.fromXmlElement(location);
        Element toLocation = (Element) element.getElementsByTagName("location").item(1);
        toLoc = Location.fromXmlElement(toLocation);
    }
}

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

    public Teleport(Location l){
        toLoc = l;
    }

    public Teleport(Element element) {
        this(Location.fromXmlElement((Element) element.getFirstChild()));
        loc = Location.fromXmlElement((Element) element.getLastChild());
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
        element.appendChild(toLoc.generateXml(doc));
        element.appendChild(loc.generateXml(doc));
        return element;
    }
}

package models.AreaEffect;

import models.Entity.Entity;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import utilities.Location.Location;
import utilities.SaveLoad.Saveable;

public abstract class AreaEffect implements Saveable {
    Location loc;

    public Location getLocation(){
        return loc;
    }
    public void setLocation(Location l){
        loc = l;
    }

    public abstract void execute(Entity e);

    /**
     * Generate the default XML for an AreaEffect. Force subclasses to explicitly
     * opt-in to this behavior so that we avoid bugs where we forget to override the method in a subclass.
     */
    protected Element generateDefaultXml(Document doc, String tagName) {
        Element element = doc.createElement(tagName);
        element.appendChild(loc.generateXml(doc));
        return element;
    }

    public static AreaEffect fromXmlElement(Element element) {
        String tagName = element.getTagName();
        AreaEffect a = null;
        switch (tagName) {
            case "flow-tile-area-effect": a = new FlowTile(); break;
            case "gain-health-area-effect": a = new GainHealth(); break;
            case "instant-death-area-effect": a =  new InstantDeath(); break;
            case "level-up-area-effect": a = new LevelUp(); break;
            case "lose-health-area-effect": a = new LoseHealth(); break;
            case "teleport-area-effect": return new Teleport(element);
            case "trap-area-effect": a = new Trap(); break;
        }
        a.initWithXml(element);
        return a;
    }

    protected void initWithXml(Element element) {
    }
}
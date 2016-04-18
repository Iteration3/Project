package models.AreaEffect;

import models.Entity.Entity;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import utilities.Direction.Direction;
import utilities.Location.Location;
import utilities.SaveLoad.Saveable;

import java.util.HashMap;

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


    private static HashMap<String, AreaEffect> prototypes = new HashMap<>();
    static {
        prototypes.put("flow-tile-area-effect", new FlowTile(null, 0, Direction.Down, null));
        prototypes.put("gain-health-area-effect", new GainHealth(null, 0));
        prototypes.put("instant-death-area-effect", new InstantDeath(null));
        prototypes.put("level-up-area-effect", new LevelUp(null, 0));
        prototypes.put("lose-health-area-effect", new LoseHealth(null, 0));
        prototypes.put("teleport-area-effect", new Teleport(null, null, null));
        prototypes.put("trap-area-effect", new Trap(null));
    }

    public static AreaEffect fromXmlElement(Element element) {
        String tagName = element.getTagName();
        AreaEffect effect = prototypes.get(tagName).clone();
        effect.initWithXml(element);
        return effect;
    }

    protected abstract AreaEffect clone();
    protected abstract void initWithXml(Element element);
}

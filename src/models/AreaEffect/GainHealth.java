package models.AreaEffect;

import models.Entity.Entity;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import utilities.Location.Location;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andy on 4/14/2016.
 */
public class GainHealth extends AreaEffect {

    int health;

   public GainHealth(Location l, int h){
       loc = l;
       health = h;
   }

    public void execute(Entity e){
        System.out.println("Should add health.");
        healEntity(e);
    }

    private void healEntity(Entity e){
        Map statChange = new HashMap<>();
        statChange.put("Life",10);
        e.modifyStats(statChange);
    }

    @Override
    public Element generateXml(Document doc) {
        Element element = super.generateDefaultXml(doc, "gain-health-area-effect");
        element.setAttribute("amount", Integer.toString(health));
        return element;
    }

    @Override
    protected AreaEffect clone() {
        return new GainHealth(loc, health);
    }

    @Override
    protected void initWithXml(Element element) {
        Element location = (Element) element.getElementsByTagName("location").item(0);
        loc = Location.fromXmlElement(location);
        health = Integer.parseInt(element.getAttribute("health"));
    }
}

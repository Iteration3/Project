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
public class InstantDeath extends AreaEffect {

    public InstantDeath(Location l){
        loc = l;
    }

    public void execute(Entity e){
        killEntity(e);
    }

    private void  killEntity(Entity e){
        //double a = e.statValue("Life");
        //a = a*-1;
        Map<String, Double> statChange = new HashMap<>();
        statChange.put("LIVES",-1.0);
        e.modifyStats(statChange);

    }

    @Override
    public Element generateXml(Document doc) {
        return super.generateDefaultXml(doc, "death-area-effect");
    }

    @Override
    protected AreaEffect clone() {
        return new InstantDeath(loc);
    }

    @Override
    protected void initWithXml(Element element) {
        Element location = (Element) element.getElementsByTagName("location").item(0);
        loc = Location.fromXmlElement(location);
    }
}

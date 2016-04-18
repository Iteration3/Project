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
public class LoseHealth extends AreaEffect {

    double healthLoss;
    public LoseHealth(Location l, int health){
        loc = l;
        healthLoss = health;
        if(healthLoss > 0){
            healthLoss = healthLoss*-1;
        }
    }

    public void execute(Entity e){
        loseHealth(e);
    }

    private void loseHealth(Entity e){
        Map<String, Double> statChange = new HashMap<>();
        statChange.put("CURRENT_LIFE",healthLoss);
        e.modifyStats(statChange);

    }

    @Override
    public Element generateXml(Document doc) {
        Element element = doc.createElement("lose-health-area-effect");
        element.appendChild(loc.generateXml(doc));
        element.setAttribute("amount", String.valueOf(healthLoss));
        return element;
    }

    @Override
    protected AreaEffect clone() {
        return new LoseHealth(loc, (int) healthLoss);
    }

    @Override
    protected void initWithXml(Element element) {
        Element location = (Element) element.getElementsByTagName("location").item(0);
        loc = Location.fromXmlElement(location);
        healthLoss = Double.parseDouble(element.getAttribute("amount"));
    }
}

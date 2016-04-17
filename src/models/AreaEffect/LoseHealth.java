package models.AreaEffect;

import models.Entity.Entity;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andy on 4/14/2016.
 */
public class LoseHealth extends AreaEffect {

    public void execute(Entity e){
        loseHealth(e);
    }

    private void loseHealth(Entity e){
        Map statChange = new HashMap<>();
        statChange.put("Life",-10);
        e.modifyStats(statChange);
    }

    @Override
    public Element generateXml(Document doc) {
        Element element = doc.createElement("gain-health-area-effect");
        element.appendChild(loc.generateXml(doc));
        return element;
    }
}

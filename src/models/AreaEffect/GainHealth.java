package models.AreaEffect;

import models.Entity.Entity;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andy on 4/14/2016.
 */
public class GainHealth extends AreaEffect {

    int health;


    public void test(){
        getLocation();
        setLocation(loc);
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
        Element element = doc.createElement("gain-health-area-effect");
        element.setAttribute("amount", Integer.toString(health));
        element.appendChild(loc.generateXml(doc));
        return element;
    }
}

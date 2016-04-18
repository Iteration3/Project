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
public class LevelUp extends AreaEffect {

    private double levels;

    public LevelUp(Location l, int lev){
        loc = l;
        levels = lev;
    }
    public void execute(Entity e){
        levelUp(e);
    }

    private void levelUp(Entity e){
        Map<String, Double> statChange = new HashMap<>();
        statChange.put("LEVEL",levels);
        e.modifyStats(statChange);
    }

    @Override
    public Element generateXml(Document doc) {
        Element e = generateDefaultXml(doc, "level-up-area-effect");
        e.setAttribute("levels", String.valueOf(levels));
        return e;
    }

    @Override
    protected AreaEffect clone() {
        return new LevelUp(loc, levels);
    }

    @Override
    protected void initWithXml(Element element) {
        Element location = (Element) element.getElementsByTagName("location").item(0);
        loc = Location.fromXmlElement(location);
        levels = Integer.parseInt(element.getAttribute("levels"));
    }
}

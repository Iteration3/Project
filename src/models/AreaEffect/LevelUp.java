package models.AreaEffect;

import models.Entity.Entity;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andy on 4/14/2016.
 */
public class LevelUp extends AreaEffect {

    public void execute(Entity e){
        levelUp(e);
    }

    private void levelUp(Entity e){
        Map statChange = new HashMap<>();
        statChange.put("Level", 1);
        e.modifyStats(statChange);
    }

    @Override
    public Element generateXml(Document doc) {
        return generateDefaultXml(doc, "level-up-area-effect");
    }
}

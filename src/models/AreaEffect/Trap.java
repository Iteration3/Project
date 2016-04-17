package models.AreaEffect;

import models.Entity.Entity;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andy on 4/14/2016.
 */
public class Trap extends AreaEffect {

    public void execute(Entity e){
        trap(e);
    }

    private void trap(Entity e){
        Map statChange = new HashMap<>();
        statChange.put("Movement",-100);
        e.modifyStats(statChange);

        //okay so how the fuck do i do this. Need to wait a certain amount of time and then do something.
    }

    @Override
    public Element generateXml(Document doc) {
        return super.generateDefaultXml(doc, "trap-area-effect");
    }
}

package models.AreaEffect;

import models.Entity.Entity;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import utilities.Location.Location;

/**
 * Created by Andy on 4/14/2016.
 */
public class FlowTile extends AreaEffect {


    public void execute(Entity e){
        flow(e);
    }

    private void flow(Entity e){
        //yeah I should probably figure this out.
        int x,y;
        Location temp = loc;
        y =temp.getCol();
        
        e.getLocation();
    }

    @Override
    public Element generateXml(Document doc) {
        Element element = doc.createElement("flow-tile-area-effect");
        element.appendChild(loc.generateXml(doc));
        return element;
    }
}

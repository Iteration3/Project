package models.AreaEffect;

import models.Entity.Entity;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import utilities.Location.Location;

/**
 * Created by Andy on 4/14/2016.
 */
public class FlowTile extends AreaEffect {

    private int flowRate;

    public FlowTile(Location l, int rate){
        loc = l;
        flowRate = rate;
    }

    public void execute(Entity e){
        flow(e);
    }


    private void flow(Entity e){
        //yeah I should probably figure this out.
        Location l = getMoveLocation();
        e.changeLocation(l);
    }

    private Location getMoveLocation(){
        int x,y,z;
        x = loc.getRow();
        y = loc.getCol()-1;
        z = loc.getHeight();
        Location temp = new Location(x,y,z);
        return temp;
    }

    @Override
    public Element generateXml(Document doc) {
        Element element = super.generateDefaultXml(doc, "flow-tile-area-effect");
        element.setAttribute("flowRate", String.valueOf(flowRate));
        return element;
    }

    @Override
    protected AreaEffect clone() {
        return new FlowTile(loc,  flowRate);
    }

    @Override
    protected void initWithXml(Element element) {
        Element location = (Element) element.getElementsByTagName("location").item(0);
        loc = Location.fromXmlElement(location);
        flowRate = Integer.parseInt(element.getAttribute("flowRate"));
    }
}

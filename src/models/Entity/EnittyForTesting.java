package models.Entity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import utilities.Location.Location;

/**
 * Created by jcvarela on 4/16/2016.
 */
public class EnittyForTesting extends Entity{

    public void setLocation(Location loc){
        super.setLocation(loc);
    }

    @Override
    public Element generateXml(Document doc) {
        return super.generateXml(doc, "entity-for-test");
    }
}

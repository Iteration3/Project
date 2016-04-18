package models.Entity;


import models.Occupation.*;
import models.StatContainer.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.awt.*;

public class Mount extends Entity {
    //
    public Mount(int level, Occupation occupation) {
        setName("Mount");
        //setLocation(new Location());
        //setDirection(models.Direction.South);
        setOccupation(occupation);
        setStats(new MountStats());
        //setInventory(new models.Inventory());
        //setEquipment(new models.Equipment());
    }

    @Override
    public Element generateXml(Document doc) {
        return super.generateXml(doc, "mount");
    }

    @Override
    public Image getImage() {
        return null;
    }
}

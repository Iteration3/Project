package models.Entity;


import models.Occupation.*;
import models.StatContainer.*;
import models.Inventory.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Avatar extends Entity {
    //
    public Avatar(int level, Occupation occupation) {
        setName("Avatar");
        //setLocation(new Location());
        //setDirection(models.Direction.South);
        setOccupation(occupation);
        setStats(new AvatarStats(occupationModifier(), level));
        setInventory(new Inventory(12, 25));
        //setEquipment(new models.Equipment());
    }

    @Override
    public Element generateXml(Document doc) {
        return super.generateXml(doc, "avatar");
    }
}

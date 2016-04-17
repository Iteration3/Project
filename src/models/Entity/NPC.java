package models.Entity;


import models.Occupation.*;
import models.StatContainer.*;
import models.Inventory.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class NPC extends Entity {
    //
    public NPC(int level, Occupation occupation) {
        setName("NPC");
        //setLocation(new Location());
        //setDirection(models.Direction.South);
        setOccupation(occupation);
        setStats(new NPCStats(occupationModifier(), level));
        setInventory(new Inventory(12));
        //setEquipment(new models.Equipment());
    }

    @Override
    public Element generateXml(Document doc) {
        return super.generateXml(doc, "npc");
    }
}

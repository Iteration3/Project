package models.Entity;


import models.Occupation.*;
import models.StatContainer.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Pet extends Entity {
    //
    public Pet(int level, Occupation occupation) {
        setName("Pet");
        //setLocation(new Location());
        //setDirection(models.Direction.South);
        setOccupation(occupation);
        setStats(new PetStats(occupationModifier(), level));
        //setInventory(new models.Inventory());
        //setEquipment(new models.Equipment());
    }

    @Override
    public Element generateXml(Document doc) {
        return super.generateXml(doc, "pet");
    }
}

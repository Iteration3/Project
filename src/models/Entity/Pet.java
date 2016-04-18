package models.Entity;

import models.Inventory.Inventory;
import models.Occupation.*;
import models.StatContainer.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import models.StatContainer.PetStats;
import utilities.Location.Location;

import javax.swing.*;
import java.awt.*;

public class Pet extends Entity {

    public Pet(int level, Occupation occupation) {

        setName("Pet");
        setLocation(new Location(0,1,0));
        setDirection(utilities.Direction.Direction.South);
        setOccupation(occupation);
        setStats(new PetStats(occupationModifier(), level));
        setInventory(new Inventory(12, 25));
//        setEquipment(new models.Equipment());
    }

    @Override
    public Image getImage() {
        Image image = new ImageIcon("res/staff.png").getImage();
        return image;
    }

    @Override
    public Element generateXml(Document doc) {
        return super.generateXml(doc, "pet");
    }
}

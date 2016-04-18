package models.Entity;


import models.Occupation.*;
import models.StatContainer.*;
import models.Inventory.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import utilities.Location.Location;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Avatar extends Entity {
    //
    public Avatar(int level, Occupation occupation) {
        setName("Avatar");
        setLocation(new Location(0,0,0));
        setDirection(utilities.Direction.Direction.South);
        setOccupation(occupation);
        setStats(new AvatarStats(occupationModifier(), level));
        setInventory(new Inventory(12, 25));
        //setEquipment(new models.Equipment());
    }

    @Override
    public Element generateXml(Document doc) {
        return super.generateXml(doc, "avatar");
    }

    @Override
    public Image getImage(){
        Image image = new ImageIcon("res/fireball.png").getImage();
        return image;
    }
}

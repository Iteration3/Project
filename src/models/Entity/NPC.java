package models.Entity;


import AI.AIController;
import controllers.NPCController;
import models.Map.Map;
import models.Occupation.*;
import models.StatContainer.*;
import models.Inventory.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.swing.*;
import java.awt.*;

public class NPC extends Entity {
    //
    public NPC(int level, Occupation occupation) {
        setName("NPC");
//        setDirection(models.Direction.South);
        setOccupation(occupation);
        setStats(new NPCStats(occupationModifier(), level));
        setInventory(new Inventory(12));
        setCurrentState(States.WANDER);
        //setEquipment(new models.Equipment());
    }

    @Override
    public Element generateXml(Document doc) {
        return super.generateXml(doc, "npc");
    }

    @Override
    public AIController createNewController(Map map) {
        return new NPCController(this, map);
    }

    public Image getImage() {
        Image image = new ImageIcon("res/twoHand.png").getImage();
        return image;
    }
}

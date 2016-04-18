package models.Entity;

import AI.AIController;
import controllers.PetController;
import models.Inventory.Inventory;
import models.Occupation.*;
import models.Map.Map;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import models.StatContainer.PetStats;
import utilities.Location.Location;

import javax.swing.*;
import java.awt.*;

public class Pet extends Entity {

    private Avatar avatar;

    public Pet(int level, Occupation occupation) {

        setName("Pet");
        setLocation(new Location(0,1,0));
        setDirection(utilities.Direction.Direction.South);
        setOccupation(occupation);
        setStats(new PetStats(occupationModifier(), level));
        setInventory(new Inventory(12, 25));
        setCurrentState(States.WANDER);
//        setEquipment(new models.Equipment());
    }

    @Override
    public AIController createNewController(Map map) {
        return new PetController(this, map, avatar);
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

    public void setOwnership(Avatar avatar){
        this.avatar = avatar;
    }


    public Location getAvatarLocation(){
        return avatar.getLocation();
    }
}

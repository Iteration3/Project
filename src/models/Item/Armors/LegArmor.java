package models.Item.Armors;

import models.Equipment.Equipment;
import models.Inventory.Inventory;
import utilities.Location.Location;

import java.awt.image.BufferedImage;

/**
 *  Implemented by Peter Camejo
 */
public class LegArmor extends Armor {
    /* Constructor */
    public LegArmor(){
        super();
    }

    public LegArmor(BufferedImage image , int id, Location location, String name, double rating){
        super(image, id, location, name ,rating);
    }

    /* Methods */
    public void equip(Equipment equipment, Inventory inventory){
        equipment.addLegs(this);
        inventory.removeItem(id);
    }

    public void unequip(Equipment equipment, Inventory inventory){
        equipment.removeLegs();
        inventory.addItem(this);
    }

}
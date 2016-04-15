package models.Item.Armors;

import models.Equipment.Equipment;
import models.Inventory.Inventory;
import Utilities.Location;

import java.awt.image.BufferedImage;

/**
 *  Implemented by Peter Camejo
 */
public class ChestArmor extends Armor {
    /* Constructor */
    public ChestArmor(){
        super();
    }

    public ChestArmor(BufferedImage image , int id, Location location, String name, double rating){
        super(image, id, location, name ,rating);
    }

    /* Methods */
    public void equip(Equipment equipment , Inventory inventory){
        equipment.addChest(this);
        inventory.removeItem(id);
    }

    public void unequip(Equipment equipment , Inventory inventory){
        equipment.removeChest();
        inventory.addItem(this);
    }

}

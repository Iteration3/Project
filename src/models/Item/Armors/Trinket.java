package models.Item.Armors;

import models.Equipment.Equipment;
import models.Inventory.Inventory;
import Utilities.Location.Location;

import java.awt.image.BufferedImage;


/**
 *  Implemented by Peter Camejo
 */
public class Trinket extends Armor {
    /* Constructor */
    public Trinket(){
        super();
    }

    public Trinket(BufferedImage image , int id, Location location, String name, double rating){
        super(image, id, location, name ,rating);
    }

    /* Methods */
    public void equip(Equipment equipment , Inventory inventory){
        equipment.addTrinket(this);
        inventory.removeItem(id);
    }

    public void unequip(Equipment equipment, Inventory inventory){
        equipment.removeTrinket();
        inventory.addItem(this);
    }
}
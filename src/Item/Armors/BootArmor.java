package Item.Armors;

import Equipment.Equipment;
import Inventory.Inventory;
import Location.Location;

import java.awt.image.BufferedImage;


/**
 *  Implemented by Peter Camejo
 */
public class BootArmor extends Armor{
    /* Constructor */
    public BootArmor(){
        super();
    }

    public BootArmor(BufferedImage image , int id, Location location, String name, double rating){
        super(image, id, location, name ,rating);
    }

    /* Methods */
    public void equip(Equipment equipment, Inventory inventory){
        equipment.addBoots(this);
        inventory.removeItem(id);
    }

    public void unequip(Equipment equipment, Inventory inventory){
        equipment.removeBoots();
        inventory.addItem(this);
    }


}
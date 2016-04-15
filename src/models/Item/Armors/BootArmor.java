package models.Item.Armors;

import models.Entity.Entity;
import models.Equipment.Equipment;
import models.Inventory.Inventory;
import utilities.Location.Location;


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
    public void equip(Entity entity, Equipment equipment, Inventory inventory){
        equipment.addBoots(this);
        inventory.removeItem(id);
        this.applyRating(entity);
    }

    public void unequip(Entity entity, Equipment equipment, Inventory inventory){
        equipment.removeBoots();
        inventory.addItem(this);
        this.unapplyRating(entity);
    }


}
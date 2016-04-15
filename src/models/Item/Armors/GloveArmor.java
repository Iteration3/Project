package models.Item.Armors;

import models.Entity.Entity;
import models.Equipment.Equipment;
import models.Inventory.Inventory;
import utilities.Location.Location;

import java.awt.image.BufferedImage;


/**
 *  Implemented by Peter Camejo
 */
public class GloveArmor extends Armor {
    /* Constructor */
    public GloveArmor(){
        super();
    }

    public GloveArmor(BufferedImage image , int id, Location location, String name, double rating){
        super(image, id, location, name ,rating);
    }

    /* Methods */
    public void equip(Entity entity , Equipment equipment , Inventory inventory){
        equipment.addGloves(this);
        inventory.removeItem(id);
        this.applyRating(entity);
    }

    public void unequip(Entity entity , Equipment equipment, Inventory inventory){
        equipment.removeGloves();
        inventory.addItem(this);
        this.unapplyRating(entity);
    }

}
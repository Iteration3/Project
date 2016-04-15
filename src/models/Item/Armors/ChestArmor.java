package models.Item.Armors;

import models.Entity.Entity;
import models.Equipment.Equipment;
import models.Inventory.Inventory;
import utilities.Location.Location;
import views.Assets;

import java.awt.image.BufferedImage;

/**
 *  Implemented by Peter Camejo
 */
public class ChestArmor extends Armor {
    /* Constructor */
    public ChestArmor(){
        super();
    }

    public ChestArmor( int id, Location location, String name, double rating){
        super(Assets.chestArmor , id, location, name ,rating);
    }

    /* Methods */
    public void equip(Entity entity , Equipment equipment , Inventory inventory){
        equipment.addChest(this);
        inventory.removeItem(id);
        this.applyRating(entity);
    }

    public void unequip(Entity entity, Equipment equipment , Inventory inventory){
        equipment.removeChest();
        inventory.addItem(this);
        this.unapplyRating(entity);
    }

}
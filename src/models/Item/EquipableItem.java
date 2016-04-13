package models.Item;

import java.awt.image.BufferedImage;
import models.Inventory.Inventory;
import models.Equipment.Equipment;
import models.Entity.Entity;
import Utilities.Location;

/*
* Implemented by Peter Camejo
*/

public abstract class EquipableItem extends TakeableItem {
    /* Attributes */
    protected double rating; //meant to be armorRating and attackRating respectively.

    /* Constructor */
    public EquipableItem(){
        super();
    }

    public EquipableItem(BufferedImage image , int id, Location location, String name , double rating){
        super(image, id, location, name);
        this.rating = rating;
    }

    /* Methods */

    public abstract void equip(Equipment equipment , Inventory inventory);
    public abstract void unequip(Equipment equipment , Inventory inventory);
    public abstract void applyRating(Entity entity);
    public abstract void unapplyRating(Entity entity);

    public void use(Entity entity){
       entity.equip(this);
    }

    public double getRating(){
        return this.rating;
    }
    public void setRating(double rating){
        this.rating  = rating;
        return;
    }

}

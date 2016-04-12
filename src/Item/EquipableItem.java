package Item;

import java.awt.image.BufferedImage;
import Inventory.Inventory;
import Equipment.Equipment;
import Location.Location;
import Entity.Entity;

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

    public void use(Entity entity){
       // this.equip(entity.getEquipment() , entity.getInventory());
    }

    public double getRating(){
        return this.rating;
    }
    public void setRating(double rating){
        this.rating  = rating;
        return;
    }
}

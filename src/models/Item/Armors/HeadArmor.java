package models.Item.Armors;


import models.Entity.Entity;
import models.Inventory.Inventory;
import models.Equipment.Equipment;
import utilities.Location.Location;

import java.awt.image.BufferedImage;

/**
 *  Implemented by Peter Camejo
 */
public class HeadArmor extends Armor{
    /*Constructors*/
    public HeadArmor(){
        super();
    }

    public HeadArmor(BufferedImage image , int id, Location location, String name, double rating){
        super(image, id, location, name ,rating);
    }


    /* Methods */
    public void equip(Entity entity, Equipment equipment , Inventory inventory) {
        /*
        if(equipment.hasHead()){
            equipment.getHead().unequip(equipment , inventory); //NOT OOP. Should probably do this within models.Equipment State
        }
        */
        equipment.addHead(this);
        inventory.removeItem(id);
        this.applyRating(entity);
    }

    public void unequip(Entity entity, Equipment equipment, Inventory inventory) {
        inventory.addItem(this);
        equipment.removeHead();
        this.unapplyRating(entity);
    }

}
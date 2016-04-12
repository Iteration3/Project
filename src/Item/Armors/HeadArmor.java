package Item.Armors;


import Inventory.Inventory;
import Equipment.Equipment;
import Location.Location;

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
    public void equip(Equipment equipment , Inventory inventory) {
        /*
        if(equipment.hasHead()){
            equipment.getHead().unequip(equipment , inventory); //NOT OOP. Should probably do this within Equipment State
        }
        */
        equipment.addHead(this);
        inventory.removeItem(id);
    }

    public void unequip(Equipment equipment, Inventory inventory) {
        inventory.addItem(this);
        equipment.removeHead();
    }

}
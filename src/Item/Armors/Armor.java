package Item.Armors;

import Item.EquipableItem;

import java.awt.image.BufferedImage;
import Location.Location;

/**
 *  Implemented by Peter Camejo
 *
 *  Class is meant to insure that armor pieces are of the type Armor
 */
public abstract class Armor extends EquipableItem {
    /* Constructor */
    public Armor(){
        super();
    }

    public Armor(BufferedImage image , int id, Location location, String name, double rating){
        super(image, id, location, name ,rating);
    }

}
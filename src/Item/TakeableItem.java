package Item;

import java.awt.image.BufferedImage;
import Entity.Entity;
import Location.Location;

/**
 *  Implemented by Peter Camejo
 */
public abstract class TakeableItem extends Item{
    /* Constructors */
    TakeableItem(){
        super();
    }

    TakeableItem(BufferedImage image , int id, Location location, String name){
        super(image, id, location, name);
    }

    /* Methods */
    public void activate(Entity entity){
        entity.addItem(this);
    }

    public abstract void use(Entity entity);

}

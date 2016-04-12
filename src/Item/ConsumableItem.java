package Item;



import java.awt.image.BufferedImage;
import Inventory.Inventory;
import Equipment.Equipment;
import Location.Location;
import Entity.Entity;

/**
 *  Implemented by Peter Camejo
 */
public abstract class ConsumableItem extends TakeableItem {
    /* Attributes */
    //StatModifier

    /* Constructor */
    public ConsumableItem(){
        super();
    }

    public ConsumableItem(BufferedImage image , int id, Location location, String name /* Stat Modifier */){
        super(image, id, location, name);
        /* this.StatMod = statmod */
    }

    /* Methods */

    public abstract void equip(Equipment equipment , Inventory inventory);
    public abstract void unequip(Equipment equipment , Inventory inventory);

    public void use(Entity entity){
        // entity.ModifyStats(Stat Modifier)
        // entity.removeItem(this);
    }

}
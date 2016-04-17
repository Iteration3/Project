package models.Item.Armors;

import models.Entity.Entity;
import models.Equipment.Equipment;
import models.Inventory.Inventory;
import models.Item.Item;
import org.w3c.dom.Element;
import utilities.Location.Location;
import views.Assets;


import java.awt.image.BufferedImage;


/**
 *  Implemented by Peter Camejo
 */
public class BootArmor extends Armor{
    /* Constructor */
    public BootArmor(){
        super();
    }

    @Override
    public Item clone() {
        return null;
    }


    public BootArmor( int id, String name, double rating){
        super(Assets.bootArmor , id, name ,rating);
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

    @Override
    protected String getXmlTagName() {
        return "boot-armor";
    }

}
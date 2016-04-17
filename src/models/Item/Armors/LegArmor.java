package models.Item.Armors;

import models.Entity.Entity;
import models.Equipment.Equipment;
import models.Inventory.Inventory;
import models.Item.Item;
import utilities.Location.Location;
import views.Assets;

import java.awt.image.BufferedImage;

/**
 *  Implemented by Peter Camejo
 */
public class LegArmor extends Armor {
    /* Constructor */
    public LegArmor(){
        super();
    }

    @Override
    public Item clone() {
        return new LegArmor(id, name, rating);
    }

    public LegArmor( int id,  String name, double rating){
        super(Assets.legArmor, id, name ,rating);
    }

    public LegArmor( int id,  String name, double rating , int requiredLevel){
        super(Assets.legArmor, id, name ,rating , requiredLevel);
    }

    /* Methods */
    public void equip(Entity entity , Equipment equipment, Inventory inventory){
        equipment.addLegs(this);
        inventory.removeItem(id);
        this.applyRating(entity);
    }

    public void unequip(Entity entity ,Equipment equipment, Inventory inventory){
        equipment.removeLegs();
        inventory.addItem(this);
        this.unapplyRating(entity);
    }

    @Override
    protected String getXmlTagName() {
        return "leg-armor";
    }


}
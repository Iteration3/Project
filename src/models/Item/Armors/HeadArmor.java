package models.Item.Armors;


import models.Entity.Entity;
import models.Inventory.Inventory;
import models.Equipment.Equipment;
import models.Item.Item;
import utilities.Location.Location;
import views.Assets;

import java.awt.image.BufferedImage;

/**
 *  Implemented by Peter Camejo
 */
public class HeadArmor extends Armor {
    /*Constructors*/
    public HeadArmor(){
        super();
    }

    @Override
    public Item clone() {
        return new HeadArmor(id, name, rating);
    }

    public HeadArmor(int id, String name, double rating){
        super(Assets.headArmor, id,  name ,rating);
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

    @Override
    protected String getXmlTagName() {
        return "head-armor";
    }

}
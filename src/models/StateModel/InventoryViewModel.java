package models.StateModel;

import models.Entity.Entity;
import models.Equipment.Equipment;
import models.Inventory.Inventory;
import models.Item.EquipableItem;
import models.Item.TakeableItem;
import utilities.State.State;

/**
 * Implemented by Peter Camejo
 */
public class InventoryViewModel{
    private Entity entity;
    private Inventory inventory;
    private Equipment equipment;
    private TakeableItem[] items;
    private TakeableItem currentItem;
    private int goldAmount;
    int index;

    public InventoryViewModel(){
        entity = null;
        equipment = null;
        inventory = null;
        items = null;
        currentItem = null;
        index = 0;
        goldAmount = 0;
    }

    public InventoryViewModel(Entity entity){
        this.entity = entity;
        inventory = entity.getInventory();
        equipment = entity.getEquipment();
        items = new TakeableItem[22];
        index = 0;
        currentItem = items[index];
    }



    public State nextState() {
        return null;
    }

    public void update() {
        int count = 0;
        items[0] = equipment.getHead();
        items[1] = equipment.getChest();
        items[2] = equipment.getGloves();
        items[3] = equipment.getLegs();
        items[4] = equipment.getBoots();
        items[5] = equipment.getTrinket();
        items[6] = equipment.getWeapon();

        for(int i = 7; i < 22; i++){
            items[i] = inventory.getItemByIndex(count++);
        }

        goldAmount = inventory.getGold();
        currentItem = items[index];
    }

    public void up(){
        if(index > 6){ //Index is in Inventory portion.
            if(index + 5 <= 21){
                index += 5;
                return;
            }
        }else{ //Index is in Equipment portion.
            index--;
            return;
        }
    }

    public void down(){
        if(index > 6){
            if(index - 5 > 6){
                index -= 5;
                return;
            }
        }else{
            index++;
            return;
        }
    }

    public void right(){
        if(index > 6){
            index++;
        }else{
            index = 7;
        }
    }

    public void left(){
        if(index == 7 || index == 12 || index == 17){
            index = 6;
            return;
        }else if(index < 7){
            return; //do nothing
        }else{
            index--;
        }
    }

    public void select(){
        if (index < 7) {
            entity.unequip((EquipableItem) currentItem);
        }else{
            entity.useItem(currentItem);
        }
    }

    public TakeableItem getCurrentItem(){
        return this.currentItem;
    }
}
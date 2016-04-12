package Inventory;

import Item.TakeableItem;
import ItemContainer.ItemContainer;

/**
 *  Implemented by Peter Camejo
 */
public class Inventory implements ItemContainer {
    /* Attributes */
    private TakeableItem[] items;
    private int goldAmount;
    private int size;

    /* Constructors */
    public Inventory(){
        size = DEFAULT_SIZE;
        items = new TakeableItem[DEFAULT_SIZE];
        goldAmount = 0;
    }

    public Inventory(int size){
        this.size = size;
        items = new TakeableItem[size];
        goldAmount = 0;
    }

    public Inventory(int size , int goldAmount){
        this.size = size;
        items = new TakeableItem[size];
        this.goldAmount = goldAmount;
    }

    /* Methods */

    public void addItem(TakeableItem item) {
        for(int i = 0; i < size; i++){
            if(items[i] != null){
                items[i] = item;
                return;
            }
        }

        System.out.println("Take Item failed: Inventory full.");

    }

    public TakeableItem removeItem(int id){
        TakeableItem itemCopy = null;

        for(int i = 0; i < size; i++){
            if(items[i].getId() == id ){
                itemCopy = items[i];
                items[i] = null;
            }
        }
        if(itemCopy == null){
            System.out.println("Remove Item failed: Item not found");
        }

        return itemCopy;
    }

    public Boolean hasItemInstance(int id){
        for(int i = 0 ; i < size; i++){
            if(items[i].getId() == id){
                return true;
            }
        }
        return false;
    }

    public void addGold(int amount){
        goldAmount += amount;
        return;
    }

    public Boolean removeGold(int amount){
        if((goldAmount - amount) < 0){  //Make sure goldAmount never goes below 0;
            return false;   //Do nothing ; return that operation failed.
        }

        goldAmount -= amount;   //else perform operation
        return true;            // and return that operation succeeded.
    }

    public int getGold(){
        return goldAmount;
    }

}
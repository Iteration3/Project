package models.Inventory;

import models.Item.ItemFactory;
import models.Item.TakeableItem;
import models.ItemContainer.ItemContainer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import utilities.SaveLoad.Saveable;

/*
* Implemented by Peter Camejo
*/

public class Inventory implements ItemContainer, Saveable {
    /* Attributes */
    public int size;
    private TakeableItem[] items;
    private int goldAmount;


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

        System.out.println("Take models.Item failed: models.Inventory full.");

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
            System.out.println("Remove models.Item failed: models.Item not found");
        }

        return itemCopy;
    }

    public TakeableItem removeItemByIndex(int index){
        TakeableItem itemCopy  = items[index];
        items[index] = null;
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

    public TakeableItem getItemByIndex(int index){
        return items[index];
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

    @Override
    public Element generateXml(Document doc) {
        Element element = doc.createElement("inventory");
        element.setAttribute("size", Integer.toString(size));
        element.setAttribute("gold", Integer.toString(goldAmount));
        Element items = doc.createElement("items");
        element.appendChild(items);

        for (TakeableItem item : this.items) {
            if (item != null) {
                items.appendChild(item.generateXml(doc));
            }
        }

        return element;
    }

    public static Inventory fromXmlElement(Element element) {
        int size = Integer.parseInt(element.getAttribute("size"));
        int gold = Integer.parseInt(element.getAttribute("gold"));
        Inventory in = new Inventory(size, gold);

        Element items = (Element) element.getElementsByTagName("items").item(0);
        NodeList itemsList = items.getChildNodes();
        for (int i = 0; i < itemsList.getLength(); ++i) {
            Element itemElement = (Element) itemsList.item(i);
            TakeableItem item = (TakeableItem) ItemFactory.fromXmlElement(itemElement);
            in.addItem(item);
        }

        return in;
    }
}
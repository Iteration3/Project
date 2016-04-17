package models.Item.InteractiveItems;

/*
* Implemented by Peter Camejo
*/

import models.Entity.Entity;
import models.Inventory.Inventory;
import models.Item.TakeableItem;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.awt.image.BufferedImage;

public class Chest extends InteractiveItem {
    /* Attributes */
    private Inventory inventory;

    /* Constructors */
    public Chest(){
        super();
        inventory = new Inventory(3);
    }

    public Chest(BufferedImage image, int id, String name , TakeableItem requiredItem , TakeableItem[] loot , int goldAmount){
        super(image, id, name, requiredItem);
        inventory = new Inventory(3);
        for(int i = 0 ; i < 3; i++) {
            inventory.addItem(loot[i]);
        }
        inventory.addGold(goldAmount);
    }

    /* Methods */
    public void passReqActivation(Entity entity) {
        for(int i = 0; i < 3; i++){
            entity.addItem(inventory.removeItemByIndex(i));
        }

        entity.destroyItem(0); // Chest Key
    }

    @Override
    public Element generateXml(Document doc) {
        Element element = doc.createElement("chest");
        element.appendChild(inventory.generateXml(doc));
        element.setAttribute("required-item-name", requirement.getRequiredItemName());
        element.setAttribute("name", name);
        element.setAttribute("id", Integer.toString(id));
        return element;
    }
}

package ItemContainer;

import Item.TakeableItem;

public interface ItemContainer {
    /* Attributes */
    int DEFAULT_SIZE = 15;

    /* Methods */
    void addItem(TakeableItem item);
    TakeableItem removeItem(int id);


}
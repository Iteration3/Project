package models.Item;

import models.Item.Weapons.*;
import models.Item.Armors.*;
import models.Item.*;
import models.Item.InteractiveItems.*;
import org.w3c.dom.Element;

import java.util.HashMap;


/**
 * Implemented by Peter Camejo
 */
public class ItemFactory {
    /* Attributes */
    private static final int CHEST_KEY = 0;

    private static final int BASIC_ONEHAND = 1;
    private static final int BASIC_TWOHAND = 2;
    private static final int BASIC_FIST = 3;
    private static final int BASIC_RANGED = 4;
    private static final int BASIC_STAFF = 5;

    private static final HashMap<String, Item> itemPrototypes = new HashMap<>();

    static {
        itemPrototypes.put("boot-armor", new BootArmor(0, "boots", 0));
        itemPrototypes.put("chest-armor", new ChestArmor(0, "chest", 0));
        itemPrototypes.put("glove-armor", new GloveArmor(0, "gloves", 0));
        itemPrototypes.put("head-armor", new HeadArmor(0, "helmet", 0));
        itemPrototypes.put("leg-armor", new LegArmor(0, "pants", 0));
        itemPrototypes.put("trinket", new Trinket(0, "trinket", 0));
        itemPrototypes.put("chest", new Chest());
        itemPrototypes.put("fist-weapon", new Fist(0, "fist", 0));
        itemPrototypes.put("one-hand-weapon", new OneHand(0, "sword", 0));
        itemPrototypes.put("ranged-weapon", new Ranged(0, "bow", 0));
        itemPrototypes.put("staff-weapon", new Staff(0, "staff", 0));
        itemPrototypes.put("two-hand-weapon", new TwoHand(0, "longsword", 0));
    }

    /* Constructor */
    public ItemFactory() { };

    /** Methods **/
    /* Weapons */
    public static OneHand getBasicOneHand(){
        return new OneHand(BASIC_ONEHAND , "Basic 1H Sword" , 5.00);
    }
    public static TwoHand getBasicTwoHand(){
        return new TwoHand(BASIC_TWOHAND , "Basic 2H AXE" , 10.00);
    }
    public static Fist getBasicFist(){
        return new Fist(BASIC_FIST, "Basic Fist" , 2.50);
    }
    public static Ranged getBasicRanged(){
        return new Ranged(BASIC_RANGED, "Basic Bow" , 5.00);
    }
    public static Staff getBasicStaff(){ return new Staff(BASIC_STAFF , "Basic Staff" , 2.50);}

    public static Item fromXmlElement(Element element) {
        Item item = itemPrototypes.get(element.getTagName()).clone();
        item.initWithXmlElement(element);
        return item;
    }
}
package models.Item;

import models.Item.Weapons.*;
import models.Item.Armors.*;
import models.Item.*;
import models.Item.InteractiveItems.*;
import org.w3c.dom.Element;

import java.util.HashMap;
import views.Assets;


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
    private static final int BASIC_HEAD_ARMOR = 6;
    private static final int BASIC_CHEST_ARMOR = 7;
    private static final int BASIC_LEG_ARMOR = 8;
    private static final int BASIC_GLOVE_ARMOR = 9;
    private static final int BASIC_BOOT_ARMOR = 10;
    private static final int BASIC_TRINKET = 11;

    private static final int POWERFUL_ONEHAND = 12;
    private static final int POWERFUL_TWOHAND = 13;
    private static final int POWERFUL_FIST = 14;
    private static final int POWERFUL_RANGED = 15;
    private static final int POWERFUL_STAFF = 16;

    private static final int POWERFUL_HEAD_ARMOR = 17;
    private static final int POWERFUL_CHEST_ARMOR = 18;
    private static final int POWERFUL_LEG_ARMOR = 19;
    private static final int POWERFUL_GLOVE_ARMOR = 20;
    private static final int POWERFUL_BOOT_ARMOR = 21;
    private static final int POWERFUL_TRINKET = 22;

    private static final int HEALTH_POTION = 23;
    private static final int MANA_POTION = 24;
    private static final int STRENGTH_POTION = 25;
    private static final int AGILITY_POTION = 26;
    private static final int INTELLECT_POTION = 27;
    private static final int EXPERIENCE_POTION = 28;

    private static final int ITEM_CHEST = 29;
    private static final int DOOR = 30;
    private static final int DOOR_KEY = 31;

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
		itemPrototypes.put("consumable-item", getHealthPotion());
    }


    /* Constructor */
    public ItemFactory() { };

    /** Methods **/
    /* Weapons */
    public static OneHand getBasicOneHand(){return new OneHand(BASIC_ONEHAND , "Basic 1H Sword" , 5.00);}
    public static TwoHand getBasicTwoHand(){return new TwoHand(BASIC_TWOHAND , "Basic 2H AXE" , 10.00);}
    public static Fist getBasicFist(){return new Fist(BASIC_FIST, "Basic Fist" , 2.50);}
    public static Ranged getBasicRanged(){return new Ranged(BASIC_RANGED, "Basic Bow" , 5.00);}
    public static Staff getBasicStaff(){ return new Staff(BASIC_STAFF , "Basic Staff" , 2.50);}

    public static OneHand getPowerfulOneHand(){ return new OneHand(5 , POWERFUL_ONEHAND , "Powerful 1H Sword" , 15.00);}
    public static TwoHand getPowerfulTwoHand(){ return new TwoHand(5 , POWERFUL_TWOHAND , "Powerful 2H Axe" , 30.00);}
    public static Fist getPowerfulFist(){ return new Fist(5, POWERFUL_FIST , "Powerful Fist" , 7.50);}
    public static Ranged getPowerfulRanged(){ return new Ranged(5, POWERFUL_RANGED , "Powerful Bow" , 15.00);}
    public static Staff getPowerfulStaff(){ return new Staff(5, POWERFUL_STAFF , "Powerful Staff" , 7.50);}

    /* Armor */
    public static HeadArmor getBasicHeadArmor(){ return new HeadArmor (BASIC_HEAD_ARMOR , "Basic Helm" , 5.00);}
    public static ChestArmor getBasicChestArmor(){ return new ChestArmor (BASIC_CHEST_ARMOR , "Basic Chestpiece" , 10.00);}
    public static LegArmor getBasicLegArmor(){ return new LegArmor(BASIC_LEG_ARMOR , "Basic Legpieces" , 10.00);}
    public static GloveArmor getBasicGloveArmor(){ return new GloveArmor(BASIC_GLOVE_ARMOR, "Basic Gloves" , 5.00);}
    public static BootArmor getBasicBootArmor(){ return new BootArmor(BASIC_BOOT_ARMOR , "Basic Boots" , 5.00);}
    public static Trinket getBasicTrinket(){ return new Trinket(BASIC_TRINKET , "Basic Trinket", 2.00);}

    public static HeadArmor getPowerfulHeadArmor(){ return new HeadArmor(POWERFUL_HEAD_ARMOR , "Powerful Helm" , 15.00 , 5);}
    public static ChestArmor getPowerfulChestArmor(){ return new ChestArmor(POWERFUL_CHEST_ARMOR , "Powerful Chestpiece" , 30.00 , 5);}
    public static LegArmor getPowerfulLegArmor(){ return new LegArmor(POWERFUL_LEG_ARMOR , "Powerful Legpieces" , 30.00 , 5);}
    public static GloveArmor getPowerfulGloveArmor(){ return new GloveArmor(POWERFUL_GLOVE_ARMOR, "Powerful Gloves" , 15.00 , 5);}
    public static BootArmor getPowerfulBootArmor(){ return new BootArmor(POWERFUL_BOOT_ARMOR , "Powerful Boots" , 15.00 , 5);}
    public static Trinket getPowerfulTrinket(){ return new Trinket(POWERFUL_TRINKET , "Powerful Trinket", 7.50 , 5);}

    /* Potions */
    public static ConsumableItem getHealthPotion(){ return new ConsumableItem("CurrentLife" , 10 , Assets.healthPotion , HEALTH_POTION , "Health Potion" );}
    public static ConsumableItem getManaPotion(){ return new ConsumableItem("CurrentMana" , 10 , Assets.manaPotion , MANA_POTION , "Mana Potion");}
    public static ConsumableItem getStrengthPotion(){ return new ConsumableItem("Strength" , 20 , Assets.strengthPotion , STRENGTH_POTION , "Strength Potion");}
    public static ConsumableItem getIntellectPotion(){ return new ConsumableItem("Intellect" , 20 , Assets.intellectPotion, INTELLECT_POTION , "Intellect Potion");}
    public static ConsumableItem getAgilityPotion(){ return new ConsumableItem("Agility" , 20, Assets.agilityPotion , AGILITY_POTION , "Agility Potion");}
    public static ConsumableItem getExperiencePotion(){ return new ConsumableItem("Experience" , 20 , Assets.experiencePotion , EXPERIENCE_POTION , "Experience Potion");}

    public static Item fromXmlElement(Element element) {
        Item item = itemPrototypes.get(element.getTagName()).clone();
        item.initWithXmlElement(element);
        return item;
    }
}

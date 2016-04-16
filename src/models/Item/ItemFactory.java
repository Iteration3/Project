package models.Item;

import models.Item.Weapons.*;
import models.Item.Armors.*;
import models.Item.*;
import models.Item.InteractiveItems.*;


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

    /* Constructor */
    public ItemFactory(){};

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
    





}
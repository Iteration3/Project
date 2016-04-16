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

    /* Constructor */
    public ItemFactory(){};

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


}

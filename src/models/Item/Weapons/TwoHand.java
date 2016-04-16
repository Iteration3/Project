package models.Item.Weapons;

import utilities.Location.Location;
import views.Assets;

import java.awt.image.BufferedImage;

/**
 *   Implemented by Peter Camejo
 *
 *   Fist weaponSpeed = 3.00;
 *   OneHand weaponSpeed = 2.00;
 *   TwoHand weaponSpeed = 1.00;
 */
public class TwoHand extends Weapon{
    /* Constructors */
    //No level requirement
    public TwoHand( int id, Location location, String name , double attackRating){
        super(1.00 , "Smasher" , Assets.twoHand , id, location, name, attackRating);
    }

    //Level requirement
    public TwoHand(int requiredLevel , int id, Location location, String name , double attackRating){
        super(1.00 , "Smasher" , requiredLevel , Assets.twoHand, id, location, name, attackRating);
    }
}

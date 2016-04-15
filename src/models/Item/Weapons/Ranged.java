package models.Item.Weapons;

import utilities.Location.Location;
import views.Assets;

import java.awt.image.BufferedImage;

/**
 *   Implemented by Peter Camejo
 *
 *   Ranged weaponSpeed = OneHand weaponSpeed = 2.00;
 *
 *
 */
public class Ranged extends Weapon{
    /* Constructors */
    //No level requirement
    public Ranged( int id, Location location, String name , double attackRating){
        super(2.00 , "Sneak" , Assets.ranged, id, location, name, attackRating);
    }

    //Level requirement
    public Ranged(int requiredLevel , int id, Location location, String name , double attackRating){
        super(2.00 , "Sneak" , requiredLevel , Assets.ranged, id, location, name, attackRating);
    }
}

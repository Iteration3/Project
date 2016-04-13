package models.Item.Weapons;

import utilities.Location.Location;

import java.awt.image.BufferedImage;

/**
 *   Implemented by Peter Camejo
 *
 *   Staff weaponSpeed = TwoHand weaponSpeed = 1.00;
 *
 *
 */
public class Staff extends Weapon{
    /* Constructors */
    //No level requirement
    public Staff(BufferedImage image , int id, Location location, String name , double attackRating){
        super(1.00 , "Summoner" , image, id, location, name, attackRating);
    }

    //Level requirement
    public Staff(int requiredLevel ,  BufferedImage image , int id, Location location, String name , double attackRating){
        super(1.00 , "Summoner" , requiredLevel , image, id, location, name, attackRating);
    }
}


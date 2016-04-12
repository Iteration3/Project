package Item.Weapons;

import java.awt.image.BufferedImage;
import Location.Location;

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
    public Ranged(BufferedImage image , int id, Location location, String name , double attackRating){
        super(2.00 , "Sneak" , image, id, location, name, attackRating);
    }

    //Level requirement
    public Ranged(int requiredLevel ,  BufferedImage image , int id, Location location, String name , double attackRating){
        super(2.00 , "Sneak" , requiredLevel , image, id, location, name, attackRating);
    }
}

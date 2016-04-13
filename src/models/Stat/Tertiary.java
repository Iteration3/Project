package models.Stat;

import static java.lang.Math.abs;

public abstract class Tertiary extends Stat {
    /*
            scale() is designed for testing by scaling stats
     */
    public void scale(double amt) {setValue(this.value *= amt);}

    /*
        modify() takes a double value. Values between -0.99 and 0.99 are calculated
        as percentage changes. Values less than -0.99 and greater than 0.99 are
        calculated as numerical values.

            EXAMPLE: stat.value = 10
                     stat.modify(.40) -> stat.value = 14.0

                     stat.value = 10
                     stat.modify(2.0) -> stat.value = 12.0
 */
    public void modify(double amt) {
        if(abs(amt) < 1.00)
            setValue(this.value + (amt * this.value));
        else
            setValue(this.value + amt);
    }
    //
    public void calculate() {}
}

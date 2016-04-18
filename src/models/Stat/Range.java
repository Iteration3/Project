package models.Stat;

/**
 * Created by denzel on 4/17/16.
 */

public class Range extends Primary {

    public Range(double base_modifier, double occupation_modifier, int level) {
        setName("Range");
        setBaseModifier(base_modifier);
        setOccupationModifier(occupation_modifier);
        calculate(level);
    }
}

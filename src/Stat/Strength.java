package Stat;

public class Strength extends Primary {
    //
    public Strength(double base_modifier, double occupation_modifier, int level) {
        setName("Strength");
        setBaseModifier(base_modifier);
        setOccupationModifier(occupation_modifier);
        calculate(level);
    }
}

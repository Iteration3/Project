package Stat;

public class Hardiness extends Primary {
    //
    public Hardiness(double base_modifier, double occupation_modifier, int level) {
        setName("Hardiness");
        setBaseModifier(base_modifier);
        setOccupationModifier(occupation_modifier);
        calculate(level);
    }
}

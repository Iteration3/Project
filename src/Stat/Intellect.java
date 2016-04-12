package Stat;

public class Intellect extends Primary {
    //
    public Intellect(double base_modifier, double occupation_modifier, int level) {
        setName("Intellect");
        setBaseModifier(base_modifier);
        setOccupationModifier(occupation_modifier);
        calculate(level);
    }
}

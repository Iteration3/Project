package models.Stat;

public class Agility extends Primary {
    //
    public Agility(double base_modifier, double occupation_modifier, int level) {
        setName("Agility");
        setBaseModifier(base_modifier);
        setOccupationModifier(occupation_modifier);
        calculate(level);
    }
}

package Occupation;

public class Sneak extends Occupation {
    //
    public Sneak () {
        setName("Sneak");
        setOccupationModifier(1.50, 1.75, 1.25, 1.25);
        setSkillContainer();
    }
    //
    protected void setSkillContainer() {}
}

package models.Occupation;

public class Smasher extends Occupation {
    //
    public Smasher () {
        setName("Smasher");
        setOccupationModifier(1.75, 1.50, 0.75, 1.75);
        setSkillContainer();
    }
    //
    protected void setSkillContainer() {}
}

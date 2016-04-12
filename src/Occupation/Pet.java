package Occupation;

public class Pet extends Occupation {
    //
    public Pet () {
        setName("Pet");
        setOccupationModifier(1.5, 1.0, 1.0, 2.0);
        setSkillContainer();
    }
    //
    protected void setSkillContainer() {}
}

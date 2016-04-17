package models.Occupation;

public class Summoner extends Occupation {
    //
    public Summoner () {
        setName("Summoner");
        setOccupationModifier(1.0, 1.25, 2.5, 1.0);
        setSkillContainer();
    }
    //
    protected void setSkillContainer() {}
}

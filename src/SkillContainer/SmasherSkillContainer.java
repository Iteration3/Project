package SkillContainer;
import Skill.SmasherSkill.*;
import Skill.Skill;

public class SmasherSkillContainer extends SkillContainer {

    public SmasherSkillContainer() {
        initializeBasicSkills();
        initializeBasicSkillsToAdd();
    }


    //this creates new skills for each basic skill and adds to list
    private void initializeBasicSkills() {
        Skill oneHandedWeapon = new OneHandedWeapon();
        Skill twoHandedWeapon = new TwoHandedWeapon();
        Skill brawling = new Brawling();

        addSkillToList(oneHandedWeapon);
        addSkillToList(twoHandedWeapon);
        addSkillToList(brawling);
    }


    //this is to add skills that can be available to the avatars if they pick them up
    private void initializeBasicSkillsToAdd() {

    }
}

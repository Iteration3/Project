package models.Skill;

import models.Skill.BasicSkill.Bargain;
import models.Skill.BasicSkill.BindWounds;
import models.Skill.BasicSkill.Observation;
import models.Skill.SmasherSkill.Brawling;
import models.Skill.SmasherSkill.OneHandedWeapon;
import models.Skill.SmasherSkill.TwoHandedWeapon;
import models.Skill.SneakSkill.Creep;
import models.Skill.SneakSkill.DetectRemoveTrap;
import models.Skill.SneakSkill.PickPocket;
import models.Skill.SneakSkill.RangedWeapon;
import models.Skill.SummonerSkill.Bane;
import models.Skill.SummonerSkill.Boon;
import models.Skill.SummonerSkill.Enchantment;
import models.Skill.SummonerSkill.Staff;
import org.w3c.dom.Element;

import java.util.HashMap;

public class SkillParser {

    private static HashMap<String, Skill> prototypes = new HashMap<>();
    static {
        prototypes.put("bargain", new Bargain());
        prototypes.put("bind-wounds", new BindWounds());
        prototypes.put("observation", new Observation());
        prototypes.put("brawling", new Brawling());
        prototypes.put("one-handed-weapon", new OneHandedWeapon());
        prototypes.put("two-handed-weapon", new TwoHandedWeapon());
        prototypes.put("creep", new Creep());
        prototypes.put("detect-remove-trap", new DetectRemoveTrap());
        prototypes.put("pick-pocket", new PickPocket());
        prototypes.put("ranged-weapon", new RangedWeapon());
        prototypes.put("bane", new Bane());
        prototypes.put("boon", new Boon());
        prototypes.put("enchantment", new Enchantment());
        prototypes.put("staff", new Staff());
    }

    public static Skill getSkillFromXmlElement(Element element) {
        Skill skill = prototypes.get(element.getTagName());
        return skill.cloneInitializedWithXmlElement(element);
    }
}

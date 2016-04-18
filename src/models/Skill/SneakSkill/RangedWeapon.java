package models.Skill.SneakSkill;
import java.util.HashMap;
import java.util.Map;
import models.Entity.*;
import models.Skill.Skill;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import models.Signal.SkillSignal.LinearSkillSignal;

public class RangedWeapon extends SneakSkill {

    private double weaponRating;

    public RangedWeapon() {
        super("Ranged Weapon", 2, 3);
        weaponRating = 0;
    }

    public void activate(Entity entity) {
        if (entity != null) {
            Map<String, Double> damageMap = getDamageMap();
            entity.modifyStats(damageMap);
        }
    }

    public Map<String, Double> getDamageMap() {
        Map<String, Double> map = new HashMap<>();
        double modifyByAmount = getModifyAmount();
        map.put("CURRENT_LIFE", -modifyByAmount);
        return map;
    }

    public void createSignal(models.Map.Map map, Entity entity) {
        new LinearSkillSignal(map, entity, this);
    }

    protected double getModifyAmount() {
        return level * 5 + weaponRating ;
    }

    public void setRating(double weaponRating) {
        this.weaponRating = weaponRating;
    }

    public void setRatingToZero() {
        weaponRating = 0;
    }

    @Override
    public Element generateXml(Document doc) {
        Element element = super.generateDefaultXml(doc);
        element.setAttribute("weaponRating", String.valueOf(weaponRating));
        return element;
    }

    @Override
    protected String getXmlTagName() {
        return "ranged-weapon";
    }

    @Override
    protected Skill cloneInitializedWithXmlElement(Element element) {
        RangedWeapon weapon = new RangedWeapon();
        weapon.getAttributesFromXmlElement(element);
        weapon.setRating(Double.parseDouble(element.getAttribute("weaponRating")));
        return weapon;
    }

}

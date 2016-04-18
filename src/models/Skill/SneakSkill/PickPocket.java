package models.Skill.SneakSkill;
import java.util.Map;
import models.Entity.*;
import models.Skill.Skill;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class PickPocket extends SneakSkill {

    private Entity avatar;

    public PickPocket() {
        super("Pick Pocket", 10.0);
    }

    public void activate(Entity entity) {
        if (entity != null) {

        }
       // avatar.addItem(entity.getRandomItem());
    }

    /*public boolean canUseSkill(Entity entity) {
        boolean canPerform = canPerform();
        double hasEnoughMana = entity.getMana();
        if (hasEnoughMana >= manaCost && canPerform) {
            Map<String, Double> modifyManaCostMap = getManaCostMap();
            entity.modifyStats(modifyManaCostMap);
            avatar = entity;
            return true;
        }
        return false;
    }*/

    @Override
    protected String getXmlTagName() {
        return "pick-pocket";
    }

    @Override
    protected Skill cloneInitializedWithXmlElement(Element element) {
        PickPocket skill = new PickPocket();
        skill.getAttributesFromXmlElement(element);
        return skill;
    }

    @Override
    public Element generateXml(Document doc) {
        return super.generateDefaultXml(doc);
    }
}

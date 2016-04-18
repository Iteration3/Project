package models.Skill.SneakSkill;
import models.Entity.*;
import models.Skill.Skill;
import models.Skill.SummonerSkill.Enchantment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DetectRemoveTrap extends SneakSkill {

    public DetectRemoveTrap() {
        super("Detect and Remove Trap", 5);
    }

    public void activate(Entity entity) {
        if (entity != null) {

        }
        //avatar.addItem(entity.getRandomItem());
    }

    @Override
    protected String getXmlTagName() {
        return "detect-remove-trap";
    }

    @Override
    protected Skill cloneInitializedWithXmlElement(Element element) {
        DetectRemoveTrap skill = new DetectRemoveTrap();
        skill.getAttributesFromXmlElement(element);
        return skill;
    }

    @Override
    public Element generateXml(Document doc) {
        return super.generateDefaultXml(doc);
    }
    public void createSignal(models.Map.Map map, Entity entity) {

    }
}

package models.Skill.SummonerSkill;
import models.Entity.*;
import models.Skill.Skill;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class Enchantment extends SummonerSkill {


    public Enchantment() {
        super("Enchantment", 15, 3);
    }

    //make NPC go to sleep
    public void activate(Entity entity) {
        //entity.goToSleep();
    }

    @Override
    protected String getXmlTagName() {
        return "enchantment";
    }

    @Override
    protected Skill cloneInitializedWithXmlElement(Element element) {
        Enchantment enchantment = new Enchantment();
        enchantment.getAttributesFromXmlElement(element);
        return enchantment;
    }

    @Override
    public Element generateXml(Document doc) {
        return super.generateDefaultXml(doc);
    }
    public void createSignal(models.Map.Map map, Entity entity) {

    }

}

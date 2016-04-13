package Skill.SummonerSkill;
import Entity.*;


public class Enchantment extends SummonerSkill {


    public Enchantment() {
        super("Enchantment", 15);
    }

    //make NPC go to sleep
    public void activate(Entity entity) {
        entity.goToSleep();
    }

}

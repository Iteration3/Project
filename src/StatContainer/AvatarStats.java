package StatContainer;

import Stat.*;

import java.util.Map;

public class AvatarStats extends StatContainer {
    //
    public AvatarStats(Map<String, Double> occupation_modifier, int level) {setStats(3.0, occupation_modifier, level);}

    //
    protected void setStats(double base_modifier, Map<String, Double> occupation_modifier, int level) {
        //
        this.BASE_MODIFIER = base_modifier;
        this.OCCUPATION_MODIFIER = occupation_modifier;
        // set key stats
        this.stats.put("LEVEL", new Level(level));
        this.stats.put("LIVES", new Lives(3));
        this.stats.put("CURRENT_LIVES", new CurrentLives((int)this.stats.get("LIVES").value()));
        this.stats.put("EXPERIENCE", new Experience(level));
        this.stats.put("CURRENT_EXPERIENCE", new CurrentExperience());
        // set primary stats
        this.stats.put("STRENGTH", new Strength(this.BASE_MODIFIER, this.OCCUPATION_MODIFIER.get("STRENGTH"), level));
        this.stats.put("AGILITY", new Agility(this.BASE_MODIFIER, this.OCCUPATION_MODIFIER.get("AGILITY"), level));
        this.stats.put("INTELLECT", new Intellect(this.BASE_MODIFIER, this.OCCUPATION_MODIFIER.get("INTELLECT"), level));
        this.stats.put("HARDINESS", new Hardiness(this.BASE_MODIFIER, this.OCCUPATION_MODIFIER.get("HARDINESS"), level));
        // set secondary stats
        this.stats.put("LIFE", new Life(this.stats.get("HARDINESS"), this.stats.get("LEVEL")));
        this.stats.put("CURRENT_LIFE", new CurrentLife(this.stats.get("LIFE")));
        this.stats.put("MANA", new Mana(this.stats.get("INTELLECT"), this.stats.get("LEVEL")));
        this.stats.put("CURRENT_MANA", new CurrentMana(this.stats.get("MANA")));
        this.stats.put("OFFENSE", new Offense(this.stats.get("STRENGTH"), this.stats.get("LEVEL")));
        this.stats.put("DEFENSE", new Defense(this.stats.get("AGILITY"), this.stats.get("LEVEL")));
        this.stats.put("ARMOR", new Armor(this.stats.get("HARDINESS")));
        // set speed stats
        this.stats.put("MOVEMENT", new Movement(1.0));
        this.stats.put("ATTACK", new Attack(2.0));
        this.stats.put("BARGAIN", new Bargain(0.0));
    }

    //
    public void levelUp() {
        // temp variables
        int level = (int)this.stats.get("LEVEL").value() + 1;
        int lives = (int)this.stats.get("LIVES").value();
        // clear current stats
        this.stats.clear();
        // set key stats
        this.stats.put("LEVEL", new Level(level));
        this.stats.put("LIVES", new Lives(lives));
        this.stats.put("CURRENT_LIVES", new CurrentLives(lives));
        this.stats.put("EXPERIENCE", new Experience(level));
        this.stats.put("CURRENT_EXPERIENCE", new CurrentExperience());
        // set primary stats
        this.stats.put("STRENGTH", new Strength(this.BASE_MODIFIER, this.OCCUPATION_MODIFIER.get("STRENGTH"), level));
        this.stats.put("AGILITY", new Agility(this.BASE_MODIFIER, this.OCCUPATION_MODIFIER.get("AGILITY"), level));
        this.stats.put("INTELLECT", new Intellect(this.BASE_MODIFIER, this.OCCUPATION_MODIFIER.get("INTELLECT"), level));
        this.stats.put("HARDINESS", new Hardiness(this.BASE_MODIFIER, this.OCCUPATION_MODIFIER.get("HARDINESS"), level));
        // set secondary stats
        this.stats.put("LIFE", new Life(this.stats.get("HARDINESS"), this.stats.get("LEVEL")));
        this.stats.put("CURRENT_LIFE", new CurrentLife(this.stats.get("LIFE")));
        this.stats.put("MANA", new Mana(this.stats.get("INTELLECT"), this.stats.get("LEVEL")));
        this.stats.put("CURRENT_MANA", new CurrentMana(this.stats.get("MANA")));
        this.stats.put("OFFENSE", new Offense(this.stats.get("STRENGTH"), this.stats.get("LEVEL")));
        this.stats.put("DEFENSE", new Defense(this.stats.get("AGILITY"), this.stats.get("LEVEL")));
        this.stats.put("ARMOR", new Armor(this.stats.get("HARDINESS")));
        // set tertiary stats
        this.stats.put("MOVEMENT", new Movement(1.0));
        this.stats.put("ATTACK", new Attack(2.0));
        this.stats.put("BARGAIN", new Bargain(0.0));
    }
}

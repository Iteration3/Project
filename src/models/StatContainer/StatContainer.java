package models.StatContainer;

import models.Stat.Stat;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public abstract class StatContainer {
    //
    protected double BASE_MODIFIER;
    protected Map<String, Double> OCCUPATION_MODIFIER;
    //
    protected Map<String, Stat> stats = new LinkedHashMap<>();

    // return Map containing all stats
    public Map<String, Stat> value() {return this.stats;}

    // return value of a specific stat
    public double value(String stat_to_get) {return value().get(stat_to_get).value();}
    public String name(String stat_to_get) {return value().get(stat_to_get).name();}

    /*
        use forEach() method of Map<> to iterate through the stats and call each
        member's modify() method
     */
    public void modifyStats(Map<String, Double> stat_to_modify) {
        stat_to_modify.forEach((k, v) -> value().get(k).modify(v));
        value().forEach((k, v)-> v.calculate());
    }

    /*
        use forEach() method of Map<> to iterate through the stats and call each
        member's print() method
    */
    public void print() {value().forEach((k, v) -> v.print());}

    // print a specific stat
    public void print(String stat_to_print) {value().get(stat_to_print).print();}

    //
    protected abstract void setStats(double base_modifier, Map<String, Double> occupation_modifier, int level);
    public abstract void levelUp();




    public Set<Map.Entry<String,Stat>> getMap() {
        return stats.entrySet();
    }
}

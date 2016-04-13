package models.Stat;

public class Life extends Secondary {
    // currently based off of Hardiness and Level
    public Life(Stat stat_one, Stat stat_two) {
        setName("Life");
        setStatOne(stat_one);
        setStatTwo(stat_two);
        calculate();
    }
    //
    public void calculate() {setValue(((0.5 * stat_two.value()) + 50 + stat_one.value()) * stat_two.value());}
    //
    @Override
    public void print() {System.out.println(name() + ": " + (int)value());}
}

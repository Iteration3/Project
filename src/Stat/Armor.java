package Stat;

//TODO: Create formula for calculate()
public class Armor extends Secondary {
    // currently based off Hardiness
    public Armor(Stat stat_one) {
        setName("Armor");
        setStatOne(stat_one);
        calculate();
    }
    //
    public void calculate() {setValue(stat_one.value());}
}

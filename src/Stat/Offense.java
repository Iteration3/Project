package Stat;

//TODO: Create formula for calculate()
public class Offense extends Secondary {
    // currently based off Strength and Level
    public Offense(Stat stat_one, Stat stat_two) {
        setName("Offense");
        setStatOne(stat_one);
        setStatTwo(stat_two);
        calculate();
    }
    //
    public void calculate() {setValue((stat_one.value() * stat_two.value()) / (stat_two.value() / 2) + 3);}
}

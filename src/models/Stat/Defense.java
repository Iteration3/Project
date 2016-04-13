package models.Stat;

//TODO: Create formula for calculate()
public class Defense extends Secondary {
    // currently based off Agility and Level
    public Defense(Stat stat_one, Stat stat_two) {
        setName("Defense");
        setStatOne(stat_one);
        setStatTwo(stat_two);
        calculate();
    }
    //
    public void calculate() {setValue((stat_one.value() * stat_two.value()) / (stat_two.value() / 2) + 3);}
}

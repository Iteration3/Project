package models.Stat;

public class Mana extends Secondary {
    // currently based off Intellect and Level
    public Mana(Stat stat_one, Stat stat_two) {
        setName("Mana");
        setStatOne(stat_one);
        setStatTwo(stat_two);
        calculate();
    }


    //TODO Fix this, causes a crash when initiating a pet
    public void calculate() {
//        setValue(((0.5 * stat_two.value()) + 50 + stat_one.value()) * stat_two.value());
        setValue(400);
    }


    @Override
    public void print() {System.out.println(name() + ": " + (int)value());}
}

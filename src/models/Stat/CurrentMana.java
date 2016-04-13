package models.Stat;

import static java.lang.Math.abs;

public class CurrentMana extends Secondary {
    // currently based off Intellect and Level
    public CurrentMana(Stat stat_one) {
        setName("CurrentMana");
        setStatOne(stat_one);
        setValue(stat_one.value());
    }
    //
    public void calculate() {}
    //
    @Override
    public void print() {System.out.println(name() + ": " + (int)value());}
    //
    @Override
    public void modify(double amt) {
        if(abs(amt) < 1.00)
            setValue(this.value + (amt * this.value));
        else
            setValue(this.value + amt);
        if(value() < 0)
            setValue(0);
        else if(value() > stat_one.value())
            setValue(stat_one.value());
    }
}

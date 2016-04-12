package Stat;

public class CurrentExperience extends Key {
    //
    public CurrentExperience() {
        setName("CurrentExperience");
        setValue(0);
    }
    //
    @Override
    protected void setValue(double value) {this.value = 0;}
}

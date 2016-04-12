package Stat;

public class Bargain extends Tertiary {
    //
    public Bargain(double value) {
        setName("Bargain");
        setValue(value);
    }
    //
    @Override
    public void modify(double amt) {this.value = amt;}
}

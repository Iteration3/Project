package models.Stat;

public abstract class Key extends Stat {
    //
    public void scale(double amt) {this.value = this.value();}
    public void modify(double amt) {this.value += (double)(int)amt;}
    public void calculate() {}
    //
    @Override
    public void print() {System.out.println(name() + ": " + (int)value());}
}

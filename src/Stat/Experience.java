package Stat;

public class Experience extends Key {
    //
    public Experience(int level) {
        setName("Experience");
        setValue((double)(level * level * 25));
    }
}

package models.Stat;

public class CurrentLives extends Key {
    //
    private double lives;
    //
    public CurrentLives(int value) {
        setName("CurrentLives");
        setValue((double)value);
    }
}
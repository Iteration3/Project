import Entity.*;
import Action.*;
import Location.*;
import Direction.*;
import Occupation.*;
import StatContainer.*;
import Item.*;

public class Main {
    //
    public static void main(String[] args) {
        // Test String
        System.out.println("\nWELCOME TO THUNDERDOME\n\n");

        // Entity test
        Entity player = new Avatar(100, new Summoner());

        player.print();

        System.out.println("\n");

        player.printStats();
    }
}

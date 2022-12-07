package farm_simulator;

import java.util.ArrayList;

public class ShedDB {
    private static int shedID = 0;
    private int id;
    ArrayList<Shed> sheds;

    public ShedDB( ArrayList<Shed> sheds) {
        this.id = ++shedID;
        this.sheds = sheds;
    }

    public static int getShedID() {
        return shedID;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Shed> getSheds() {
        return sheds;
    }
}

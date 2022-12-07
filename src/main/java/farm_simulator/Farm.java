package farm_simulator;

import java.util.ArrayList;

public class Farm {
    private static int farmID = 0;
    private int id;
    private String owner;
    private HerdDB herdDB;
    private ShedDB shedDB;


    public Farm(String owner, HerdDB herdDB, ShedDB shedDB) {
        this.id = ++farmID;
        this.owner = owner;
        this.herdDB = herdDB;
        this.shedDB = shedDB;
    }

    public int getFarmID() {
        return farmID;
    }

    public String getOwner() {
        return owner;
    }

    public HerdDB getHerdDB() {
        return herdDB;
    }

    public ShedDB getShedDB() {
        return shedDB;
    }


    @Override
    public String toString() {
        return "Farm{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", herdDB=" + herdDB +
                ", shedDB=" + shedDB +
                '}';
    }
}

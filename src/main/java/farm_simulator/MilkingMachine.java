package farm_simulator;

public class MilkingMachine {
    private static int milkingMachineID = 0;
    private int id;
    private MilkTank milkTank;

    public MilkingMachine(MilkTank milkTank) {
        this.id = ++milkingMachineID;
        this.milkTank = milkTank;
    }

    public int getId() {
        return id;
    }

    public MilkTank getMilkTank() {


           return milkTank;

        //or null

    }

    public void setMilkTank(MilkTank milkTank) {
        this.milkTank = milkTank;

    }
    public void milk(IMilkable milkable)
    {

    }
}

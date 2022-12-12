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

        if(!(milkTank == null))
        {
            return milkTank;
        }else
        {
            return null;
        }
    }

    public boolean milk(IMilkable milkable)
    {
        if(!(milkTank == null))
        {
            double milkProduced =  milkable.milk();
            milkTank.addToTank(milkProduced);
        }else
        {
            throw new IllegalStateException("No MilkTank Connected");
        }
        return false;
    }

    @Override
    public String toString() {
        return "\n  MilkingMachine{" +
                "id=" + id +
                ", milkTank=" + milkTank +
                '}';
    }
}

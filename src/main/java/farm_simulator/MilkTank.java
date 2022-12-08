package farm_simulator;

public class MilkTank {

    private static int milkTankID=0;
    private int tankID;
    private int capacity;
    private int currentLevel;
    FarmEnums milkType;


    public MilkTank(FarmEnums milkType) {
        this.tankID = ++milkTankID;
        this.capacity = 2000;
        this.currentLevel = 0;
        this.milkType = milkType;
    }

    public MilkTank(int capacity) {
        this.capacity = capacity;
    }


    public double getCapacity() {
        return capacity;
    }
//    public double freeSpace(int space)
//    {
//        return this.capacity - space;
//    }

    public void addToTank(double amount)
    {
        double temp = amount + currentLevel;
        if(temp <= this.capacity )
        {
            this.capacity -= amount;
            this.currentLevel += amount;
        }else
        {
            System.out.println("The Tank hasn't got enough space to be filled");
            System.out.println("current level of the Tank:- " + currentLevel);
        }
    }
    public double getFromTank(double amount)
    {
        if(amount <= currentLevel)
        {
            return this.currentLevel - amount;

        }else
        {
            return 0;
        }

    }

    @Override
    public String toString() {
        return "MilkTank{" +
                "milkTankID=" + tankID +
                ", capacity=" + capacity +
                ", currentLevel=" + currentLevel +
                ", cowMilk=" + FarmEnums.COWMILK +
                ", GoatMilk=" + FarmEnums.GOATMILK +
                '}';
    }
}

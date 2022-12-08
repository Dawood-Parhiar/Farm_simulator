package farm_simulator;

import java.util.ArrayList;
import java.util.Collection;

public class Shed {

    private static int ShedID = 0;
    private int id;
    private MilkingMachine milkingMachine;
    private MilkTank milkTank;
    private ArrayList<Animal> animals;


    public Shed(MilkTank tank)
    {
        this.id = ++ShedID;
        this.milkingMachine = milkingMachine;
        this.milkTank = tank;
        ArrayList<Animal> animals = new ArrayList<>();
    }

    public static int getShedID() {
        return ShedID;
    }

    public int getId() {
        return id;
    }

    public MilkingMachine getMilkingMachine() {
        return milkingMachine;
    }

    public MilkTank getMilkTank() {
        return this.milkTank;
    }

    public void installMilkingMachine(MilkingMachine milkingMachine){
        // installs a milking
        //machine and connects it to the shed’s milk tank
        this.milkingMachine = milkingMachine;
        milkingMachine.setMilkTank(this.milkTank);

    }
    public void milkAnimal(IMilkable imilkable)
    {
        // milks the animal with the milking machine, the
        //method throws an IllegalStateException if the milking machine is not installed
            if(!(milkingMachine == null))
            {
                milkingMachine.milk(imilkable);
            }else
            {
                new IllegalStateException("Milking Machine is not installed");
            }


    }
    public void milkAnimal(Collection<Animal> animals){
        /*
            milks the herd of animals with the
            milking machine, the method throws an IllegalStateException if the milking machine is not
            installed
         */

            if(!(milkingMachine == null))
            {
                milkingMachine.milk(animals);
            }else
            {
                new IllegalStateException("Milking Machine is not installed");
            }
    }
    public String toString()
    {
        //) returns the state of the milk tank contained in the shed
        return "";
    }

    public void setMilkingMachine(MilkingMachine milkingMachine) {
        this.milkingMachine = milkingMachine;
    }

    public void setMilkTank(MilkTank milkTank) {
        this.milkTank = milkTank;
    }
}

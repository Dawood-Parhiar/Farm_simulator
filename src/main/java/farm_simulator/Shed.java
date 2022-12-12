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

    public void setMilkTank(MilkTank milkTank) {
        this.milkTank = milkTank;
    }

    public void installMilkingMachine(MilkingMachine milkingMachine){
        // installs a milking
        //machine and connects it to the shed’s milk tank
        this.milkingMachine = milkingMachine;


    }
    public boolean milkAnimal(IMilkable imilkable)
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
        return false;
    }
    public void milkAnimal(Collection<Animal> animals){
        /*
            milks the herd of animals with the
            milking machine, the method throws an IllegalStateException if the milking machine is not
            installed
         */

            if(!(milkingMachine == null))
            {
                for(Animal animal : animals)
                {
                    if(animal.isCanMilk())
                    {
                       // milkingMachine.milk(animal);
                    }
                }
            }else
            {
                new IllegalStateException("Milking Machine is not installed");
            }
    }



    @Override
    public String toString() {
        return "Shed{" +
                "id=" + id +
                ", milkingMachine=" + milkingMachine +
                ", milkTank=" + milkTank +
                ", animals=" + animals +
                '}';
    }
}

package farm_simulator;

import java.util.Random;

public class Goat extends Animal implements IMilkable{

    private static int goatID = 2000;
    private int id;
    private int udderCapacity;
    private int milkedPerDay;
    private int totalMilkProduced;
    private String name;

    static Random rand = new Random();
    public Goat(boolean pedigree, double weight, int age,String name) {
        super(pedigree, weight, age);
        this.id = ++goatID;
        this.udderCapacity = 0;
        this.milkedPerDay = 1;
        this.totalMilkProduced = 0;
        this.name = name;

    }



    public static int getGoatID() {
        return goatID;
    }

    public int getId() {
        return id;
    }

    public int getUdderCapacity() {
        return udderCapacity;
    }

    public int getMilkedPerDay() {
        return milkedPerDay;
    }

    public int getTotalMilkProduced() {
        return totalMilkProduced;
    }

    public String getName(){
        return name;
    }



    @Override
    public double milk() {

        this.udderCapacity = rand.nextInt(3-2)+2;
        this.totalMilkProduced += udderCapacity;
        //milks once a day, whatever is in the udder, is milked per day
        return udderCapacity;
    }

    @Override
    public String toString() {
        return "Goat{" +
                "\n id=" + id +
                ",\n name=" + name +
                ",\n pedigree='" + super.getPedigree() + '\'' +
                ",\n weight='" + super.getWeight() + '\'' +
                ",\n age='" + super.getAge() + '\'' +
                ",\n udderCapacity=" + udderCapacity +
                ",\n milkedPerDay=" + milkedPerDay +
                ",\n totalMilkProduced=" + totalMilkProduced +
                "}\n";
    }
}

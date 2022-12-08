package farm_simulator;

import java.util.Random;
import java.util.Scanner;

public class DairyCow extends Animal implements IMilkable{
    private static int DairyCowID = 1000;
    private int id;
    private String name;
    private int udderCapacity;
    private int milkedPerDay;
    private int totalMilkProduced;

    static Scanner scanner = new Scanner(System.in);
    static Random rand = new Random();

    public DairyCow(boolean pedigree, double weight, int age, String name) {
        super(pedigree, weight, age);
        this.id = ++DairyCowID;
        this.name = name;
        this.udderCapacity = 0;
        this.milkedPerDay = 0;
        this.totalMilkProduced = 0;
    }

    public static double getDairyCowID() {
        return DairyCowID;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
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


    public DairyCow Cow(String name){

        System.out.print("Please Enter the Pedigree of "+ name+" : ");
        boolean pedigree = Boolean.parseBoolean(scanner.next());
        System.out.print("Please Enter the Weight "+ name + " : ");
        double weight = scanner.nextDouble();
        System.out.println("Please Enter the Age " + name + " : ");
        int age = scanner.nextInt();
        scanner.nextLine();
        //Add cow to the arraylist
        return  new DairyCow(pedigree,weight,age,name);
    }


    @Override
    public double milk() {

        this.milkedPerDay = rand.nextInt(5-2)+2;
        this.udderCapacity = rand.nextInt(40-20)+20;
        this.totalMilkProduced += udderCapacity;
        int averageMilkEachTime = udderCapacity/milkedPerDay;

        return averageMilkEachTime;
    }

    @Override
    public String toString() {
        return "DairyCow{\n" +
                " id=" + id +
                "\n name='" + name + '\'' +
                ", pedigree='" + super.getPedigree() + '\'' +
                ", weight='" + super.getWeight() + '\'' +
                ", age='" + super.getAge() + '\'' +
                "\n udderCapacity=" + udderCapacity +
                "\n milkedPerDay=" + milkedPerDay +
                "\n totalMilkProduced=" + totalMilkProduced +
                "}\n";
    }
}

package farm_simulator;

public class Sheep extends Animal implements Comparable<Animal>{

    private static int sheepID = 3000;
    private int id = ++sheepID;
    private String name;
    private boolean canMilk = false;
    private double price;

    public Sheep(boolean pedigree, double weight, int age, String name,double price) {
        super(pedigree, weight, age);
        this.id = ++sheepID;
        this.name = name;
        this.price = price;
    }

    public boolean isCanMilk() {
        return canMilk;
    }

    public static int getSheepID() {
        return sheepID;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;

    }

    @Override
    public String toString() {
        return "Sheep{" +
                "\n id=" + id +
                ",\n name =" + name +
                ",\n price =" + price +
                ",\n pedigree='" + super.getPedigree() + '\'' +
                ",\n weight='" + super.getWeight() + '\'' +
                ",\n age='" + super.getAge() + '\'' +
                "}\n";
    }

    @Override
    public int compareTo(Animal other) {
        if(this.getWeight() > other.getWeight())
        {
            System.out.println(this.getName() + ": is more valuable than\n" + other);
            return 1;
        }
        else if (this.getWeight() < other.getWeight())
        {
            System.out.println(other + "\nis more valuable than" + this.getName());
            return -1;
        }
        else
        {
            return 0;
        }
    }
}

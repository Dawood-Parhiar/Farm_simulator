package farm_simulator;

public class BeefCow extends Animal implements Comparable<Animal>{
    private static int BeefCowID = 001;
    private int id;
    private String name;
    private double price;

    public BeefCow(boolean pedigree, int weight, int age, String name,double price) {
        super(pedigree, weight, age);
        this.id = ++BeefCowID;
        this.name = name;
        this.price = price;
    }


    public static double getBeefCowID() {
        return BeefCowID;
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
        return "BeefCow{" +
                "\n id=" + id +
                ",\n name='" + name + '\'' +
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

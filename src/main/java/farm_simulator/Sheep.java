package farm_simulator;

public class Sheep extends Animal{

    private static int sheepID = 3000;
    private int id = ++sheepID;
    private String name;

    public Sheep(boolean pedigree, double weight, int age, String name) {
        super(pedigree, weight, age);
        this.id = ++sheepID;
        this.name = name;
    }

    public static int getSheepID() {
        return sheepID;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "\n id=" + id +
                ",\n name =" + name +
                ",\n pedigree='" + super.getPedigree() + '\'' +
                ",\n weight='" + super.getWeight() + '\'' +
                ",\n age='" + super.getAge() + '\'' +
                "}\n";
    }
}

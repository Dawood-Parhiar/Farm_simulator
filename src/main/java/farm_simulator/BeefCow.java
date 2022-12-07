package farm_simulator;

public class BeefCow extends Animal{
    private static int BeefCowID = 0;
    private int id;
    private String name;

    public BeefCow(boolean pedigree, int weight, int age, String name) {
        super(pedigree, weight, age);
        this.id = ++BeefCowID;
        this.name = name;
    }

    public static int getBeefCowID() {
        return BeefCowID;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "BeefCow{" +
                "\n id=" + id +
                ",\n name='" + name + '\'' +
                ",\n pedigree='" + super.getPedigree() + '\'' +
                ",\n weight='" + super.getWeight() + '\'' +
                ",\n age='" + super.getAge() + '\'' +
                "}\n";
    }
}

package farm_simulator;

public class Animal {

    private boolean pedigree;
    private double weight;
    private int age;

    public Animal(boolean pedigree, double weight, int age) {
        this.pedigree = pedigree;
        this.weight = weight;
        this.age = age;
    }

    public boolean getPedigree() {
        return pedigree;
    }

    public double getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }


    @Override
    public String toString() {
        return "Animal{" +
                "pedigree=" + pedigree +
                ", weight=" + weight +
                ", age=" + age +
                '}';
    }
}

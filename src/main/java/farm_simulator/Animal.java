package farm_simulator;

public  class Animal {


    private boolean pedigree;
    private double weight;
    private int age;
    private  boolean canMilk;

    public Animal(boolean pedigree, double weight, int age) {
        this.pedigree = pedigree;
        this.weight = weight;
        this.age = age;
        this.canMilk = false;
    }

    public boolean isCanMilk() {
        return canMilk;
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

    public  int compareTo(Animal other)
    {
        return 0;
    };

}

package farm_simulator;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the Farm Simulator");
        FarmControl();
    }
    public void MainMenu()
    {

    }

    private static void FarmControl() {
        ArrayList<DairyCow> dairyCows = new ArrayList<>();
        ArrayList<BeefCow> beefCows = new ArrayList<>();
        ArrayList<Goat> goats = new ArrayList<>();
        ArrayList<Sheep> sheep = new ArrayList<>();
        ArrayList<Animal> animals = new ArrayList<>();
        ArrayList<Shed> sheds = new ArrayList<>();
        ShedDB shedDataBase = new ShedDB(sheds);
        HerdDB herdDB = new HerdDB(1,dairyCows,beefCows,goats,sheep);
        Farm farm = new Farm("Dawood",herdDB,shedDataBase);

        Animal cow1 = new DairyCow(true,70.5,2,"Brownie");
        DairyCow cow2 = new DairyCow(false,76.5,2,"Brownie");
        DairyCow cow3 = new DairyCow(true,79.5,2,"Flat White");
        Animal cow4 = new DairyCow(false,80.5,2,"Brownie");
        Animal cow5 = new DairyCow(true,130.5,2,"Brownie");

        Animal beefCow1 = new BeefCow(false,53,1,"Dottie");
        Animal beefCow2 = new BeefCow(true,98,3,"Dottie");
        Animal beefCow3 = new BeefCow(false,123,4,"Dottie");



        animals.add(cow1);
        animals.add(cow2);
       // animals.add(cow3);
        dairyCows.add(cow3);
        dairyCows.add(cow2);
        animals.add(cow4);
        animals.add(cow5);
        animals.add(beefCow1);
        animals.add(beefCow2);
        animals.add(beefCow3);


        MilkTank milkTank = new MilkTank(FarmEnums.COWMILK);
        Shed shed1 = new Shed(milkTank);
        MilkingMachine machine = new MilkingMachine(milkTank);

        //shed1.milkAnimal(animals);
        //shed1.milkAnimal(cow2);
        //System.out.println(animals);
        farm.getHerdDB();
        System.out.println(cow3.getId());
        herdDB.deleteCow(1003,"Flat White");
       // System.out.println(cow3);
        System.out.println(dairyCows);
        //System.out.println(dairyCows);

        DairyCow newCow = new DairyCow(false,105,7,"Kamri Dhaggi");
        newCow.getPedigree();
        herdDB.addCow(newCow);
        System.out.println(dairyCows);
        newCow.milk();
        newCow.getTotalMilkProduced();
    }

}

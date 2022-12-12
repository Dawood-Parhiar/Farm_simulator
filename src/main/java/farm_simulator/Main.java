package farm_simulator;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<DairyCow> dairyCows = new ArrayList<>();
    static ArrayList<BeefCow> beefCows = new ArrayList<>();
    static ArrayList<Goat> goats = new ArrayList<>();
    static ArrayList<Sheep> sheepArrayList = new ArrayList<>();
    static ArrayList<Animal> animals = new ArrayList<>();
    static ArrayList<Shed> sheds = new ArrayList<>();
    static ShedDB shedDataBase = new ShedDB(sheds);
    static HerdDB herdDB = new HerdDB(1,dairyCows,beefCows,goats,sheepArrayList,animals);
    static Farm farm = new Farm("John Loane",herdDB,shedDataBase);
    static ArrayList<Farm> farms = new ArrayList<>();
    static FarmDB farmDB = new FarmDB(farms);
    static MilkTank milkTank = new MilkTank(FarmEnums.COWMILK);
    static Shed shed1 = new Shed(milkTank);
    static MilkingMachine machine = new MilkingMachine(milkTank);

    public static void main(String[] args) {

        shed1.setMilkTank(milkTank);
        shed1.installMilkingMachine(machine);

        System.out.println();
        Menu();
        farm.getHerdDB().saveToFile();
    }

    public static void Menu()
    {

        System.out.println(Colours.BLUE + "Welcome to the Farm Simulator" + Colours.RESET);
        MenuOptions selectedOption = MenuOptions.CONTINUE;

        while(selectedOption != MenuOptions.QUIT)
        {
            try
            {
                printMenu();
                selectedOption = MenuOptions.values()[Integer.parseInt(scanner.nextLine().trim())];

                switch(selectedOption)
                {
                    //2
                    case ENTER_NEW_FARM:
                        addFarm();
                        break;
                    //3
                    case ADD_ANIMAL:
                        addAnimal();
                        break;
                    //4
                    case DELETE_OR_REMOVE_DEAD_ANIMAL:
                        removeAnimal();
                        break;
                    //5
                    case EDIT_ANIMAL_DETAILS:
                        editAnimal();
                        break;

                    case ADD_SHED:
                        addShed();
                        break;

                    case REMOVE_SHED:
                        removeShed();
                        break;

                    case EDIT_SHED:
                        editShed();
                        break;

                    case PRINT_FARMS:
                        printFarms();
                        break;

                    case MILK_ANIMAL:
                        milkAnimal();
                        break;

                    case PRINT_ANIMALS:
                        printAnimals();
                        break;

                    case QUIT:
                        System.out.println("Have a Good Day");
                        break;
                    default:
                        System.out.println(Colours.RED+"Not a valid option, please try again"+Colours.RESET);

                }
            }
            catch(IllegalArgumentException e)
            {
                System.out.println(Colours.RED + "selectin out of range" + Colours.RESET);

            }catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.println(Colours.RED + "selection out of range" + Colours.RESET);
            }
        }
    }

    private static void printAnimals() {
        System.out.println(animals.toString());
    }

    private static void printFarms() {
        System.out.println(farmDB.toString());
    }

    private static void addShed() {

        MilkTank milkTank = new MilkTank(FarmEnums.GOATMILK);
        MilkTank milkTank2 = new MilkTank(FarmEnums.COWMILK);
        Shed newShed = new Shed(milkTank2);
        newShed.setMilkTank(milkTank2);

        MilkingMachine machine1 = new MilkingMachine(milkTank2);
        newShed.installMilkingMachine(machine1);
        farm.getShedDB().addShed(newShed);
    }

    private static void removeShed() {
        System.out.println("Please enter shed Id:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Shed ifExists = shedDataBase.findShed(id);
        if(!(ifExists == null))
        {
            farm.getShedDB().deleteShed(ifExists);
            System.out.println("Successfully Removed");
        }
    }

    private static void printMenu() {
        System.out.println(Colours.GREEN+"\nEnter: ");
        System.out.println("1. Add New Farm");
        System.out.println("2. Add Animal");
        System.out.println("3. Delete Animal");
        System.out.println("4. Edit Animals Details: ");
        System.out.println("5. Add Shed");
        System.out.println("6. Remove Shed");
        System.out.println("7. Edit Shed");
        System.out.println("8. print Farms");
        System.out.println("9. Milk Animals");
        System.out.println("10. Print Animals");
        System.out.println("11. Quit"+Colours.RESET);
    }

    private static void editAnimal() {


    }

    private static void removeAnimal()
    {
        System.out.println("To Remove Animal:");
        System.out.println("Please enter dead animal's ID");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter name");
        String name = scanner.nextLine();

        BeefCow beefCow = herdDB.findBeefCowByName(id, name, beefCows);
        DairyCow dairyCow = herdDB.findDairyCowByName(id, name, dairyCows);
        Goat goat = herdDB.findGoatByName(id, name, goats);
        Sheep sheep = herdDB.findSheepByName(id, name,sheepArrayList);

        if(!(beefCow == null))
        {
            farm.getHerdDB().deleteAnimal(beefCow);
            System.out.println("Removed");
        }else if(!(dairyCow == null))
        {
            farm.getHerdDB().deleteAnimal(dairyCow);
            System.out.println("Removed");
        }else if(!(goat == null))
        {
            farm.getHerdDB().deleteAnimal(goat);
            System.out.println("Removed");
        }else if(!(sheep == null))
        {
            farm.getHerdDB().deleteAnimal(sheep);
            System.out.println("Removed");
        }else
        {
            System.out.println("Null");
        }
    }

    private static void editShed() {

        System.out.println("To Edit Shed:");
        System.out.println("Please enter shed Id:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Shed checkShed = shedDataBase.findShed(id);

        MilkTank milkTank = new MilkTank(FarmEnums.GOATMILK);
        MilkTank milkTank2 = new MilkTank(FarmEnums.COWMILK);
        Shed newShed = new Shed(milkTank2);
        newShed.setMilkTank(milkTank2);
        MilkingMachine machine1 = new MilkingMachine(milkTank2);
        newShed.installMilkingMachine(machine1);
        if(!(checkShed == null))
        {
            shedDataBase.updateShed(checkShed,newShed);
        }
    }

    private static void milkAnimal() {

        for(IMilkable milkable: dairyCows)
        {
            System.out.println(shed1.milkAnimal(milkable));
            System.out.println(machine.milk(milkable));
        }
        for(IMilkable milkable: goats)
        {
            System.out.println(shed1.milkAnimal(milkable));
            System.out.println(machine.milk(milkable));
        }
    }

    private static void addAnimal() {

        System.out.println(Colours.BLUE + "please choose one of the following to add Animal");
        System.out.println("1- Dairy Cow");
        System.out.println("2- Beef Cow");
        System.out.println("3- Goat");
        System.out.println("4- Sheep"+Colours.RESET);
        int choice = scanner.nextInt();
        switch (choice)
        {case 1:
            addDairyCow();
            break;
        case 2:
            addBeefCow();
            break;
        case 3:
            addGoat();
            break;
        case 4:
            addSheep();
            break;
        default:
                System.out.println(Colours.RED+"Not a valid option, please try again"+Colours.RESET);

        }
    }
    private static void addSheep()
    {
        System.out.println("How Many Sheep would you like to add to your farm");
        int quantity = scanner.nextInt();
        for(int i = 0; i < quantity; i++)
        {
            System.out.println("Enter Pedigree true or false ");
            boolean pedigree = Boolean.parseBoolean(scanner.next());

            System.out.println("Enter Weight");
            double weight = scanner.nextDouble();

            System.out.println("Enter Age");
            int age = scanner.nextInt();
            scanner.nextLine();

            scanner.nextLine();
            System.out.println("Enter Name");
            String name = scanner.nextLine();

            System.out.println("Enter Price");
            double price = scanner.nextDouble();

            Animal sheep1 = new Sheep(pedigree,weight,age,name,price);
            animals.add(sheep1);
            System.out.println(sheep1);
            System.out.println("Added Successfully");
            herdDB.saveToFile();
        }
    }
    private static void addGoat() {
        System.out.println("How Many Goat would you like to add to your farm");
        int quantity = scanner.nextInt();
        for (int i = 0; i < quantity; i++) {
            System.out.println("Enter Pedigree true or false ");
            boolean pedigree = Boolean.parseBoolean(scanner.next());

            System.out.println("Enter Weight");
            double weight = scanner.nextDouble();

            System.out.println("Enter Age");
            int age = scanner.nextInt();

            scanner.nextLine();
            System.out.println("Enter Name");
            String name = scanner.nextLine();


            Animal goat = new Goat(pedigree, weight, age, name);
            System.out.println(goat);
            System.out.println("Added Successfully");
            animals.add(goat);
            herdDB.saveToFile();
        }
    }
    private static void addBeefCow() {
        System.out.println("How Many Beef Cows would you like to add to your farm");
        int quantity = scanner.nextInt();
        for (int i = 0; i < quantity; i++) {
            System.out.println("Enter Pedigree true or false ");
            boolean pedigree = Boolean.parseBoolean(scanner.next());

            System.out.println("Enter Weight");
            double weight = scanner.nextDouble();

            System.out.println("Enter Age");
            int age = scanner.nextInt();

            scanner.nextLine();
            System.out.println("Enter Name");
            String name = scanner.nextLine();

            System.out.println("Enter Price");
            double price = scanner.nextDouble();

            Animal beefCow = new Sheep(pedigree, weight, age, name, price);
            animals.add(beefCow);
            System.out.println(beefCow);
            System.out.println("Added Successfully");
            herdDB.saveToFile();
        }
    }
    private static void addDairyCow()
    {
        System.out.println("How Many Dairy Cows would you like to add to your farm");
        int quantity = scanner.nextInt();
        for(int i = 0; i < quantity; i++) {
            System.out.println("Enter Pedigree true or false ");
            boolean pedigree = Boolean.parseBoolean(scanner.next());

            System.out.println("Enter Weight");
            double weight = scanner.nextDouble();

            System.out.println("Enter Age");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter Name");
            String name = scanner.nextLine();


            Animal cow = new DairyCow(pedigree, weight, age, name);
            animals.add(cow);
            System.out.println(cow);
            System.out.println("Added Successfully");
            herdDB.saveToFile();
        }
    }

    private static void addFarm() {


        //arraylists for new farm
        ArrayList<DairyCow> newDairyCows = new ArrayList<>();
        ArrayList<BeefCow> newBeefCows = new ArrayList<>();
        ArrayList<Goat> newGoats = new ArrayList<>();
        ArrayList<Sheep> newSheep = new ArrayList<>();
        ArrayList<Animal> newAnimals = new ArrayList<>();

        System.out.println("Please Enter the Name of the Owner");
        String name = scanner.nextLine();

        HerdDB newHerdDB = new HerdDB(2,newDairyCows,newBeefCows,newGoats,newSheep,newAnimals);
        ArrayList<Shed> newFarmSheds = new ArrayList<>();
        ShedDB newShedsDB = new ShedDB(newFarmSheds);

        MilkTank goatMilkTank = new MilkTank(FarmEnums.GOATMILK);
        MilkTank cowMilkTank = new MilkTank(FarmEnums.COWMILK);
        Shed whiteShed = new Shed(goatMilkTank);
        Shed blackShed = new Shed(cowMilkTank);

        newFarmSheds.add(whiteShed);
        newFarmSheds.add(blackShed);

        MilkTank machinesTank1 = new MilkTank(FarmEnums.GOATMILK);
        MilkTank machinesTank2 = new MilkTank(FarmEnums.COWMILK);

        MilkingMachine machine1 = new MilkingMachine(machinesTank1);
        MilkingMachine machine2 = new MilkingMachine(machinesTank2);

        whiteShed.installMilkingMachine(machine1);
        blackShed.installMilkingMachine(machine2);

        ArrayList<Farm> totalFarms= new ArrayList<>();
        Farm newFarm = new Farm(name,newHerdDB,newShedsDB);
        totalFarms.add(newFarm);
        System.out.println("New Farm has been added\n"+newFarm);
        farmDB.saveToFile();
    }


}

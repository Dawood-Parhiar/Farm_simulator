package farm_simulator;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class HerdDB implements ISavable{
    private int farmID;
    private ArrayList<DairyCow> dairyCows;

    private ArrayList<BeefCow> beefCows;

    private ArrayList<Goat> goats;

    private ArrayList<Sheep> sheep;

    private ArrayList<Animal> animals;

    static Scanner scanner = new Scanner(System.in);

    public HerdDB(int farmID, ArrayList<DairyCow> dairyCows, ArrayList<BeefCow> beefCows, ArrayList<Goat> goats, ArrayList<Sheep> sheep, ArrayList<Animal> animals) {
        this.farmID = farmID;
        this.dairyCows = dairyCows;
        this.beefCows = beefCows;
        this.goats = goats;
        this.sheep = sheep;
        this.animals = animals;
    }

    public int getFarmID() {
        return farmID;
    }

    public ArrayList<DairyCow> getDairyCows() {
        return dairyCows;
    }

    public ArrayList<BeefCow> getBeefCows() {
        return beefCows;
    }

    public ArrayList<Goat> getGoats() {
        return goats;
    }

    public ArrayList<Sheep> getSheep() {
        return sheep;
    }


    public DairyCow findDairyCowByName(int id, String name, ArrayList<DairyCow> dairyCows)
    {
        for(int i=0; i < dairyCows.size(); i++)
        {
            DairyCow checkedCow = dairyCows.get(i);
            if(checkedCow.getId() == id && checkedCow.getName().equals(name))
            {
                return checkedCow;
            }
        }
        return null;
    }
    public Goat findGoatByName(int id, String name, ArrayList<Goat> goats)
    {
        for(int i=0; i < goats.size(); i++)
        {
            Goat checked = goats.get(i);
            if(checked.getId() == id && checked.getName().equals(name))
            {
                return checked;
            }
        }
        return null;
    }
    public Sheep findSheepByName(int id, String name, ArrayList<Sheep> sheep)
    {
        for(int i=0; i < sheep.size(); i++)
        {
            Sheep checked = sheep.get(i);
            if(checked.getId() == id && checked.getName().equals(name))
            {
                return checked;
            }
        }
        return null;
    }
    public BeefCow findBeefCowByName(int id, String name, ArrayList<BeefCow> beefCows)
    {
        for(int i=0; i < beefCows.size(); i++)
        {
            BeefCow checked = beefCows.get(i);
            if(checked.getId() == id && checked.getName().equals(name))
            {
                return checked;
            }
        }
        return null;
    }

    private int findAnimalIndex(Animal animal)
    {
        System.out.println("inside find Animal :::  "+this.animals.size());
        return this.animals.indexOf(animal);
    }
    private boolean findAnimalExistance(Animal animal)
    {
        for(Animal exist_animal : this.animals)
        {
            if(exist_animal.equals(animal))
            {
                return true;
            }
        }
        return false;
    }
    public boolean updateAnimal(Animal oldAnimal, Animal newAnimal){

        int foundPosition = findAnimalIndex(oldAnimal);

        if(foundPosition < 0)
        {
            System.out.println(oldAnimal+ " was not found");
            return false;
        }
        this.animals.set(foundPosition,newAnimal);
        System.out.println(oldAnimal + " , was replaced with " + newAnimal);

        return true;
    }
    public boolean deleteAnimal(Animal animal)
    {

        int index = findAnimalIndex(animal);

        if(animal instanceof DairyCow)
        {
            dairyCows.remove(index);
            return true;
        }else if(animal instanceof BeefCow)
        {
            beefCows.remove(index);
            return true;
        }else if(animal instanceof Goat)
        {
            goats.remove(index);
            return true;
        }
        else if(animal instanceof Sheep)
        {
            sheep.remove(index);
            return true;
        }else
        {
            return false;
        }
    }

    //Dylan Fennelly helped me to cover the code below.
    public boolean addAnimal(Animal animal)
    {
        if(!(findAnimalExistance(animal)))
        {
            if(animal instanceof DairyCow)
            {
                dairyCows.add((DairyCow) animal);
                return true;
            }
            else if(animal instanceof BeefCow)
            {
                beefCows.add((BeefCow) animal);
                return true;
            }else if(animal instanceof Sheep)
            {
                sheep.add((Sheep) animal);
                return true;
            }else if(animal instanceof Goat)
            {
                goats.add((Goat) animal);
                return true;
            }else
            {
                return false;
            }
        }
        return false;
    }

    @Override
    public void loadFromFile() {

        try(BufferedReader fileReader = new BufferedReader(new FileReader("animals.txt")))
        {
            String input;
            while ((input = fileReader.readLine()) != null)
            {
                String[] data = input.split(",");
                int id = Integer.parseInt(data[0]);

                boolean pedigree = Boolean.parseBoolean(data[1]);

                double weight = Double.parseDouble(data[2]);

                int age = Integer.parseInt(data[3]);

                String name = data[4];
                Animal tempAnimal = new Animal(pedigree,weight,age);
                animals.add(tempAnimal);
            }
        }
        catch(FileNotFoundException fnfe)
        {
            System.out.println(fnfe.getMessage());
        }catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    @Override
    public void saveToFile() {


        try(BufferedWriter fileWriter = new BufferedWriter(new FileWriter("animals.txt")))
        {
            for(Animal animal : animals)
            {
               fileWriter.write(animal.toString());
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    @Override
    public String toString() {
        return "\n  HerdDB{" +
                "farmID=" + farmID +
                ", dairyCows=" + dairyCows +
                ", beefCows=" + beefCows +
                ", goats=" + goats +
                ", sheep=" + sheep +
                '}';
    }
}

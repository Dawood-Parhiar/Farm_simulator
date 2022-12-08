package farm_simulator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HerdDB implements ISavable{
    private int farmID;
    private ArrayList<DairyCow> dairyCows;

    private ArrayList<BeefCow> beefCows;

    private ArrayList<Goat> goats;

    private ArrayList<Sheep> sheep;

    private ArrayList<Animal> animals;

    static Scanner scanner = new Scanner(System.in);

    public HerdDB(int farmID, ArrayList<DairyCow> dairyCows, ArrayList<BeefCow> beefCows, ArrayList<Goat> goats, ArrayList<Sheep> sheep) {
        this.farmID = farmID;
        this.dairyCows = dairyCows;
        this.beefCows = beefCows;
        this.goats = goats;
        this.sheep = sheep;
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

    private DairyCow findAnimal(int id, String name, List<DairyCow> dairyCows)
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
    private int findAnimalIndex(Animal animal)
    {
        return this.animals.indexOf(animal);
    }
    private boolean findAnimalExistance(Animal animal)
    {
        for(Animal exist_animal : animals)
        { if(exist_animal.equals(animal))
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

        try(BufferedReader fileReader = new BufferedReader(new FileReader("players.txt")))
        {
            String input;
            while ((input = fileReader.readLine()) != null)
            {
//               String[] data = input.split(",");
//                do id = Integer.parseInt(data[0]);
//                String name = data[1];
//                int health = Integer.parseInt(data[2]);
//                DairyCow tempDairyCow = new DairyCow();
//                animals.add(tempDairyCow);
//                String[] data = input.split(",");

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

        try(BufferedWriter fileWriter = new BufferedWriter(new FileWriter("players.txt")))
        {
            for(Animal animal : animals)
            {
               // fileWriter.write();//animal.getId()+", "+ player.getName()+", "+ player.getHealth()+ "\n");
                }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    @Override
    public String toString() {
        return "HerdDB{" +
                "farmID=" + farmID +
                ", dairyCows=" + dairyCows +
                ", beefCows=" + beefCows +
                ", goats=" + goats +
                ", sheep=" + sheep +
                '}';
    }
}

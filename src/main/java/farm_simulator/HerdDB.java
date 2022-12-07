package farm_simulator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HerdDB implements ISavable{
    private int farmID;
    private ArrayList<DairyCow> dairyCows;
    private ArrayList<BeefCow> beefCows;
    private ArrayList<Goat> goats;
    private ArrayList<Sheep> sheep;

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

    private DairyCow findAnimal(int id,String name)
    {
        for(int i=0; i < this.dairyCows.size(); i++)
        {
            DairyCow checkedCow = this.dairyCows.get(i);
            if(checkedCow.getId() == id && checkedCow.getName().equals(name))
            {
                return checkedCow;
            }
        }
        return null;
    }
    public void deleteCow(int id, String name)
    {
        DairyCow existCow = findAnimal(id,name);
        if(existCow != null)
        {
            System.out.println(existCow);
            System.out.println("1.  Confirm Delete");
            System.out.println("2.  Cancel Delete");
            int choice = scanner.nextInt();
            if(choice == 1)
            {
                dairyCows.remove(existCow);
                System.out.println("Deleted");
            }else
            {
                System.out.println("Cancelled Delete");
            }

        }
    }

    public void addCow(DairyCow dairyCow){
        dairyCows.add(dairyCow);
    }

    @Override
    public void loadFromFile() {

        try(BufferedReader fileReader = new BufferedReader(new FileReader("players.txt")))
        {
            String input;
            while ((input = fileReader.readLine()) != null)
            {
//                String[] data = input.split(",");
//                int id = Integer.parseInt(data[0]);
//                String name = data[1];
//                int health = Integer.parseInt(data[2]);
//                Player tempPlayer = new Player(id,name,health);
//                players.add(tempPlayer);
                String[] data = input.split(",");

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

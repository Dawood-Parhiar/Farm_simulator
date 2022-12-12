package farm_simulator;

import java.io.*;
import java.util.ArrayList;

public class FarmDB implements ISavable{
    ArrayList<Farm> farms;

    public FarmDB(ArrayList<Farm> farms) {
        this.farms = farms;
    }

    public ArrayList<Farm> getFarms() {
        return farms;
    }

    public int findFarm(Farm farm)
    {
        return this.farms.indexOf(farms);
    }

    public boolean checkFarmExists(Farm farm)
    {
        for(Farm exist_farm : farms)
        {
            if(exist_farm.equals(farm))
            {
                return true;
            }
        }
        return false;
    }
    public Farm findFarmByID(int id, String ownerName)
        {
            for(int i=0; i < farms.size(); i++)
            {
                Farm checkfarm = farms.get(i);
                if(checkfarm.getFarmID() == id && checkfarm.getOwner().equals(ownerName))
                {
                    return checkfarm;
                }
            }
            return null;
    }
    @Override
    public void loadFromFile() {

        try(BufferedReader fileReader = new BufferedReader(new FileReader("animals.txt")))
        {
            String input;
            while ((input = fileReader.readLine()) != null)
            {

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
            for(Farm farm : farms)
            {
                fileWriter.write(farm.toString());
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    @Override
    public String toString() {
        return "FarmDB{" +
                "farms=" + farms +
                '}';
    }
}

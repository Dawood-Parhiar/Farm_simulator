package farm_simulator;

import java.util.ArrayList;

public class ShedDB {

    ArrayList<Shed> sheds;

    public ShedDB( ArrayList<Shed> sheds) {

        this.sheds = sheds;
    }

    public ArrayList<Shed> getSheds() {
        return sheds;
    }

    public int findShed(Shed shed)
    {
        return this.sheds.indexOf(shed);
    }
    public boolean checkShedExists(Shed shed)
    {
        for(Shed exist_shed : sheds)
        {
            if(exist_shed.equals(shed))
            {
                return true;
            }
        }
        return false;
    }

    public Shed findShed(int id)
    {
        for(int i= 0; i < sheds.size(); i++)
        {
            Shed checShed = sheds.get(i);
            if(checShed.getId() == id)
            {
                return checShed;
            }
        }return null;
    }
    private int findShedIndex(Shed shed)
    {
        System.out.println("inside find Animal :::  "+shed);
        return this.sheds.indexOf(shed);
    }

    public boolean addShed(Shed shed)
    {
        boolean shedExist = checkShedExists(shed);
        if(!shedExist)
        {
            return false;
        }else
        {
            sheds.add(shed);
            return true;
        }

    }
    public boolean updateShed(Shed oldShed,Shed newShed)
    {

        int foundPosition = findShedIndex(oldShed);

        if(foundPosition < 0)
        {
            System.out.println(oldShed+ " was not found");
            return false;
        }
        this.sheds.set(foundPosition,newShed);
        System.out.println(oldShed + " , was replaced with " + newShed);

        return true;
    }
    public void deleteShed(Shed shed)
    {
        int index = findShedIndex(shed);
            sheds.remove(index);
    }

    @Override
    public String toString() {
        return "\n  ShedDB{" +
                "sheds=" + sheds +
                '}';
    }
}

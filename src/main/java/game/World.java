package game;

import java.util.ArrayList;

public class World {

    private ArrayList<Enemy> enemies;
    private Player player;
    private ArrayList<String> loot;
    private char[][] map;
    int rows = 5;
    int columns = 5;

    public World() {
        this.enemies = enemies;
        this.player = player;
        this.loot = loot;
        this.map = new char[rows][columns];
    }

    public void printMap()
    {

        System.out.println("_____________________________________________________________");
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                if(j == columns - 1)
                {
                    System.out.println(map[i][j] + " | ");
                } else
                {
                    System.out.print(map[i][j] + " | ");
                }

            }
        }
        System.out.println("_____________________________________________________________");

    }
    public void movePlayer(){

    }
    public int attack(){

        return 0;
    }

}

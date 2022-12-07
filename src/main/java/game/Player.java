package game;

import java.util.ArrayList;

public class Player {
    public Player(String playerName, int playerHealth, int strength, String[] weapons, ArrayList<String> loot, int score, int lives, int attack) {
        this.playerName = playerName;
        this.playerHealth = playerHealth;
        this.strength = strength;
        this.weapons = weapons;
        this.loot = loot;
        this.score = score;
        this.lives = lives;
        this.attack = attack;
    }

    private String playerName;
    private int playerHealth;
    private int strength;
    private String[] weapons;
    private ArrayList<String> loot;
    private int score;
    private int lives;
    private int attack;

    public void reSpawn(){

    }
    public int heal()
    {
        {

        }
        return this.playerHealth;
    }
    public void levelUp(){


    }
}

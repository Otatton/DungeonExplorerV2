/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonexplorerv2;

/**
 * CSIS 1400 "group" project
 * @author orson tatton
 */
import java.util.*;
public class DEMain2 
{
    private static Player newPlayer = null;
    private static Monster newMonster = null;
    private static Map newMap = null;
    private static Random rand = new Random();
    private static Items newItem = new Items();
    
    public static void newRoom() //Makes random rooms
    {
        newMap = new Map();
        Scanner scan = new Scanner(System.in);

        System.out.println("Press enter to continue: ");
        scan.nextLine();
        newMap.drawRandomMap();
   
    }
    public static void exploreMenu() //prompts user to check map areas
    {
        System.out.println("\n1) Area 1");
        System.out.println("2) Area 2");
        System.out.println("3) Area 3");
        System.out.println();
        System.out.print("Pick an area to explore: ");
    }
    
    public static void checkDoor() //prompts users to check doors
    {
        System.out.println("\n1) Door 1");
        System.out.println("2) Door 2");
        System.out.println("3) Door 3");
        System.out.println();
        System.out.print("Pick a door to check: ");
    }
    public static void gameOver() //ends game and exits program
    {
        System.out.println("You are dead... Game over dude, game over.");
        System.exit(0);
    }

    public static void main(String[] args) 
    {
        //Random rand = new Random();
        Scanner input = new Scanner(System.in);
        Items newItem = new Items();
        //Start a new game
        System.out.print("What is your name adventurer? ");
        String name = input.nextLine();
        //newPlayer.setName(name);
        newPlayer = new Player(name, 10, 1, 4);
        //newMonster = new Monster(null, 1, 0, 3);
         
        System.out.printf("Welcome to my dungeon %s, Mwah ha hah!\n", name);

        int counter = 0;
        //variable length dungeon
        while (counter < 50)
        {
            newRoom();
            int[] explore = new int[3];
            for (int i = 0; i < 3; i++)
            {
                explore[i] = rand.nextInt(6) + 1;
            }
            
            boolean[] door = new boolean[3];
            int open = rand.nextInt(3);
            door[open] = true;
            boolean exitFound = false;
            while (exitFound == false)
            {
                exploreMenu();
                int checkArea = input.nextInt() - 1;
                    
                if (explore[checkArea] > 0 && explore[checkArea] <= 3)
                {
                    foundItem();
                    explore[checkArea] = 0;
                } 
                
                else if (explore[checkArea] >= 4)
                {
                    String[] monster = {"Orc", "Skeleton", "Giant Rat", "Spider", "Clown"};
                    String mName = monster[rand.nextInt(5)];
                    newMonster = new Monster(mName, 1, 0, 3);
                   
                    System.out.printf("You have encountered a rather unpleasant looking %s\n"
                            , newMonster.getName());
                    
                    System.out.printf("You have %d hitpoints\n", newPlayer.getPHp());
                    combat();
                    explore[checkArea] = 0;
                }
                
                else
                {
                    System.out.println("You have already checked this area");
                }

                checkDoor();
                int newDoor = input.nextInt() - 1;
                if (door[newDoor])
                {
                    System.out.println("You have found the open door and exit"
                            + " the current room\n");
                    exitFound = true;
                    break;
                }
                else
                {
                     System.out.println("The door is blocked, continue searching\n");
                }
            }
            counter += rand.nextInt(5);
        }
        
        System.out.println("You stumble through the darkness for what seems like ages");
        System.out.println();
        System.out.println("Just when you are about give in to despair you come across a massive ornate door");
        System.out.println();
        System.out.println("It doesn't take Batman to figure out that this is probably the boss room");
        System.out.println("Press enter to open the door: ");
        input.nextLine();
        
        //creates a boss mob
        newMonster.setMAtk(1);
        String[] boss = {"Dragon", "Lich", "Vampire", "General Zod"};
        int type = rand.nextInt(4);
        newMonster.setName(boss[type]);
        newMonster.setMTough(4);
        newMonster.setMHp(rand.nextInt(4)+6);
        //fills explorable areas
        int[] bossAreas = new int[3];
            for (int i = 0; i < 3; i++)
            {
                bossAreas[i] = rand.nextInt(6) + 1;
            }
        //explore the lair and fight the boss
        newMap.bRoom();
        System.out.printf("You find your self in the lair of a fearsome %s", 
                newMonster.getName());
        
        
        while (newPlayer.getPHp()> 0 && newMonster.getMHp() > 0)
        {
            System.out.println("The dreadful creature has not seemed to notice you yet");
            System.out.println("Press enter to continue: ");
            input.nextLine();
            newMap.bRoom();
            System.out.println("Do you wish to explore or fight the boss?");
            System.out.println("1) Explore");
            System.out.println("2) Fight boss");
            System.out.print("Choice: ");
            int choice = input.nextInt();
            if (choice == 1)
            {
                exploreMenu();
                int checkArea = input.nextInt() - 1;
                if (bossAreas[checkArea] > 0)
                {
                    foundItem();
                    bossAreas[checkArea] = 0;
                }
                else
                {
                    System.out.println("You have already checked this area");
                }
                
            }
            else if (choice == 2)
            {
                System.out.println("As you climb the stairs your pulse begins to quicken");
                System.out.println("You reach the top and hear a voice filled with malice taunting you");
                System.out.printf("You have done well %s, now DIE!!!\n", newPlayer.getName());
                System.out.println("The fight is on. Press enter to continue");
                input.nextLine();
                combat();
            }
            else
            {
                System.out.println("That is not valid input");
            }
        }
        if(newPlayer.getPHp() > 0)
        {
            System.out.printf("%s has triumphed over the evil %s!\n", 
                    newPlayer.getName(), newMonster.getName());
            System.out.println("You Win!");
        }
        else
            gameOver();
            
        
 
    }
    public static void combat()
    {
        while (newMonster.getMHp() > 0 && newPlayer.getPHp() > 0)
        {
            int pDamage = newPlayer.getPAtk() + rand.nextInt(6) + 1;
            int mDamage = newMonster.getMAtk() + rand.nextInt(6) + 1;

            System.out.printf("Your damage  total is %d\n", pDamage);

            if (pDamage > newMonster.getMTough())
            {
                newMonster.takeDamage();
                if (newMonster.getMHp() < 1)
                {
                System.out.printf("You have destroyed the evil %s\n",
                        newMonster.getName());
                }
                else
                {
                    System.out.printf("The %s loses a hitpoint but is still alive\n", 
                            newMonster.getName());
                }
            }

            else
            {
                System.out.println("Your attack does no damage");
                System.out.printf("The %s's attack is %d\n",
                        newMonster.getName(), mDamage); 
                if (mDamage > newPlayer.getTough())
                {
                    newPlayer.takeDamage();
                    System.out.println("You lose 1 hitpoint");
                }
                else
                {
                    System.out.println("You narrowly avoid the attack");
                }
            }
            System.out.printf("your hitpoints are now %d\n", newPlayer.getPHp()); 
        } 
    }
    
    public static void foundItem()
    {
        int randomItem = rand.nextInt(9);
        switch (randomItem){
            case 0:
                newItem.badWeapons();
                if (newPlayer.getPAtk() > 0){
                    System.out.println("You have been cursed and lose a point of attack!");
                    newPlayer.setPAtk(newPlayer.getPAtk()-1);}
                else {System.out.println("You have been cursed!");}
                break;
            case 2:
                newItem.badArmor();
                if (newPlayer.getTough() > 2){
                    System.out.println("You have been cursed and lose a point of toughness!");
                    newPlayer.setTough(newPlayer.getTough()-1);}
                else {System.out.println("You have been cursed!");}
                break;
            case 4:
                newItem.badItems();
                newPlayer.takeDamage();
                if (newPlayer.getPHp()== 0){ 
                    System.out.println("You have rotten luck and suffer a death curse!");
                    gameOver();}    
                else {System.out.println("You have been cursed and lose 1 hitpoint!");}
                break;
            case 6:
                System.out.println("You find nothing of value");
                break;
            case 1:
                System.out.println("You find nothing of value");
                break;
            case 3:
                newItem.goodItems();
                newPlayer.healDamage();
                System.out.println("You gain one hitpoint");
                break;    
            case 5:
                newItem.goodItems();
                newPlayer.healDamage();
                System.out.println("You gain one hitpoint");
                break;
            case 7:
                newItem.goodArmor();
                 if (newPlayer.getTough() < 6){
                    System.out.println("You have a set of awesome armor and gain 1 toughness!");
                    newPlayer.setTough(newPlayer.getTough()+1);}
                else {System.out.println("While its nice armor, you have seen better");}
                break;
            case 8:
                newItem.goodWeapons();
                 if (newPlayer.getPAtk() < 3){
                    System.out.println("You have found an awesome new weapon and gain 1 attack!");
                    newPlayer.setPAtk(newPlayer.getPAtk()+1);}
                else {System.out.println("This weapon is not as good as your current equipment");}
                break;
        }
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeonexplorerv2;

/**
 *
 * @author otatton
 */
import java.util.Random;
public class Items 
{
    private static Random rand = new Random();
    
    public static void goodWeapons()
    {
        //11 weapon types
        String[] weapon = {"Sword", "Axe", "Dagger", "Mace", "Bow", 
            "Crossbow", "Warhammer", "Spear", "Polearm", "Club", "Staff"};
        //9 weapon descriptions
        String[] goodWep = {"Vorpal", "Divine", "Flaming", "Rending", "Shocking", 
            "Piercing", "Rune", "Seeking", "Thundering"};
       
        System.out.printf("You have found a +%d %s %s\n", rand.nextInt(3)+1, 
                goodWep[rand.nextInt(9)], weapon[rand.nextInt(11)]);
    }
    
    public static void goodArmor()
    {
        //5 armor types
        String[] armor = {"Leather", "Chain", "Scale", "Plate", "Cloth"};
        //5 misc item types
        String[] goodAr = {"Impenetrable", "Shining", "Charmed", "Lucky", 
            "Mithril", "Elvish", "Dwarven", "Magical", "Arcane"};
        
        System.out.printf("You have found a +%d %s %s armor\n", rand.nextInt(3)+1, 
                goodAr[rand.nextInt(5)], armor[rand.nextInt(5)]);
    }    
    public static void goodItems()
    {
        //5 items
        String[] misc = {"Potion", "Ring", "Pendant", "Charm", "Belt"};
        //8 descriptors
        String[] goodMisc = {"Protection", "Healing", "Fortune", "Luck", 
            "Resistance", "Swiftness", "Energy", "Regeneration"};
        
        System.out.printf("You have found a %s of %s\n", misc[rand.nextInt(5)], 
                goodMisc[rand.nextInt(8)]);
    } 
    
    public static void badWeapons()
    {
        // 8 curses
        String[] curse = {"Cursed", "Enfeebling", "Doomed", "Poisoned", 
            "Draining", "Unlucky", "Petrifying", "Berserking"};
        //11 weapon types
        String[] weapon = {"Sword", "Axe", "Dagger", "Mace", "Bow", 
            "Crossbow", "Warhammer", "Spear", "Polearm", "Club", "Staff"};
        
        System.out.printf("You have found a +%d %s of %s\n", rand.nextInt(3)+1, 
                curse[rand.nextInt(8)], weapon[rand.nextInt(11)]);  
    }
    
    public static void badArmor()
    {
        // 8 curses
        String[] curse = {"Cursed", "Enfeebling", "Doomed", "Poisoned", 
            "Draining", "Unlucky", "Petrifying", "Berserking"};
        //5 armor types
        String[] armor = {"Leather", "Chain", "Scale", "Plate", "Cloth"};
        
        System.out.printf("You have found a +%d %s %s\n", rand.nextInt(3)+1, 
                curse[rand.nextInt(8)], armor[rand.nextInt(5)]);
    }
    
    public static void badItems()
    {
        // 8 curses
        String[] curse = {"Cursed", "Enfeebling", "Doomed", "Poisoned", 
            "Draining", "Unlucky", "Petrifying", "Berserking"};
        //5 items
        String[] misc = {"Potion", "Ring", "Pendant", "Charm", "Belt"};

        System.out.printf("You have found a %s %s\n", curse[rand.nextInt(8)], 
                misc[rand.nextInt(5)]);
    }
  
}

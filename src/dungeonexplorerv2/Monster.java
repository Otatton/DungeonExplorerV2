package dungeonexplorerv2;


import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author otatton
 */

public class Monster 
{
    private String name;
    // monsters hitpoints -  ie 1 reg, 3 midboss, 5 boss
    private int mHp;
    //base attack value to see if the monster can damage the player
    private int mAtk;
    //target value for damage to make monter lose a hitpoint
    private int mTough;
    
    
    //create new instance of monster
    public Monster(String n, int h, int d, int t)
    {
        name = n;
        mHp = h;
        mAtk = d;
        mTough = t;
        
    }
    
    public int getMHp()
    {
        return mHp;
    }
     
    public int getMAtk()
    {
        return mAtk;
    }
    
    public int getMTough()
    {
        return mTough;
    }
    public String getName()
    {
        return name;
    }
    
    public void setName(String n)
    {
        name = n;
    }
    
    public void setMHp(int h)
    {
        mHp = h;
    }
    
    public void setMAtk (int d)
    {
        mAtk = d;
    }
    
    public void setMTough(int t)
    {
        mTough = t;
    }

    
    //modifies the monters hitpoints
    public void takeDamage()
    {
        mHp--;
    }
    
    public void regen()
    {
        mHp++;
    }
    
}

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

public class Player 
{
    private String name;
    private int pHp;
    private int pAtk;
    private int pTough;
    
    public Player (String n, int h, int d, int t)
    {
        name = n;
        pHp = h;
        pAtk = d;
        pTough = t;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getPHp()
    {
        return pHp;
    }
    
    public int getPAtk()
    {
        return pAtk;
    }
    
    public int getTough()
    {
        return pTough;
    }
    
    public void setName(String n)
    {
        name = n;
    }
    
    public void takeDamage()
    {
        pHp--;
        
    }
    public void healDamage()
    {
        pHp++;
    }
    
    public void setPAtk(int d)
    {
        pAtk = d;
    }
    public void setTough(int t)
    {
        pTough = t;
    }
}

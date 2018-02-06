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
public class Map 
{
    
    public static void drawRandomMap()
    {
        //randomly generates simple rooms with doors, walls and points of interest
        Random rand = new Random();
        int room = rand.nextInt(5);
        if (room == 0)
            hRoom();
        else if (room == 1)
            tRoom();
        else if (room >= 2)
            sRoom();
 
    }
    
    public static void hRoom()    
        {
           //print a hallway and description
        System.out.print
            ("=============================================[D1]=============\n"
           + "=                                                            =\n"
           + "=                                                            =\n"
           + "E            [1]              [2]              [3]          D2\n"
           + "=                                                            =\n"
           + "=                                                            =\n"
           + "=============================================[D3]=============\n");
           
           System.out.println("You dash through the doorway as the ceiling behind "
                    + "you caves in");
//            System.out.println("The room behind you is filled with rubble");
            System.out.println("\nBefore you is a dark hallway with 3 doors at the end");
                
        }
    public static void sRoom()
        {
            //print a square room
        System.out.print
            ("============================[D2]==============================\n"
           + "=                                                            =\n"
           + "=                                                            =\n"
           + "=                                                            =\n"         
           + "=                                                            =\n"          
           + "=            [2]                              [3]            =\n"
           + "=                                                            =\n"
           + "=                                                            =\n"
           + "D1                                                          D3\n"
           + "=                                                            =\n"         
           + "=                                                            =\n"         
           + "=                            [1]                             =\n"
           + "=                                                            =\n"
           + "=                                                            =\n"
           + "=                                                            =\n"         
           + "=                                                            =\n"
           + "=============================[E]==============================\n");
        
            System.out.println("You dash through the doorway as a "
                    + "portculis slams shut behind you");
            //System.out.println("The way back is blocked");
            System.out.println("\nA large stone room looms before you");
        }
    
    public static void tRoom()
        {
         //print a T shaped room
         System.out.print
            ("============================[D2]==============================\n"
           + "=                                                            =\n"
           + "=                                                            =\n"
           + "=                                                            =\n"         
           + "D1           [2]                              [3]           D3\n"
           + "=                                                            =\n"
           + "=                                                            =\n"         
           + "=                                                            =\n"
           + "====================                     =====================\n"
           + "                   =                     =\n"         
           + "                   =                     =\n"         
           + "                   =          [1]        =\n"
           + "                   =                     =\n"
           + "                   =                     =\n"         
           + "                   =                     =\n"
           + "                   ==========[E]==========\n");
            
            System.out.println("As you walk through the doorway a "
                    + "stone slab slides into place blocking the way back");
            //System.out.println("The way back is blocked");
            System.out.println("\nBefore you is a dimly lit T shaped "
                    + "corridor with 3 doors"); 
        }
    
    public static void bRoom()
    {
        System.out.print
            ("=========================================================\n"
           + "=       __      |           [P]          |      __      =\n"
           + "=       ||      |                        |      ||      =\n"
           + "=       ||      |           [B]          |      ||      =\n"         
           + "=               |                        |              =\n"          
           + "=       __      |                        |      __      =\n"
           + "=       ||      |____|--------------|____|      ||      =\n"
           + "=       ||           |--------------|           ||      =\n"
           + "=                    |--------------|                   =\n"
           + "=       __           |--------------|           __      =\n"         
           + "=       ||           |--------------|           ||      =\n"         
           + "=       ||           |--------------|           ||      =\n"
           + "=                    |--------------|                   =\n"
           + "=                                                       =\n"
           + "=              [1]          [2]         [3]             =\n"         
           + "=                                                       =\n"
           + "========================[Entrance]=======================\n");
    }
   
}

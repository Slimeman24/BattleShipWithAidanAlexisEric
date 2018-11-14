package battleship;
import java.io.*; 
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class Board {
     static final int numRows = 21;
    static final int numColumns = 11;
    static boolean secActive = false;
    static int xDelta=Window.getWidth2()/numColumns;
    static int yDelta=Window.getHeight2()/numRows;
    
    static final int PATH = 0;
    static final int WALL = 1;
    static final int SHIP = 2;
    

    static int board[][] = {
{WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL},
{WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL},
{WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL},
{WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL },
{WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL },
{WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL},
{WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL},
{WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL},
{WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL},
{WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL},
{WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,},
{WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL,},
{WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL,},
{WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL,},
{WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL },
{WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL },
{WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL},
{WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL},
{WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL},
{WALL,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,PATH,WALL},
{WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL,WALL }

            
            
            

    };
    
    public static void addShip(Ships.Direction dir,int length,int width,int xpos, int ypos)
    {
    Ships.create(dir,length,width,xpos,ypos);
    
    }        
    public static int[][] getBoard()
    {
    return board;    
    }        

}



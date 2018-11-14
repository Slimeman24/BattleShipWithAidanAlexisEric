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
    static final int SANK = 3;
    

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

static final int resetboard[][] = {
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
 
    
////////////////////////////////////////////////////////////////////////////////
    public static void addShip(Ships.Direction dir,Ships.TYPE type,int xpos, int ypos)
    {
        
        
        
    int currRow = 0;
        int ydelta = Window.getHeight2()/numRows;
        int currYVal = ydelta;
        while (ypos > currYVal)
        {
            currRow++;
            currYVal += ydelta;
        }


        int currCol = 0;
        int xdelta = Window.getWidth2()/numColumns;
        int currXVal = xdelta;
        while (xpos > currXVal)
        {
            currCol++;
            currXVal += xdelta;
        }    
        
        System.out.println(xpos+" "+ypos+" "+currRow+" "+currCol);
    Ships.create(dir,type,currRow,currCol);
    
    }        
////////////////////////////////////////////////////////////////////////////////    
    public static int[][] getBoard()
    {
    return board;    
    }        



////////////////////////////////////////////////////////////////////////////////  
    public static void reset()
    {
    Ships.reset();
    board=resetboard;
    
    }

}



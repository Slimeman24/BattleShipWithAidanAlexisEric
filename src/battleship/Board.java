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
        
      for (int zi=1;zi<Board.numColumns;zi++)
        {  
  for (int zx=numRows/2;zx<Board.numRows;zx++)    
        {      
            
        int left=Window.getX(0)+zi*Window.getWidth2()/Board.numColumns;
        int right=Window.getX(0)+(zi+1)*Window.getWidth2()/Board.numColumns;
        int top=Window.getY(0)+zx*Window.getHeight2()/Board.numRows;
        int bottom=Window.getY(0)+(zx+1)*Window.getHeight2()/Board.numRows;
        if (xpos>left&&xpos<right&&ypos>top&&ypos<bottom)
        {
        if(board[zx][zi]==PATH)
        {
        Ships.create(dir,type,zx,zi);
        break;
        }
        }
        }
        }
        
        
    
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
    for (int zi=0;zi<Board.numColumns;zi++)
    for (int zx=0;zx<Board.numRows;zx++)       
    board[zx][zi]=resetboard[zx][zi];
    
    }

}



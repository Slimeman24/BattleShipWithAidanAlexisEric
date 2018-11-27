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
<<<<<<< Updated upstream
    static final int SANK = 3;
    static final int HIGHLIGHT = 3;
=======
    static final int HIGHLIGHT = 3;
    static final int MISS = 4;
    static final int HIT = 5;
    static final int SANK = 6;
>>>>>>> Stashed changes

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

 public static int Player1[][] = {
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
 
 public static int P2[][] = {
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
<<<<<<< Updated upstream
        
      for (int zi=1;zi<Board.numColumns;zi++)
        {  
  for (int zx=numRows/2;zx<Board.numRows;zx++)    
        {      
            
        int left=Window.getX(0)+zi*Window.getWidth2()/Board.numColumns;
        int right=Window.getX(0)+(zi+1)*Window.getWidth2()/Board.numColumns;
        int top=Window.getY(0)+zx*Window.getHeight2()/Board.numRows;
        int bottom=Window.getY(0)+(zx+1)*Window.getHeight2()/Board.numRows;
        if (xpos>left&&xpos<right&&ypos>top&&ypos<bottom)
=======
    int currRow = 0;
        int ydelta = Window.getHeight2()/numRows;
        int currYVal = ydelta;
        while (ypos > currYVal)
        {
            currRow++;
            currYVal += ydelta;
        }

>>>>>>> Stashed changes

        if(board[zx][zi]==PATH)
        {
        Ships.create(dir,type,zx,zi);
        break;
        }
        }
        }
        }
        
<<<<<<< Updated upstream
    
  
   
            
=======
   //     System.out.println(xpos+" "+ypos+" "+currRow+" "+currCol);
  //  Ships.create(dir,type,currRow,currCol);
    
    }        
>>>>>>> Stashed changes
///////////////////////////////////////////////////////////////////////////////    
    public static int[][] getBoard()
    {
    return board;    
    }        



////////////////////////////////////////////////////////////////////////////////  
    public static void reset()
    {
<<<<<<< Updated upstream
    Ships.reset();  
    for (int zi=1;zi<Board.numColumns;zi++)
    for (int zx=1;zx<Board.numRows;zx++)       

    board[zx][zi]=resetboard[zx][zi];
    
    }
=======
    Ships.reset();
   
    for (int zi=1;zi<Board.numColumns;zi++){
        for (int zx=1;zx<Board.numRows;zx++){       
            board[zx][zi]=resetboard[zx][zi];
            Player1[zx][zi] = resetboard[zx][zi];
            P2[zx][zi] = resetboard[zx][zi];
        }
    }
    
    }
   ////////////////////////////////////////////////////////////////////////////////  
    public static void changingBoard()
    { 
    for (int zi=1;zi<Board.numColumns;zi++)
        for (int zx=1;zx<Board.numRows;zx++)       
            board[zx][zi]=P2[zx][zi];  
    }
       ////////////////////////////////////////////////////////////////////////////////  
    public static void changingBoard2()
    { 
    for (int zi=1;zi<Board.numColumns;zi++)
        for (int zx=1;zx<Board.numRows;zx++)       
            board[zx][zi]=Player1[zx][zi];  
    }
    
    
>>>>>>> Stashed changes
    
}





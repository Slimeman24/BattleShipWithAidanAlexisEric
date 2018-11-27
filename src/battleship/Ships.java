package battleship;
import java.util.ArrayList;
import java.awt.*;
public class Ships {
private static ArrayList<Ships> ships = new ArrayList<Ships>(); 
private Direction dir;
private int Long;
private int tall;
private int X;
private int Y;
private boolean stop;
private TYPE type;
private int HP=tall*Long;
private static boolean show=true;


////////////////////////////////////////////////////////////////////////////////
public static enum Direction {
        LEFT,RIGHT,UP,DOWN
    }; 
public static enum TYPE {
        thxon,twxon,onxon,foxon,twxtw,thxtw
    }; 

////////////////////////////////////////////////////////////////////////////////
public static Ships create(Direction _dir,TYPE _type,int _Y, int _X)
{
Ships ptr = new Ships(_dir,_type,_Y,_X);
ships.add(ptr);
return (ptr);    
}         
    
Ships(Direction _dir,TYPE _type,int _Y,int _X)
{
dir=_dir;   
type=_type;
X=_X;
Y=_Y;
setSize();
setlocal();




}
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
public void setShow(boolean is)
{
show=is;
}   

public void setlocal()
{
    
if(dir==Ships.Direction.DOWN)   
{    
if(Y+tall<Board.numColumns&&Y+tall>-1&&X+Long<Board.numRows&&X+Long>-1)        
for(int zi=X;zi<X+Long;zi++)
for(int zx=Y;zx<Y+tall;zx++)
if(zi>Board.numColumns&&zi>-1&&zx<Board.numRows&&zx>-1&&Board.board[zi][zx]!=Board.PATH)
stop=true;    
if(!stop)  
{    
for(int zi=X;zi<X+Long;zi++)
for(int zx=Y;zx<Y+tall;zx++)
Board.board[zx][zi]=Board.SHIP;  
}
}


////////////////////////////////////////////////////////////////////////////////
else if(dir==Ships.Direction.UP) 
{    
if(Y+tall<Board.numColumns&&Y+tall>-1&&X+Long<Board.numRows&&X+Long>-1)        
for(int zi=X;zi<X+Long;zi++)
for(int zx=Y;zx>Y-tall;zx--)
if(zi>Board.numColumns&&zi>-1&&zx<Board.numRows&&zx>-1&&Board.board[zi][zx]!=Board.PATH)
stop=true;    
if(!stop)  
{    
for(int zi=X;zi<X+Long;zi++)
for(int zx=Y;zx>Y-tall;zx--)
Board.board[zx][zi]=Board.SHIP; 
}
}


////////////////////////////////////////////////////////////////////////////////
else if(dir==Ships.Direction.RIGHT)   
{    
if(Y+tall<Board.numColumns&&Y+tall>-1&&X+Long<Board.numRows&&X+Long>-1)    
for(int zi=Y;zi<Y+tall;zi++)
for(int zx=X;zx<X+Long;zx++)
if(zi<Board.numColumns&&zi>-1&&zx<Board.numRows&&zx>-1&&Board.board[zi][zx]!=Board.PATH)
stop=true;    
if(!stop)
{    
for(int zi=Y;zi<Y+tall;zi++)
for(int zx=X;zx<X+Long;zx++)
Board.board[zi][zx]=Board.SHIP; 
}
}


////////////////////////////////////////////////////////////////////////////////
else if(dir==Ships.Direction.LEFT)  
{   
if(Y+tall<Board.numColumns&&Y+tall>-1&&X+Long<Board.numRows&&X+Long>-1)        
for(int zi=Y;zi<Y+tall;zi++)
for(int zx=X;zx>X-Long;zx--)    
if(zi>Board.numColumns&&zi>-1&&zx<Board.numRows&&zx>-1&&Board.board[zi][zx]!=Board.PATH)
stop=true;    
if(!stop)
{    
for(int zi=Y;zi<Y+tall;zi++)
for(int zx=X;zx>X-Long;zx--)
Board.board[zi][zx]=Board.SHIP;  
}
}

}
//reset
public static void reset()
{
ships.clear();

}


public void setSize()
{
    
if(type==TYPE.onxon)
{
Long=1;
tall=1;
}   

else if(type==TYPE.twxon)
{
if(dir==Direction.LEFT||dir==Direction.RIGHT)
{
Long=2;
tall=1;
}
else
{    
Long=1;
tall=2;
}
}  

else if(type==TYPE.thxon)
{
if(dir==Direction.LEFT||dir==Direction.RIGHT)
{
Long=3;
tall=1;
}
else
{    
Long=1;
tall=3;
}
}  

else if(type==TYPE.foxon)
{
if(dir==Direction.LEFT||dir==Direction.RIGHT)
{
Long=4;
tall=1;
}
else
{    
Long=1;
tall=4;
}
}  

else if(type==TYPE.twxtw)
{
Long=2;
tall=2;
}  

else if(type==TYPE.thxtw)
{
if(dir==Direction.LEFT||dir==Direction.RIGHT)
{
Long=3;
tall=2;
}
else
{    
Long=2;
tall=3;
}
}  

}
////////////////////////////////////////////////////////////////////////////////
public void sinkCheck()
{
if(dir==Ships.Direction.DOWN)   
{    
if(Y+(tall-1)<Board.numRows&&Board.board[Y][X]==Board.PATH&&Board.board[Y+(tall-1)][X]==Board.PATH)     
{    
for(int zi=X;zi<X+Long;zi++)
for(int zx=Y;zx<Y+tall;zx++)
if(Board.board[zx][zi]==Board.SANK)
HP--; 
}   
}


////////////////////////////////////////////////////////////////////////////////
else if(dir==Ships.Direction.UP) 
{    
if(Y-(tall-1)>-1&&Board.board[Y][X]==Board.PATH&&Board.board[Y-(tall-1)][X]==Board.PATH)
{    
for(int zi=X;zi<X+Long;zi++)
for(int zx=Y;zx>Y-tall;zx--)
if(Board.board[zx][zi]==Board.SANK)
HP--;
}
}

////////////////////////////////////////////////////////////////////////////////
else if(dir==Ships.Direction.RIGHT)   
{    
if(X+(Long-1)<Board.numColumns&&Board.board[Y][X]==Board.PATH&&Board.board[Y][X+(Long-1)]==Board.PATH)      
{
for(int zi=Y;zi<Y+tall;zi++)
for(int zx=X;zx<X+Long;zx++)
if(Board.board[zx][zi]==Board.SANK)
HP--;
}
}

////////////////////////////////////////////////////////////////////////////////
else if(dir==Ships.Direction.LEFT)  
{    
if(X-(Long-1)>-1&&Board.board[Y][X]==Board.PATH&&Board.board[Y][X-(Long-1)]==Board.PATH)    
{
for(int zi=Y;zi<Y+tall;zi++)
for(int zx=X;zx>X-Long;zx--)
if(Board.board[zx][zi]==Board.SANK)
HP--;
}
}
}
////////////////////////////////////////////////////////////////////////////////
}


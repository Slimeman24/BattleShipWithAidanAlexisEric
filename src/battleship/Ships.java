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
private TYPE type;
private int HP=tall*Long;
private static boolean show=true;


////////////////////////////////////////////////////////////////////////////////
public static enum Direction {
        LEFT,RIGHT,UP,DOWN
    }; 
public static enum TYPE {
        thxon,twxon,onxon,
    }; 
////////////////////////////////////////////////////////////////////////////////
public static Ships create(Direction _dir,TYPE _type,int _X, int _Y)
{
Ships ptr = new Ships(_dir,_type,_X,_Y);
ships.add(ptr);
return (ptr);    
}         
Ships(Direction _dir,TYPE _type,int _X,int _Y)
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
for(int zi=X;zi<X+Long;zi++)
for(int zx=Y;zx<Y+tall;zx++)
{    
if(zx+tall<Board.numRows&&zi+Long<Board.numColumns&&zi-Long>-1&&zx-tall>-1&&Board.board[zi][zx]==Board.PATH)
Board.board[zi][zx]=Board.SHIP; 
else
{
System.out.println("you cant place it there");
break;
}
}
////////////////////////////////////////////////////////////////////////////////
else if(dir==Ships.Direction.UP)    
for(int zi=X;zi>X-Long;zi--)
for(int zx=Y;zx<Y+tall;zx++)
{    
if(zx+tall<Board.numRows&&zi+Long<Board.numColumns&&zi-Long>-1&&zx-tall>-1&&Board.board[zi][zx]==Board.PATH)
Board.board[zi][zx]=Board.SHIP; 
else
{
System.out.println("you cant place it there");
break;
}
}
////////////////////////////////////////////////////////////////////////////////
else if(dir==Ships.Direction.RIGHT)    
for(int zi=X;zi<X+tall;zi++)
for(int zx=Y;zx<Y+Long;zx++)
{    
if(zx+tall<Board.numRows&&zi+Long<Board.numColumns&&zi-Long>-1&&zx-tall>-1&&Board.board[zi][zx]==Board.PATH)
Board.board[zi][zx]=Board.SHIP; 
else
{
System.out.println("you cant place it there");
break;
}
}
////////////////////////////////////////////////////////////////////////////////
else if(dir==Ships.Direction.LEFT)    
for(int zi=X;zi<X+tall;zi++)
for(int zx=Y;zx>Y-Long;zx--)
if(zx+tall<Board.numRows&&zi+Long<Board.numColumns&&zi-Long>-1&&zx-tall>-1&&Board.board[zi][zx]==Board.PATH)
Board.board[zi][zx]=Board.SHIP;    
else
{
System.out.println("you cant place it there");
break;
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
Long=2;
tall=1;
}  

else if(type==TYPE.thxon)
{
Long=3;
tall=1;
}  

}
////////////////////////////////////////////////////////////////////////////////
}


//Alexis Laparra
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
private int HP=tall*Long;
private static boolean show=true;


////////////////////////////////////////////////////////////////////////////////
public static enum Direction {
        LEFT,RIGHT,UP,DOWN
    }; 
////////////////////////////////////////////////////////////////////////////////
public static Ships create(Direction _dir,int _long,int _tall, int _X,int _Y)
{
Ships ptr = new Ships(_dir,_long,_tall,_X,_Y);
ships.add(ptr);
return (ptr);    
}         
Ships(Direction _dir,int _long,int _tall,int _X,int _Y)
{
dir=_dir;   
Long=_long;
tall=_tall;
X=_X;
Y=_Y;
setlocal();
System.out.println(ships.size());



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
if(zx-tall<Board.numRows&&zi+Long>-1&&zi+Long<Board.numColumns&&Board.board[zi][zx]==Board.PATH)
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
if(zx-tall<Board.numRows&&zi+Long<Board.numColumns&&zi+Long<Board.numColumns&&Board.board[zi][zx]==Board.PATH)
Board.board[zi][zx]=Board.SHIP; 
else
{
System.out.println("you cant place it there");
break;
}
}
////////////////////////////////////////////////////////////////////////////////
else if(dir==Ships.Direction.RIGHT)    
for(int zi=X;zi<X+Long;zi++)
for(int zx=Y;zx<Y+tall;zx++)
{    
if(zx-tall>-1&&zx-tall<Board.numRows&&zi+Long<Board.numColumns&&zi+Long<Board.numColumns&&Board.board[zi][zx]==Board.PATH)
Board.board[zi][zx]=Board.SHIP; 
else
{
System.out.println("you cant place it there");
break;
}
}
////////////////////////////////////////////////////////////////////////////////
else if(dir==Ships.Direction.LEFT)    
for(int zi=X;zi<X+Long;zi++)
for(int zx=Y;zx>Y-tall;zx--)
if(zx-tall>-1&&zx-tall<Board.numRows&&zi+Long<Board.numColumns&&zi+Long<Board.numColumns&&Board.board[zi][zx]==Board.PATH)
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
}
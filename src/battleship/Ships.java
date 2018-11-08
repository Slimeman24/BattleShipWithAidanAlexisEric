//Alexis Laparra
package battleship;
import java.util.ArrayList;
import java.awt.*;
public class Ships {
private static ArrayList<Ships> ships = new ArrayList<Ships>(); 
private Type type;
private static boolean show=true;
private boolean hit;
private int health;
////////////////////////////////////////////////////////////////////////////////
public static enum Type {
    ONE_ONE,TWO_ONE,THREE_ONE
};
////////////////////////////////////////////////////////////////////////////////
public static Ships create(Type type)
{
Ships ptr = new Ships(type);
ships.add(ptr);
return (ptr);    
}         
Ships(Type _type)
{
type=_type;    
hit=false;
setHealth();
}
////////////////////////////////////////////////////////////////////////////////
public void draw(Graphics2D g)
{
if(show)
{
//g.fillOval(x, y, xDelta*health, ydelta);
}

else
{    
return;    
} 

}
////////////////////////////////////////////////////////////////////////////////
public void setHealth()
{
if(type==Ships.Type.ONE_ONE)
health=1;
else if(type==Ships.Type.TWO_ONE)
health=2;
else if(type==Ships.Type.THREE_ONE)
health=3;

}        


public void setShow(boolean is)
{
show=is;
}   
////////////////////////////////////////////////////////////////////////////////
}

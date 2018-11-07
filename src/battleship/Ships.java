
package battleship;
import java.util.ArrayList;
import java.awt.*;
public class Ships {
private static ArrayList<Ships> ships = new ArrayList<Ships>(); 
private Type type;
private boolean show;
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
show=true;
}
public void draw(Graphics2D g)
{
if(show)
{
    
}
else
{    
return;    
}   
}

}

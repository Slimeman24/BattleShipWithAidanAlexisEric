
package battleship;
import java.util.ArrayList;
import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.*;


public class Missiles{
    public static Image pic1;
    public static Image pic2;
    public static Image pic3;
    public static Image pic4;
    public static Image pic5;
    public static Image pic6;
    private static ArrayList<Missiles> missiles = new ArrayList<Missiles>(); 
    private Type MissileType;
    private Image pic;
    
    
    public static enum Type {
        NUKE,NORMAL,YEEMISSILE,REVEAL, RANDOM, SONGMISSILE,SlowTurtle 
    };    
   
    Missiles (Type type){
        MissileType = type;
    }
    
    public static void setpictures(){
       pic1 = Toolkit.getDefaultToolkit().getImage("./TNT.PNG");
       pic2 = Toolkit.getDefaultToolkit().getImage("./Turtle.PNG");
       pic3 = Toolkit.getDefaultToolkit().getImage("./MB.GIF");
       pic4 = Toolkit.getDefaultToolkit().getImage("./NR.PNG");
       pic5 = Toolkit.getDefaultToolkit().getImage("./R.PNG");
       pic6 = Toolkit.getDefaultToolkit().getImage("./Song.MP4");
       
       
    }
    
    public static Missiles Create(Type type)
    {
        Missiles ptr = new Missiles(type);
        missiles.add(ptr);
        return (ptr);    
    }   
    
    public static void paint(Graphics2D g) {
        g.setColor(Color.yellow);
        Drawing.drawImage(pic1, 300, 300, 0,1, 1);
        Drawing.drawImage(pic2, 600, 300, 0,1, 1);
        Drawing.drawImage(pic4, 600, 600, 0,1, 1);
        Drawing.drawImage(pic6, 300, 600, 0,1, 1);
    }


   public void drawRockets(Graphics2D g,Image image, BattleShip obj,int xpos,int ypos,double rot,double xscale,double yscale)
    {
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

//        int xval[] = {1,1,-1,-1,1};
//        int yval[] = {-1,1,1,-1,-1};
//        g.fillPolygon(xval,yval,xval.length);
            g.drawImage(image,-1,-1,2,2,obj);

        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }    
   






}

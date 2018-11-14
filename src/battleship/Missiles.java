
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
    private ArrayList<Image> images = new ArrayList<Image>(); 
    public static Image Whole;
    private static ArrayList<Missiles> missiles = new ArrayList<Missiles>(); 
    private Type MissileType;
    public static Image pic;
    public static Graphics2D g; 
    
    
    public static enum Type {
        NUKE,NORMAL,YEEMISSILE,REVEAL, RANDOM, SONGMISSILE,SlowTurtle 
    };    
   
    Missiles (Type type){
        MissileType = type;
        images.add(getImage(MissileType));
        
    }
    
    public static void setpictures(){
       Whole = Toolkit.getDefaultToolkit().getImage("./BlackH.JPG");
       pic = Toolkit.getDefaultToolkit().getImage("./R.PNG");
    }
    
    public static Missiles Create(Type type)
    {
        Missiles ptr = new Missiles(type);
        missiles.add(ptr);
        return (ptr);    
    }   
    
    public static void paint(Graphics2D _g) {
        g = _g;
        
        g.setColor(Color.yellow);
        Drawing.drawImage(Whole, Window.getWidth2()-20, 80, 0, .1, .1);
        
        
        Drawing.drawImage(pic, Window.getWidth2()-20, Window.getHeight2()/2, 0, .1, .1);
        if (pic==Toolkit.getDefaultToolkit().getImage("./Turtle.PNG") || pic == Toolkit.getDefaultToolkit().getImage("./Joe.GIF"))
            Drawing.drawImage(pic, Window.getWidth2()-20, Window.getHeight2()/2, 0, .5, .5);
        else if (pic ==Toolkit.getDefaultToolkit().getImage("./TNT.PNG"))
            Drawing.drawImage(pic, Window.getWidth2()-20, Window.getHeight2()/2, 0, .2, .2);
        
        g.setColor(Color.blue);        
        drawArrow(Window.getWidth2()-25,Window.getHeight2()/2 +90,0,3,2,g);
        drawArrow(Window.getWidth2()-25,Window.getHeight2()/2 -90,180,3,2,g);
    }


////////////////////////////////////////////////////////////////////////////
    public static void drawArrow(int xpos,int ypos,double rot,double xscale,double yscale, Graphics2D g)
    {
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        int xvals2 [] = {0,10,5,5,-5,-5,-10,0};
        int yvals2 [] = {30,0,0,-30,-30,0,0,30}; 
        g.fillPolygon(xvals2,yvals2,xvals2.length);
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    
        g.setColor(Color.BLUE);

    }
    
   
    public Image getImage(Type type)
    {
        if (type == Missiles.Type.NUKE)
            return Toolkit.getDefaultToolkit().getImage("./TNT.PNG");
        else if (type == Missiles.Type.NORMAL)
            return Toolkit.getDefaultToolkit().getImage("./R.PNG");
        else if (type == Missiles.Type.RANDOM)
            return Toolkit.getDefaultToolkit().getImage("./Joe.GIF");
        else if (type == Missiles.Type.SlowTurtle)
            return Toolkit.getDefaultToolkit().getImage("./Turtle.PNG");
        else if (type == Missiles.Type.YEEMISSILE)
            return Toolkit.getDefaultToolkit().getImage("./Yoda.PNG");
        else if (type == Missiles.Type.REVEAL)
            return Toolkit.getDefaultToolkit().getImage("./R.PNG");

        
        return null;
    }

        public static Image getIm(Type type)
    {
        if (type == Missiles.Type.NUKE)
            return Toolkit.getDefaultToolkit().getImage("./TNT.PNG");
        else if (type == Missiles.Type.NORMAL)
            return Toolkit.getDefaultToolkit().getImage("./R.PNG");
        else if (type == Missiles.Type.RANDOM)
            return Toolkit.getDefaultToolkit().getImage("./Joe.GIF");
        else if (type == Missiles.Type.SlowTurtle)
            return Toolkit.getDefaultToolkit().getImage("./Turtle.PNG");
        else if (type == Missiles.Type.YEEMISSILE)
            return Toolkit.getDefaultToolkit().getImage("./Yoda.PNG");
        else if (type == Missiles.Type.REVEAL)
            return Toolkit.getDefaultToolkit().getImage("./R.PNG");

        
        return null;
    }
        
        public static void changeRight(){
        if (pic ==Toolkit.getDefaultToolkit().getImage("./R.PNG"))
            pic = Toolkit.getDefaultToolkit().getImage("./Turtle.PNG");
        else if (pic ==Toolkit.getDefaultToolkit().getImage("./Turtle.PNG"))
            pic = Toolkit.getDefaultToolkit().getImage("./Joe.GIF");
        else if (pic == Toolkit.getDefaultToolkit().getImage("./Joe.GIF"))
            pic = Toolkit.getDefaultToolkit().getImage("./Yoda.PNG");
        else if (pic ==Toolkit.getDefaultToolkit().getImage("./Yoda.PNG"))
            pic =Toolkit.getDefaultToolkit().getImage("./TNT.PNG");
        else if (pic ==Toolkit.getDefaultToolkit().getImage("./TNT.PNG"))
            pic =Toolkit.getDefaultToolkit().getImage("./R.PNG");

        }
        
        public static void changeLeft(){
        
        if (pic ==Toolkit.getDefaultToolkit().getImage("./TNT.PNG"))
            pic =Toolkit.getDefaultToolkit().getImage("./Yoda.PNG");
        else if (pic ==Toolkit.getDefaultToolkit().getImage("./Yoda.PNG"))
            pic = Toolkit.getDefaultToolkit().getImage("./Joe.GIF");
        else if (pic == Toolkit.getDefaultToolkit().getImage("./Joe.GIF"))
            pic = Toolkit.getDefaultToolkit().getImage("./Turtle.PNG");
        else if (pic ==Toolkit.getDefaultToolkit().getImage("./Turtle.PNG"))
            pic = Toolkit.getDefaultToolkit().getImage("./R.PNG");
        else if (pic ==Toolkit.getDefaultToolkit().getImage("./R.PNG"))
            pic =Toolkit.getDefaultToolkit().getImage("./TNT.PNG");
        }
    


}

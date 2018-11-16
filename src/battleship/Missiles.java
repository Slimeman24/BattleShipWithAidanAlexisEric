
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
    public static Image Button;
    private static ArrayList<Missiles> missiles = new ArrayList<Missiles>(); 
    private Type MissileType;
    public static Image pic;
    public static Graphics2D g; 
    public static boolean MS = false;
    public static int curCol;
    public static int curRow;
    public static int X = Window.getWidth2()-20;
    public static int Y = 80;
    
    
    
    public static enum Type {
        NUKE,NORMAL,YEEMISSILE,REVEAL, RANDOM, SONGMISSILE,SlowTurtle 
    };    
   
    Missiles (Type type){
        MissileType = type;
        
    }
    
    
    public static void setpictures(){
       Whole = Toolkit.getDefaultToolkit().getImage("./BlackH.JPG");
       pic = Toolkit.getDefaultToolkit().getImage("./R.PNG");
    }

    public static void reset(){
       Whole = Toolkit.getDefaultToolkit().getImage("./BlackH.JPG");
       pic = Toolkit.getDefaultToolkit().getImage("./R.PNG");
       MS= false;
       X = Window.getWidth2()-20;
       Y = 80;
       curCol =0 ;
       curRow=0;
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
        
        Drawing.drawImage(Toolkit.getDefaultToolkit().getImage("./Button.PNG"), Window.getWidth2()-25, 270, 0, .3, .3);
        Drawing.drawImage(Toolkit.getDefaultToolkit().getImage("./B2.PNG"), Window.getWidth2()-25, 268, 0, .1, .1);
        
        Drawing.drawImage(pic, Window.getWidth2()-20, Window.getHeight2()/2, 0, .1, .1);
        if (pic==Toolkit.getDefaultToolkit().getImage("./Turtle.PNG") || pic == Toolkit.getDefaultToolkit().getImage("./Joe.GIF"))
            Drawing.drawImage(pic, Window.getWidth2()-20, Window.getHeight2()/2, 0, .5, .5);
        else if (pic ==Toolkit.getDefaultToolkit().getImage("./TNT.PNG"))
            Drawing.drawImage(pic, Window.getWidth2()-20, Window.getHeight2()/2, 0, .2, .2);
        
        g.setColor(Color.blue);        
        drawArrow(Window.getWidth2()-25,Window.getHeight2()/2 +90,0,3,2,g);
        drawArrow(Window.getWidth2()-25,Window.getHeight2()/2 -90,180,3,2,g);
        
        if (MS==true)
            Drawing.drawImage(pic, X, Y, 0, .1, .1);
             
        
//        checkPressingButton();
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
    
 /////////////////////////////////////////
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
        
 /////////////////////////////////////////
        
        public static void Launch(){
         MS = true;
           
         CheckLocHit();
         MoveMissile();
         
        }
        
/////////////////////////////////////////
        public static void CheckLocHit(){
        int currCol = 0;
        int xdelta = Window.getWidth2()/Board.numColumns;
        int currXVal = xdelta;
        while (TitleScreen.MouseX > currXVal)
        {
            currCol++;
            currXVal += xdelta;
        }

        int currRow = 0;
        int ydelta = Window.getHeight2()/Board.numRows;
        int currYVal = ydelta;
        while (TitleScreen.MouseY > currYVal)
        {
            currRow++;
            currYVal += ydelta;
        }
        
        if(curRow !=0 && Board.board[curRow-1][curCol] == Board.HIGHLIGHT )
            Board.board[curRow-1][curCol] = Board.PATH;
        
        if (MS ==false){
            curRow = currRow;
            curCol = currCol;       
        }
        
        if(curRow !=0 && curCol!= 11 && Board.board[curRow-1][curCol] == Board.PATH )
            Board.board[curRow-1][curCol] = Board.HIGHLIGHT;
        
        if (curRow !=0 && Board.board[curRow-1][curCol] == Board.PATH || Board.board[curRow-1][curCol] == Board.HIGHLIGHT && MS == true)
            Board.board[curRow-1][curCol] = Board.SHIP;
        }
        
        
        /////////////////////////////////////////
        public static void MoveMissile(){
            Drawing.drawImage(pic, TitleScreen.MouseX, TitleScreen.MouseY, 0, 5, 5);
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

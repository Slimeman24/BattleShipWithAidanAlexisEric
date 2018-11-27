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

class Drawing {
    private static Graphics2D g;
    private static BattleShip mainClassInst;

    public static void setDrawingInfo(Graphics2D _g,BattleShip _mainClassInst) {
        g = _g;
        mainClassInst = _mainClassInst;
    }
////////////////////////////////////////////////////////////////////////////
    public static void drawCircle(int xpos,int ypos,double rot,double xscale,double yscale,Color color)
    {
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        g.setColor(color);
        g.fillOval(-10,-10,20,20);

        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
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
    ///////////////////////////////////////////////////////////////////////////////
     public static void drawPlay(int xpos,int ypos,double rot,double xscale,double yscale,Color color)
    {
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        g.setColor(color);
        g.fillRect(1,1,160,50);
        
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.PLAIN,35));
        g.drawString("Play", 50, 38);        

        //g.fillRoundRect(ypos, ypos, ypos, ypos, ypos, ypos);
        
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }

     public static void drawHTP(int xpos,int ypos,double rot,double xscale,double yscale,Color color)
    {
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        g.setColor(color);
        g.fillRect(1,1,160,50);
        
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.PLAIN,25));
        g.drawString("How To Play", 10, 36);        

        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }
        public static void drawHTPback(int xpos,int ypos,double rot,double xscale,double yscale,Color color)
    {
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        g.setColor(color);
        g.fillRect(1,1,160,50);
        
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.PLAIN,25));
        g.drawString("Back", 50, 36);        

        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }

////////////////////////////////////////////////////////////////////////////
    public static void drawImage(Image image,int xpos,int ypos,double rot,double xscale,
            double yscale) {
        int width = image.getWidth(mainClassInst);
        int height = image.getHeight(mainClassInst);
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        g.drawImage(image,-width/2,-height/2,
        width,height,mainClassInst);

        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    public static void drawMissileHelp() {
               
                g.setColor(Color.black);
                Drawing.drawImage(BattleShip.metalImage, Window.getX(250), Window.getY(450), 0, 1.5, 1.8);
                g.setColor(Color.blue);
                Drawing.drawArrow(Window.getWidth2()-25,Window.getHeight2()/2 +90,0,3,2,g);
                Drawing.drawArrow(Window.getWidth2()-25,Window.getHeight2()/2 -90,180,3,2,g);
                if(Missiles.pic == Toolkit.getDefaultToolkit().getImage("./Reveal.PNG")   // for smaller missiles making them bigger
                || Missiles.pic == Toolkit.getDefaultToolkit().getImage("./Turtle.PNG") || Missiles.pic  == Toolkit.getDefaultToolkit().getImage("./Joe.GIF") )
                Drawing.drawImage(Missiles.pic, Window.getWidth2()-20, Window.getHeight2()/2, 0,.3, .3);
                else if(Missiles.pic == Toolkit.getDefaultToolkit().getImage("./TNT.PNG"))
                Drawing.drawImage(Missiles.pic, Window.getWidth2()-20, Window.getHeight2()/2, 0,.2, .2);
                else       
                Drawing.drawImage(Missiles.pic, Window.getWidth2()-20, Window.getHeight2()/2, 0, .1, .1);

                if(BattleShip.thing){  /////////// Makes a timed thing that goes just the right time for an explosion at the spot of impact
                g.setColor(Color.white);
                g.setFont(new Font("Arial",Font.PLAIN,40));
                g.drawString("You can change the missile with the up and down arrows ", 30, 250);
                BattleShip.i++;
                if(BattleShip.i==150){
                    BattleShip.thing=false;
                }
                }
                g.setFont(new Font("Arial",Font.PLAIN,20));
                g.drawString("How The Missiles Work ", 80, 400);
                g.drawString("___________________ :", 80, 400);
                
                if (Missiles.pic == Toolkit.getDefaultToolkit().getImage("./TNT.PNG")){
                    g.setColor(Color.white);
                    g.setFont(new Font("Arial",Font.PLAIN,20));
                    g.drawString("Destroys anything in 3x3 area ", 80, Window.getHeight2()/2);  
                }
                else if (Missiles.pic ==  Toolkit.getDefaultToolkit().getImage("./R.PNG"))
                {
                    g.setColor(Color.white);
                    g.setFont(new Font("Arial",Font.PLAIN,20));
                    g.drawString("Acts like normal Missile in BattleShip ", 80, Window.getHeight2()/2);      
                }    
                else if (Missiles.pic == Toolkit.getDefaultToolkit().getImage("./Joe.GIF"))
                {
                    g.setColor(Color.white);
                    g.setFont(new Font("Arial",Font.PLAIN,20));
                    g.drawString(" Randomly Chooses A Missile * CAUTION * \n there are missiles that harm you ",80, Window.getHeight2()/2);                       
                }     
                else if (Missiles.pic == Toolkit.getDefaultToolkit().getImage("./Turtle.PNG"))
                {
                    g.setColor(Color.white);
                    g.setFont(new Font("Arial",Font.PLAIN,20));
                    g.drawString("Takes 3 turns to land but when in effect it protects your ship ", 80, Window.getHeight2()/2);       
                }            
                else if (Missiles.pic == Toolkit.getDefaultToolkit().getImage("./Yoda.PNG"))
                {
                    g.setColor(Color.white);
                    g.setFont(new Font("Arial",Font.PLAIN,20));
                    g.drawString("Lets you move one of your ships but lets other player know" ,80, Window.getHeight2()/2);      
                }    
                else if (Missiles.pic == Toolkit.getDefaultToolkit().getImage("./Reveal.PNG"))
                {
                    g.setColor(Color.white);
                    g.setFont(new Font("Arial",Font.PLAIN,20));
                    g.drawString("Reveals a 3x3 area only a hit if the spot you clicked in has a ship",80, Window.getHeight2()/2);    
                }   
                
    }
    
    
    
    
}
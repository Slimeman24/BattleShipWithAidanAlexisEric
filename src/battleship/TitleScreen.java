
package battleship;

import java.io.*; 
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;


public class TitleScreen {
    

    
    
    
    
    
     public static void ifPClick(int xpixel,int ypixel)
    {
        int x = Window.getWidth2()-25; 
        int y = Window.getHeight2()/2 +90;
        int y2 = Window.getHeight2()/2 -90;
        
        
           if ((Window.getWidth2()-25)-31<xpixel &&
               (Window.getWidth2()-25)+30>xpixel &&  
               (Window.getHeight2()/2 +90)-60<ypixel && 
               (Window.getHeight2()/2 +90)+59>ypixel)
            {
               Missiles.changeRight();
            }
           
            if (x-31<xpixel &&
               x+30>xpixel &&  
               y2-60<ypixel && 
               y2+59>ypixel)
            {
               Missiles.changeLeft();
            }
           
    }

   private static int  PlayXPOS = Window.getWidth2()/2 -80;
   private static int  PlayYPOS = Window.getHeight2()/3 * 2;
   
   private static int  HTPXPOS = Window.getWidth2()/2 -80;
   private static int  HTPYPOS = Window.getHeight2()/4 * 3;
 
   
    TitleScreen ()
    {
      
        
       
    }
    
      public  static void draw(Graphics2D g, Image image, BattleShip obj)
    {
      
      Drawing.drawImage(image, Window.getWidth2()/2,(Window.getHeight2()/2)+50, 0, .425,.625 );
    Drawing.drawPlay(PlayXPOS, PlayYPOS, 0, 1, 1, Color.BLACK);
     Drawing.drawHTP(HTPXPOS, HTPYPOS, 0, 1, 1, Color.BLACK);
     
     
     
//      g.setColor(Color.BLACK);
//        g.fillRect(300,215,455,110);
//     
//      g.setColor(Color.WHITE);
//        g.setFont(new Font("Times New Roman",Font.PLAIN,100));
//        g.drawString("Battle Ship", 300, 300);    
    }
////////////////////////////////////////////////////////////////////////////
    public void drawTS(Graphics2D g,Image image, BattleShip obj, int xpos,int ypos,double rot,double xscale,double yscale)
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
     
    
    public static boolean ifPClick(int xpixel,int ypixel, boolean gameStart)
    {
           if (PlayXPOS-18<xpixel &&
               PlayXPOS+143>xpixel &&  
               PlayYPOS-40<ypixel && 
               PlayYPOS+10>ypixel)
            {
                gameStart = true;
                System.out.println("p");
            }

           return gameStart;
    }
    
    public static void ifHTPClick(int xpixel,int ypixel)
    {
           if (HTPXPOS-18<xpixel &&
               HTPXPOS+143>xpixel &&  
               HTPYPOS-40<ypixel && 
               HTPYPOS+10>ypixel)
            {
               
                 System.out.println("woot");
            }

           

    }
}

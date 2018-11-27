
package battleship;

import java.io.*; 
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;


public class TitleScreen {
    
    public static int MouseX;
    public static int MouseY;

    
    
    
    
    
     public static void ifPClick(int xpixel,int ypixel)
    {
<<<<<<< Updated upstream
        MouseX= xpixel;
        MouseY= ypixel;
        int x = Window.getWidth2()-25;
        int y = 270;
        int y2 = Window.getHeight2()/2 -90;
        
        
=======
        if(!Missiles.MS){
        MouseX= xpixel;
        MouseY= ypixel;
        int x = Window.getWidth2()-25;
        int y = 650;
        int y2 = Window.getHeight2()/2 -90;

>>>>>>> Stashed changes
           if (x-31<xpixel &&
               x+30>xpixel &&  
               (Window.getHeight2()/2 +90)-60<ypixel && 
               (Window.getHeight2()/2 +90)+59>ypixel)
            {
               Missiles.changeRight();
            }
            else if (x-31<xpixel &&
               x+30>xpixel &&  
               y2-60<ypixel && 
               y2+59>ypixel)
            {
               Missiles.changeLeft();
            }
<<<<<<< Updated upstream
            

            if (x-45<xpixel &&
=======
            else if (x-45<xpixel &&
>>>>>>> Stashed changes
               x+45>xpixel &&  
               y-46<ypixel && 
               y+40>ypixel)
            {
<<<<<<< Updated upstream
                Missiles.Launch();
              
            }
            
            Missiles.CheckLocHit();            
            
            
=======
                Missiles.Launch();              
            }
            
            Missiles.CheckLocHit();  
        }
>>>>>>> Stashed changes
           
    }

   private static int  PlayXPOS = Window.getWidth2()/2 -80;
   private static int  PlayYPOS = Window.getHeight2()/3 * 2;
   
   private static int  HTPXPOS = Window.getWidth2()/2 -80;
   private static int  HTPYPOS = Window.getHeight2()/4 * 3;

    
   private static int  HTPXPOSb = Window.getWidth2() - Window.getWidth2()+ 7;
   private static int  HTPYPOSb = Window.getHeight2() - 1 ;
<<<<<<< Updated upstream
    
=======
>>>>>>> Stashed changes

   

    
    public  static void draw(Graphics2D g, Image image1, Image image2,Image image3, BattleShip obj, boolean HTPshow)
    {
     if(HTPshow)
     {
     Drawing.drawImage(BattleShip.metalImage, Window.getX(250), Window.getY(450), 0, 1.5, 1.8);
     g.setColor(Color.black);
     g.fillRect(Window.getWidth2()/9*7 ,Window.getHeight2()/18, 200, 100);
     g.setColor(Color.white);
     g.drawRect(Window.getWidth2()/9*7 ,Window.getHeight2()/18, 200, 100);
     //Drawing.drawImage(image3, Window.getWidth2()/2+16,Window.getHeight2()/2, 0, 1.2,2.3 );
     g.setColor(Color.WHITE);
     g.setFont(new Font("Times New Roman",Font.PLAIN,50));
     g.drawString("Missiles",Window.getWidth2() - 200 ,Window.getHeight2()/8); 

     Drawing.drawImage(image2, Window.getWidth2()/2+16,Window.getHeight2()/2, 0, 1.2,2.3 );
     g.setColor(Color.WHITE);
     g.setFont(new Font("Times New Roman",Font.PLAIN,50));
     g.drawString("How To Play", Window.getWidth2()/2 - Window.getWidth2()/8, Window.getHeight2()/6-50); 
     g.setFont(new Font("Times New Roman",Font.PLAIN,40));
     g.drawString("111111111111111111111111111111111111111", Window.getWidth2()/8, Window.getHeight2()/4);  
     g.drawString("111111111111111111111111111111111111111", Window.getWidth2()/8, Window.getHeight2()/4 + 50);  
     g.drawString("111111111111111111111111111111111111111", Window.getWidth2()/8, Window.getHeight2()/4 + 100);  
     g.drawString("111111111111111111111111111111111111111", Window.getWidth2()/8, Window.getHeight2()/4 + 150);  
     g.drawString("111111111111111111111111111111111111111", Window.getWidth2()/8, Window.getHeight2()/4 + 200);  
     g.drawString("111111111111111111111111111111111111111", Window.getWidth2()/8, Window.getHeight2()/4 + 250);  
      
<<<<<<< Updated upstream
       
       
    }
    
      public  static void draw(Graphics2D g, Image image1, Image image2,Image image3, BattleShip obj, boolean HTPshow)
    {
        
      if(HTPshow)
     {
    Drawing.drawImage(image2, Window.getWidth2()/2+16,Window.getHeight2()/2, 0, 1.2,2.3 );
     g.setColor(Color.WHITE);
     g.setFont(new Font("Times New Roman",Font.PLAIN,50));
     g.drawString("How To Play", Window.getWidth2()/2 - Window.getWidth2()/8, Window.getHeight2()/6-50); 
     g.setFont(new Font("Times New Roman",Font.PLAIN,40));
     g.drawString("11111111111111111111 \n 11111111111111111", Window.getWidth2()/8, Window.getHeight2()/4);   
     Drawing.drawHTPback(HTPXPOSb, HTPYPOSb, 0, 1, 1, Color.BLACK);
     
     }
     
        
        
     if(HTPshow == false)
     {
      Drawing.drawImage(image1, Window.getWidth2()/2,(Window.getHeight2()/2)+50, 0, .425,.625 );
      Drawing.drawPlay(PlayXPOS, PlayYPOS, 0, 1, 1, Color.BLACK);
      Drawing.drawHTP(HTPXPOS, HTPYPOS, 0, 1, 1, Color.BLACK);
      g.setColor(Color.BLACK);
        g.fillRect(300,215,455,110);
=======
     Drawing.drawHTPback(HTPXPOSb, HTPYPOSb, 0, 1, 1, Color.BLACK);
   
     }
     
        
        
     if(HTPshow == false)
     {
      Drawing.drawImage(image1, Window.getWidth2()/2,(Window.getHeight2()/2)+50, 0, .425,.625 );
      Drawing.drawPlay(PlayXPOS, PlayYPOS, 0, 1, 1, Color.BLACK);
      Drawing.drawHTP(HTPXPOS, HTPYPOS, 0, 1, 1, Color.BLACK);
      g.setColor(Color.BLACK);
        g.fillRect(250,215,510,110);
     
      g.setColor(Color.WHITE);
        g.setFont(new Font("Britannic Bold",Font.PLAIN,100));
        g.drawString("Battle Ship", 270, 300);  
     }

    
>>>>>>> Stashed changes
     
      g.setColor(Color.WHITE);
        g.setFont(new Font("Britannic Bold",Font.PLAIN,100));
        g.drawString("Battle Ship", 300, 300);  
     }
    
     
     
       
    
     
       
    
     
     
       
    }
////////////////////////////////////////////////////////////////////////////
//    public void drawTS(Graphics2D g,Image image, BattleShip obj, int xpos,int ypos,double rot,double xscale,double yscale)
//    {
//        g.translate(xpos,ypos);
//        g.rotate(rot  * Math.PI/180.0);
//        g.scale( xscale , yscale );
//
////        int xval[] = {1,1,-1,-1,1};
////        int yval[] = {-1,1,1,-1,-1};
////        g.fillPolygon(xval,yval,xval.length);
//         g.drawImage(image,-1,-1,2,2,obj);
//         
//         
//         
//        g.scale( 1.0/xscale,1.0/yscale );
//        g.rotate(-rot  * Math.PI/180.0);
//        g.translate(-xpos,-ypos);
//    }
     
    
    public static boolean ifPClick(int xpixel,int ypixel, boolean gameStart, boolean HTPshow)
    {
        
        if(gameStart)
            return false;
        
        if(HTPshow)
            return gameStart;
        
           if (PlayXPOS-18<xpixel &&
               PlayXPOS+143>xpixel &&  
               PlayYPOS-40<ypixel && 
               PlayYPOS+10>ypixel)
            {
                gameStart = true;

<<<<<<< Updated upstream
                System.out.println("PLAY");

=======
                //System.out.println("PLAY");
>>>>>>> Stashed changes

            }

           return gameStart;
    }
    
    public static boolean ifHTPClick(int xpixel,int ypixel, boolean gameStart,  boolean HTPshow)
    {
        if(gameStart)
            return false;
        
           if (HTPXPOS-18<xpixel &&
               HTPXPOS+143>xpixel &&  
               HTPYPOS-40<ypixel && 
               HTPYPOS+10>ypixel)
            {
               HTPshow = true;
                 System.out.println("HTP");
            }


           return HTPshow;
<<<<<<< Updated upstream
    }
    
     public static boolean HTPback(int xpixel,int ypixel, boolean HTPshow)
    {
        
        System.out.println(xpixel);
        System.out.println(ypixel);
        
           if (HTPXPOSb-18<xpixel &&
               HTPXPOSb+143>xpixel &&  
               HTPYPOSb-40<ypixel && 
               HTPYPOSb+10>ypixel)
            {
               HTPshow = false;
                 System.out.println("donenene");
            }
        
           return HTPshow;
=======
>>>>>>> Stashed changes
    }
    
     public static boolean HTPback(int xpixel,int ypixel, boolean HTPshow)
    {
        

           if (HTPXPOSb-18<xpixel &&
               HTPXPOSb+143>xpixel &&  
               HTPYPOSb-40<ypixel && 
               HTPYPOSb+10>ypixel)
            {
               HTPshow = false;
              //   System.out.println("donenene");
            }
           else if(Window.getWidth2()/9*7 - 18 < xpixel && Window.getWidth2()/9*7 +182 > xpixel && Window.getHeight2()/18 -40 < ypixel && Window.getHeight2()/18 + 60 > ypixel) 
           {
              BattleShip.MissileMenu =true;
           }
           return HTPshow;

    }

}

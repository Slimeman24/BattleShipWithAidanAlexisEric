
package battleship;


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
}

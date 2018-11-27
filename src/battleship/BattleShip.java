
package battleship;

import java.io.*; 
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class BattleShip extends JFrame implements Runnable {

/////////Variables
    boolean animateFirstTime = true;
    Image image;
    Graphics2D g;
<<<<<<< Updated upstream
 
=======
//Variables for the player.

>>>>>>> Stashed changes
    int timeCount;
    int score;
    int highScore = 0;
    boolean gameOver;
    boolean setShips=true;
    Ships.Direction dir=Ships.Direction.UP;
    Ships.TYPE type=Ships.TYPE.onxon;
    TitleScreen screen;
    Image titlescreenImage;
    Image htpImage;
    Image oceanImage;
<<<<<<< Updated upstream
    Image metalImage;
    

    //boolean gameStart = false;
    boolean HTPshow = false;

    boolean gameStart = true;
=======
    public static Image metalImage;
    public static int i =0;
    public static boolean P1;
    public static boolean changing;
    public static boolean testing2;
    public static boolean Timed=true;

    boolean gameStart = false;
    boolean HTPshow = false;
    public static boolean MissileMenu = false;
    public static boolean thing=true;

>>>>>>> Stashed changes
    int numNpcs = 4;
   

  
    
    static BattleShip frame;
    public static void main(String[] args) {
        frame = new BattleShip();
        frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public BattleShip() {
        ////MouseOptions
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.BUTTON1 == e.getButton()) {
                    //left button

// location of the cursor.
                    int xpos = e.getX();
                    int ypos = e.getY();

                    
                    TitleScreen.ifPClick(xpos, ypos);

                    Missiles.MoveMissile();

                    
                    
                   if(TitleScreen.ifPClick(e.getX() - Window.getX(0),
                      e.getY() - Window.getY(0),gameStart, HTPshow))
                      {
                          gameStart = true;     
                      }

                  if(TitleScreen.ifHTPClick(e.getX() - Window.getX(0),
                      e.getY() - Window.getY(0),gameStart, HTPshow))
                  {
                      HTPshow = true;
                      if(TitleScreen.HTPback(e.getX() - Window.getX(0),
                      e.getY() - Window.getY(0),HTPshow) == false)
                    {
                      HTPshow = false;
                    }
                  }
                  
<<<<<<< Updated upstream
                   
=======
>>>>>>> Stashed changes

                    


                }
                if (e.BUTTON3 == e.getButton()) {
                    //right button
                    int xpos = e.getX();
                    int ypos = e.getY();
                    Board.addShip(dir,type,xpos,ypos);
                    
                }
                repaint();
            }
        });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
        repaint();
      }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {
         
        repaint();
      }
    });

        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
//add or modify.  Move the player with the arrow keys.
//Size//////////////////////////////////////////////////////////////////////////
                if (e.VK_W == e.getKeyCode()) {
                if(type==Ships.TYPE.onxon)
                type=Ships.TYPE.twxon;
                
                else if(type==Ships.TYPE.twxon)
                type=Ships.TYPE.thxon;
                
                else if(type==Ships.TYPE.thxon)
                type=Ships.TYPE.foxon;   
                
                else if(type==Ships.TYPE.foxon)
                type=Ships.TYPE.fixon; 
                
                else if(type==Ships.TYPE.fixon)
                type=Ships.TYPE.onxon; 
                
                
                } 
////                
                else if (e.VK_S == e.getKeyCode()) {
                if(type==Ships.TYPE.onxon)
                type=Ships.TYPE.fixon;
                
                else if(type==Ships.TYPE.twxon)
                type=Ships.TYPE.onxon;
                
                else if(type==Ships.TYPE.thxon)
                type=Ships.TYPE.twxon;  
                
                else if(type==Ships.TYPE.foxon)
                type=Ships.TYPE.thxon;  
                
                else if(type==Ships.TYPE.fixon)
                type=Ships.TYPE.foxon; 
                } 
////////////////////////////////////////////////////////////////////////////////                
                else if (e.VK_A == e.getKeyCode()) {
               
                if(dir==Ships.Direction.UP)
                dir=Ships.Direction.LEFT;
                
                else if(dir==Ships.Direction.LEFT)
                dir=Ships.Direction.DOWN;
                
                else if(dir==Ships.Direction.DOWN)
                dir=Ships.Direction.RIGHT;  
                
                else if(dir==Ships.Direction.RIGHT)
                dir=Ships.Direction.UP;
                
                
                } 
                
                else if (e.VK_ESCAPE == e.getKeyCode()) {
                reset();    
                }
                
                repaint();
            }
        });
        init();
        start();
    }
    Thread relaxer;
////////////////////////////////////////////////////////////////////////////
    public void init() {
        requestFocus();
    }
////////////////////////////////////////////////////////////////////////////
    public void destroy() {
    }

//////////////////////////////////////////////////////////////////////////////
   public void paint(Graphics gOld) {
        if (image == null || Window.xsize != getSize().width || Window.ysize != getSize().height) {
            Window.xsize = getSize().width;
            Window.ysize = getSize().height;
            image = createImage(Window.xsize, Window.ysize);
            g = (Graphics2D) image.getGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            Drawing.setDrawingInfo(g,this);
        }
      ///Drawing Title Screen etc  
        if (gameStart == false)
        {
            Drawing.setDrawingInfo(g, this);
            TitleScreen.draw(g, titlescreenImage, htpImage, oceanImage, this, HTPshow);
             
<<<<<<< Updated upstream
                 
=======
            if(MissileMenu){
            Drawing.drawMissileHelp();
               
        
            }
>>>>>>> Stashed changes
        }
        
        /// Drawing Board
        if(gameStart)
        {
            
//fill background
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, Window.xsize, Window.ysize);

        int x[] = {Window.getX(0), Window.getX(Window.getWidth2()), Window.getX(Window.getWidth2()), Window.getX(0), Window.getX(0)};
        int y[] = {Window.getY(0), Window.getY(0), Window.getY(Window.getHeight2()), Window.getY(Window.getHeight2()), Window.getY(0)};
//fill border
////Background OCEAN
for (int zrow=0;zrow<Board.numRows;zrow++)
        {
            for (int zcolumn=0;zcolumn<Board.numColumns;zcolumn++)
            {
                if (Board.board[zrow][zcolumn] == Board.WALL)
                {
                    g.setColor(Color.PINK);
//                    g.fillRect(Window.getX(0)+zcolumn*Window.getWidth2()/Board.numColumns,
//                    Window.getY(0)+zrow*Window.getHeight2()/Board.numRows,
//                    Window.getWidth2()/Board.numColumns,
//                    Window.getHeight2()/Board.numRows);
<<<<<<< Updated upstream
                Drawing.drawImage(metalImage, Window.getX(250), Window.getY(450), 0, 1.5, 1.8);
=======
               // Drawing.drawImage(metalImage, Window.getX(250), Window.getY(450), 0, 1.5, 1.8);
>>>>>>> Stashed changes
                
                
                }  
       
            }
              
        }
        g.setColor(Color.CYAN);
        g.fillPolygon(x, y, 4);
        Drawing.drawImage(oceanImage, Window.getX(500), Window.getY(250), 0, 1.4, 1.25);
        Drawing.drawImage(oceanImage, Window.getX(500), Window.getY(700), 180, 1.4, 1.25);
      
// draw border
        g.setColor(Color.DARK_GRAY);
        g.drawPolyline(x, y, 5);
        

        if (animateFirstTime) {
            gOld.drawImage(image, 0, 0, null);
            return;
        }

         
        
        g.setColor(Color.BLACK);
//horizontal lines
        for (int zi=1;zi<Board.numRows;zi++)
        {
            g.drawLine(Window.getX(0) ,Window.getY(0)+zi*Window.getHeight2()/Board.numRows ,
            Window.getX(Window.getWidth2()) ,Window.getY(0)+zi*Window.getHeight2()/Board.numRows );
        }
        
//vertical lines
        for (int zi=1;zi<Board.numColumns;zi++)
        {
            g.drawLine(Window.getX(0)+zi*Window.getWidth2()/Board.numColumns ,Window.getY(0) ,
            Window.getX(0)+zi*Window.getWidth2()/Board.numColumns,Window.getY(Window.getHeight2())  );
        }
        
//Display the objects of the Board.board
        for (int zrow=0;zrow<Board.numRows;zrow++)
        {
            for (int zcolumn=0;zcolumn<Board.numColumns;zcolumn++)
            {
                if (Board.board[zrow][zcolumn] == Board.WALL)
                {
                    g.setColor(Color.DARK_GRAY);
                    g.fillRect(Window.getX(0)+zcolumn*Window.getWidth2()/Board.numColumns,
                    Window.getY(0)+zrow*Window.getHeight2()/Board.numRows,
                    Window.getWidth2()/Board.numColumns,
                    Window.getHeight2()/Board.numRows);
               // Drawing.drawImage(metalImage, Window.getX(250), Window.getY(450), 0, 1.5, 1.8);
                
                
                }  

       
            }
              
        }
        for (int zrow=0;zrow<Board.numRows;zrow++)
        {
            for (int zcolumn=0;zcolumn<Board.numColumns;zcolumn++)
            {
                if (Board.board[zrow][zcolumn] == Board.SHIP && setShips == true||Board.board[zrow][zcolumn] == Board.SANK)
                {
                    g.setColor(Color.green);
                    g.fillRect(Window.getX(0)+zcolumn*Window.getWidth2()/Board.numColumns,
                    Window.getY(0)+zrow*Window.getHeight2()/Board.numRows,
                    Window.getWidth2()/Board.numColumns,
                    Window.getHeight2()/Board.numRows);
                }  
                else if (Board.board[zrow][zcolumn] == Board.HIGHLIGHT)
                {
                    g.setColor(Color.yellow);
                    g.fillRect(Window.getX(0)+zcolumn*Window.getWidth2()/Board.numColumns,
                    Window.getY(0)+zrow*Window.getHeight2()/Board.numRows,
                    Window.getWidth2()/Board.numColumns,
                    Window.getHeight2()/Board.numRows);
                }
                else if (Board.board[zrow][zcolumn] == Board.MISS)
                {
                    g.setColor(Color.blue);
                    g.fillRect(Window.getX(0)+zcolumn*Window.getWidth2()/Board.numColumns,
                    Window.getY(0)+zrow*Window.getHeight2()/Board.numRows,
                    Window.getWidth2()/Board.numColumns,
                    Window.getHeight2()/Board.numRows);
                }  
                else if (Board.board[zrow][zcolumn] == Board.HIT)
                {
                    g.setColor(Color.red);
                    g.fillRect(Window.getX(0)+zcolumn*Window.getWidth2()/Board.numColumns,
                    Window.getY(0)+zrow*Window.getHeight2()/Board.numRows,
                    Window.getWidth2()/Board.numColumns,
                    Window.getHeight2()/Board.numRows);
                }  
<<<<<<< Updated upstream
                else if (Board.board[zrow][zcolumn] == Board.HIGHLIGHT)
                {
                    g.setColor(Color.yellow);
                    g.fillRect(Window.getX(0)+zcolumn*Window.getWidth2()/Board.numColumns,
                    Window.getY(0)+zrow*Window.getHeight2()/Board.numRows,
                    Window.getWidth2()/Board.numColumns,
                    Window.getHeight2()/Board.numRows);
                }  
=======
                
>>>>>>> Stashed changes
       
            }
              
        }
        Missiles.paint(g);
        
<<<<<<< Updated upstream

     //   screen.draw(g, titlescreenImage, this);
      }
=======
         if(changing){
            if(BattleShip.thing){  /////////// Makes a timed thing that goes just the right time for an explosion at the spot of impact
                g.setColor(Color.black);
                g.setFont(new Font("Arial",Font.PLAIN,40));
                g.drawString("Get Ready To Change Players ",200, 250);
                BattleShip.i++;
                if(BattleShip.i==100){
                    BattleShip.thing=false;
                    BattleShip.testing2=true;
                    Timed = true;
                    i=0;
                }
            }           
        }
         if(testing2 && P1 == false){
            if(Timed){
                g.setColor(Color.black);
                g.fillRect(0, 0, 1100,1000); 
                g.setColor(Color.white);
                g.setFont(new Font("Arial",Font.PLAIN,40));
                g.drawString("Player1 Look Away",200, 250);
                i++;    
                if(BattleShip.i>=50){
                g.drawString("Player2 Get Ready ",200, 320);
                
                }
                if(BattleShip.i==100){
                    Timed=false;
                    testing2 = false;
                    i=0;
                }
                Board.changingBoard();
            }
         }
                 
         else if(testing2 && P1){
            if(Timed){
                g.setColor(Color.black);
                g.fillRect(0, 0, 1100,1000); 
                g.setColor(Color.white);
                g.setFont(new Font("Arial",Font.PLAIN,40));
                g.drawString("Player2 Look Away",200, 250);
                i++;    
                if(BattleShip.i>=50){
                g.drawString("Player1 Get Ready ",200, 320);
                
                }
                if(BattleShip.i==100){
                    Timed=false;
                    testing2 = false;
                    i=0;
                }        
            }
            Board.changingBoard2();
         }
         
        }
>>>>>>> Stashed changes


        gOld.drawImage(image, 0, 0, null);
    }


////////////////////////////////////////////////////////////////////////////
// needed for     implement runnable
    public void run() {
        while (true) {
            animate();
            repaint();
            double seconds = .2;    //time that 1 frame takes.
            int miliseconds = (int) (1000.0 * seconds);
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
            }
        }
    }
/////////////////////////////////////////////////////////////////////////
    public void reset() {

    Board.reset();
    Missiles.reset();
<<<<<<< Updated upstream
=======
    MissileMenu =false;
    i=0;
    thing = true;
    gameStart = false;
    HTPshow = false;
    P1 = true;
    changing =false;
    testing2 =false;
    Timed=true;
    
>>>>>>> Stashed changes

        
    }
/////////////////////////////////////////////////////////////////////////
    public void animate() {
        if (animateFirstTime) {
            animateFirstTime = false;
            if (Window.xsize != getSize().width || Window.ysize != getSize().height) {
                Window.xsize = getSize().width;
                Window.ysize = getSize().height;
            }
         Missiles.setpictures();
            
          titlescreenImage = Toolkit.getDefaultToolkit().getImage("./titlescreen.JPG");
          htpImage = Toolkit.getDefaultToolkit().getImage("./htpback.JPG");
          oceanImage = Toolkit.getDefaultToolkit().getImage("./oceantop1.JPG");
          metalImage = Toolkit.getDefaultToolkit().getImage("./metal.JPG");

//Setting up the images for use
          titlescreenImage = Toolkit.getDefaultToolkit().getImage("./titlescreen.JPG");
          htpImage = Toolkit.getDefaultToolkit().getImage("./htpback.JPG");
           oceanImage = Toolkit.getDefaultToolkit().getImage("./oceantop1.JPG");
          metalImage = Toolkit.getDefaultToolkit().getImage("./metal.JPG");
            reset();

<<<<<<< Updated upstream
        }
                
        
        if(Missiles.MS == true){
            int currCol = 0;
        while (currCol<= Missiles.curCol)
        {
            currCol++;
            if(currCol ==Missiles.curCol)
                break;
            Missiles.X-=4;
            
        }
        }



         
          
          
          Missiles.Create(Missiles.Type.NUKE);


     
  gameStart=true;

            
         
          
           
             
           
        
=======
        }   
        Missiles.Missileanimate();    
      
     //   if(Missiles.MS){
//        if(P1==false && testing2 ==false){
//            
//        if(timeCount%30==29){
//            changing = true;
//        }
//        }
//        else if (P1 && testing2 == false){
//        if(timeCount%30==29){
//            changing = true;
//        }
//     //   }
//        
//        }
>>>>>>> Stashed changes
        
    timeCount++;
    }
   
////////////////////////////////////////////////////////////////////////////
   
////////////////////////////////////////////////////////////////////////////
    public void start() {
        if (relaxer == null) {
            relaxer = new Thread(this);
            relaxer.start();
        }
    }
////////////////////////////////////////////////////////////////////////////
    public void stop() {
        if (relaxer.isAlive()) {
            relaxer.stop();
        }
        relaxer = null;
    }

    
    

}

 

    
   
        
          
        
    

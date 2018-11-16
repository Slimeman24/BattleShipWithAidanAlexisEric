
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
   
    int timeCount;
    int score;
    int highScore = 0;
    boolean gameOver;
   
    TitleScreen screen;
    Image titlescreenImage;
    Image htpImage;
    Image oceanImage;
    Image metalImage;
    
    boolean gameStart = false;
    boolean HTPshow = false;
    
<<<<<<< Updated upstream
    int numNpcs = 4;
    int numCoins = 9;
=======
>>>>>>> Stashed changes
   

  
    
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
                  
                   

                    Board.addShip(Ships.Direction.UP,Ships.TYPE.thxon,xpos,ypos);


                }
                if (e.BUTTON3 == e.getButton()) {
                    //right button
                    reset();
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
                if (e.VK_W == e.getKeyCode()) {
                   
                    
                } else if (e.VK_S == e.getKeyCode()) {
                    
                } else if (e.VK_A == e.getKeyCode()) {
                    
                } else if (e.VK_D == e.getKeyCode()) {
                    
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



////////////////////////////////////////////////////////////////////////////
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
                Drawing.drawImage(metalImage, Window.getX(250), Window.getY(450), 0, 1.5, 1.8);
                
                
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
                if (Board.board[zrow][zcolumn] == Board.SHIP)
                {
                    g.setColor(Color.red);
                    g.fillRect(Window.getX(0)+zcolumn*Window.getWidth2()/Board.numColumns,
                    Window.getY(0)+zrow*Window.getHeight2()/Board.numRows,
                    Window.getWidth2()/Board.numColumns,
                    Window.getHeight2()/Board.numRows);
                }  
       
            }
              
        }
        
<<<<<<< Updated upstream

        Missiles.paint(g);
        

     //   screen.draw(g, titlescreenImage, this);
=======
    
>>>>>>> Stashed changes
        }


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

        
    }
/////////////////////////////////////////////////////////////////////////
    public void animate() {
        if (animateFirstTime) {
            animateFirstTime = false;
            if (Window.xsize != getSize().width || Window.ysize != getSize().height) {
                Window.xsize = getSize().width;
                Window.ysize = getSize().height;
            }
<<<<<<< Updated upstream
         Missiles.setpictures();
            


          titlescreenImage = Toolkit.getDefaultToolkit().getImage("./titlescreen.JPG");
         

=======
//Setting up the images for use
          titlescreenImage = Toolkit.getDefaultToolkit().getImage("./titlescreen.JPG");
          htpImage = Toolkit.getDefaultToolkit().getImage("./htpback.JPG");
           oceanImage = Toolkit.getDefaultToolkit().getImage("./oceantop1.JPG");
          metalImage = Toolkit.getDefaultToolkit().getImage("./metal.JPG");
>>>>>>> Stashed changes
            reset();

        }
        



         
          
          
          Missiles.Create(Missiles.Type.NUKE);


     
  gameStart=true;

            
         
          
           
             
           
        
        
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

 

    
   
        
          
        
    

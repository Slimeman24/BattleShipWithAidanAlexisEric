
package battleship;

import java.io.*; 
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class BattleShip extends JFrame implements Runnable {

     
    boolean animateFirstTime = true;
    Image image;
    Graphics2D g;
//Variables for the player.
   
 
    int timeCount;
     int score;
    int highScore = 0;
    boolean gameOver;
   
    TitleScreen screen;
    Image titlescreenImage;
    
    boolean gameStart = false;
    
    int numNpcs = 4;
    int numCoins = 9;
   /// int npcRow[] = new int[numNpcs];
   /// int npcColumn[] = new int[numNpcs];

  
    
    static BattleShip frame;
    public static void main(String[] args) {
        frame = new BattleShip();
        frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public BattleShip() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.BUTTON1 == e.getButton()) {
                    //left button

// location of the cursor.
                    int xpos = e.getX();
                    int ypos = e.getY();
<<<<<<< HEAD
                    
                    TitleScreen.ifPClick(xpos, ypos);
=======

                    
                    
                   TitleScreen.ifPClick(e.getX() - Window.getX(0),
                            e.getY() - Window.getY(0),gameStart); 


                    Board.addShip(Ships.Direction.LEFT,Ships.TYPE.thxon,3,3);

>>>>>>> 209ce9a1912344fc99c8ef925c8efc1c17a2e54a
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
        if (gameStart == false)
        {
       Drawing.setDrawingInfo(g, this);
       
        TitleScreen.draw(g, titlescreenImage, this);
        }
        
        if(gameStart)
        {
//fill background
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, Window.xsize, Window.ysize);

        int x[] = {Window.getX(0), Window.getX(Window.getWidth2()), Window.getX(Window.getWidth2()), Window.getX(0), Window.getX(0)};
        int y[] = {Window.getY(0), Window.getY(0), Window.getY(Window.getHeight2()), Window.getY(Window.getHeight2()), Window.getY(0)};
//fill border
        g.setColor(Color.CYAN);
        g.fillPolygon(x, y, 4);
// draw border
        g.setColor(Color.DARK_GRAY);
        g.drawPolyline(x, y, 5);

        if (animateFirstTime) {
            gOld.drawImage(image, 0, 0, null);
            return;
        }

         
        
        g.setColor(Color.DARK_GRAY);
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
                    g.setColor(Color.gray);
                    g.fillRect(Window.getX(0)+zcolumn*Window.getWidth2()/Board.numColumns,
                    Window.getY(0)+zrow*Window.getHeight2()/Board.numRows,
                    Window.getWidth2()/Board.numColumns,
                    Window.getHeight2()/Board.numRows);
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
        
<<<<<<< HEAD
        Missiles.paint(g);
        
=======
     //   screen.draw(g, titlescreenImage, this);
        }
>>>>>>> 209ce9a1912344fc99c8ef925c8efc1c17a2e54a

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
<<<<<<< HEAD
   
=======
    Board.reset();
>>>>>>> 209ce9a1912344fc99c8ef925c8efc1c17a2e54a
        
    }
/////////////////////////////////////////////////////////////////////////
    public void animate() {
        if (animateFirstTime) {
            animateFirstTime = false;
            if (Window.xsize != getSize().width || Window.ysize != getSize().height) {
                Window.xsize = getSize().width;
                Window.ysize = getSize().height;
            }
<<<<<<< HEAD
         Missiles.setpictures();
            
=======

          titlescreenImage = Toolkit.getDefaultToolkit().getImage("./titlescreen.JPG");
         
>>>>>>> 209ce9a1912344fc99c8ef925c8efc1c17a2e54a
            reset();

        }
        


<<<<<<< HEAD
          Board.addShip(Ships.Direction.DOWN,3,1,1,1);
          
          
          Missiles.Create(Missiles.Type.NUKE);

=======
     
  gameStart=true;
>>>>>>> 209ce9a1912344fc99c8ef925c8efc1c17a2e54a
            
         
          
           
             
           
        
        
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

 

    
   
        
          
        
    

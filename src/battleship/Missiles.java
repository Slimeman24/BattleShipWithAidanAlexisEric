
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
    
   // Variables for Missiles
    public static Image Whole;
    public static Image Button;

    private static ArrayList<Missiles> missiles = new ArrayList<Missiles>(); 
    private Type MissileType;

    public static Image pic;
    static Image image;
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
    
    
=======
    public static int X = Window.getWidth2()-20;
    public static int Y = 80;
    public static int currYVal;
    public static int currXVal;
    public static int curCol;
    public static int curRow;
    static boolean TimedExpo;
    static int i;
    static boolean thing;
    static int NumMis;
    static int Numbers[] = new int[6];
    static int Numbers2[] = new int[6];
    
    
//////////////////////////////////////////////
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
    
//////////////////////////////////////////////
    public static void reset(){
        // Putting all variables back to normal getting called from Main Class
       Whole = Toolkit.getDefaultToolkit().getImage("./BlackH.JPG");
       pic = Toolkit.getDefaultToolkit().getImage("./R.PNG");
       MS= false;
       X = Window.getWidth2()-20;
       Y = 80;
       curCol =0;
       curRow=0;
       currYVal=0;
       currXVal =0;
       TimedExpo=false;
       Numbers[0]=2;
       Numbers[1]=999;
       Numbers[2]=3;
       Numbers[3]=1;
       Numbers[4]=1;
       Numbers[5]=2;
       Numbers2[0]=2;
       Numbers2[1]=999;
       Numbers2[2]=3;
       Numbers2[3]=1;
       Numbers2[4]=1;
       Numbers2[5]=2;
       thing=false;
    }    
    
   /////////////////////////////////////////////////////////// 
    public static void paint(Graphics2D _g) {
        g = _g; // made a static variable so dont have to keep making this

        g.setColor(Color.blue);        
        Drawing.drawImage(Whole, Window.getWidth2()-20, 80, 0, .1, .1);      
        Drawing.drawImage(Toolkit.getDefaultToolkit().getImage("./Button.PNG"), Window.getWidth2()-25, 650, 0, .3, .3);
        Drawing.drawImage(Toolkit.getDefaultToolkit().getImage("./B2.PNG"), Window.getWidth2()-25, 648, 0, .1, .1);        
        Drawing.drawArrow(Window.getWidth2()-25,Window.getHeight2()/2 +90,0,3,2,g);
        Drawing.drawArrow(Window.getWidth2()-25,Window.getHeight2()/2 -90,180,3,2,g);
        

        Drawing.drawImage(Toolkit.getDefaultToolkit().getImage("./Button.PNG"), Window.getWidth2()-25, 270, 0, .3, .3);
        Drawing.drawImage(Toolkit.getDefaultToolkit().getImage("./B2.PNG"), Window.getWidth2()-25, 268, 0, .1, .1);

        if (MS==true){ // for smaller missiles making them bigger
        if( pic == Toolkit.getDefaultToolkit().getImage("./Reveal.PNG") 
                || pic == Toolkit.getDefaultToolkit().getImage("./Turtle.PNG") || pic  == Toolkit.getDefaultToolkit().getImage("./Joe.GIF") )
            Drawing.drawImage(pic, X, Y, 0, .3, .3);
                 
        else if(pic == Toolkit.getDefaultToolkit().getImage("./R.PNG"))      
            Drawing.drawImage(pic, X, Y, 180, .1, .1); 
        else 
            Drawing.drawImage(pic, X, Y, 0, .1, .1);
        }

        
       
        if(pic == Toolkit.getDefaultToolkit().getImage("./Reveal.PNG")   // for smaller missiles making them bigger
                || pic == Toolkit.getDefaultToolkit().getImage("./Turtle.PNG") || pic  == Toolkit.getDefaultToolkit().getImage("./Joe.GIF") )
            Drawing.drawImage(pic, Window.getWidth2()-20, Window.getHeight2()/2, 0,.3, .3);
        else if(pic == Toolkit.getDefaultToolkit().getImage("./TNT.PNG"))
            Drawing.drawImage(pic, Window.getWidth2()-20, Window.getHeight2()/2, 0,.2, .2); 
        else       
            Drawing.drawImage(pic, Window.getWidth2()-20, Window.getHeight2()/2, 0, .1, .1);  
         
        
        g.setColor(Color.blue);        
        drawArrow(Window.getWidth2()-25,Window.getHeight2()/2 +90,0,3,2,g);
        drawArrow(Window.getWidth2()-25,Window.getHeight2()/2 -90,180,3,2,g);
        
        if (MS==true)
            Drawing.drawImage(pic, X, Y, 0, .1, .1);
             
        
//        checkPressingButton();
    }
        if(TimedExpo){  /////////// Makes a timed thing that goes just the right time for an explosion at the spot of impact
            Drawing.drawImage(Toolkit.getDefaultToolkit().getImage("./Expo.GIF"), X, Y-10, 0, .4, .4);
            i++;
            if(i==15){
                TimedExpo=false;
                i=0;
                X = Window.getWidth2()-20;
                Y = 80;
            }
        }
        
        if(BattleShip.P1){
            NumMis = getIm(pic);
            g.setColor(Color.white);
            g.setFont(new Font("Arial",Font.PLAIN,20));
            g.drawString("# Of Rockets Left For P1 : " + NumMis, 40, 58);  
        }
        else {
            NumMis = getIm2(pic);
            g.setColor(Color.white);
            g.setFont(new Font("Arial",Font.PLAIN,20));
            g.drawString("# Of Rockets Left For P2: " + NumMis, 40, 58);  
        }

        
        if(thing){  /////////// Makes a timed thing that goes just the right time for an explosion at the spot of impact
        g.setColor(Color.black);
        g.setFont(new Font("Arial",Font.PLAIN,40));
        g.drawString("You Got : " + ShowonScreen(image),  110, 250);
        BattleShip.i++;
        if(BattleShip.i==150){
        thing=false;
        BattleShip.i= 0;
        }
        }
        
        
//        checkPressingButton();
    }


    


 ///////////////////////////////////////// Returning num of missiles you have
        public static int getIm(Image type)
    {
        if (type == Toolkit.getDefaultToolkit().getImage("./TNT.PNG"))
            return Numbers[0];
        else if (type ==  Toolkit.getDefaultToolkit().getImage("./R.PNG"))
            return Numbers[1];
        else if (type == Toolkit.getDefaultToolkit().getImage("./Joe.GIF"))
            return Numbers[2];
        else if (type == Toolkit.getDefaultToolkit().getImage("./Turtle.PNG"))
            return Numbers[3];
        else if (type == Toolkit.getDefaultToolkit().getImage("./Yoda.PNG"))
            return Numbers[4];
        else if (type == Toolkit.getDefaultToolkit().getImage("./Reveal.PNG"))
            return Numbers[5];

        return Numbers[1];
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



 ///////////////////////////////////////// Returning num of missiles you have
        public static int getIm2(Image type)
    {
        if (type == Toolkit.getDefaultToolkit().getImage("./TNT.PNG"))
            return Numbers2[0];
        else if (type ==  Toolkit.getDefaultToolkit().getImage("./R.PNG"))
            return Numbers2[1];
        else if (type == Toolkit.getDefaultToolkit().getImage("./Joe.GIF"))
            return Numbers2[2];
        else if (type == Toolkit.getDefaultToolkit().getImage("./Turtle.PNG"))
            return Numbers2[3];
        else if (type == Toolkit.getDefaultToolkit().getImage("./Yoda.PNG"))
            return Numbers2[4];
        else if (type == Toolkit.getDefaultToolkit().getImage("./Reveal.PNG"))
            return Numbers2[5];

        return Numbers2[1];
    }
>>>>>>> Stashed changes
        
        
 /////////////////////////////////////////
        
        public static void Launch(){   
           // Gets called when button pressed
         if( BattleShip.P1 && curRow!=0 && Board.board[curRow-1][curCol] == Board.HIGHLIGHT && getIm(pic) > 0){
         MS = true;   
         }
         else if( BattleShip.P1 ==false && curRow!=0 && Board.board[curRow-1][curCol] == Board.HIGHLIGHT && getIm2(pic) > 0){
         MS = true;   
         }
         CheckLocHit();
         
        }
        
        
/////////////////////////////////////////
        public static void CheckLocHit(){
        boolean breaking =false;                                    // variable so it wont shoot missiles on your side of screen
        
        if(MS == false                              // Goes into if its not a button press and its not in the border
           && TitleScreen.MouseX < Window.getWidth2() 
           &&  TitleScreen.MouseX >0 
           && TitleScreen.MouseY < Window.getHeight2()
           &&  TitleScreen.MouseY >0){
            
            //checking where mouse is
            int currCol = 0;
            breaking =false;
            int xdelta = Window.getWidth2()/Board.numColumns;
            currXVal = xdelta;
            while (TitleScreen.MouseX > currXVal)
            {
                currCol++;
                currXVal += xdelta;
            }
            int currRow = 0;
            int ydelta = Window.getHeight2()/Board.numRows;
            currYVal = ydelta;
            while (TitleScreen.MouseY > currYVal)
            {
                currRow++;
                currYVal += ydelta;
            }
            
            if(currRow >= 11){  
                breaking = true;
                currRow=0;
                currCol=0;
            }
        // end of checking mouse
            
            // only one spot will highlight
            if(curRow !=0 && Board.board[curRow-1][curCol] == Board.HIGHLIGHT){
                Board.board[curRow-1][curCol] = Board.PATH;
                
            }
            
            if(!breaking){       // if its a valid loco set the spot to highlight 
                curRow = currRow;
                curCol = currCol;       
            
        
            if(curRow !=0 && curCol!= 11 && Board.board[curRow-1][curCol] == Board.PATH)
                Board.board[curRow-1][curCol] = Board.HIGHLIGHT;
            }
       
        }
        }

 ///////////////////////////////////////////     Changes Side Bar Pictures  
        public static void changeRight(){
        if (pic ==Toolkit.getDefaultToolkit().getImage("./R.PNG"))
            pic = Toolkit.getDefaultToolkit().getImage("./Turtle.PNG");
        else if (pic ==Toolkit.getDefaultToolkit().getImage("./Turtle.PNG"))
            pic = Toolkit.getDefaultToolkit().getImage("./Joe.GIF");
        else if (pic == Toolkit.getDefaultToolkit().getImage("./Joe.GIF"))
            pic = Toolkit.getDefaultToolkit().getImage("./Yoda.PNG");
        else if (pic ==Toolkit.getDefaultToolkit().getImage("./Yoda.PNG"))
            pic =Toolkit.getDefaultToolkit().getImage("./Reveal.PNG");
        else if (pic ==Toolkit.getDefaultToolkit().getImage("./Reveal.PNG"))
            pic =Toolkit.getDefaultToolkit().getImage("./TNT.PNG");
        else if (pic ==Toolkit.getDefaultToolkit().getImage("./TNT.PNG"))
            pic =Toolkit.getDefaultToolkit().getImage("./R.PNG");
        }
        
        public static void changeLeft(){        
        if (pic ==Toolkit.getDefaultToolkit().getImage("./TNT.PNG"))
            pic =Toolkit.getDefaultToolkit().getImage("./Reveal.PNG");
        else if (pic ==Toolkit.getDefaultToolkit().getImage("./Reveal.PNG"))
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
    
 ////////////////////////////////////////////////////////    
        
       public static void Explode(){
           // going to check for ships but its making locoation a hit or miss
       if (curRow !=0 && Board.board[curRow-1][curCol] == Board.PATH || Board.board[curRow-1][curCol] == Board.HIGHLIGHT && MS == true ){          
           boolean hit = CheckHit(pic);
           
           System.out.println(BattleShip.P1);
           if(BattleShip.P1 == true){
               if(!hit){
                Board.board[curRow-1][curCol] = Board.MISS;
                Board.Player1[curRow-1][curCol] = Board.MISS;
               }    
               else{
                Board.board[curRow-1][curCol] = Board.HIT;
                Board.Player1[curRow-1][curCol] = Board.HIT;
               }
               System.out.println(curRow-1 + " " + curCol);
               System.out.println(Board.Player1[curRow-1][curCol]);
           }
           else {
               if(!hit){
                Board.board[curRow-1][curCol] = Board.MISS;
                Board.P2[curRow-1][curCol] = Board.MISS;
               }
               else{
                Board.board[curRow-1][curCol] = Board.HIT;
                Board.P2[curRow-1][curCol] = Board.HIT;
                }
                System.out.println(curRow + " " + curCol);
               System.out.println(Board.P2[curRow-1][curCol]);
           }
           
       TimedExpo=true;
       if(MS){
           BattleShip.P1 = !BattleShip.P1;
//           BattleShip.testing2 = false;
           BattleShip.changing = true;
           BattleShip.thing = true;
       }
       MS=false;
       
       
//       if(BattleShip.P1)
//       for (int zi=1;zi<Board.numColumns;zi++)
//        for (int zx=1;zx<Board.numRows;zx++)       
//            Board.board[zx][zi]= Board.P1[zx][zi];
//       
//       else 
//      for (int zi=1;zi<Board.numColumns;zi++)
//        for (int zx=1;zx<Board.numRows;zx++)      
//            Board.P1[zx][zi] = Board.board[zx][zi];
       }
       }

 /////////////////////////////////////////    Removes # of missiles you can use and calls a special effect if its a special missile. 
       public static boolean CheckHit(Image image){
        if(BattleShip.P1){
        if (pic == Toolkit.getDefaultToolkit().getImage("./TNT.PNG")){
            Numbers[0]--;
            tnt();
        }
        else if (pic ==  Toolkit.getDefaultToolkit().getImage("./R.PNG"))
        {
            Numbers[1]--;            
        }    
        else if (pic == Toolkit.getDefaultToolkit().getImage("./Joe.GIF"))
        {
            Numbers[2]--; 
            Random();
        }     
        else if (pic == Toolkit.getDefaultToolkit().getImage("./Turtle.PNG"))
        {
            Numbers[3]--;  
            Turtle();
        }            
        else if (pic == Toolkit.getDefaultToolkit().getImage("./Yoda.PNG"))
        {
            Numbers[4]--; 
            MoveShips();
        }    
        else if (pic == Toolkit.getDefaultToolkit().getImage("./Reveal.PNG"))
        {
            Numbers[5]--;
            Reveal();
        }     
        }
        else {
        if (pic == Toolkit.getDefaultToolkit().getImage("./TNT.PNG")){
            Numbers2[0]--;
            tnt();
        }
        else if (pic ==  Toolkit.getDefaultToolkit().getImage("./R.PNG"))
        {
            Numbers2[1]--;            
        }    
        else if (pic == Toolkit.getDefaultToolkit().getImage("./Joe.GIF"))
        {
            Numbers2[2]--; 
            Random();
        }     
        else if (pic == Toolkit.getDefaultToolkit().getImage("./Turtle.PNG"))
        {
            Numbers2[3]--;  
            Turtle();
        }            
        else if (pic == Toolkit.getDefaultToolkit().getImage("./Yoda.PNG"))
        {
            Numbers2[4]--; 
            MoveShips();
        }    
        else if (pic == Toolkit.getDefaultToolkit().getImage("./Reveal.PNG"))
        {
            Numbers2[5]--;
            Reveal();
        } 
        }
           
           
           return false;
       }
       
/////////////////////////////////////////////////////////////////////////////       
       public static void tnt(){
          for(int j= curRow-2; j<=curRow; j++){     
           for(int i= curCol-1; i<=curCol+1; i++){
               if(Board.board[j][i] == Board.PATH && BattleShip.P1 ){
                Board.board[j][i] = Board.HIT;
                Board.Player1[j][i] = Board.HIT;
               }
               else if(Board.board[j][i] == Board.PATH && BattleShip.P1 ==false){
                Board.board[j][i] = Board.HIT;
                Board.P2[j][i] = Board.HIT;
               }
           }
          }
       }
       
       
////////////////////////////////////////////////////////////////////////////////       
       public static void Reveal(){
          for(int j= curRow-2; j<=curRow; j++){     
           for(int i= curCol-1; i<=curCol+1; i++){
               if(Board.board[j][i] == Board.PATH && BattleShip.P1 ){
                Board.board[j][i] = Board.MISS;
                Board.Player1[j][i] = Board.MISS;
               }
               else if(Board.board[j][i] == Board.PATH && BattleShip.P1 ==false){
                Board.board[j][i] = Board.MISS;
                Board.P2[j][i] = Board.MISS;
               }
           }
          }

       }
       
       
////////////////////////////////////////////////////////////////////////////////       
       public static void Random(){
        int i= (int)(Math.random()*7) ;  
         image = null;
        if (i == 0){
            thing = true;
            image = Toolkit.getDefaultToolkit().getImage("./Turtle.PNG");
            ShowonScreen(image);
            Turtle();
        }
        else if (i == 1){
            thing = true;
            image =Toolkit.getDefaultToolkit().getImage("./LoveMissile.PNG");
            ShowonScreen(image);
        }
        else if (i == 2){
            thing = true;
            image = Toolkit.getDefaultToolkit().getImage("./Yoda.PNG");
            ShowonScreen(image);
            MoveShips();
        }
        else if (i == 3){
            thing=true;
            image =Toolkit.getDefaultToolkit().getImage("./Reveal.PNG");
            ShowonScreen(image);
            Reveal();
        }
        else if (i == 4){
            thing = true;
            image =Toolkit.getDefaultToolkit().getImage("./TNT.PNG");
            ShowonScreen(image);
            tnt();
        }
        else if (i == 5){
            thing = true;
            image =Toolkit.getDefaultToolkit().getImage("./R.PNG");
            ShowonScreen(image);
        }
        else if (i == 6){
            thing = true;
            image =Toolkit.getDefaultToolkit().getImage("./ERocket.PNG");
            ShowonScreen(image);
        }

        
        
       }
       
       
////////////////////////////////////////////////////////////////////////////////       
       public static void Turtle(){
           
       }
       
             
////////////////////////////////////////////////////////////////////////////////       
       public static void MoveShips(){
        
       }       
       
       
////////////////////////////////////////////////////////////////////////////////       
       public static String ShowonScreen(Image image){
       
        if (image == Toolkit.getDefaultToolkit().getImage("./TNT.PNG")){
            return "TNT";
        }
        else if (image ==  Toolkit.getDefaultToolkit().getImage("./R.PNG"))
        {
            return "REGULAR MISSILE";           
        }    
        else if (image == Toolkit.getDefaultToolkit().getImage("./ERocket.PNG"))
        {
            return "EVIL MISSILE";     
        }     
        else if (image == Toolkit.getDefaultToolkit().getImage("./Turtle.PNG"))
        {
            return "TURTLE"; 
        }            
        else if (image == Toolkit.getDefaultToolkit().getImage("./Yoda.PNG"))
        {
            return "MOVE YOUR OWN SHIP"; 
        }    
        else if (image == Toolkit.getDefaultToolkit().getImage("./Reveal.PNG"))
        {
            return "REVEAL MISSILE"; 
        }   
        else if (image == Toolkit.getDefaultToolkit().getImage("./LoveMissile.PNG"))
        {
            return "LOVE MISSILE"; 
        }   
          
        return null;
       }
              
/////////////////////////////////////////////////////////////////////////////////////////
    public static void Missileanimate() {
        
        if(Missiles.MS == true){
            int currCol = 0;
            int currRow = 0;
            while (Missiles.X > Missiles.currXVal - Window.getWidth2()/Board.numColumns/3)
            {
                currCol++;
                if(currCol == 8)
                    break;
                Missiles.X-=4;
            }
            while (Missiles.Y < Missiles.currYVal-20)
            {
                currRow++;
                if(currRow == 8)
                    break;
                Missiles.Y+=4;
            }
        }
        
        if(Missiles.X > (Missiles.currXVal-Window.getWidth2()/Board.numColumns/3)-8 && Missiles.X < (Missiles.currXVal-Window.getWidth2()/Board.numColumns/3)+8 && Missiles.Y > (Missiles.currYVal-25) && Missiles.Y < (Missiles.currYVal-10)){
           // Missiles.CheckHit();
            Missiles.Explode();
        }
        
    }
       
}


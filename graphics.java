import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Component;

class graphics implements Runnable, KeyListener, WindowListener, MouseListener {
    public final String TITLE = "Musical Guac";
    public final Dimension SIZE = new Dimension(1920, 1080); //SETS WINDOW DIMENSION
    public JFrame frame;
    private boolean isRunning, isDone;
    private Image imgBuffer;
    private BufferedImage stone, grass, pig, dirt;
    private TexturePaint stoneOcta, grassOcta, pigs, guaca;
    private boolean change, move, wool;
    @SuppressWarnings("unused")
    private Color BROWN;
    @SuppressWarnings("unused")
    int w=100;
    int h=10;
    int speed=3;
    int laxtx=0;
    int x=laxtx+speed;
    private int fontSize=100;
    private Rectangle myRect;
    private Point current;
    private Rectangle asdf;
    private Rectangle next;
    private Rectangle tong;
    private Rectangle ayush;
    private Rectangle wall;
    private Polygon p;
    public JFrame window;
    private int tx, ty, df, dg,dx,dy,ax,ay;
    
    
    

    public void setChange(boolean change) {
        this.change = change;
    }

    private void loadImages() {

        try {


            stone = ImageIO.read(this.getClass().getResource("5717966_orig.jpg")); //picks the images used
            grass = ImageIO.read(this.getClass().getResource("cameron.jpg"));
            pig = ImageIO.read(this.getClass().getResource("blackkkk.jpg"));
            dirt = ImageIO.read(this.getClass().getResource("sample chip new.png"));
            grassOcta = new TexturePaint(grass, new Rectangle(0, 0, 90, 60));
            stoneOcta = new TexturePaint(stone, new Rectangle(0, 0, 1920, 1080)); // sets image as paint, sets dimensions
            guaca=new TexturePaint(dirt, new Rectangle(0,0,500,500));
            pigs = new TexturePaint(pig, new Rectangle(0, 0, 1920, 1080)); //sets the image as a paint, and then sets how big the image will be


        } catch (IOException ex) {

            Logger.getLogger(driver.class.getName()).log(Level.SEVERE,null, ex);
        }
    }

    public graphics(){

        loadImages();
        setChange(true);
        dx=10;
	    dy=700;
	    df=100;
        current = new Point(0,0); //starting point
        myRect = new Rectangle((int)current.getX(), (int)current.getY(), 200, 200);// x,y,h,w to move just change x and y, sets how big the underlying image is
        asdf= new Rectangle(1100,800,100,100);
        tong= new Rectangle(100, 100, 200, 200);
        ayush=new Rectangle(700,700,100,100);
        next=new Rectangle(600, 300, 400, 400);
        wall=new Rectangle(1000, 500, 10, 1700);
        p=new Polygon(new int[] {100, 200, 300}, new int[] {100, 50, 100}, 3);
        BROWN = new Color(139,69,19);
        frame = new JFrame();
        frame.addKeyListener(this);
        frame.addWindowListener(this);
        frame.addMouseListener(this);
        frame.setSize(SIZE);
        frame.setTitle(TITLE);
        isRunning = true;
        isDone = false;
        frame.setVisible(true);
        frame.setLayout(null);
        imgBuffer = frame.createImage(SIZE.width, SIZE.height);
        move=true;
        wool=false;
    }


   

	@Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int Key;
        Key = e.getKeyCode();



        if(Key == KeyEvent.VK_UP){ // UP
            if(asdf.getY()>(31)) {
                asdf.setLocation((int) asdf.getX(), (int) asdf.getY() - 20); //how much it moves by
                next.setLocation((int)asdf.getX(), (int)asdf.getY()+200);
            }
            else {
                asdf.setLocation((int) asdf.getX(), 30); //goes back to starting point
            }
        }
        else if(Key == KeyEvent.VK_LEFT){
            if(asdf.getX()>10) {
                asdf.setLocation((int) asdf.getX() - 20, (int) asdf.getY());
                next.setLocation((int)asdf.getX()+200, (int)asdf.getY());
            }
            else {
                asdf.setLocation(10, (int) asdf.getY());
            }
        }
        else if(Key == KeyEvent.VK_DOWN){ // DOWN
            if(asdf.getY()<(int)(1080-asdf.getHeight()-20)) {
                asdf.setLocation((int) asdf.getX(), (int) asdf.getY() + 20);
                next.setLocation((int) asdf.getX(), (int) asdf.getY() - 200);
            }
            else {
                asdf.setLocation((int) asdf.getX(), (int)(950-asdf.getHeight()-10));
            }
        }
        else if(Key == KeyEvent.VK_RIGHT){
            if(asdf.getX()<(int)(1920-asdf.getWidth()-20)) {
                asdf.setLocation((int) asdf.getX() + 20, (int) asdf.getY());
                next.setLocation((int) asdf.getX() - 200, (int) asdf.getY());
            }
            else {
                asdf.setLocation((int)(600-asdf.getWidth()-20), (int) asdf.getY());
            }
        }
        else if(Key==KeyEvent.VK_W){
        	if(myRect.getY()>(31)) {
                myRect.setLocation((int)myRect.getX(), (int)myRect.getY() - 10); //how much it moves by
            }
            else {
                myRect.setLocation((int)myRect.getX(), 30); //goes back to starting point
            }
        }
        else if(Key==KeyEvent.VK_A){
        	 if(myRect.getX()>10) {
                 myRect.setLocation((int) myRect.getX() - 10, (int) myRect.getY());
             }
             else {
                 myRect.setLocation(10, (int) myRect.getY());
             }
         }
        else if(Key==KeyEvent.VK_S){
        	if(myRect.getY()<(int)(1080-myRect.getHeight()-10)) {
                myRect.setLocation((int) myRect.getX(), (int) myRect.getY() + 10);
            }
            else {
                myRect.setLocation((int) myRect.getX(), (int)(950-myRect.getHeight()-10));
            }
        }
        else if(Key==KeyEvent.VK_D){
        	 if(myRect.getX()<(int)(1920-myRect.getWidth()-10)) {
                 myRect.setLocation((int) myRect.getX() + 10, (int) myRect.getY());
             }
             else {
                 myRect.setLocation((int)(600-myRect.getWidth()-10), (int) myRect.getY());
             }
         }
        	
        }
    
    


    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        frame.setVisible(false);
        frame.dispose();
        isRunning = false;
    }

    @Override
    public void windowClosed(WindowEvent e) {
        while(true){

            if(isDone){
                System.exit(0);
            }
            try{
                Thread.sleep(100);
            }
            catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
    
    public void AI(){
    	
    }
    @Override
    public void run() {
        while(isRunning){
        	
        	
           draw();
           ryan();
           check();
          
          

            if(change){
          
                setChange(false);
                
            }
            try{
            	Thread.sleep(25);
            	}
            catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }
        isDone = true;
    }

    private void draw() {

        
        Graphics2D g2d = (Graphics2D) imgBuffer.getGraphics();
        g2d.setPaint(pigs); //sets paint with the already pre set dirty paint
        g2d.fillRect(0, 0, SIZE.width, SIZE.height); //actually fills screen
        g2d.setColor(BROWN);
        g2d.setFont(new Font("chiller", Font.BOLD, fontSize));
        g2d.setColor(Color.green);
        //g2d.drawString("MUSICAL", 800, 110);
        //g2d.drawString("GUACAMOLE", 800,200);
        g2d.setPaint(stoneOcta); 
        g2d.fillRect((int)myRect.getX(), (int)myRect.getY(), (int)myRect.getWidth(), (int)myRect.getHeight()); //fills the rectangle in particular
        g2d.setColor(Color.BLUE); //sets the color of the outline of the rectangle
        //g2d.drawPolygon(new int[] {100, 200, 300}, new int[] {100, 50, 100}, 3);
        //g2d.setPaint(grassOcta);
        //g2d.fillPolygon(p);
        g2d.setPaint(stoneOcta); 
        //sasag2d.fillRect((int)next.getX(), (int)next.getY(), (int)next.getWidth(), (int)next.getHeight());
        //g2d.draw(next);
        //g2d.drawOval(25, 35, 25, 25);
        g2d.setPaint(guaca);
        g2d.fillRect((int)asdf.getX(), (int)asdf.getY(), (int)asdf.getWidth(), (int)asdf.getHeight()); //fills the rectangle in particular 
        g2d.setPaint(Color.red);
        g2d.draw(asdf);
        g2d.fillRect((int)tong.getX(), (int)tong.getY(), (int)tong.getWidth(), (int)tong.getHeight());
        g2d.draw(tong);
        g2d.fillRect((int)ayush.getX(), (int)ayush.getY(), (int)ayush.getWidth(), (int)ayush.getHeight());
        g2d.draw(ayush);
        Stroke old = g2d.getStroke();
        g2d.setStroke(new BasicStroke(3));
        g2d.draw(myRect); //actually draws it
        g2d.setPaint(Color.blue);
        g2d.draw(wall);
        g2d.fillRect((int)wall.getX(), (int)wall.getY(), (int)wall.getWidth(), (int)wall.getHeight());
        g2d.setStroke(old);
        if(isRunning) 
        g2d = (Graphics2D) frame.getGraphics();
        g2d.drawImage(imgBuffer, 0,  0, SIZE.width, SIZE.height, 0, 0, SIZE.width, SIZE.height, null);
        g2d.dispose();
    }
    
    
    private void check(){
       /* Graphics2D g2d = (Graphics2D) imgBuffer.getGraphics();
        g2d.setColor(Color.red);
        g2d.fillRect(0, 0, SIZE.width, SIZE.height); //actually fills screen
        g2d.fillRect(0, 0, SIZE.width, SIZE.height);
        g2d.setFont(new Font("chiller", Font.BOLD, fontSize));
        g2d.setColor(Color.green);
        g2d.drawString("MUSICAL", 800, 110);
        g2d.drawString("GUACAMOLE", 800,200);
        g2d = (Graphics2D) window.getGraphics();
        */
    	tx=(int)tong.getX();
    	ty=(int)tong.getY();
    	dx=(int)asdf.getX();
    	dy=(int)asdf.getY();
    	ax=(int)ayush.getX();
    	ay=(int)ayush.getY();
    	if(((tx-110<dx&&dx<tx+110)&&(ty-110<dy&&dy<ty+110))||((ax-70<dx&&dx<ax+70)&&(ay-70<dy&&dy<ay+70))){
    		isRunning=false;
    	}
    	
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    }
    private void ryan(){
    	dg=((int)tong.getX());
    	df=((int)ayush.getY());
    	if(move==true){
    	df+=10;
    	dg+=20;
    	if(dg>1800||df>1000){
    		move=false;
    	}
    	else{
        tong.setLocation(dg, 100);
        ayush.setLocation(700, df);
    		}
    	}
    	else if(move==false){
        df-=10;
        dg-=20;
        if(dg<0||df<0){
        	move=true;
        }
        else{
        tong.setLocation(dg, 100);
        ayush.setLocation(700,df);
         }
    	 
    }

}
}
    

    

  


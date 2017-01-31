import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.geom.*;


class graphics implements Runnable, KeyListener, WindowListener, MouseListener {
    public final String TITLE = "Musical Guac";
    public final Dimension SIZE = new Dimension(1920, 1080); //SETS WINDOW DIMENSION
    public JFrame frame;
    private boolean isRunning, isDone;
    private Image imgBuffer;
    private BufferedImage stone, grass, pig, dirt;
    private TexturePaint stoneOcta, grassOcta, pigs, guaca;
    private boolean change;
    @SuppressWarnings("unused")
    private Color BROWN;
    @SuppressWarnings("unused")
  
    private Rectangle myRect;
    private Point current;
    private Rectangle asdf;
    private Rectangle next;
    

    public void setChange(boolean change) {
        this.change = change;
    }

    private void loadImages() {

        try {


            stone = ImageIO.read(this.getClass().getResource("5717966_orig.jpg")); //picks the images used
            grass = ImageIO.read(this.getClass().getResource("16.png"));
            pig = ImageIO.read(this.getClass().getResource("blackkkk.jpg"));
            dirt = ImageIO.read(this.getClass().getResource("guacccccccccccccc (1).jpg"));
            grassOcta = new TexturePaint(grass, new Rectangle(0, 0, 90, 60));
            stoneOcta = new TexturePaint(stone, new Rectangle(0, 0, 1920, 1080)); // sets image as paint, sets dimensions
            guaca=new TexturePaint(dirt, new Rectangle(0,0,1920,1080));
            pigs = new TexturePaint(pig, new Rectangle(0, 0, 1920, 1080)); //sets the image as a paint, and then sets how big the image will be


        } catch (IOException ex) {

            Logger.getLogger(driver.class.getName()).log(Level.SEVERE,null, ex);
        }
    }

    public graphics(){

        loadImages();
        setChange(true);
        current = new Point(0,0); //starting point
        myRect = new Rectangle((int)current.getX(), (int)current.getY(), 200, 200);// x,y,h,w to move just change x and y, sets how big the underlying image is
        asdf= new Rectangle(100,100,300,300);
        next=new Rectangle(600, 300, 400, 400);
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
                asdf.setLocation((int) asdf.getX(), (int) asdf.getY() - 10); //how much it moves by
            }
            else {
                asdf.setLocation((int) asdf.getX(), 30); //goes back to starting point
            }
        }
        else if(Key == KeyEvent.VK_LEFT){
            if(asdf.getX()>10) {
                asdf.setLocation((int) asdf.getX() - 10, (int) asdf.getY());
            }
            else {
                asdf.setLocation(10, (int) asdf.getY());
            }
        }
        else if(Key == KeyEvent.VK_DOWN){ // DOWN
            if(asdf.getY()<(int)(1080-asdf.getHeight()-10)) {
                asdf.setLocation((int) asdf.getX(), (int) asdf.getY() + 10);
            }
            else {
                asdf.setLocation((int) asdf.getX(), (int)(950-asdf.getHeight()-10));
            }
        }
        else if(Key == KeyEvent.VK_RIGHT){
            if(asdf.getX()<(int)(1920-asdf.getWidth()-10)) {
                asdf.setLocation((int) asdf.getX() + 10, (int) asdf.getY());
            }
            else {
                asdf.setLocation((int)(600-asdf.getWidth()-10), (int) asdf.getY());
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

            if(change){
                setChange(false);

            }
            try{Thread.sleep(50);}
            catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }
        isDone = true;
    }

    private void draw() {

        // TODO Auto-generated method stub
        Graphics2D g2d = (Graphics2D) imgBuffer.getGraphics();
        g2d.setPaint(pigs); //sets paint with the already pre set dirty paint
        g2d.fillRect(0, 0, SIZE.width, SIZE.height); //actually fills screen
        g2d.setPaint(stoneOcta); 
        g2d.fillRect((int)myRect.getX(), (int)myRect.getY(), (int)myRect.getWidth(), (int)myRect.getHeight()); //fills the rectangle in particular
        g2d.setColor(Color.BLUE); //sets the color of the outline of the rectangle
        g2d.drawPolygon(new int[] {100, 200, 300}, new int[] {100, 50, 100}, 3);
        g2d.setPaint(stoneOcta); 
        g2d.drawOval(25, 35, 25, 25);
        g2d.setPaint(grassOcta);
        g2d.fillRect((int)asdf.getX(), (int)asdf.getY(), (int)asdf.getWidth(), (int)asdf.getHeight()); //fills the rectangle in particular //fills the rectangle in particular
        g2d.draw(asdf);
        Stroke old = g2d.getStroke();
        g2d.setStroke(new BasicStroke(3));
        g2d.draw(myRect); //actually draws it
        g2d.setStroke(old); 
        if(isRunning) //isrunning is true
        g2d = (Graphics2D) frame.getGraphics();
        g2d.drawImage(imgBuffer, 0,  0, SIZE.width, SIZE.height, 0, 0, SIZE.width, SIZE.height, null);
        g2d.dispose();
    }
}

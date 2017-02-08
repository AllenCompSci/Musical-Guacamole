import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class Screen implements Runnable, KeyListener, WindowListener, MouseListener {
	 	public final String TITLE = "Musical Guac";
	    public final Dimension SIZE = new Dimension(1920, 1080); //SETS WINDOW DIMENSION
	    public JFrame window;
	    private int fontSize=300;
	    private Rectangle choice1;
	    private Rectangle choice2;
	    private Rectangle choice3;
	    private Rectangle tong;
	    private Image imgbuffer;
	    private boolean change;
	    private boolean isrunner, isdoner;
	    private int dx, dy, df, dg;
	    
	    public void setChange(boolean change) {
	        this.change = change;
	    }
	    
	    
	 public Screen(){
		 choice1= new Rectangle(400,600,1000,100);
	     choice2=new Rectangle(400,700,1000,100);
	     choice3=new Rectangle(400,800,1000,100);
	     dx=100;
	     dy=300;
	     df=300;
	     dg=500;
	     tong=new Rectangle(dx,dy,df,dg);
		 window=new JFrame();
		 window.setSize(SIZE);
	     window.setTitle(TITLE);
	     window.setVisible(true);
	     window.setLayout(null);
	     isrunner=true;
	     isdoner=false;
	     setChange(true);
	     imgbuffer = window.createImage(SIZE.width, SIZE.height);
	 }
	    
	    public void run() {
	        while(isrunner){
	        	dx+=10;
		        dy+=10;
		        df+=10;
		        dg+=10;
	        dicks();
	        

	            if(change){
	                setChange(false);

	            }
	            try{Thread.sleep(50);}
	            catch(InterruptedException ie){
	                ie.printStackTrace();
	            }
	        }
	        isdoner = true;
	    }


private void dicks(){
    Graphics2D g2d = (Graphics2D) imgbuffer.getGraphics();
    g2d.setColor(Color.black);
    g2d.fillRect(0, 0, SIZE.width, SIZE.height); //actually fills screen
    g2d.setFont(new Font("chiller", Font.BOLD, fontSize));
    g2d.setColor(Color.green);
    g2d.draw(choice1);
    g2d.draw(choice2);
    g2d.draw(choice3);
    g2d.draw(tong);
    g2d.drawString("MUSICAL", 300, 300);
    g2d.drawString("GUACAMOLE", 300,500);
    g2d = (Graphics2D) window.getGraphics();
    if(isrunner) 
    g2d = (Graphics2D) window.getGraphics();
    g2d.drawImage(imgbuffer, 0,  0, SIZE.width, SIZE.height, 0, 0, SIZE.width, SIZE.height, null);
    g2d.dispose();
}

@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowOpened(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowClosing(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowClosed(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowIconified(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowDeiconified(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowActivated(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowDeactivated(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}

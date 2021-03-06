import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.image.BufferedImage;
import java.awt.Color;

class graphics implements Runnable, KeyListener, WindowListener, MouseListener {
    public final String TITLE = "Musical Guac";
    public final Dimension SIZE = new Dimension(1920, 1080); //SETS WINDOW DIMENSION
    public JFrame frame;
    private boolean isRunning, isDone;
    private boolean startgame = false;
    private boolean credits=false;
    private boolean options=false;
    private Image imgBuffer;
    private BufferedImage stone, grass, pig, dirt, chip, kulkarni,guacamoleImg;
    private TexturePaint stoneOcta, grassOcta, pigs, guaca, kulkarni2;
    private boolean change, move, wool;
    @SuppressWarnings("unused")
    private Color BROWN;
    @SuppressWarnings("unused")
    int w=100;
    int h=10;
    int speed=3;
    int laxtx=0;
    int x=laxtx+speed;
    private int fontSize=300;
    private Rectangle choice1;
    private Rectangle choice2;
    private Rectangle choice3;
    private Rectangle myRect;
    private Point current;
    private Rectangle asdf;
    private Rectangle next;
    private Rectangle tong;
    private Rectangle ayush;
    private Rectangle wall, wall2;
    private Rectangle marker0,marker1,marker2,marker3,marker4;
    private Polygon p;
    public JFrame window;
    private int tx, ty, df, dg,dx,dy,ax,ay,lx,ly,bx,by;
    private int dx4, dx5, dy4, dy5;
    private int Mx, My;
    private int down, right;
    private guac one, two ,thr, four, five, six ,sev, eig, nin;
    
    

    public void setChange(boolean change) {
        this.change = change;
    }

    private void loadImages() {

        try {

        	kulkarni = ImageIO.read(this.getClass().getResource("Kulkarni_ScienceFair_Award 2017.jpeg")); 
            stone = ImageIO.read(this.getClass().getResource("5717966_orig.jpg")); //picks the images used
            chip = ImageIO.read(this.getClass().getResource("sample chip new.png"));
            grass = ImageIO.read(this.getClass().getResource("cameron.jpg"));
            pig = ImageIO.read(this.getClass().getResource("blackkkk.jpg"));
            dirt = ImageIO.read(this.getClass().getResource("blackkkk.jpg"));
            guacamoleImg = ImageIO.read(this.getClass().getResource("ddddd.gif"));
            grassOcta = new TexturePaint(grass, new Rectangle(0, 0, 90, 60));
            stoneOcta = new TexturePaint(stone, new Rectangle(0, 0, 1920, 1080)); // sets image as paint, sets dimensions
            guaca=new TexturePaint(dirt, new Rectangle(0,0,500,500));
            pigs = new TexturePaint(pig, new Rectangle(0, 0, 1920, 1080)); //sets the image as a paint, and then sets how big the image will be
            kulkarni2=new TexturePaint(kulkarni, new Rectangle(0,0,1920,1080));


        } catch (IOException ex) {

            Logger.getLogger(driver.class.getName()).log(Level.SEVERE,null, ex);
        }
    }

    public graphics(){
    	dx4 = 1100;
    	dy4 = 800;
    	dx5 = 1300;
    	dy5 = 1000;
    	choice1= new Rectangle(400,600,1000,100);
	    choice2=new Rectangle(400,700,1000,100);
	    choice3=new Rectangle(400,800,1000,100);
        loadImages();
        setChange(true);
        dx=10;
	    dy=700;
	    df=100;
        current = new Point(0,0); //starting point
        myRect = new Rectangle((int)current.getX(), (int)current.getY(), 200, 200);// x,y,h,w to move just change x and y, sets how big the underlying image is
        asdf= new Rectangle(1100,800,100,100);
        tong= new Rectangle(100, 100, 100, 100);
        ayush=new Rectangle(700,700,100,100);
        next=new Rectangle(600, 300, 400, 400);
        wall=new Rectangle(1000, 500, 20, 1700);
        wall2=new Rectangle(740, 300, 1200, 20);
        marker0=new Rectangle(0,0, 20,20);
        marker1=new Rectangle(0,0, 20,20);
        marker2=new Rectangle(0,0, 20,20);
        marker3=new Rectangle(0,0, 20,20);
        marker4=new Rectangle(0,0, 20,20);
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

        if(startgame==true&&credits==true){
        if(Key == KeyEvent.VK_ESCAPE){
        	frame.dispose();
        	isRunning=false;
        }
        }
        if(startgame==true&&credits==false){
        	if(Key == KeyEvent.VK_ESCAPE){
        		Graphics2D g2d = (Graphics2D) imgBuffer.getGraphics();
        		endscreen(g2d);
        		isRunning=false;
        		
            }
        }
        if(Key == KeyEvent.VK_UP){ // UP
        	if((((BufferedImage) imgBuffer).getRGB(dx4, (dy4 - 1)) != -65536)){ //&& (((BufferedImage) imgBuffer).getRGB(dx5, (dy5 - 20)) != -16776961)){//doesnt work
        	dy4 -= 20;
           // dy5 -= 20;
            if(asdf.getY()>(31)) {
                asdf.setLocation(dx4, dy4); //how much it moves by
                //next.setLocation((int)asdf.getX(), (int)asdf.getY()+200);
            }
            else {
                asdf.setLocation((int) asdf.getX(), 32); //goes back to starting point
            }
        	//}
        	}
        }
        else if(Key == KeyEvent.VK_LEFT){
        	if((((BufferedImage) imgBuffer).getRGB((dx4-1),dy4) != -65536)){ //&& (((BufferedImage) imgBuffer).getRGB((dx4 - 20), dy5) != -16776961)){//blue is -16776961 the color of walls
        	dx4 -= 20;
            //dx5 -= 20;
            if(asdf.getX()>10) {
                asdf.setLocation(dx4, dy4);
                //next.setLocation((int)asdf.getX()+200, (int)asdf.getY());
            }
            else {
                asdf.setLocation(10, (int) asdf.getY());
            }
        	}
        }
        else if(Key == KeyEvent.VK_DOWN){ // DOWN
        	down=dy4+100;
        	if((((BufferedImage) imgBuffer).getRGB(dx4, (down + 1)) != -65536)){ //&& (((BufferedImage) imgBuffer).getRGB(dx5, (dy5 + 20)) != -16776961)){//doesnt work
        	dy4 += 20;
            //dy5 += 20;
            if(asdf.getY()<(int)(1080-asdf.getHeight()-20)) {
                asdf.setLocation(dx4,dy4);
               // next.setLocation((int) asdf.getX(), (int) asdf.getY() - 200);
            }
            else {
                asdf.setLocation((int) asdf.getX(), 980);
            }
        	}
        	
        }
        else if(Key == KeyEvent.VK_RIGHT){
        	right=dx4+100;
        	if((((BufferedImage) imgBuffer).getRGB((right + 1), dy4) != -65536 )){// THE COLOR OF BLACK IS -16777216  && (((BufferedImage) imgBuffer).getRGB((dx5 + 20), dy5) != -16776961)){//doesnt work
        	dx4 += 20;
            //dx5 += 20;
        	
        	}
            if(asdf.getX()<(int)(1920-asdf.getWidth()-20)) {
                asdf.setLocation(dx4, dy4);
                //next.setLocation((int) asdf.getX() - 200, (int) asdf.getY());
            }
            else {
                asdf.setLocation(1820, (int) asdf.getY());
            }
        	}
        
        
        
        /*else if(Key==KeyEvent.VK_W){
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
         */
        else if(Key==KeyEvent.VK_SPACE){
        	bx=(int)asdf.getX();
        	by=(int)asdf.getY();
        	
        	for(int i=0;i<4;i++){
        	marker0.setLocation(bx+30,by+30);
        	
        	/*if(i==1&&Key==KeyEvent.VK_SPACE){
        		marker1.setLocation(bx+30,by+30);
        	}
        	else if(i==2&&Key==KeyEvent.VK_SPACE){
        		marker2.setLocation(bx+3,by+3);
        	}
        	else if(i==3&&Key==KeyEvent.VK_SPACE){
        		marker3.setLocation(bx+50,by+50);
        	}
        	else if(i==4&&Key==KeyEvent.VK_SPACE){
        		marker4.setLocation(bx+70,by+70);
        	}*/
        	
        }
        }
        
    }
    
    


    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    	Mx = e.getXOnScreen();
    	//Mx2 = Mx + 200; not sure what this does
    	My = e.getYOnScreen();
    	//My2 = My + 200; same thing here
    	int cC = ((BufferedImage) imgBuffer).getRGB(Mx, My);
    	String s = "color in: " + cC;
    	System.out.println(s);
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
            	Thread.sleep(50);
            	}
            catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }
     
        isDone = true;
    }
    private void guacamole(guac newenemy, int x, int y, int direction, int distance){
    	newenemy = new guac(x, y, direction, distance);
    }
    private void guacmove(guac newenemy){
    	if(newenemy.getForward() == true){
    		if(newenemy.getDirection() == 1){
    			newenemy.setX(newenemy.getX() + 4);
    			if(newenemy.getX() == newenemy.getstartX() + newenemy.getDist()){
    				newenemy.switchForward();
    			}
    		}
    		else if(newenemy.getDirection() == 2){
    			newenemy.setY(newenemy.getY() + 4);
    			if(newenemy.getY() == newenemy.getstartY() + newenemy.getDist()){
    				newenemy.switchForward();
    			}
    		}
    		else if(newenemy.getDirection() == 3){
    			newenemy.setX(newenemy.getX() - 4);
    			if(newenemy.getX() == newenemy.getstartX() - newenemy.getDist()){
    				newenemy.switchForward();
    			}
    		}
    		else if(newenemy.getDirection() == 4){
    			newenemy.setY(newenemy.getY() - 4);
    			if(newenemy.getY() == newenemy.getstartY() - newenemy.getDist()){
    				newenemy.switchForward();
    			}
    		}
    	}
    	else if(newenemy.getForward() == false){
    		if(newenemy.getDirection() == 1){
    			newenemy.setX(newenemy.getX() - 4);
    			if(newenemy.getX() == newenemy.getstartX()){
    				newenemy.switchForward();
    			}
    		}
    		else if(newenemy.getDirection() == 2){
    			newenemy.setY(newenemy.getY() - 4);
    			if(newenemy.getY() == newenemy.getstartY()){
    				newenemy.switchForward();
    			}
    		}
    		else if(newenemy.getDirection() == 3){
    			newenemy.setX(newenemy.getX() + 4);
    			if(newenemy.getX() == newenemy.getstartX()){
    				newenemy.switchForward();
    			}
    		}
    		else if(newenemy.getDirection() == 4){
    			newenemy.setY(newenemy.getY() + 4);
    			if(newenemy.getY() == newenemy.getstartY()){
    				newenemy.switchForward();
    			}
    		}
    	}
    }
    private void closestG(){
    	int minDist = 0;
    	minDist = one.getAlarm((int)asdf.getX(), (int)asdf.getY());
    	if(two.getAlarm((int)asdf.getX(), (int)asdf.getY()) < minDist){
    		minDist = two.getAlarm((int)asdf.getX(), (int)asdf.getY());
    	}
    	if(thr.getAlarm((int)asdf.getX(), (int)asdf.getY()) < minDist){
    		minDist = thr.getAlarm((int)asdf.getX(), (int)asdf.getY());
    	}
    	if(four.getAlarm((int)asdf.getX(), (int)asdf.getY()) < minDist){
    		minDist = four.getAlarm((int)asdf.getX(), (int)asdf.getY());
    	}
    	if(five.getAlarm((int)asdf.getX(), (int)asdf.getY()) < minDist){
    		minDist = five.getAlarm((int)asdf.getX(), (int)asdf.getY());
    	}
    	String blah = "minDist to player: " + minDist;
    	/*String blah1 = "one to player: " + one.getAlarm((int)asdf.getX(), (int)asdf.getY());
    	String blah2 = "two to player: " + two.getAlarm((int)asdf.getX(), (int)asdf.getY());
    	String blah3 = "thr to player: " + thr.getAlarm((int)asdf.getX(), (int)asdf.getY());
    	String blah4 = "four to player: " + four.getAlarm((int)asdf.getX(), (int)asdf.getY());
    	String blah5 = "five to player: " + five.getAlarm((int)asdf.getX(), (int)asdf.getY());
        System.out.println(blah);
        System.out.println(blah1);
        System.out.println(blah2);
        System.out.println(blah3);
        System.out.println(blah4);
        System.out.println(blah5);
        try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    	System.out.println(blah);
    }
    public int getclosestG(){
    	int minDist = 0;
    	minDist = one.getAlarm((int)asdf.getX(), (int)asdf.getY());
    	if(two.getAlarm((int)asdf.getX(), (int)asdf.getY()) < minDist){
    		minDist = two.getAlarm((int)asdf.getX(), (int)asdf.getY());
    	}
    	if(thr.getAlarm((int)asdf.getX(), (int)asdf.getY()) < minDist){
    		minDist = thr.getAlarm((int)asdf.getX(), (int)asdf.getY());
    	}
    	if(four.getAlarm((int)asdf.getX(), (int)asdf.getY()) < minDist){
    		minDist = four.getAlarm((int)asdf.getX(), (int)asdf.getY());
    	}
    	if(five.getAlarm((int)asdf.getX(), (int)asdf.getY()) < minDist){
    		minDist = five.getAlarm((int)asdf.getX(), (int)asdf.getY());
    	}
    	return minDist;
    }
    private void startscreen(Graphics2D g2d){
    	one = new guac(500, 500, 1, 200);
    	two = new guac(700, 700, 2, 400);
    	thr = new guac(0, 0, 2, 200);
    	four = new guac(40, 40, 3, 20);
    	five = new guac(900, 900, 1, 100);
    	g2d.setColor(Color.black);
        g2d.fillRect(0, 0, SIZE.width, SIZE.height); //actually fills screen
        g2d.setFont(new Font("chiller",Font.BOLD, fontSize));
        g2d.setColor(Color.green);
        g2d.draw(choice1);
        g2d.draw(choice2);
        g2d.draw(choice3);
        g2d.drawString("MUSICAL", 300, 300);
        g2d.drawString("GUACAMOLE", 300,500);
        g2d.setFont(new Font("chiller",Font.BOLD, 100));
        g2d.drawString("PLAY", 800, 890);
        g2d.drawString("CREDITS",740, 690);
        g2d.drawString("OPTIONS",740,790);
        g2d = (Graphics2D) frame.getGraphics();
        if(isRunning) 
        g2d = (Graphics2D) frame.getGraphics();
        g2d.drawImage(imgBuffer, 0,  0, SIZE.width, SIZE.height, 0, 0, SIZE.width, SIZE.height, null);
        
    }
   
    private void endscreen(Graphics2D g2d){
    	g2d.setColor(Color.black);
    	g2d.setPaint(kulkarni2);
    	g2d.fillRect(0, 0, SIZE.width, SIZE.height); //actually fills screen
    	g2d.setFont(new Font("arial",Font.BOLD, fontSize));
    	g2d.setColor(Color.red);
    	g2d.drawString("game", 300, 300);
        g2d.drawString("over", 300,500);
        if(isRunning){
        	 g2d = (Graphics2D) frame.getGraphics();
             g2d.drawImage(imgBuffer, 0,  0, SIZE.width, SIZE.height, 0, 0, SIZE.width, SIZE.height, null);
        }
    }
 
    private void draw() {
        Graphics2D g2d = (Graphics2D) imgBuffer.getGraphics();
        if(!startgame){
        	/*g2d.setColor(Color.black);
            g2d.fillRect(0, 0, SIZE.width, SIZE.height); //actually fills screen
            g2d.setFont(new Font("chiller",Font.BOLD, fontSize));
            g2d.setColor(Color.green);
            g2d.draw(choice1);
            g2d.draw(choice2);
            g2d.draw(choice3);
            g2d.drawString("MUSICAL", 300, 300);
            g2d.drawString("GUACAMOLE", 300,500);
            g2d.setFont(new Font("chiller",Font.BOLD, 100));
            g2d.drawString("PLAY", 800, 890);
            g2d.drawString("CREDITS",740, 690);
            g2d.drawString("OPTIONS",740,790);
            g2d = (Graphics2D) frame.getGraphics();
            if(isRunning) 
            g2d = (Graphics2D) frame.getGraphics();
            g2d.drawImage(imgBuffer, 0,  0, SIZE.width, SIZE.height, 0, 0, SIZE.width, SIZE.height, null);
            if(Mx > 400 && Mx < 1400 && My > 800 && My < 900){
            	startgame = true;*/
        	startscreen(g2d);
        	if(Mx > 400 && Mx < 1400 && My > 800 && My < 900){
            	startgame = true;
            }
        	if(Mx > 0 && Mx < 1800 && My > 600 && My < 700){
        		credits=true;
        		startgame=true;
        	}
        	if(Mx > 0 && Mx < 1800 && My > 700 && My < 800){
        		credits=true;
        		options=true;
        		startgame=true;
        	}
        	
        }
        else if(startgame==true&&credits==true&&options==true){
        	g2d.setColor(Color.black);
        	g2d.fillRect(0,0,SIZE.width, SIZE.height);
        	g2d.setColor(Color.ORANGE);
        	g2d.setFont(new Font("Arial", Font.BOLD, 100));
        	g2d.draw(choice1);
        	g2d.drawString("Press escape", 575, 680);
            g2d = (Graphics2D) frame.getGraphics();
            if(isRunning) 
            g2d = (Graphics2D) frame.getGraphics();
            g2d.drawImage(imgBuffer, 0,  0, SIZE.width, SIZE.height, 0, 0, SIZE.width, SIZE.height, null);
        }
        else if(startgame==true&&credits==true){
        	g2d.setColor(Color.black);
        	g2d.fillRect(0, 0, SIZE.width, SIZE.height); //actually fills screen
        	g2d.setFont(new Font("arial",Font.BOLD, fontSize));
        	g2d.setColor(Color.red);
        	g2d.drawString("tong", 300, 300);
            g2d.drawString("johnmatthe", 300,500);
            g2d.drawString("W",300,700);
            if(isRunning){
    	        g2d = (Graphics2D) frame.getGraphics();
    	        g2d.drawImage(imgBuffer, 0,  0, SIZE.width, SIZE.height, 0, 0, SIZE.width, SIZE.height, null);
            }
        }
        else if(startgame==true&&credits==false){
	        g2d.setPaint(Color.DARK_GRAY); 
	        g2d.fillRect(0, 0, SIZE.width, SIZE.height); //actually fills screen
	        g2d.setColor(BROWN);
	        g2d.setFont(new Font("chiller", Font.BOLD, fontSize));
	        g2d.setColor(Color.green);
	        //g2d.drawString("MUSICAL", 800, 110);
	        //g2d.drawString("GUACAMOLE", 800,200);
	        g2d.setPaint(stoneOcta); 
	        //g2d.fillRect((int)myRect.getX(), (int)myRect.getY(), (int)myRect.getWidth(), (int)myRect.getHeight()); //fills the rectangle in particular
	        g2d.setColor(Color.BLUE); //sets the color of the outline of the rectangle
	        //g2d.drawPolygon(new int[] {100, 200, 300}, new int[] {100, 50, 100}, 3);
	        //g2d.setPaint(grassOcta);
	        //g2d.fillPolygon(p);
	        g2d.setPaint(stoneOcta); 
	        //sasag2d.fillRect((int)next.getX(), (int)next.getY(), (int)next.getWidth(), (int)next.getHeight());
	        // g2d.draw(next);
	        //g2d.drawOval(25, 35, 25, 25);
	        g2d.setPaint(guaca);
	        g2d.fillRect((int)asdf.getX(), (int)asdf.getY(), (int)asdf.getWidth(), (int)asdf.getHeight()); //fills the rectangle in particular 
	        
	        g2d.setPaint(Color.black);
	        g2d.draw(asdf);//hitbox
	        g2d.setPaint(Color.red);
	        g2d.fillRect((int)tong.getX(), (int)tong.getY(), (int)tong.getWidth(), (int)tong.getHeight());
	        g2d.draw(tong);
	        g2d.fillRect((int)ayush.getX(), (int)ayush.getY(), (int)ayush.getWidth(), (int)ayush.getHeight());
	        g2d.draw(ayush);
	        Stroke old = g2d.getStroke();
	        g2d.setStroke(new BasicStroke(3));
	        //g2d.drawImage(chip, dx4, dy4, dx5, dy5, 0, 0, 4000, 3000, null );//uses chip image and keyboard press locations
	        //g2d.draw(myRect); //actually draws it
	        g2d.setPaint(Color.red);
	        g2d.draw(wall);
	        g2d.draw(wall2);
	        g2d.fillRect((int)wall.getX(), (int)wall.getY(), (int)wall.getWidth(), (int)wall.getHeight());
	        g2d.fillRect((int)wall2.getX(), (int)wall2.getY(), (int)wall2.getWidth(), (int)wall2.getHeight());
	        g2d.setStroke(old);
	        
	        g2d.setPaint(Color.yellow);
	        g2d.draw(marker0);
	        g2d.fillRect((int)marker0.getX(), (int)marker0.getY(), (int)marker0.getWidth(), (int)marker0.getHeight());
	        guacmove(one);
	        guacmove(two);
	        guacmove(thr);
	        guacmove(four);
	        guacmove(five);
	        //g2d.draw(one.getHitbox());
	        g2d.drawImage(guacamoleImg, one.getX(), one.getY(), one.getX() + 60, one.getY() + 60, 0, 0, 550, 550, null );
	        g2d.drawImage(guacamoleImg, two.getX(), two.getY(), two.getX() + 60, two.getY() + 60, 0, 0, 550, 550, null );
	        g2d.drawImage(guacamoleImg, thr.getX(), thr.getY(), thr.getX() + 60, thr.getY() + 60, 0, 0, 550, 550, null );
	        g2d.drawImage(guacamoleImg, four.getX(), four.getY(), four.getX() + 60, four.getY() + 60, 0, 0, 550, 550, null );
	        g2d.drawImage(guacamoleImg, five.getX(), five.getY(), five.getX() + 60, five.getY() + 60, 0, 0, 550, 550, null );
	        //String blah = "Dist to player: " + one.getAlarm((int)asdf.getX(), (int)asdf.getY());
	        //System.out.println(blah);
	        closestG();
	        /*g2d.setPaint(Color.pink);
	        g2d.draw(marker2);
	        g2d.fillRect((int)marker2.getX(), (int)marker2.getY(), (int)marker2.getWidth(), (int)marker2.getHeight());
	        
	        g2d.setPaint(Color.orange);
	        g2d.draw(marker3);
	        g2d.fillRect((int)marker3.getX(), (int)marker3.getY(), (int)marker3.getWidth(), (int)marker3.getHeight());
	        
	        g2d.setPaint(Color.blue);
	        g2d.draw(marker4);
	        g2d.fillRect((int)marker4.getX(), (int)marker4.getY(), (int)marker4.getWidth(), (int)marker4.getHeight());
	        
	        g2d.setPaint(Color.white);
	        g2d.draw(marker1);
	        g2d.fillRect((int)marker1.getX(), (int)marker1.getY(), (int)marker1.getWidth(), (int)marker1.getHeight());
	        */
	        if(isRunning){
	        g2d = (Graphics2D) frame.getGraphics();
	        g2d.drawImage(imgBuffer, 0,  0, SIZE.width, SIZE.height, 0, 0, SIZE.width, SIZE.height, null);
	        }
	       
        }
    
        g2d.dispose();
    }
    
    
    private void check(){
    	Graphics2D g2d = (Graphics2D) imgBuffer.getGraphics();
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
    	if(((tx-90<dx&&dx<tx+90)&&(ty-100<dy&&dy<ty+90))||((ax-100<dx&&dx<ax+100)&&(ay-100<dy&&dy<ay+100))){
    		endscreen(g2d);
    		isRunning=false;
    	}

    	
    		
    		    		
    }
    private void ryan(){//moves cpu
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
        ayush.setLocation(1800, df);
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
        ayush.setLocation(1800,df);
         }
    	 
    }

}
}

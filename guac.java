import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class guac {
	private Rectangle hitbox;
	//private BufferedImage guacamoleImg;
	private int direction;//right = 1; up = 2; left = 3; down = 4;
	private int pathDist;//distance the guacamole moves MUST BE MULTIPLE OF 20
	private int startX, startY, x, y;
	private boolean forward = true;//true = going in direction, false = going opposite direction
	public guac(int xIn, int yIn, int directionIn, int pathDistIn){
		/*try {
			guacamoleImg = ImageIO.read(this.getClass().getResource("guacamole2new.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		hitbox = new Rectangle(x, y, 60, 60);//x and y is point of top left corner, next 2 numbers is width and length
		direction = directionIn;
		pathDist = pathDistIn;
		startX = xIn;
		startY = yIn;
		x = startX;
		y = startY;
	}
	public Rectangle getHitbox(){
		hitbox.x = x;
		hitbox.y = y;
		return hitbox;
	}
	public int getDirection(){
		return direction;
	}
	public int getDist(){
		return pathDist;
	}
	public int getstartX(){
		return startX;
	}
	public int getstartY(){
		return startY;
	}
	public void setX(int xPosition){
		x = xPosition;
	}
	public void setY(int yPosition){
		y = yPosition;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public boolean getForward(){
		return forward;
	}
	public void switchForward(){
		if(forward == true){
			forward = false;
		}
		else{
			forward = true;
		}
	}
	public int getAlarm(int playerX, int playerY){
		return (int) Math.sqrt(Math.pow(Math.abs(playerX - x), 2) + Math.pow(Math.abs(playerY-y), 2));
	}
	
}

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class guac {
	private Rectangle hitbox;
	//private BufferedImage guacamoleImg;
	private int direction;//right = 1; up = 2; left = 3; down = 4;
	private int pathDist;//distance the guacamole moves
	public guac(int x, int y, int directionIn, int pathDistIn){
		/*try {
			guacamoleImg = ImageIO.read(this.getClass().getResource("guacamole2new.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		hitbox = new Rectangle(x, y, 100, 100);
		direction = directionIn;
		pathDist = pathDistIn;
	}
	
	//public static void main(String[] args) {
		// TODO Auto-generated method stub

	//}

}

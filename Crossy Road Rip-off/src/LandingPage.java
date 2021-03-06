import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class LandingPage {

	private int x = 0,y = 0;
	private Image img; // image of the frog
	private Image img2;
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	private boolean visible = true;
	private long time = 0;
	public LandingPage() {
		//big roads
		
		
		img2 = getImage("crossylandingpage.gif");//load the image based on the filename "ground.png"
	

		tx.scale(7.0, 7.0);
		init(x, y);					//initialize the picture location
	}
	
	public void paint(Graphics g) {
		if(!visible) return;
		
		//using a Graphics2D to draw images
		Graphics2D g2 = (Graphics2D) g;
		tx.setToTranslation(0,  0);
		tx.scale(7.0, 7.0);
		
		g2.drawImage(img2, tx, null);
		time += 17;
		if(time > 1000) visible = false;
		
	}   
	
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}

	// converts image to make it drawable in paint
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Ground.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}

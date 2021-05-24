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

	public LandingPage() {
		//big roads
		
		
		img2 = getImage("crossylandingpage.gif");///load the image based on the filename "ground.png"
		Image imgModified = img2.getScaledInstance(700, 700, java.awt.Image.SCALE_SMOOTH);

		img2=  imgModified;
		
		init(x, y);					//initialize the picture locationb
	}
	
	public void paint(Graphics g) {
		//using a Graphics2D to draw images
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img2, tx, null);
		 
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

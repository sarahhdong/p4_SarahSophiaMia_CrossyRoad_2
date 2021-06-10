import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class FinalPage {

	private int x = 0,y = 0;
	private Image img; // image of the frog
	private Image img2;
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	private boolean visible = true;
	//private long time = 0;
	
	public FinalPage() {
		
		
		img2 = getImage("deadPage.png");///load the image

		tx.scale(7.0, 7.0);
		init(x, y);	
		
	}
	
	public void paint(Graphics g) {
		if(!visible) return;
		
		//using a Graphics2D to draw images
		Graphics2D g2 = (Graphics2D) g;
		tx.setToTranslation(0,  0);
		
		g2.drawImage(img2, tx, null);

		
	}   
	public void appear() {
		x = 350;
		y=350;
		init(x,y);
	}
	public void disappear() {
		x=1000;
		y=1000;
		init(x,y);
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

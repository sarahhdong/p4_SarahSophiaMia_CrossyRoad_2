import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Ground {
	private int x = 0,y = 0;
	private Image img; // image of the frog
	private Image img2;
	private Image img3;
	private Image coin;
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);

	public Ground() {
		//big roads
		
		img = getImage("evenRoads.png");

		img3 = getImage("Tree(short).png");
		coin = getImage("coin.png");
		
		

		init(x, y);					//initialize the picture locationb
	}
	public void paint(Graphics g) {
		//using a Graphics2D to draw images
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);

		g2.drawImage(img2, tx, null);
		g2.drawImage(img3, 150, 10, null);
		g2.drawImage(img3, 500, 450, null);
		g2.drawImage(img3, 300, 370, null);
		g2.drawImage(img3, 100, 300, null);
		
		g2.drawImage(coin, 100, 200, null);
		g2.drawImage(coin, 200, 300, null);
		g2.drawImage(coin, 250, 550, null);
		g2.drawImage(coin, 550, 200, null);
		g2.drawImage(coin, 330, 15, null);

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

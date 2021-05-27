import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;


public class Coin {

	
		// TODO Auto-generated method stub
		private int x, y;
		private double vx, vy;
		private Image img; // image of the frog
		private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);

		public Coin() {
			img = getImage("coin.png");
			init(x, y);				//initialize the location of the image
			//this.x = x;
			//this.y = y;
			//vx = -5;
			//vy = vx+3;
			
		}
		
		public void paint(Graphics g) {//hope this works
			//x += vx;
			//y += vy;

			if(x<=0) {
				if(y<=400) {//BOTTOM car
					x = 700;
					y = 650;
					init(x,y);
				}
				
				
			}

			tx.setToTranslation(x, y);
			//tx.scale(1.5, 1.5);
			tx.scale(.75, .75);
			
			//these are the 2 lines of code needed draw an image on the screen
			Graphics2D g2 = (Graphics2D) g;
			g2.drawImage(img, tx, null);   
			
		}
		
		private void init(double a, double b) {
			tx.setToTranslation(a, b);
			tx.scale(1, 1);
		}

		private Image getImage(String path) {
			Image tempImage = null;
			try {
				URL imageURL = CarRL.class.getResource(path);
				tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return tempImage;
		}
		

	
}

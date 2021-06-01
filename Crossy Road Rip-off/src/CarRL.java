import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class CarRL {
	private int x, y;
	private double vx, vy;
	private Image img; 
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);

	public CarRL(int x, int y) {
		if(Math.random() <.25) { img = getImage("YellowBackwardCar.png");}
		else if(Math.random() <.50) { img = getImage("GreenBackwardCar.png");}
		else if(Math.random() <.75) { img = getImage("PurpleBackwardCar.png");}
		else {img = getImage("RedBackwardCar.png");}
		
		init(x, y);	
		this.x = x;
		this.y = y;
		vx = -5;
		vy = vx+3;
	}
	
	public void paint(Graphics g) {
		x += vx;
		y += vy;

		if(x<=0) {
			if(y<=650&&y>=370) {//BOTTOM car
				x = 700;
				y = 650;
				init(x,y);
			}
			if(y<=350) {//middle car
				x = 700;
				y = 350;
				init(x,y);
			}
			if(y<=150) {//top car
				x = 700;
				y = 150;
				init(x,y);
			}
		}

		tx.setToTranslation(x, y);
		tx.scale(.75, .75);
		
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);   
		
	}
	
	public boolean car2Collide(Chicken c) {
		Rectangle car = new Rectangle(x,y,50,20);
//		
//		//represent the paddle as a rectangle
		Rectangle chick = new Rectangle(c.getX(),c.getY(), 28, 38);
		
		if(car.intersects(chick)) {
			vx = 0;
			System.out.println("This works2");
		//or stop timer if want to reset chicken to starting position
		//boolean in main frame to see if dead, then reset chicken and reset timer
//		}
		return true;
		}
		//main frame: every single car, ask if colliding with chicken
		return false;
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

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Car {
	private int x, y;
	private double vx, vy;
	private Image img; // image of the frog
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);

	public Car(int x, int y) {
		if(Math.random() <.25) { img = getImage("CarNew.png");}
		else if(Math.random() <.50) { img = getImage("greencar.png");}
		else if(Math.random() <.75) { img = getImage("purplecar.png");}
		else {img = getImage("redcar.png");}
		
		init(x, y);				//initialize the location of the image
		this.x = x;
		this.y = y;
		vx = 5;
		//vx = (int)(Math.random()*(10-2+1))+2;
		vy = vx-2.5;
		//if(Math.random()<.5) {
		//	vx*=-1;
		//}
	}
	
	public void paint(Graphics g) {//hope this works
		x += vx;
		y += vy;

		if(x>=800) {
			if(y<=80) {//top car
				x = 250;
				y = 0;
				init(x,y);
			}
			if(y>80&&y<=370) {//middle car
				x = 0;
				y = 50;
				init(x,y);
			}
			if(y>370) {//bottom car
				x = 0;
				y = 400;
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
			URL imageURL = Car.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
}

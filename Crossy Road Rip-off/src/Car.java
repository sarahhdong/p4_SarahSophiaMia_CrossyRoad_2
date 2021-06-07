import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Car {
	private int x, y;
	private double vx, vy;
	private Image img;
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);

	public Car(int x, int y) {
		if(Math.random() <.25) { img = getImage("CarNew.png");}
		else if(Math.random() <.50) { img = getImage("greencar.png");}
		else if(Math.random() <.75) { img = getImage("purplecar.png");}
		else {img = getImage("redcar.png");}
		
		init(x, y);
		this.x = x;
		this.y = y;
		vx = 5;
		vy = vx-2.5;
	}
	
	public void paint(Graphics g) {//hope this works
		x += vx;
		y += vy;


		if(x>=800) {
			if(y<=200) {//top car
				x = 320;
				y = 0;
				init(x,y);
				if(Math.random() <.25) { img = getImage("CarNew.png");}
				else if(Math.random() <.50) { img = getImage("greencar.png");}
				else if(Math.random() <.75) { img = getImage("purplecar.png");}
				else {img = getImage("redcar.png");}
			}
			if(y>100&&y<=450) {//middle car
				x = 0;
				y = 100;
				init(x,y);
				if(Math.random() <.25) { img = getImage("CarNew.png");}
				else if(Math.random() <.50) { img = getImage("greencar.png");}
				else if(Math.random() <.75) { img = getImage("purplecar.png");}
				else {img = getImage("redcar.png");}
			}
			if(y>500) {//bottom car
				x = 0;
				y = 400;
				init(x,y);
				if(Math.random() <.25) { img = getImage("CarNew.png");}
				else if(Math.random() <.50) { img = getImage("greencar.png");}
				else if(Math.random() <.75) { img = getImage("purplecar.png");}
				else {img = getImage("redcar.png");}
			}
		}

		tx.setToTranslation(x, y);
		//tx.scale(1.5, 1.5);
		tx.scale(.75, .75);
		
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);   
		
	}
	
	public void collided() {
		vx=0;
		vy=0;
	}
	
	public void carCrash(Car c) {
		Rectangle r1 = new Rectangle(this.x+20, this.y+20, 25, 30);
		
		//Represent Coin as a rectangle
		Rectangle r2 = new Rectangle(c.getX()+10, c.getY()+10, 30, 30);
		
		if(r1.intersects(r2)) {
			vx=0;
			vy=0;
			c.collided();
			System.out.println("crash");
		}
	}
	
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}


	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}
	
	public void setX(int newX) {
		this.x = newX;
	}
	public void setY(int newY) {
		this.y = newY;
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

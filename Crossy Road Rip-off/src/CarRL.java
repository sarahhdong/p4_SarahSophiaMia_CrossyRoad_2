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
//			if(y<=200) {
//				x = 700;
//				y = 100;
//				init(x,y);
//			}
////			if(y<=100&&y>50) {
////				x = 700;
////				y = 100;
////				init(x,y);
////			}
			if(y<400) {//middle car
				x = 700;
				y = 350;
				init(x,y);
			}
			else if(y<800) {//BOTTOM car
				x = 700;
				y = 650;
				init(x,y);
			}

			else{//top car
				x = 700;
				y = 100;
				init(x,y);
			}
		}


		tx.setToTranslation(x, y);
		tx.scale(.75, .75);
		
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);   
		
	}
	
	public void collided() {
		vx=0;
		vy=0;
	}
	public void carCrash2(CarRL c) {
		Rectangle r1 = new Rectangle(this.x+20, this.y+20, 25, 30);
		
		//Represent Coin as a rectangle
		Rectangle r2 = new Rectangle(c.getX()+10, c.getY()+10, 30, 30);
		 
		if(r1.intersects(r2)) {
			vx=0;
			vy=0;
			c.collided();
			//System.out.println("crash2");
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
			URL imageURL = CarRL.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
}

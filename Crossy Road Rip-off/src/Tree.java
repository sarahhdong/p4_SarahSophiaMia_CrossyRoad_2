import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Tree {
	
	private int x, y;
	private double vx, vy;
	private Image img; // image of the frog
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	
	public Tree(int x, int y) {
		img = getImage("Tree(short).png");
		
		init(x,y);
		this.x = x;
		this.y = y;
		
		
		//x = setX;
		//y = setY;
		
	}
	
	public void paint(Graphics g) {//hope this works
	

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
	
	public void Collided() {
		
		x = 1000;
		y = 1000;
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
	
	
	


}

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Chicken implements MouseListener{
	private int x = 150,y = 600;
	private int vx, vy;
	private Image img; // image of the duck
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	int collect = 0;
	int count = 0;
	
	int collide=0;
	
	Music chirp = new Music("chirp.wav", false);
	public Chicken() {
		img = getImage("crossy_road_chicken.png"); //load the image for Tree
		init(x, y); 				//initialize the location of the image
	}
	
	
	public void paint(Graphics g) {

		x += vx;
		y += vy;
		if(y<0) {
			x=150;
			y=600;
			init(x, y); 
		}
		if(x>650) {
			vx=0;
			x=650;
			init(x, y); 
		}
		if(x<0) {
			vx=0;
			x=0;
			init(x, y); 
		}

		//call this line of code any time there is an update to x and y
		tx.setToTranslation(x, y); // must call this any time you update x and y;
		tx.scale(0.75, 0.75);
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);   
		}
	
	public void jump() {
			y-=36;
			x+=20;
			vx=0;
			if(count%3 ==0) {
				chirp.play();
			}
			count++;

			init(x,y);
		
	}
	public void left() {
		x-=20;
		y-=8;
		vx=0;
		init(x,y);
	
}
	public void right() {
		x+=20;
		y+=8;
		vx=0;
		init(x,y);
	
}
	public void stop() {
		vx=0;
		vy=0;
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Chicken.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	public void TreeCollide(Tree t) {
		
		//represent the 2 objects as Rectangles and check for intersection
		Rectangle r1 = new Rectangle(this.x+20, this.y+20, 25, 40);
		
		//Represent Coin as a rectangle
		Rectangle r2 = new Rectangle(t.getX()+10, t.getY()+10, 30, 40);
		
		if(r1.intersects(r2)) {
			x=150;
			y=600;
			System.out.println("tree");
		}
	}
	 
public void TallTreeCollide(TallTree t) {
		
		//represent the 2 objects as Rectangles and check for intersection
		Rectangle r1 = new Rectangle(this.x+20, this.y+20, 25, 40);
		
		//Represent Coin as a rectangle
		Rectangle r2 = new Rectangle(t.getX()+10, t.getY()+10, 30, 40);
		
		if(r1.intersects(r2)) {
			x=150;
			y=600;
			System.out.println("tall tree");
		}
	}
	
	public void CoinCollide(Coin c) {

		//represent the 2 objects as Rectangles and check for intersection
		Rectangle r1 = new Rectangle(this.x+20, this.y+25, 30, 40);
		
		//Represent Coin as a rectangle
		Rectangle r2 = new Rectangle(c.getX(), c.getY(), 20, 20);
		
		if(r1.intersects(r2)) {
			c.Collided();
			System.out.println("hi");
			collect++;
		}
			
	}
	public int CarCollide(Car c) {
		
		
		//represent the 2 objects as Rectangles and check for intersection
		Rectangle r1 = new Rectangle(this.x+20, this.y+20, 25, 30);
		
		//Represent Coin as a rectangle
		Rectangle r2 = new Rectangle(c.getX()+10, c.getY()+10, 30, 30);
		
		if(r1.intersects(r2)) {
			x=150;
			y=600;
			c.collided();
			System.out.println("car");
			collide=0;
		}
		return collide;
	}
		public int CarCollide(CarRL c) {
			
			//represent the 2 objects as Rectangles and check for intersection
			Rectangle r1 = new Rectangle(this.x+20, this.y+20, 25, 30);
			
			//Represent Coin as a rectangle
			Rectangle r2 = new Rectangle(c.getX()+10, c.getY()+10, 30, 30);
			
			if(r1.intersects(r2)) {
				x=150;
				y=600;
				c.collided();
				System.out.println("car");
				collide=1;
			}
			return collide;
				
			
	}
		

	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}
	public int getCollect() {
		// TODO Auto-generated method stub
		return collect;
	}


	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}
}

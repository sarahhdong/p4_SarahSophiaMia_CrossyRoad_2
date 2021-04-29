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
	private int x = 200,y = 500;
	private int vx, vy;
	private Image img; // image of the duck
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);

	public Chicken() {
		img = getImage("crossy_road_chicken.png"); //load the image for Tree
		init(x, y); 				//initialize the location of the image
//		vx = (int)(Math.random()*(4-3+1))+2;
//		vy = -3;
//		if(Math.random()<.5) {
//			vx*=-1;
//		}
	}
	
	
	public void paint(Graphics g) {

		x += vx;
		y += vy;
		
		//reset velocity if hits bottom of frame
//		if(y>=600) {
//			vx = (int)(Math.random()*(4-3+1))+1;
//			vy = -3;
//			if(Math.random()<.5) {
//				vx*=-1;
//			}
//
//		}
//		//if duck hits the sides of the frame, it will bounce in the opposite direction
//		if(x <= 0 || x>= 800) {
//			vx *= -1;
//		}
//		//if duck hits top of frame, reinitialize behind grass
//		if(y <= 0) {
//			x = 200;
//			y = 500;
//			init(x,y);
//			}

		//call this line of code any time there is an update to x and y
		tx.setToTranslation(x, y); // must call this any time you update x and y;
		
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);   
		}
	//create a Music object for the sound-effects (names got mixed-up)
	Music soundBang = new Music("bang.wav", false); //actually Bang
	Music soundHaha = new Music("haha.wav", false); //probaly Thud
	Music soundQuack = new Music("quack.wav", false); //actually Quack
	Music soundThud = new Music("thud.wav", false); //actually Haha
	
	//when the mouse clicks on the duck
	public boolean collided(int mX, int mY) {
		System.out.println(mX+ ":"+mY);
		System.out.println(x+ ":"+y);
		Rectangle example = new Rectangle(x,y,150,150);
		
		//mouse clicks on duck
		if(example.contains(mX,mY)) {
		
			System.out.println("ouch");
			soundQuack.play();//plays Quack
			
			//ducks falls
			if(y<1000) {
				y-=10;
				x+=5;
				vx=0;
				//vy=-1;
			}
			init(x,y);

			return true;
		}
		
		return false;
	}
	
	public void jump() {
			y-=10;
			x+=5;
			vx=0;
			//vy=-1;
		init(x,y);
		
	}
	public void stop() {
		vx=0;
		vy = 0;
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
}

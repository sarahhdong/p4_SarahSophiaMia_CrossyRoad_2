import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	private int miss;
	//Objects that need to be drawn on the JFrame in the paint method.
	//1) write the code to create a Ground object as one of your instance variables
	Ground foreground = new Ground();
	
	//2) try the same thing with the Tree class
	Car car = new Car(0,180);
	Car car1 = new Car(0,100);
	Car car2 = new Car(0,0);
	Chicken chick = new Chicken();
	Dog dog = new Dog();
	
	//create a Music object for the sound-effects (names got mixed-up)
	Music chirp = new Music("chirp.wav", false);
	Music coin = new Music("coin.wav", false);
//	Music soundQuack = new Music("chirp.wav", false);
//	Music soundThud = new Music("coin.wav", false);
//	
	public void paint(Graphics g) {
		//invoke the paint methods of the foreground and tree objects
		super.paintComponent(g); //makes sure to refresh the jFrame properly
		car.paint(g);
		car1.paint(g);
		car2.paint(g);
		chick.paint(g);
		dog.paint(g);
		foreground.paint(g);

		
		

	}
	
	public static void main(String[] arg) {
		Frame f = new Frame();
	}
	
	public Frame() {
		JFrame f = new JFrame("Duck Hunt");
		f.setSize(new Dimension(700, 700));
		f.setBackground(Color.blue);
		f.add(this);
		f.addMouseListener(this);
		f.addKeyListener(this);
		f.setResizable(false);
		
		Timer t = new Timer(16, this);
	
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	/*scale pictures
	 * tx.scale(2,2);
	 * 
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//figure out how to get the date to the object that needs it
		
		//what if we represent the mouse as a rectangle?
		//Rectangle m = new Rectangle(arg0.getX(), arg0.getY(), 50,50);
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
		chirp.play();
		int x = arg0.getX();// get mouse location
		int y = arg0.getY();
		
		//calls upon collided method from Duck.java
		chick.collided(x, y);
		
		//if mouse misses
		if(chick.collided(x, y) == false ){//&& duck1.collided(x,y) == false) {
			miss++;
			//if there are 3 misses, dog appears
			if(miss == 3) {
				dog.appear();
				coin.play();
				miss = 0;
			}else {
				dog.disappear();
			}
		}
		else {
			miss =0;
		}

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getKeyCode());
		
		
		switch(arg0.getKeyCode()) {
		//if keycode is space bar
		case 32:
			//chick.jump();
			break;
			
//		case 65:
//			System.out.println("stuff for left key using a");
//			break;
			
		}
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		chick.stop();
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

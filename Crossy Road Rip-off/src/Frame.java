import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import java.lang.Thread;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	private int miss;
	int collision = 0;
	// Objects that need to be drawn on the JFrame in the paint method.
	// 1) write the code to create a Ground object as one of your instance variables
	// welp
	Ground foreground = new Ground();

	int counter = 0;

	// 2) try the same thing with the Tree class
	Car car = new Car(0, 400);
	Car car1 = new Car(0, 100);
	Car car2 = new Car(320, 0);
//	Car car3 = new Car(500,0);
	CarRL carRL = new CarRL(700, 650);
	CarRL2 carRL1 = new CarRL2(700, 350);
	CarRL3 carRL2 = new CarRL3(700, 100);
	CarRL carRL3 = new CarRL(700, 50);
	Chicken chick = new Chicken();
	LandingPage landingPage = new LandingPage();
	FinalPage deadPage = new FinalPage();
	WinPage winPage = new WinPage();

	Coin c1 = new Coin();
	Coin c2 = new Coin();
	Coin c3 = new Coin();
	Coin c4 = new Coin();
	Coin c5 = new Coin();
	Coin c6 = new Coin();
	Coin c7 = new Coin();
	Coin c8 = new Coin();

	Tree t1 = new Tree(150, 10);
	Tree t2 = new Tree(500, 450);
	Tree t3 = new Tree(300, 370);
	Tree t4 = new Tree(100, 300);

	TallTree tt1 = new TallTree(500, 350);
	TallTree tt2 = new TallTree(350, 100);
	TallTree tt3 = new TallTree(70, 500);

	// create a Music object for the sound-effects (names got mixed-up)
	Music chirp = new Music("chirp.wav", false);
	Music coin = new Music("coin.wav", false);

	public void paint(Graphics g) {
		// invoke the paint methods of the foreground and tree objects
		super.paintComponent(g); // makes sure to refresh the jFrame properly
		
		foreground.paint(g);
		
		c1.paint(g);
		c2.paint(g);
		c3.paint(g);
		c4.paint(g);
		c5.paint(g);
		c6.paint(g);
		c7.paint(g);
		c8.paint(g);
		
		carRL.paint(g);
		carRL1.paint(g);
		carRL2.paint(g);
		carRL3.paint(g);
		car.paint(g);
		car1.paint(g);
		car2.paint(g);


		t1.paint(g);
		t2.paint(g);
		t3.paint(g);
		t4.paint(g);

		tt1.paint(g);
		tt2.paint(g);
		tt3.paint(g);
		
		chick.paint(g);

		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 20);
		g.setFont(font);
		g.setColor(Color.white);

		g.drawString(chick.getCollect() + "", 650, 30);
		

		landingPage.paint(g);
		
		
		
		if (chick.dead) {
			
			deadPage.paint(g);
			deadPage.appear();
			
		
			
		}
		if(chick.win) {
			
			winPage.paint(g);
			winPage.appear();
		}

		
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

	public void update() {
		// ask the ball to check for collisions
		
		
		chick.CoinCollide(c1);
		chick.CoinCollide(c2);
		chick.CoinCollide(c3);
		chick.CoinCollide(c4);
		chick.CoinCollide(c5);
		chick.CoinCollide(c6);
		chick.CoinCollide(c7);
		chick.CoinCollide(c8);

		chick.CarCollide(car);
		chick.CarCollide(car1);
		chick.CarCollide(car2);
		chick.CarCollide(carRL);
		chick.CarCollide(carRL1);
		chick.CarCollide(carRL2);
		chick.CarCollide(carRL3);
		

		chick.TreeCollide(t1);
		chick.TreeCollide(t2);
		chick.TreeCollide(t3);
		chick.TreeCollide(t4);

		chick.TallTreeCollide(tt1);
		chick.TallTreeCollide(tt2);
		chick.TallTreeCollide(tt3);

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

		int x = arg0.getX();
		int y = arg0.getY();

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
		update();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getKeyCode());

		switch (arg0.getKeyCode()) {

		// forward
		case 38:
			chick.jump();
			break;

		// right
		case 39:
			chick.right();
			break;

		// left
		case 37:
			chick.left();
			break;

		// final page button (space bar)
		case 32:
			
			chick.dead = false;
			if(!chick.dead) {
				deadPage.disappear();
				chick.setCollect();
				c1.reset();
				c2.reset();
				c3.reset();
				c4.reset();
				c5.reset();
				c6.reset();
				c7.reset();
				c8.reset();
				
			}
			chick.win =false;
			if(!chick.win) {
				winPage.disappear();
				chick.setCollect();
				c1.reset();
				c2.reset();
				c3.reset();
				c4.reset();
				c5.reset();
				c6.reset();
				c7.reset();
				c8.reset();
				
			}
			break;
		}

		update();

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

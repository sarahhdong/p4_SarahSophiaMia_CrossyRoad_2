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
	// Objects that need to be drawn on the JFrame in the paint method.
	// 1) write the code to create a Ground object as one of your instance variables
	Ground foreground = new Ground();
	int counter = 0;
	//cars
	Car car = new Car(0, 400);
	Car car1 = new Car(0, 100);
	Car car2 = new Car(320, 0);
	CarRL carRL = new CarRL(700, 650);
	CarRL2 carRL1 = new CarRL2(700, 350);
	CarRL3 carRL2 = new CarRL3(700, 100);
	CarRL carRL3 = new CarRL(700, 50);
	//chicken
	Chicken chick = new Chicken();
	//pages
	LandingPage landingPage = new LandingPage();
	FinalPage deadPage = new FinalPage();
	WinPage winPage = new WinPage();
	//coins
	Coin[] coins = new Coin[8];
	//trees
	Tree t1 = new Tree(150, 10);
	Tree t2 = new Tree(500, 450);
	Tree t3 = new Tree(300, 370);
	Tree t4 = new Tree(100, 300);
	TallTree tt1 = new TallTree(500, 350);
	TallTree tt2 = new TallTree(350, 100);
	TallTree tt3 = new TallTree(70, 500);

	// create a Music object for the sound-effects 
	Music chirp = new Music("chirp.wav", false);
	Music coin = new Music("coin.wav", false);

	public void paint(Graphics g) {
		// invoke the paint methods of the foreground and tree objects
		super.paintComponent(g); // makes sure to refresh the jFrame properly
		foreground.paint(g);
		for (int i = 0; i<coins.length; i++) {
			coins[i].paint(g);
		}
		//cars
		carRL.paint(g);
		carRL1.paint(g);
		carRL2.paint(g);
		carRL3.paint(g);
		car.paint(g);
		car1.paint(g);
		car2.paint(g);
		//trees
		t1.paint(g);
		t2.paint(g);
		t3.paint(g);
		t4.paint(g);
		tt1.paint(g);
		tt2.paint(g);
		tt3.paint(g);
		//chicken
		chick.paint(g);
		//coin collection counter
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 20);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString(chick.getCollect() + "", 650, 30);
		//landing page
		landingPage.paint(g);
		//paint dead page if chick dies
		if (chick.dead) {
			deadPage.paint(g);
			deadPage.appear();	
		}
		//paint win page if chick wins
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
		for (int i = 0; i<coins.length; i++) {
			coins[i] = new Coin();
		}
		Timer t = new Timer(16, this);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		t.start();
	}

	public void update() {
		// ask the ball to check for collisions
		for(int i = 0; i<coins.length; i++) {
			chick.CoinCollide(coins[i]);
		}

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
			//dead condition
			chick.dead = false;
			if(!chick.dead) {
				deadPage.disappear();
				chick.setCollect();
				for(int i = 0; i<coins.length; i++) {
					coins[i].reset();
				}	
			}
			//won condition 
			chick.win =false;
			if(!chick.win) {
				winPage.disappear();
				chick.setCollect();
				for(int i = 0; i<coins.length; i++) {
					coins[i].reset();
				}
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

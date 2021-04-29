import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener {
	private int miss;
	//Objects that need to be drawn on the JFrame in the paint method.
	//1) write the code to create a Ground object as one of your instance variables
	Ground foreground = new Ground();
	
	//2) try the same thing with the Tree class
	Tree tree = new Tree();
	Duck duck = new Duck();
	Duck duck1 = new Duck();
	Dog dog = new Dog();
	
	//create a Music object for the sound-effects (names got mixed-up)
	Music soundBang = new Music("bang.wav", false);
	Music soundHaha = new Music("haha.wav", false);
	Music soundQuack = new Music("quack.wav", false);
	Music soundThud = new Music("thud.wav", false);
	
	public void paint(Graphics g) {
		//invoke the paint methods of the foreground and tree objects
		super.paintComponent(g); //makes sure to refresh the jFrame properly
		duck.paint(g);
		duck1.paint(g);
		dog.paint(g);
		foreground.paint(g);
		tree.paint(g);
		
		

	}
	
	public static void main(String[] arg) {
		Frame f = new Frame();
	}
	
	public Frame() {
		JFrame f = new JFrame("Duck Hunt");
		f.setSize(new Dimension(900, 600));
		f.setBackground(Color.blue);
		f.add(this);
		f.addMouseListener(this);
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
		soundBang.play();
		int x = arg0.getX();// get mouse location
		int y = arg0.getY();
		
		//calls upon collided method from Duck.java
		duck.collided(x, y);
		duck1.collided(x, y);
		
		//if mouse misses
		if(duck.collided(x, y) == false && duck1.collided(x,y) == false) {
			miss++;
			//if there are 3 misses, dog appears
			if(miss == 3) {
				dog.appear();
				soundThud.play();
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

}
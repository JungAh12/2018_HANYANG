package game;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.Timer;
public class work extends JPanel implements ActionListener {


	private int HEIGHT = 500;
	private int WIDTH = 700;
	private int space;
	private int speed;
	private int width =80;
	private int height =70;
	private Rectangle human;
	private Random random;
	Timer t;
	private ArrayList <Rectangle> ohuman;
	public work() {
		t = new Timer(20,this);
		random =new Random( ) ;
		ohuman = new ArrayList<Rectangle>();
		human = new Rectangle(WIDTH/2, HEIGHT-100, width, height);
		space =300;
		speed = 2;
		addhuman(true);
		t.start();
	}
	public void addhuman(boolean first) {
		int positionx=random.nextInt() %2;
		int x=0;
		int y =0;
		int Width =width;
		int Height=height;
		if(positionx==0) {
			x = Width/2;
			}
		else {
			x = Width/2+10;
		}
		if(first) {
			ohuman.add(new Rectangle(x, y, Width, Height));
		}
		else {
			ohuman.add(new Rectangle(x, x,Width, Height));
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.MAGENTA);
		for (Rectangle rect:(ohuman)) {
			g.fillRect(rect.x, rect.y, rect.width, rect.height);
		}
	}
	
	public static void main(String[] args) {
		JFrame app = new JFrame();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
		work w = new work();
		app.add(w);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(500 , 720);
		app.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0) {		
		Rectangle rect;
		for (int i=0; i<ohuman.size(); i++) {
			rect = ohuman.get(i);
			rect.y += speed;
		}
	repaint();
	}
	
  }

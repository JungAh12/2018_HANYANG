

import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class Human extends JFrame implements Runnable,ActionListener, KeyListener {
	private JPanel panel = new JPanel();
	ImageIcon image;// jw : Human image
	final int move =10;
	JLabel lb;
	
	private double time;
	private int state;
	private double speed;
	
	
	Human() {
		this.speed=10;
		this.state = 1;
		this.time = 40;
		
		putImg();
		panel.setLayout(null);
		lb.addKeyListener(this);
		setTitle("Human code");
		setSize(300,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(true);
		lb.requestFocus();
	}
	public void putImg() {
		image = new ImageIcon("C:\\man.png");
		lb = new JLabel(image,JLabel.CENTER);
		lb.setVerticalTextPosition(JLabel.CENTER);
		lb.addKeyListener(this);
		add(lb);
	}
	
	public void eating_Item(String item) {
		double game_Time = 0;
		switch(item) {
		case "water" :
			game_Time +=3;
			break;
		case "wingShoes" :
			speed+=5;
			game_Time =2;
			break;
		case "clock" :
			time +=3;
			break;
		}
	}
	
	public void eating_Obstacle(String item) {
		double game_Time = 0;
		switch(item) {
		case "drunken" :
			game_Time =1;
			speed =0;
			break;
		case "cat" :
			game_Time=0.5;
			speed=0;
			break;
		case "grandma" :
			game_Time =3;
			speed =0;
			break;
		case "emergency" :
			game_Time =2;
			speed =0;
			break;
		case "trash" :
			game_Time =0.5;
			speed =0;
			break;
		case "manhole" :
			state = 0;
			break;
		}
	}
	
	public void clear_Stage(int stage_Number) { 
		switch(stage_Number) {
		case 1:
			//next_Stage(stage_Number);
			break;
		case 2:
			//next_Stage(stage_Number);
			break;
		case 3:
			//clear();
			break;
			}
	}
	
	public void run() {
	}
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
	}

	
	public void keyPressed(KeyEvent e) {// 키보드 이벤트
		int keyCode = e.getKeyCode();
		switch(keyCode) {
		case KeyEvent.VK_RIGHT :
			lb.setLocation(lb.getX()+move, lb.getY());
			break;
		case KeyEvent.VK_LEFT :
			lb.setLocation(lb.getX()-move, lb.getY());
			break;
	}
	}
		public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
		
	public static void main(String[] args) {
		
	 Human exam = new Human();
	 
	 }
	
}
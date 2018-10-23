

import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class Human  implements KeyListener {
	public static JLabel panel = new JLabel();
	ImageIcon image;// jw : Human image
	final int move =10;
	//JLabel lb;
	
	private double time;
	private int state;
	private double speed;
	
	
	Human() {
		this.speed=10;
		this.state = 1;
		this.time = 40;
		
		putImg();
		panel.addKeyListener(this);
		panel.setFocusable(true);
		
		//this.requestFocus();
	}
	public void putImg() {
		image = new ImageIcon("man.png");
		panel.setIcon(image);
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



	
	public void keyPressed(KeyEvent e) {// 키보드 이벤트
		int keyCode = e.getKeyCode();
		switch(keyCode) {
		case KeyEvent.VK_RIGHT :
			panel.setLocation(panel.getX()+move, panel.getY());
			System.out.println(panel.getX());
			break;
		case KeyEvent.VK_LEFT :
			panel.setLocation(panel.getX()-move, panel.getY());
			break;
		case KeyEvent.VK_UP :
			panel.setLocation(panel.getX(), panel.getY()-move);
			break;
		case KeyEvent.VK_DOWN :
			panel.setLocation(panel.getX(), panel.getY()+move);
			break;
	}
	}
		public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
	
}
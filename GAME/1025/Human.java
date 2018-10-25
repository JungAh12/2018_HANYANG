

import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import java.util.ArrayList;

import javax.swing.*;

public class Human extends JLabel implements KeyListener {
	
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
		this.setLocation(500,500);
		putImg();
		this.addKeyListener(this);
		this.setFocusable(true);
		
		//this.requestFocus();
	}
	public void putImg() {
		image = new ImageIcon("man.png");
		this.setIcon(image);
		this.setBounds(500, 500, 30, 30);
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
			this.setLocation(this.getX()+move, this.getY());
			MainPage.stage1.actionPerformed(null);
			break;
		case KeyEvent.VK_LEFT :
			this.setLocation(this.getX()-move, this.getY());
			MainPage.stage1.actionPerformed(null);
			break;
		case KeyEvent.VK_UP :
			this.setLocation(this.getX(), this.getY()-move);
			MainPage.stage1.actionPerformed(null);
			break;
		case KeyEvent.VK_DOWN :
			this.setLocation(this.getX(), this.getY()+move);
			MainPage.stage1.actionPerformed(null);
			break;
	}
	}
		public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
	
	
}
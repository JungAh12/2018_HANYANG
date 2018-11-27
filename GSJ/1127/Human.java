

import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import java.util.ArrayList;

import javax.swing.*;

public class Human extends JLabel implements KeyListener {
	
	ImageIcon image;// jw : Human image
	final int move =40;
	//JLabel lb;

	public static int width = 100;
	public static int height = 100;
	public static int score = 0;
	
	Human() {
	
		this.setLocation(500,600);
		putImg();
		this.addKeyListener(this);
		this.setFocusable(true);
		
		//this.requestFocus();
	}
	public void putImg() {
		image = new ImageIcon(this.getClass().getResource("bear.gif"));
		this.setIcon(image);	
		this.setSize(width, height);
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
			
	}
		
	}
		public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
	
	
}
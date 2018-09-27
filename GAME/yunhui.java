package yangyang;

import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class yunhui extends JFrame implements Runnable,ActionListener, KeyListener {
	private JPanel panel = new JPanel();
	ImageIcon image;
	final int move =10;
	JLabel lb;
	yunhui() {
		init();
		panel.setLayout(null);
		lb.addKeyListener(this);//라벨에 키보드이벤트를 붙여준다
		setTitle("yuni's code");
		setSize(300,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(true);
		lb.requestFocus();
	}
	public void init() {//runnable을 사용했기에 init과 run을 사용한다.
		image = new ImageIcon("C:\\Users\\user\\Desktop\\pacman.png");//이미지를 불러운다
		lb = new JLabel(image, JLabel.CENTER);//라벨을 중앙에 설정
		lb.setVerticalTextPosition(JLabel.CENTER);
		lb.setHorizontalTextPosition(JLabel.RIGHT);
		lb.addKeyListener(this);
		add(lb);
	}
	
	public void run() {
	}
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
	}
	public static void main(String[] args) {
		
	 yunhui exam = new yunhui();
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
}
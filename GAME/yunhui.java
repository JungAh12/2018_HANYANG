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
		lb.addKeyListener(this);//�󺧿� Ű�����̺�Ʈ�� �ٿ��ش�
		setTitle("yuni's code");
		setSize(300,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(true);
		lb.requestFocus();
	}
	public void init() {//runnable�� ����߱⿡ init�� run�� ����Ѵ�.
		image = new ImageIcon("C:\\Users\\user\\Desktop\\pacman.png");//�̹����� �ҷ����
		lb = new JLabel(image, JLabel.CENTER);//���� �߾ӿ� ����
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
	
	public void keyPressed(KeyEvent e) {// Ű���� �̺�Ʈ
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
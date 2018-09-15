package game;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class Movement_Test extends JFrame{

	Dimension screenSize;
	double width, height;
	int x = 0, y = 0;
	JPanel panel = new MyPanel();
	
	public static void main(String[] args) {
		
		new Movement_Test();
	}
	
	public Movement_Test(){
		
		//��ũ�� �ػ�
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = screenSize.getWidth();
		height = screenSize.getHeight();
		int x = 50, y = 50;
		this.x = 300; this.y = 200;		

		//������ ����
		setBounds((int)width/3, (int)height/3, 500, 500);	//������ â ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//�ݱ� ��ư ���
		setTitle("Testing Window");							//â ����
		setVisible(true);									//â �ð�ȭ
		
		setContentPane(panel);	//Ű �Է� ���� �� �ְ� ��Ŀ�� ��.
		
	}

	class MyPanel extends JPanel
	{
		public MyPanel() {
			//Ű ������ ���
			addKeyListener(new KeyListener() {

				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub					
				}

				@Override
				public void keyPressed(KeyEvent e) {
					
					// TODO Auto-generated method stub
					switch(e.getKeyCode()) {
					case KeyEvent.VK_LEFT :
						x += 10;
						repaint();
						break;
					case KeyEvent.VK_RIGHT : 
						x -= 10; 
						repaint();
						break;
					}
				}

				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
			
			this.requestFocus();	//������Ʈ�� �̺�Ʈ�� ���� �� �ְ� ��
			setFocusable(true);
		}
		
		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(Color.BLACK);
			g.fillRect(getBounds().width-x, getBounds().height-y, 100, 100);
			
		}
	}
}


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
		
		//스크린 해상도
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = screenSize.getWidth();
		height = screenSize.getHeight();
		int x = 50, y = 50;
		this.x = 300; this.y = 200;		

		//윈도우 생성
		setBounds((int)width/3, (int)height/3, 500, 500);	//윈도우 창 세팅
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//닫기 버튼 등록
		setTitle("Testing Window");							//창 제목
		setVisible(true);									//창 시각화
		
		setContentPane(panel);	//키 입력 받을 수 있게 포커스 줌.
		
	}

	class MyPanel extends JPanel
	{
		public MyPanel() {
			//키 리스너 등록
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
			
			this.requestFocus();	//컴포넌트가 이벤트를 받을 수 있게 함
			setFocusable(true);
		}
		
		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(Color.BLACK);
			g.fillRect(getBounds().width-x, getBounds().height-y, 100, 100);
			
		}
	}
}


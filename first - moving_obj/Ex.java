import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Ex extends JFrame {
	
	private JPanel ep = new exPanel("USER","A",200);//200ms
	public Ex() {
		setTitle("A가 USER를 따라다니는 예시");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(ep);
		
		setSize(800,500);
		setVisible(true);
		
		ep.setFocusable(true);
		ep.requestFocus();
		
	}
	
	class exPanel extends JPanel{
		private String userChar;
		private String AChar;
		private long ADelay;
		private JLabel user;
		private JLabel A; 
		final int USER_MOVE=10;//USER는 한번에 10픽셀 씩이동
		
		public exPanel(String userChar,String AChar, long ADelay ) {
			this.userChar = userChar;
			this.AChar = AChar;
			this.ADelay = ADelay;
			
			
			user = new JLabel(userChar);
			A = new JLabel(AChar);
			
			
			setLayout(null);
			addKeyListener(new MyKeyListener());
			
			
			user.setLocation(50,50);//처음 위치
			user.setSize(40,15);//크기
			user.setForeground(Color.BLUE);
			add(user);
			
			A.setLocation(200,5);
			A.setSize(15,15);
			A.setForeground(Color.RED);
			add(A);
			
			AThread ath = new AThread(A, user, ADelay);
			ath.start();
			
			this.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					JPanel panel = (JPanel)e.getSource();
					panel.requestFocus();
				}
			});
			
			
		
			
			
		}
		class MyKeyListener extends KeyAdapter{
			@Override
			public void keyPressed(KeyEvent e) {
				
				int keyCode = e.getKeyCode();
				
				switch(keyCode) {
				case KeyEvent.VK_UP:
					user.setLocation(user.getX(),user.getY()-USER_MOVE);
					break;
				case KeyEvent.VK_DOWN: 
					user.setLocation(user.getX(), user.getY()+USER_MOVE); 
					break;
				case KeyEvent.VK_LEFT: 
					user.setLocation(user.getX()-USER_MOVE, user.getY()); 
					break;
				case KeyEvent.VK_RIGHT: 
					user.setLocation(user.getX()+USER_MOVE, user.getY()); 
					break;	
					
				}//switch
				
				user.getParent().repaint();//USER의 위치가 변경되었으므로 다시그리기 지시
				//USER가 있는 패널에는 이전 위치에 있었던 USER지워야하기때문에 부모 패널에게 다시그리기 지시
			}
		} //MyKeyListener
		
		
		//생성자에 두개의 레이블 컴포넌트. 
		//A레이블을 움직이는 스레드. 200ms 5픽셀 움직임. 
		class AThread extends Thread{
			private JLabel from;//쫓아가는 레이블. A
			private JLabel to;// 도망가는 레이블. USER
			private long ADelay;//A 는200ms 당 5 픽셀씩 이동
			private final int A_MOVE = 5;
			
			public AThread(JLabel from, JLabel to, long ADelay) {
				this.from = from;
				this.to = to;
				this.ADelay = ADelay;
			}
			
			@Override
			public void run() {
				int x = from.getX(),y = from.getY();//현재 A위치 
				while (true) {
					if(to.getX()<from.getX())//USER가 A의 왼쪽에 위치하면
						x = from.getX()-A_MOVE;//A가 -5만큼 오른쪽으로 이동
					else 
						x = from.getX()+A_MOVE;
					if(to.getY()<from.getY())
						y = from.getY()-A_MOVE;
					else
						y = from.getY()+A_MOVE;
					
					//A 위치 수정
					from.setLocation(x,y);
					
					//A 위치가 변경되었으므로 A가 포함된 패널을 다시 그리자?
					from.getParent().repaint();
					
					
					try {
						sleep(ADelay);
					}catch(InterruptedException e) {
						return;
					}//???
				}
				
				
			}
			
			
		}
		
		
		
	}
	public static void main(String [] args) {
		new Ex();
	}

}

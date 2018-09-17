import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Ex extends JFrame {
	
	private JPanel ep = new exPanel("USER","A",200);//200ms
	public Ex() {
		setTitle("A�� USER�� ����ٴϴ� ����");
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
		final int USER_MOVE=10;//USER�� �ѹ��� 10�ȼ� ���̵�
		
		public exPanel(String userChar,String AChar, long ADelay ) {
			this.userChar = userChar;
			this.AChar = AChar;
			this.ADelay = ADelay;
			
			
			user = new JLabel(userChar);
			A = new JLabel(AChar);
			
			
			setLayout(null);
			addKeyListener(new MyKeyListener());
			
			
			user.setLocation(50,50);//ó�� ��ġ
			user.setSize(40,15);//ũ��
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
				
				user.getParent().repaint();//USER�� ��ġ�� ����Ǿ����Ƿ� �ٽñ׸��� ����
				//USER�� �ִ� �гο��� ���� ��ġ�� �־��� USER�������ϱ⶧���� �θ� �гο��� �ٽñ׸��� ����
			}
		} //MyKeyListener
		
		
		//�����ڿ� �ΰ��� ���̺� ������Ʈ. 
		//A���̺��� �����̴� ������. 200ms 5�ȼ� ������. 
		class AThread extends Thread{
			private JLabel from;//�Ѿư��� ���̺�. A
			private JLabel to;// �������� ���̺�. USER
			private long ADelay;//A ��200ms �� 5 �ȼ��� �̵�
			private final int A_MOVE = 5;
			
			public AThread(JLabel from, JLabel to, long ADelay) {
				this.from = from;
				this.to = to;
				this.ADelay = ADelay;
			}
			
			@Override
			public void run() {
				int x = from.getX(),y = from.getY();//���� A��ġ 
				while (true) {
					if(to.getX()<from.getX())//USER�� A�� ���ʿ� ��ġ�ϸ�
						x = from.getX()-A_MOVE;//A�� -5��ŭ ���������� �̵�
					else 
						x = from.getX()+A_MOVE;
					if(to.getY()<from.getY())
						y = from.getY()-A_MOVE;
					else
						y = from.getY()+A_MOVE;
					
					//A ��ġ ����
					from.setLocation(x,y);
					
					//A ��ġ�� ����Ǿ����Ƿ� A�� ���Ե� �г��� �ٽ� �׸���?
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

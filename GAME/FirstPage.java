
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;;

public class FirstPage extends JFrame{
	private final int BUTTON_LOCATION_X = 480;
	private final int BUTTON_LOCATION_Y = 400;
	
	JLabel timerLabel = new JLabel();
	TimerThread th = new TimerThread(timerLabel);
	
	public FirstPage() {
		
		setTitle("FirstPage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		
		timerLabel.setFont(new Font("Gothic",Font.ITALIC,20));
		timerLabel.setLocation(0,0);
		timerLabel.setSize(50,30);
		timerLabel.setOpaque(true);
		timerLabel.setBackground(Color.LIGHT_GRAY);
		
		JButton button_gamestart = new JButton("게임 시작");
		button_gamestart.setLocation(BUTTON_LOCATION_X,BUTTON_LOCATION_Y);
		button_gamestart.setSize(240,40);
		button_gamestart.addActionListener(new ActionListener_gamestart());
		
		JButton button_exit = new JButton("나가기");
		button_exit.setLocation(BUTTON_LOCATION_X,BUTTON_LOCATION_Y+100);
		button_exit.setSize(240,40);
		button_exit.addActionListener(new ActionListener_exit());
		
		JButton button_setting = new JButton("ABCD");		
		button_setting.setLocation(BUTTON_LOCATION_X,BUTTON_LOCATION_Y+200);
		button_setting.setSize(240,40);
		
		
		c.add(button_setting);
		c.add(button_gamestart);
		c.add(button_exit);
		c.add(timerLabel);
		

		setSize(1200, 800); 
		setVisible(true);
		
	}
	
	class ActionListener_gamestart implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			th.start();
			
		}
	}	
	class ActionListener_exit implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	



	public static void main(String[] args) {
		new FirstPage();
	}

}
	class TimerThread extends Thread{
		private JLabel timerLabel;
		
		public TimerThread(JLabel timerLabel) {
			this.timerLabel = timerLabel;
		}
		
		@Override
		public void run() {
			double n=0;
			while(n<=40) {
				timerLabel.setText(Double.toString(n));
				n++;
				try {
					Thread.sleep(1000);
				}
				catch(InterruptedException e) {return;}
			}
		}
		
	}
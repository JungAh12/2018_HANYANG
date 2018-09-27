
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;;

public class FirstPage {
	private final int BUTTON_LOCATION_X = 480;
	private final int BUTTON_LOCATION_Y = 400;
	JButton button_gamestart;
	JButton button_exit;
	JButton button_setting;
	JFrame frame = new JFrame();
	JLabel timerLabel = new JLabel();
	TimerThread th = new TimerThread(timerLabel);
	JPanel c = new JPanel();
	public FirstPage() {
		
		frame.setTitle("FirstPage");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		timerLabel.setFont(new Font("Gothic",Font.ITALIC,20));
		timerLabel.setLocation(0,0);
		timerLabel.setSize(50,30);
		timerLabel.setOpaque(true);
		timerLabel.setBackground(Color.LIGHT_GRAY);
		
		button_gamestart = new JButton("���� ����");
		button_gamestart.setLocation(BUTTON_LOCATION_X,BUTTON_LOCATION_Y);
		button_gamestart.setSize(240,40);
		button_gamestart.addActionListener(new ActionListener_gamestart());
		
		button_exit = new JButton("������");
		button_exit.setLocation(BUTTON_LOCATION_X,BUTTON_LOCATION_Y+100);
		button_exit.setSize(240,40);
		button_exit.addActionListener(new ActionListener_exit());
		
		button_setting = new JButton("ABCD");		
		button_setting.setLocation(BUTTON_LOCATION_X,BUTTON_LOCATION_Y+200);
		button_setting.setSize(240,40);
		
		frame.getContentPane().add(c);
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		c.add(button_setting);
		c.add(button_gamestart);
		c.add(button_exit);
		c.add(timerLabel);
		

		frame.setSize(1200, 800); 
		frame.setVisible(true);
		
	}
	
	class ActionListener_gamestart implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			button_gamestart.setVisible(false);
			button_exit.setVisible(false);
			button_setting.setVisible(false);
			
			work w = new work();

			frame.add(w);
			frame.validate();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			th.start();
			
		}
	}	
	class ActionListener_exit implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	



	public static void main(String[] args) {
		
		FirstPage n = new FirstPage();
		}

}
	class TimerThread extends Thread{
		private JLabel timerLabel;
		
		public TimerThread(JLabel timerLabel) {
			this.timerLabel = timerLabel;
		}
		
		@Override
		public void run() {
			double n=40;
			while(n>=0) {
				timerLabel.setText(Double.toString(n));
				n--;
				try {
					Thread.sleep(1000);
				}
				catch(InterruptedException e) {return;}
			}
		}
		
	}
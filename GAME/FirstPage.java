package game;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;;

//한정원:FirstPage관리자 페이지

public class FirstPage{
	private final int BUTTON_LOCATION_X = 480;
	private final int BUTTON_LOCATION_Y = 400;
	static JFrame app;
	JLabel timerLabel = new JLabel();
	TimerThread th = new TimerThread(timerLabel);
	Container c;
	JButton button_gamestart = new JButton("게임 시작");
	JButton button_exit = new JButton("나가기");
	JButton button_setting = new JButton("ABCD");
	
	class work extends JPanel implements ActionListener {


		private int HEIGHT = 500;
		private int WIDTH = 700;
		private int space;
		private int speed;
		private int width =80;
		private int height =70;
		private Rectangle human;
		private Random random;
		Timer t;
		private ArrayList <Rectangle> ohuman;
		
		
		public work() {
			System.out.println("사각형");
			t = new Timer(20,this);
			random = new Random( ) ;
			ohuman = new ArrayList<Rectangle>();
			human = new Rectangle(WIDTH/2, HEIGHT-100, width, height);
			space =300;
			speed = 2;
			addhuman(true);
			t.start();
		}
		public void addhuman(boolean first) {
			int positionx=random.nextInt() %2;
			int x=0;
			int y =0;
			int Width =width;
			int Height=height;
			if(positionx==0) {
				x = Width/2;
				}
			else {
				x = Width/2+10;
			}
			if(first) {
				ohuman.add(new Rectangle(x, y, Width, Height));
			}
			else {
				ohuman.add(new Rectangle(x, x,Width, Height));
			}
		}
		@Override
		public void paintComponent(Graphics g) {
			System.out.println("action");
			super.paintComponent(g);
			g.setColor(Color.MAGENTA);
			for (Rectangle rect:(ohuman)) {
				g.fillRect(rect.x, rect.y, rect.width, rect.height);
			}
		}
		
		
		public void actionPerformed(ActionEvent arg0) {		
			
			Rectangle rect;
			for (int i=0; i<ohuman.size(); i++) {
				rect = ohuman.get(i);
				rect.y += speed;
			}
		repaint();
		}
		
	  }
	
	public FirstPage() {
	
		c = app.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		
		timerLabel.setFont(new Font("Gothic",Font.ITALIC,20));
		timerLabel.setLocation(0,0);
		timerLabel.setSize(50,30);
		timerLabel.setOpaque(true);
		timerLabel.setBackground(Color.LIGHT_GRAY);
		
		
		button_gamestart.setLocation(BUTTON_LOCATION_X,BUTTON_LOCATION_Y);
		button_gamestart.setSize(240,40);
		button_gamestart.addActionListener(new ActionListener_gamestart());
		
		
		button_exit.setLocation(BUTTON_LOCATION_X,BUTTON_LOCATION_Y+100);
		button_exit.setSize(240,40);
		button_exit.addActionListener(new ActionListener_exit());
		
				
		button_setting.setLocation(BUTTON_LOCATION_X,BUTTON_LOCATION_Y+200);
		button_setting.setSize(240,40);
		
		
		c.add(button_setting);
		c.add(button_gamestart);
		c.add(button_exit);
		c.add(timerLabel);
		

		
	}
	
	class ActionListener_gamestart implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			button_gamestart.setVisible(false);
			button_exit.setVisible(false);
			button_setting.setVisible(false);

			new StageOne();

		}
	}	
	class ActionListener_exit implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	class StageOne{
		public StageOne() {
			th.start();
			app.getContentPane().remove(c);
			work w = new work();
			app.getContentPane().add(w);
			app.revalidate();
			app.repaint();
	
		}
	}
	
	public void next_Stage(int stageNumber) {
		switch(stageNumber) {
		
		//case 1 : new StageTwo();break;
		//case 2 : new StageThree();break;
		
		}
		
	}
	public void Clear() {
		
		JLabel clearLabel = new JLabel();
		ImageIcon clearImg = new ImageIcon("dsklf.jpg");
		clearLabel.setIcon(clearImg);
		c.add(clearLabel);
		clearLabel.setLocation(50,50);
		
	}



	public static void main(String[] args) {
			app = new JFrame();
			app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			app.setVisible(true);
			app.setSize(1200, 800); 
			
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
	

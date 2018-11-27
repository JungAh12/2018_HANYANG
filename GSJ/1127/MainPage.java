import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;
import java.util.Timer;

public class MainPage{

	public static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	public static int width_s = gd.getDisplayMode().getWidth();
	public static int height_s = gd.getDisplayMode().getHeight();
	
	//jungah : BUTTON POSITION
	private final int BUTTON_LOCATION_X = 480;
	private final int BUTTON_LOCATION_Y = 400;
	public boolean isStart = false;
	

	JButton button_gamestart;
	JButton button_exit;
	JButton button_setting;
	
	ImageIcon logoimg;

	static JFrame frame = new JFrame();
	JPanel main_panel = new JPanel();					//Main screen panel
	JLabel backlabel = new JLabel();
	static JLabel imageLabel = new JLabel();	
	
	static nextstage start_video;
	public static HYGame stage1;
	static Boolean endVideo = false;
	
	/*----jungah : start video off object-------*/
	//jungah : after 4sec, execute
	java.util.Timer video_timer = new Timer();

	TimerTask video_task = new TimerTask() {

		@Override

		public void run() {

			//jungah : Video off

			start_video.setInvisible();

			//jungah : stage1 start

			stage1_start();

		}

	};
	
	public MainPage(){
		
		frame.setTitle("First Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon startb = new ImageIcon(this.getClass().getResource("startB.jpg"));
		ImageIcon exitb = new ImageIcon(this.getClass().getResource("exitB.jpg"));
		ImageIcon settingb = new ImageIcon(this.getClass().getResource("settingB.jpg"));
		//ImageIcon bgimg = new ImageIcon("startpage.jpg");
		ImageIcon bgimg = new ImageIcon(this.getClass().getResource("startpage.jpg"));
		backlabel.setIcon(bgimg);
		backlabel.setSize(1200,800);
		backlabel.setLocation(0,0);
		
		//jungah : button setting
		button_gamestart = new JButton();
		button_gamestart.setIcon(startb);
		button_gamestart.setLocation(BUTTON_LOCATION_X, BUTTON_LOCATION_Y);
		button_gamestart.setSize(240, 40);
		button_gamestart.addActionListener(new ActionListener_gamestart());
		
		button_exit = new JButton();
		button_exit.setIcon(exitb);
		button_exit.setLocation(BUTTON_LOCATION_X, BUTTON_LOCATION_Y+100);
		button_exit.setSize(240, 40);
		button_exit.addActionListener(new ActionListener_exit());
		
		button_setting = new JButton("setting");
		button_setting.setIcon(settingb);
		button_setting.setLocation(BUTTON_LOCATION_X, BUTTON_LOCATION_Y+200);
		button_setting.setSize(240, 40);
		button_setting.addActionListener(new ActionListener_setting());
		
		logoimg = new ImageIcon(this.getClass().getResource("gsj.jpg"));
		imageLabel.setIcon(logoimg);	
		imageLabel.setSize(200,125);
		imageLabel.setLocation(525, 200);
		
		//jungah : Add Main Panel to frame
		frame.getContentPane().add(main_panel);
		
		//jungah : panel setting, Add buttons & label
		main_panel.setLayout(null);
		
		main_panel.add(backlabel);
		main_panel.add(button_gamestart);
		main_panel.add(button_exit);
		main_panel.add(button_setting);
		main_panel.add(imageLabel);

		//jungah : frame setting

		//frame.setSize(width_s,height_s);
		frame.setSize(1200, 800);
		frame.setVisible(true);
		
		//frame.setAlwaysOnTop(true);
		
	}
	
	public static void stage1_start() {
		frame.setFocusable(false);
		
		//jungah : All component remove
		frame.getContentPane().removeAll();
		
		//jungah : Create Game Class
		stage1 = new HYGame();
		stage1.setName("stage1");

		frame.add(stage1);
		frame.setName("MAINPAGE");
		//jungah : Add Game Panel to frame
		frame.setContentPane(stage1);
		System.out.print(stage1.getParent().getName());
		
	}
	
	public static void gameover(int score) {
		frame.getContentPane().removeAll();
		nextstage gg = new nextstage();
		frame.add(gg);
		frame.setContentPane(gg);
		
	}
	//jungah : button Action Listener
	class ActionListener_gamestart implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			//jungah : Game Start, buttons not visible
			button_gamestart.setVisible(false);
			button_exit.setVisible(false);
			button_setting.setVisible(false);
			
			//jungah : video start
			start_video = new nextstage(true);
	
			frame.add(start_video);
			frame.setContentPane(start_video.imageLabel);
			video_timer.schedule(video_task,4000);

			
		}
	}
	
	class ActionListener_exit implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	class ActionListener_setting implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("setting page");
		}
	}
	//jungah : main function
	public static void main(String[] args) {
		new MainPage();
	}
}

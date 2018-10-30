import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.Timer;

public class MainPage {
	//jungah : BUTTON POSITION
	private final int BUTTON_LOCATION_X = 480;
	private final int BUTTON_LOCATION_Y = 400;
	public boolean isStart = false;
	final int ITEM_NUM_EX = 9;
	
	
	JButton button_gamestart;
	JButton button_exit;
	JButton button_setting;
	
	JFrame frame = new JFrame();
	JPanel main_panel = new JPanel();					//Main screen panel
	static JLabel timer_label = new JLabel();
	public static TimerThread timer = new TimerThread(timer_label);
	
	PlayVideo start_video;
	public static HYGame stage1;
	Boolean endVideo = false;
	
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
		
		//jungah : timer setting
		timer_label.setFont(new Font("Gothic", Font.ITALIC, 20));
		timer_label.setLocation(0, 0);
		timer_label.setSize(50, 30);
		timer_label.setOpaque(true);
		timer_label.setBackground(Color.LIGHT_GRAY);
		
		//jungah : button setting
		button_gamestart = new JButton("START");
		button_gamestart.setLocation(BUTTON_LOCATION_X, BUTTON_LOCATION_Y);
		button_gamestart.setSize(240, 40);
		button_gamestart.addActionListener(new ActionListener_gamestart());
		
		button_exit = new JButton("EXIT");
		button_exit.setLocation(BUTTON_LOCATION_X, BUTTON_LOCATION_Y+100);
		button_exit.setSize(240, 40);
		button_exit.addActionListener(new ActionListener_exit());
		
		button_setting = new JButton("SETTING");
		button_setting.setLocation(BUTTON_LOCATION_X, BUTTON_LOCATION_Y+200);
		button_setting.setSize(240, 40);
		button_setting.addActionListener(new ActionListener_setting());
		
		//jungah : Add Main Panel to frame
		frame.getContentPane().add(main_panel);
		
		//jungah : panel setting, Add buttons & label
		main_panel.setLayout(null);
		main_panel.setBackground(Color.WHITE);
		
		main_panel.add(button_gamestart);
		main_panel.add(button_exit);
		main_panel.add(button_setting);
		
		//ImageIcon water = new ImageIcon("water.png");
		
		Item item[] =new Item[ITEM_NUM_EX];
		
		
		
		
		try 
		{	
			item[0] = new Item("water.png",50,50);
			item[1] = new Item("cat.png",50,50);
			item[2] = new Item("clock.png",50,50);
			item[3] = new Item("emergency.png",50,50);
			item[4] = new Item("manhole.png",50,50);
			item[5] = new Item("shoe.png",50,50);
			item[6] = new Item("grandma.png",100,100);
			item[7] = new Item("trash.png",50,50);
			item[8] = new Item("druken.png",150,100);
			//File path = new File("water.png");
			
			JLabel[] ex = new JLabel[ITEM_NUM_EX];
			Image image;
			ImageIcon img[] = new ImageIcon[ITEM_NUM_EX];
			
			for(int i=0;i<ITEM_NUM_EX;i++) {
			
			image = ImageIO.read(item[i].path);
			image = image.getScaledInstance(item[i].width, item[i].height, java.awt.Image.SCALE_SMOOTH);
			
			img[i] = new ImageIcon(image);
			ex[i] = new JLabel();
			ex[i].setIcon(img[i]);
			ex[i].setLocation(50*i+item[i].width,0);
			ex[i].setSize(100,100);
			main_panel.add(ex[i]);
			
			}
			
			
			

				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
		
		//jungah : frame setting
		frame.setSize(1200, 800);
		frame.setVisible(true);
		
		
		
	}
	
	public void stage1_start() {
		//jungah : All component remove
		frame.getContentPane().removeAll();
		
		//jungah : Create Game Class
		stage1 = new HYGame();
		stage1.setName("stage1");
		
		//jungah : Add timer_label
		
		stage1.add(timer_label);
		
		//jungah : Add Game Panel to frame
		frame.setContentPane(stage1);
		
		
		//jungah : total game timer = 40
		timer.start();
	}
	//jungah : button Action Listener
	class ActionListener_gamestart implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			//jungah : Game Start, buttons not visible
			button_gamestart.setVisible(false);
			button_exit.setVisible(false);
			button_setting.setVisible(false);
			
			//jungah : video start
			start_video = new PlayVideo();
	
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

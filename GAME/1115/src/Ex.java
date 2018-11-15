
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.awt.*;

	public class Ex extends JFrame {
		private final int MOVE = 10;
		private int user_x = 550;
		private int user_y = 650;
		JLabel user;
		JLabel mouse;
		
		private JLabel la = new JLabel("No Mouse Event");
		
		static ImageIcon ChangeSize(String path, int width, int hight){
		    ImageIcon Icon = new ImageIcon(path);
		    Image image = Icon.getImage();
		    Image newimg = image.getScaledInstance(width, hight,  java.awt.Image.SCALE_DEFAULT);
		    Icon = new ImageIcon(newimg);
		    return Icon;
		}
		
		public Ex() {
			setTitle("asdfadsfdsfds");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container c = getContentPane();
			c.setLayout(null);
			
			MyMouseListener listener = new MyMouseListener();
			c.addMouseListener(listener);
			c.addMouseMotionListener(listener); 
			
			
			ImageIcon imgcon = ChangeSize("bear.gif", 100, 100);
			
			user = new JLabel();
			
			user.setSize(100, 100);
			user.setLocation(475, 291);
			user.setIcon(imgcon);
	
			c.addKeyListener(new MyKeyListener());
			c.addMouseListener(new MyMouseListener());
			
			
			
			la.setLocation(550,0);
			la.setSize(200, 20);
			c.add(la);
			c.add(user);
			c.setFocusable(true);
			c.requestFocus();
			setSize(1200,800);
			setVisible(true);
			}
		
		class MyMouseListener extends MouseAdapter { 

			public void mouseMoved(MouseEvent e) {
				la.setText("("+e.getX()+","+e.getY()+")");
			}
				
			}
		
		class MyKeyListener extends KeyAdapter{
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				
				if(code==e.VK_LEFT) {
					user_x = user.getX()-MOVE;
					user.setLocation(user_x,user_y);
					//user.setIcon(new ImageIcon("left.png"));
					}
				else if (code==e.VK_RIGHT) {
					user_x = user.getX()+MOVE;
					user.setLocation(user_x,user.getY());
					//user.setIcon(new ImageIcon("left2.png"));
					}
			}
		}
		
	}
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.Timer;

public class HYGame extends JPanel implements ActionListener{
	//anel hyPanel = new JPanel();
	final int ITEM_NUM_EX = 9;
	Item item[] =new Item[ITEM_NUM_EX];
	
	private int HEIGHT = 500;
	private int WIDTH = 700;
	private int space;
	private int speed;
	private int width =80;
	private int height =70;
	private Item bgImg;
	private Item Item;
	private Random random;
	Timer timer;						//jungah : human moving time
	//private ArrayList <Item> ohuman; //jungah : human ArrayList
	public ArrayList <Item> oItem; //jungah : Item ArrayList
	Human human;
	JLabel[] example;
	ImageIcon img[];
	Image image;
	
	public HYGame() {
		
		//timer = new Timer(20,this);
		random =new Random() ;
		//jungah : Create human rect, items rect
		 
		this.setLayout(null);
		human = new Human();
		this.add(human);
		
		//ohuman = new ArrayList<Item>();
		oItem = new ArrayList<Item>();
		
		space =300;
		speed = 2;
		
		
		this.setVisible(true);
		
		//addhuman(true);
		addItem();
		//timer.start();
	}
	
	public void addItem(){
		try 
		{
			item[0] = new Item("water.png",100,100);
			item[1] = new Item("cat.png",100,100);
			item[2] = new Item("clock.png",100,100);
			item[3] = new Item("emergency.png",100,100);
			item[4] = new Item("manhole.png", 100,100);
			item[5] = new Item("shoe.png",100,100);
			item[6] = new Item("grandma.png",70,70);
			item[7] = new Item("trash.png",100,100);
			item[8] = new Item("druken.png",100,100);
			
		//jungah : randomly create Item Item
	
		example = new JLabel[ITEM_NUM_EX];
		img = new ImageIcon[ITEM_NUM_EX];
		
		for(int i = 0 ; i < ITEM_NUM_EX ; i++) {
			int positionx = random.nextInt(1100);
			int positiony = random.nextInt(700);
			oItem.add(item[i]);	
			oItem.get(i).x = positionx;
			oItem.get(i).y = positiony;
			System.out.println(oItem.size()+"sisisisisisisi");
			image = ImageIO.read(item[i].path);
			image = image.getScaledInstance(item[i].width, item[i].height, java.awt.Image.SCALE_SMOOTH);
			
			img[i] = new ImageIcon(image);
			example[i] = new JLabel();
			example[i].setIcon(img[i]);
			example[i].setLocation(positionx,positiony);
			example[i].setSize(100,100);
			
			this.add(example[i]);

		}
		
			
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
		
		
	}
	

		
	public void actionPerformed(ActionEvent arg0) {		

		
		for(int i = 0 ; i < oItem.size(); i++) {
			collisionDetection(human, oItem);			//jungah : human detects items			
		}
		repaint();
	}

	
	public void collisionDetection(Human human, ArrayList<Item> Item) {
		Item[] item_arr = (Item[]) Item.toArray(new Item[0]);	//jungah : ArrayList -> Item[]
		//jungah : upper left (x1,y1), bottom right(x2,y2) save "class Point"
		class Point{
			int x1,x2,y1,y2;
			public Point(Item item_arr) {
				this.x1 = item_arr.x;
				this.x2 = item_arr.width + this.x1;
				this.y1 = item_arr.y;
				this.y2 = this.y1 + item_arr.height;
			}
			
			public Point(Human human) {
				this.x1 = human.getX();
				this.x2 = this.x1 + human.WIDTH;
				this.y1 = human.getY();
				this.y2 = this.y1 + human.HEIGHT;
			}
			
		}
		
		Point human_p = new Point(human);		//jungah : human point
		Point[] item_p = new Point[item_arr.length];	//jungah : items point
		
		for (int i = 0; i<item_p.length; i++) {
			item_p[i] = new Point(item_arr[i]);
		}
		if(human_p.y2<800) {
			for(int i = 0; i<item_p.length; i++)
			{
				
				//jungah : item detection
				if(((human_p.x1<item_p[i].x2)&&(item_p[i].x1<human_p.x2))&&
				((human_p.y1<item_p[i].y2)&&(item_p[i].y1<human_p.y2))) {
					//System.out.println("human_pos = ["+human_p.x1+","+human_p.y1+"],,,,item pos = "+(item[i].path)+"번째 "+"["+item_p[i].x1+","+item_p[i].y1+"]");
					//jungah : detection true
					item_p[i] = null;
					item_arr[i] = null;
					this.remove(example[i]);
					oItem.remove(i);
				
				MainPage.timer.gameTime+=5;
		
				}
				System.out.println(i+"번째 남은 아이템:"+item[i].path+"["+item_p[i].x1+","+item_p[i].y1+"]");
				
			}
		}
	}
	
		

}

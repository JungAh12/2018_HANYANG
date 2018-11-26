import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;


public class HYGame extends JPanel implements ActionListener{
	//anel hyPanel = new JPanel();
	private int HEIGHT = 800;
	private int WIDTH = 1200;
	private int space;
	private int speed;
	private int width =15;
	private int height =80;
	int life = 3;
	private Rectangle bgImg;
	private Rectangle Item;
	private Random random;
	private JLabel backlabel;
	Image img;
	File path = new File("./src\\background.jpg");
	JLabel life1 = new JLabel();
	JLabel life2 = new JLabel();
	JLabel life3 = new JLabel();
	ImageIcon lifeimg;
	int cnt = 0;
	int dwheight = 800;
	int ITEM_NUM = 10;

	//private ArrayList <Rectangle> ohuman; //jungah : human ArrayList
	public ArrayList <Item> oItem; //jungah : Item ArrayList
	Human human;
	Rectangle dw;
	public ArrayList <Color> c = new ArrayList<Color>();
	public static Color[] collist = {Color.BLACK,Color.decode("#FFF900"), Color.decode("#00FF7B"),Color.decode("#A900FF"),Color.decode("#FF4800"),Color.decode("#00FFFB")};

	class Point{
		int x1,x2,y1,y2;
		public Point(Rectangle rect) {
			this.x1 = rect.x;
			this.x2 = rect.width + this.x1;
			this.y1 = rect.y;
			this.y2 = this.y1 + rect.height;
		}
		
		public Point(Human human) {
			this.x1 = human.getX();
			this.x2 = this.x1 + human.width;
			this.y1 = human.getY();
			this.y2 = this.y1+ human.height;
		}
		
	}
	
	Point human_p;		//jungah : human point
	Point[] item_p;	//jungah : items point
	
	public HYGame() {
		
		try {
			life = 3;
			img = ImageIO.read(path);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		dw = new Rectangle();
		random =new Random() ;
		//jungah : Create human rect, items rect
		this.setLayout(null);
		human = new Human();
		this.add(human);
		/*quest = new Quest();
		quest.setLocation(800,800);
		quest.setSize(100,100);
		this.add(quest);
		*/
		//ohuman = new ArrayList<Rectangle>();
		oItem = new ArrayList<Item>();
		
		space =300;
		speed = 2;
		
		lifeimg = new ImageIcon(this.getClass().getResource("bear.png"));
		life1.setIcon(lifeimg);	
		life2.setIcon(lifeimg);	
		life3.setIcon(lifeimg);	
		
		life1.setSize(100,100);
		life1.setLocation(100, 0);
		
		life2.setSize(100,100);
		life2.setLocation(200, 0);
		
		life3.setSize(100,100);
		life3.setLocation(300, 0);
		this.add(life1);
		this.add(life2);
		this.add(life3);
		//addhuman(true);
		addItem();
	}
	
	public void addItem() {

		//jungah : randomly create Item rectangle
		int Width =width;
		int Height=height;
		
		
		for(int i = 0; i<ITEM_NUM;i++) {
			int positionx = random.nextInt(this.WIDTH);
			int positiony = - random.nextInt(1000);
			c.add(collist[random.nextInt(collist.length-1)]);
			oItem.add(new Item(c.get(c.size()-1), positionx, positiony, Width, Height));
		}
	}
	
	public void paintComponent(Graphics g) {
	
		if(life==0) {
			try {
				img = ImageIO.read(new File("./src/next.gif"));

				g.drawImage(img, 0, 0, this);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gameOver();
			
		}else {
			human.requestFocus();
		System.out.println("item개수 : "+life);
		super.paintComponent(g);
		cnt++;
		g.drawImage(img, 0, 0, this);
		//g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, dwheight, 1200, 10000);
		for (int i = 0 ; i<oItem.size(); i++) {
			Rectangle rect = oItem.get(i).getr();
			g.setColor(oItem.get(i).c);
			g.fillRect(rect.x, rect.y, rect.width, rect.height);
			if(cnt % 250 == 0) {

				rect.y+=30;
			}
		}
		if(oItem.size()<=5&&life!=0) {
			
			addItem();
		}
		}
		repaint();
		
	}
		
	public void actionPerformed(ActionEvent arg0) {
		
		//for (int i=0; i<oItem.size(); i++) {
			if(life==0)
				gameOver();
			collisionDetection(human, oItem);
	//	}
		
	
		
	}

	
	public void collisionDetection(Human human, ArrayList<Item> Item) {
		ArrayList<Rectangle> item = new ArrayList<Rectangle>();
		Rectangle[] item_arr = new Rectangle[item.size()];
		
		for(int i = 0 ; i <Item.size();i++) { 
			item.add(Item.get(i).getr());	//jungah : ArrayList -> Rectangle[]
			item_arr = (Rectangle[]) item.toArray(new Rectangle[0]);
		}
		//jungah : upper left (x1,y1), bottom right(x2,y2) save "class Point"
		human_p = new Point(human);		//jungah : human point
		item_p = new Point[item_arr.length];	//jungah : items point
		
		for (int i = 0; i<item_p.length; i++) {
			item_p[i] = new Point(item_arr[i]);
			
		}
		
			for(int i = 0; i<item_p.length; i++)
			{
				//jungah : item detection
				if(((human_p.x1<item_p[i].x2)&&(item_p[i].x1<human_p.x2))&&
				((human_p.y1<item_p[i].y2)&&(item_p[i].y1<human_p.y2))) {
				
					//jungah : detection true
					if(oItem.get(i).c == Color.BLACK) {
						this.remove(this.getComponentCount()-1);
						--life;
					}
					else {
						
					human.score += 10;
					
					}
					item_p[i] = null;
					item_arr[i] = null;
					oItem.remove(i);
					
				}
				else {
					if(item_p[i].y1 > 750) {
						item_p[i] = null;
						item_arr[i] = null;
						oItem.remove(i);
					
					}
				}
			}
			
		
	}

		
public void gameOver() {


	this.removeAll();
	oItem = null;
	human = null;
	
}
}

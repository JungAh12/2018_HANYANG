import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;


public class HYGame extends JPanel implements ActionListener{
	//anel hyPanel = new JPanel();
	private int HEIGHT = 800;
	private int WIDTH = 1200;
	private int space;
	private int speed;
	private int width =80;
	private int height =70;
	private Rectangle bgImg;
	private Rectangle Item;
	private Random random;
	int cnt = 0;
	int dwheight = 700;
	Timer timer;						//jungah : human moving time
	int ITEM_NUM = 10;
	//private ArrayList <Rectangle> ohuman; //jungah : human ArrayList
	public ArrayList <Rectangle> oItem; //jungah : Item ArrayList
	Human human;
	Rectangle dw;
	public ArrayList <Color> c;
	public static Color[] collist = {Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN, Color.PINK};
	public Quest quest;
	
	public HYGame() {
		dw = new Rectangle();
		//timer = new Timer(20,this);
		random =new Random() ;
		//jungah : Create human rect, items rect
		bgImg = new Rectangle(WIDTH/2, HEIGHT-100, width, height); 
		Item = new Rectangle(WIDTH/2, HEIGHT-100, width, height);
		this.setLayout(null);
		human = new Human();
		this.add(human);
		/*quest = new Quest();
		quest.setLocation(800,800);
		quest.setSize(100,100);
		this.add(quest);
		*/
		//ohuman = new ArrayList<Rectangle>();
		oItem = new ArrayList<Rectangle>();
		
		space =300;
		speed = 2;
		
		
		this.setVisible(true);
		
		//addhuman(true);
		addItem();
		//timer.start();
	}
	
	public void addItem() {

		//jungah : randomly create Item rectangle
		int Width =width;
		int Height=height;
		
		c = new ArrayList<Color>();
		for(int i = 0 ; i < ITEM_NUM ; i++) {
			int positionx = random.nextInt(this.WIDTH);
			int positiony = - random.nextInt(1000);
			oItem.add(new Rectangle(positionx, positiony, Width, Height));
			c.add(collist[random.nextInt(collist.length-1)]);
			
		}
	}
	
	public void paintComponent(Graphics g) {
 
		super.paintComponent(g);
		cnt++;
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, dwheight, 1200, 10000);
		for (int i = 0 ; i<oItem.size(); i++) {
			Rectangle rect = oItem.get(i);
	
			g.setColor(c.get(i));
			g.fillRect(rect.x, rect.y, rect.width, rect.height);
			if(cnt % 250 == 0) {
				rect.y+=30;
				
				if(rect.y >= this.HEIGHT) {
					
					System.out.println("높이노핑"+this.HEIGHT/ITEM_NUM);
					System.out.println("상자"+dwheight);
					
					dwheight -= this.HEIGHT/oItem.size();
				
					oItem.remove(i);
					c.remove(i);
				}
			}
			
		}
		
	
		repaint();
		
	}
		
	public void actionPerformed(ActionEvent arg0) {
		
		for (int i=0; i<oItem.size(); i++) {
	
			collisionDetection(human, oItem);
		}
		
	
		
	}

	
	public void collisionDetection(Human human, ArrayList<Rectangle> Item) {
		Rectangle[] item_arr = (Rectangle[]) Item.toArray(new Rectangle[0]);	//jungah : ArrayList -> Rectangle[]
		//jungah : upper left (x1,y1), bottom right(x2,y2) save "class Point"
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
				this.x2 = this.x1 + human.WIDTH;
				this.y1 = human.getY();
				this.y2 = this.y1+ human.HEIGHT;
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
				System.out.println("human_pos = ["+human_p.x1+","+human_p.y1+"],,,,item pos = ["+item_p[i].x1+","+item_p[i].y1+"]");
				//jungah : item detection
				if(((human_p.x1<item_p[i].x2)&&(item_p[i].x1<human_p.x2))&&
				((human_p.y1<item_p[i].y2)&&(item_p[i].y1<human_p.y2))) {
					//jungah : detection true
					item_p[i] = null;
					item_arr[i] = null;
					oItem.remove(i);
					c.remove(i);
				MainPage.timer.gameTime+=5;
				
				
				
				}
			}
		}
	}
	class questRect extends Rectangle{
		
		public Color c;
		public int num;
		
	}

	class Quest extends JLabel {
		Random random = new Random();
		public questRect [] rectList = new questRect[2];
		Quest(){
			
			rectList[0].c = HYGame.collist[random.nextInt(HYGame.collist.length)];
			rectList[1].c = HYGame.collist[random.nextInt(HYGame.collist.length)];
			
			rectList[0].num = random.nextInt(5);
			rectList[1].num = random.nextInt(5);
		
			this.setBounds(rectList[0]);
			this.setBounds(rectList[1]);
			
		}
	}
		

}

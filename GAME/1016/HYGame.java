import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class HYGame extends JPanel implements ActionListener{

	private int HEIGHT = 500;
	private int WIDTH = 700;
	private int space;
	private int speed;
	private int width =80;
	private int height =70;
	private Rectangle human;
	private Rectangle Item;
	private Random random;
	Timer timer;						//jungah : human moving time
	private ArrayList <Rectangle> ohuman; //jungah : human ArrayList
	private ArrayList <Rectangle> oItem; //jungah : Item ArrayList
	
	public HYGame() {
		
		timer = new Timer(20,this);
		random =new Random() ;
		//jungah : Create human rect, items rect
		human = new Rectangle(WIDTH/2, HEIGHT-100, width, height); 
		Item = new Rectangle(WIDTH/2, HEIGHT-100, width, height);
		
		ohuman = new ArrayList<Rectangle>();
		oItem = new ArrayList<Rectangle>();
		
		space =300;
		speed = 2;
		
		this.setVisible(true);
		addhuman(true);
		addItem();
		timer.start();
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
	public void addItem() {

		//jungah : randomly create Item rectangle
		int Width =width;
		int Height=height;
		int ITEM_NUM = 10;
		
		for(int i = 0 ; i < ITEM_NUM ; i++) {
			int positionx = random.nextInt(1200);
			int positiony = random.nextInt(800);
			oItem.add(new Rectangle(positionx, positiony, Width, Height));	
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (Rectangle rect:(ohuman)) {
			g.setColor(Color.MAGENTA);
			g.fillRect(rect.x, rect.y, rect.width, rect.height);
		}
		
		for (Rectangle rect:(oItem)) {
			g.setColor(Color.BLACK);
			g.fillRect(rect.x, rect.y, rect.width, rect.height);
		}
	}
		
	public void actionPerformed(ActionEvent arg0) {		
		Rectangle rect;
		for (int i=0; i<ohuman.size(); i++) {
			rect = ohuman.get(i);
			rect.y += speed;
			collisionDetection(rect, oItem);			//jungah : human detects items
		}
	repaint();
	}
	
	public void collisionDetection(Rectangle human, ArrayList<Rectangle> Item) {
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
					//jungah : detection true
					item_p[i] = null;
					item_arr[i] = null;
					oItem.remove(i);
				}
			}
		}
	}
}

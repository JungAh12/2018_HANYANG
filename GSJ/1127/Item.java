import java.awt.Color;
import java.awt.Rectangle;

public class Item extends Rectangle{

	Color c;
	Rectangle r;
	
	Item(Color c, int x, int y, int width, int height){
		
		this.c = c;
		this.r = new Rectangle(x,y,width,height);
	}
	Rectangle getr() {
		return r;
	}
}

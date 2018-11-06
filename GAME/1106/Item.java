import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Item{
	File path;
	int width;
	int height;
	JLabel ex = new JLabel();
	Image image;
	ImageIcon img = new ImageIcon();
	public int x;
	public int y;
	
	public Item(String path,int width,int height) {
		this.path = new File(path);
		this.width = width;
		this.height = height;
		
		
		try {
			image = ImageIO.read(this.path);
			image = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
			
			img = new ImageIcon(image);
			ex = new JLabel();
			ex.setIcon(img);
			ex.setSize(width, height);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}


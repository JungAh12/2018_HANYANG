import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

/*----------jungah : video play----------------*/
public class nextstage extends JPanel{
	static JLabel imageLabel = new JLabel();											
	static ImageIcon img;
	
	
	public nextstage(){
		/*img = new ImageIcon(this.getClass().getResource("gameover.gif"));
		imageLabel.setIcon(img);
		this.add(imageLabel);
		this.setVisible(true);
		this.setSize(1200,800);
		this.setLocation(0,0);
		
	}*/
		img = new ImageIcon(this.getClass().getResource("4.gif"));

		imageLabel.setIcon(img);	

		imageLabel.setSize(1200,800);

	}
	
	public nextstage(boolean i) {
		/*img = new ImageIcon(this.getClass().getResource("gameover.gif"));
		imageLabel.setIcon(img);
		this.add(imageLabel);
		this.setVisible(true);
		this.setSize(1200,800);
		this.setLocation(0,0);
		*/
		img = new ImageIcon(this.getClass().getResource("4.gif"));

		imageLabel.setIcon(img);	

		imageLabel.setSize(1200,800);
		
	}
	
	/*----jungah : invisible img label function---*/
	public void setInvisible() {
		this.imageLabel.setVisible(false);

		img = null;

		imageLabel = null;
			
	}

}

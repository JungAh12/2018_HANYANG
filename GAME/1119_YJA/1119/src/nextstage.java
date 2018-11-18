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
	ImageIcon img;
	
	public nextstage(){
		System.out.println("nexenxenxnenene");
		img = new ImageIcon(this.getClass().getResource("next.gif"));
		imageLabel.setIcon(img);	
		imageLabel.setSize(500,500);
	}
	
	/*----jungah : invisible img label function---*/
	public void setInvisible() {
		this.imageLabel.setVisible(false);
		img = null;
		imageLabel = null;
	}
}

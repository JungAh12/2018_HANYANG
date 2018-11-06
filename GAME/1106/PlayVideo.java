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
public class PlayVideo extends JPanel{
	JLabel imageLabel = new JLabel();											
	ImageIcon img;
	
	public PlayVideo(){

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

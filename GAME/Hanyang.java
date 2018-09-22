import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

/*---------������ Ŭ����------------*/
class Item{
	private double time;
	private String state;
	private double speed;
	
	public Item(double time, String state, double speed){
		time = this.time;
		state = this.state;
		speed = this.speed;
	}
	
	
}
/*--------------------------------*/

/*-------------��ֹ� Ŭ����------------*/
class Obstacle{
	private double time;
	
	public Obstacle(double time){
		time = this.time;
	}
}
/*---------------------------------*/

/*----------���� ����----------------*/
public class Hanyang extends JFrame{
	
	JPanel contentPane;																//�гμ���
	JLabel imageLabel = new JLabel();												//�гο� �߰��� �̹��� ���̺� ����
	
	public static void main(String argc[]) {
		
		/*-----Item ���� (���� ���� Ȯ��x)--------*/
		Item water = new Item(0,"damageZero",0);
		Item wingShoes =new Item(0,null,1.5);
		Item clock = new Item(3.0,null,0);
		
		/*-----Obstacle ���� (���� ���� Ȯ��x)--------*/
		Obstacle drunken = new Obstacle(1.0);
		Obstacle cat = new Obstacle(0.5);
		Obstacle grandma = new Obstacle(3.0);
		Obstacle emergency = new Obstacle(2.0);
		Obstacle trash = new Obstacle(0.5);
		Obstacle manhole = new Obstacle(100.0);
		
		new Hanyang();																//�������
		
	}
	
	public Hanyang(){
		try {
			setDefaultCloseOperation(EXIT_ON_CLOSE);								//�ݱ� ��ư Ȱ��ȭ
			contentPane = (JPanel)getContentPane();									//�Է��� �ޱ����� ��Ŀ�� Ȱ��ȭ
			contentPane.setLayout(new BorderLayout());								//������Ҹ� ���ϴ� ���� ��ġ�� �� �ִ� ���̾ƿ�
			setSize(new Dimension(500,500));										//������ ������ ����
			setTitle("Hanyang");													//������ Ÿ��Ʋ ����
			
			ImageIcon img = new ImageIcon(this.getClass().getResource("4.gif"));	//ǥ���ϰ��� �ϴ� �̹��� ������ ����
			imageLabel.setIcon(img);												//JLabel�� �̹��� ����
			contentPane.add(imageLabel, java.awt.BorderLayout.CENTER);				//JPanel�� �߰�
			this.setLocationRelativeTo(null);										//â �߾ӿ� ������ �����ϰ� ��
			this.setVisible(true);													//�ð�ȭ
		}
		catch(Exception e) {														//���� ������ catch��
			e.printStackTrace();
		}
	}
}
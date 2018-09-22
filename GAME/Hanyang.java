import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

/*---------아이템 클래스------------*/
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

/*-------------장애물 클래스------------*/
class Obstacle{
	private double time;
	
	public Obstacle(double time){
		time = this.time;
	}
}
/*---------------------------------*/

/*----------영상 띄우기----------------*/
public class Hanyang extends JFrame{
	
	JPanel contentPane;																//양정아 : 패널선언
	JLabel imageLabel = new JLabel();												//양정아 : 패널에 추가할 이미지 레이블 생성
	
	public static void main(String argc[]) {
		
		/*-----Item 생성 (인자 아직 확정x)--------*/
		Item water = new Item(0,"damageZero",0);
		Item wingShoes =new Item(0,null,1.5);
		Item clock = new Item(3.0,null,0);
		
		/*-----Obstacle 생성 (인자 아직 확정x)--------*/
		Obstacle drunken = new Obstacle(1.0);
		Obstacle cat = new Obstacle(0.5);
		Obstacle grandma = new Obstacle(3.0);
		Obstacle emergency = new Obstacle(2.0);
		Obstacle trash = new Obstacle(0.5);
		Obstacle manhole = new Obstacle(100.0);
		
		new Hanyang();																//양정아 : 영상띄우기
		
	}
	
	public Hanyang(){
		try {
			setDefaultCloseOperation(EXIT_ON_CLOSE);								//양정아 : 닫기 버튼 활성화
			contentPane = (JPanel)getContentPane();									//양정아 : 입력을 받기위한 포커스 활성화
			contentPane.setLayout(new BorderLayout());								//양정아 : 구성요소를 원하는 곳에 배치할 수 있는 레이아웃
			setSize(new Dimension(500,500));										//양정아 : 윈도우 사이즈 설정
			setTitle("Hanyang");													//양정아 : 윈도우 타이틀 설정
			
			ImageIcon img = new ImageIcon(this.getClass().getResource("4.gif"));	//양정아 : 표시하고자 하는 이미지 아이콘 생성
			imageLabel.setIcon(img);												//양정아 : JLabel에 이미지 설정
			contentPane.add(imageLabel, java.awt.BorderLayout.CENTER);				//양정아 : JPanel에 추가
			this.setLocationRelativeTo(null);										//양정아 : 창 중앙에 윈도우 생성하게 함
			this.setVisible(true);													//양정아 : 시각화
		}
		catch(Exception e) {														//양정아 : 동작 에러시 catch문
			e.printStackTrace();
		}
	}
}

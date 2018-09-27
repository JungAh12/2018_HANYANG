
import java.awt.event.ActionListener;

public class Human implements ActionListener {
	private double time;
	private int state;
	private double speed;
	
	public Human() {
		this.speed = 10;
		this.state = 1;
		this.time = 40;
	}
	
	public void eating_Item(String item) {
		
		double game_Time = 0;
		switch(item) {
		case "water" :
			game_Time +=3;
			break;
		case "wingShoes" :
			speed+=5;
			game_Time =2;
			break;
		case "clock" :
			time +=3;
			break;
		}
	}
	public void eating_Obstacle(String item){
		
		double game_Time = 0;
		switch(item) {
		case "drunken" :
			game_Time =1;
			speed =0;
			break;
		case "cat" :
			game_Time=0.5;
			speed=0;
			break;
		case "grandma" :
			game_Time =3;
			speed =0;
			break;
		case "emergency" :
			game_Time =2;
			speed =0;
			break;
		case "trash" :
			game_Time =0.5;
			speed =0;
			break;
		case "manhole" :
			state = 0;
			break;
		}
		
	}
public void clear_Stage(int stage_Number) {
	switch(stage_Number) {
	case 1:
		next_Stage(stage_Number);
		break;
	case 2:
		next_Stage(stage_Number);
		break;
	case 3:
		clear();
		break;
		}
	}
}


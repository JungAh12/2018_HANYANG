import javax.swing.JLabel;

/* GAME TIMER */
public class TimerThread extends Thread{
		private JLabel timerLabel;
		public static double gameTime;
		public TimerThread(JLabel timerLabel) {
			this.timerLabel = timerLabel;
			this.timerLabel.setLocation(600,0);
		}
		
		@Override
		public void run() {
			gameTime = 40;
			while(gameTime>=0) {
				if(gameTime>=40 ) {
					gameTime = 40;
				}
				timerLabel.setText(Double.toString(gameTime));
				gameTime--;
				
				try {
					Thread.sleep(1000);
				}
				catch(InterruptedException e) {return;}
			}
		}
		
	}
import javax.swing.JLabel;

/* GAME TIMER */
class TimerThread extends Thread{
		private JLabel timerLabel;
		double gameTime;
		public TimerThread(JLabel timerLabel) {
			this.timerLabel = timerLabel;
		}
		
		@Override
		public void run() {
			gameTime = 40;
			while(gameTime>=0) {
				timerLabel.setText(Double.toString(gameTime));
				gameTime--;
				try {
					Thread.sleep(1000);
				}
				catch(InterruptedException e) {return;}
			}
		}
		
	}
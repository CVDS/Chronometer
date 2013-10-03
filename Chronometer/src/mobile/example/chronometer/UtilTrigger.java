package mobile.example.chronometer;

import java.util.Timer;
import java.util.TimerTask;

public class UtilTrigger implements ITrigger{
	
	private Timer timer;
	private TimerTask task;
	private int counter;
	private ChronoMain chrono;

	public UtilTrigger(ChronoMain chrono){
		timer = new Timer();
		counter = 0;
		task = new TimerTask(){
            @Override
            public void run() {
                counter++;
            }
        };
        this.chrono = chrono;
	}
	
	@Override
	public void startTimer() {
		counter = 0;
		continueTimer();
	}

	@Override
	public void continueTimer() {
		timer.scheduleAtFixedRate(task, 1000, 1000);
	}

	@Override
	public void pauseTimer() {
		timer.cancel();
	}

	@Override
	public int getTime() {
		return counter;
	}

	@Override
	public void notifyChrono() {
		chrono.update();
	}

}

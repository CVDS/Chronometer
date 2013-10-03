package mobile.example.chronometer;

import android.os.Handler;

public class HandlerTrigger implements ITrigger{
	
	private Handler handler;
	private Runnable runnable;
	private int counter;
	private ChronoMain chrono;
	
	public HandlerTrigger(ChronoMain chrono){
		handler = new Handler();
		counter = 0;
		this.chrono = chrono;
		runnable = new Runnable() {
			   @Override
			   public void run() {
				   counter ++;
				   notifyChrono();
			   }
			};		
	}
	
	@Override
	public void startTimer() {
		counter = 0;
		continueTimer();
	}

	@Override
	public void continueTimer() {
		handler.removeCallbacks(runnable);
		handler.postDelayed(runnable, 1000);
	}

	@Override
	public void pauseTimer() {
		handler.removeCallbacks(runnable);
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

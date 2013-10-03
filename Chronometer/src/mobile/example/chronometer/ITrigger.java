package mobile.example.chronometer;

public interface ITrigger {

	public void startTimer();
	public void continueTimer();
	public void pauseTimer();
	public int getTime();
	public void notifyChrono();
}

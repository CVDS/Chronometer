package mobile.example.chronometer;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Configuration;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChronoMain extends Activity {
	private ITrigger trigger;
	private Button startButton;
	private Button pauseButton;
	private Button contButton;
	private TextView timerText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chrono_main);
		startButton = (Button) findViewById(R.id.startButton);
		pauseButton = (Button) findViewById(R.id.pauseButton);
		contButton = (Button) findViewById(R.id.contButton);
		timerText = (TextView) findViewById(R.id.timerView);
		trigger = new HandlerTrigger(this);	
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		//setContentView(R.layout.activity_chrono_main);
	}
	
	public void onClick(View view){
		if(view.equals(startButton)){
			trigger.startTimer();
		}else if(view.equals(contButton)){
			trigger.continueTimer();
		}
		else if(view.equals(pauseButton)){
			trigger.pauseTimer();
		}
	}
	
	public void update(){
		timerText.setText(trigger.getTime()+"");
	}
	
}

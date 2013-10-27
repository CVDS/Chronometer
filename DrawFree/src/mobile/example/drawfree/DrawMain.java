package mobile.example.drawfree;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class DrawMain extends Activity {
	private ImageButton newButton, paintButton, eraseButton, fbButton;
	private ImageButton brown, red, yellow, green, blue, black;
	private DrawingPanel panel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setMenuButtons();
		setColorButtons();
		panel = (DrawingPanel) findViewById(R.id.drawing);
		panel.setColor(Color.parseColor("#000000"));
		panel.setStroke(20);
	}

	private void setColorButtons() {
		brown = (ImageButton) findViewById(R.id.brownButton);
		red = (ImageButton) findViewById(R.id.redButton);
		yellow = (ImageButton) findViewById(R.id.yellowButton);
		green = (ImageButton) findViewById(R.id.greenButton);
		blue = (ImageButton) findViewById(R.id.blueButton);
		black = (ImageButton) findViewById(R.id.blackButton);
	}

	private void setMenuButtons() {
		newButton = (ImageButton) findViewById(R.id.newButton);
		paintButton = (ImageButton) findViewById(R.id.paintButton);
		eraseButton = (ImageButton) findViewById(R.id.eraseButton);
		fbButton = (ImageButton) findViewById(R.id.fbButton);
	}

	public void paintClicked(View view) {
		ImageButton selectedButton = ((ImageButton) view);
		changeButtonImage(selectedButton);
		setPaintColor(selectedButton);
	}

	private void changeButtonImage(ImageButton selectedButton) {
		LinearLayout colorLayout = (LinearLayout) findViewById(R.id.colorLayout);
		for (int i = 0; i < colorLayout.getChildCount(); i++) {
			ImageButton colorButton = ((ImageButton) colorLayout.getChildAt(i));
			// How to get drawable id??????
			switch (colorButton.getId()) {
			case R.id.brownButton:
				if (selectedButton.equals(colorButton)) {
					selectedButton.setImageDrawable(getResources().getDrawable(
							R.drawable.brownchecked));
				} else {
					colorButton.setImageDrawable(getResources().getDrawable(
							R.drawable.brown));
				}
				break;
			case R.id.redButton:
				if (selectedButton.equals(colorButton)) {
					selectedButton.setImageDrawable(getResources().getDrawable(
							R.drawable.redchecked));
				} else {
					colorButton.setImageDrawable(getResources().getDrawable(
							R.drawable.red));
				}
				break;
			case R.id.yellowButton:
				if (selectedButton.equals(colorButton)) {
					selectedButton.setImageDrawable(getResources().getDrawable(
							R.drawable.yellowchecked));
				} else {
					colorButton.setImageDrawable(getResources().getDrawable(
							R.drawable.yellow));
				}
				break;
			case R.id.greenButton:
				if (selectedButton.equals(colorButton)) {
					selectedButton.setImageDrawable(getResources().getDrawable(
							R.drawable.greenchecked));
				} else {
					colorButton.setImageDrawable(getResources().getDrawable(
							R.drawable.green));
				}
				break;
			case R.id.blueButton:
				if (selectedButton.equals(colorButton)) {
					selectedButton.setImageDrawable(getResources().getDrawable(
							R.drawable.bluechecked));
				} else {
					colorButton.setImageDrawable(getResources().getDrawable(
							R.drawable.blue));
				}
				break;
				case R.id.blackButton:
					if (selectedButton.equals(colorButton)) {
						selectedButton.setImageDrawable(getResources().getDrawable(
								R.drawable.blackchecked));
					} else {
						colorButton.setImageDrawable(getResources().getDrawable(
								R.drawable.black));
					}
					break;
			}
			
			
		}
	}

	public void newDrawing(View view) {
		Log.v("DrawActivity", "new selected");
		panel.resetCanvas();
		// reset screen
	}

	public void paint(View view) {
		Log.v("DrawActivity", "paint selected");
		panel.setStroke(20);
		black.setImageDrawable(getResources().getDrawable(
				R.drawable.blackchecked));
		setPaintColor(black);
		// set paint brush
	}

	private void setPaintColor(ImageButton button) {
		Log.v("DrawActivity", "other color");
		String colorS = button.getTag().toString();
		int color = Color.parseColor(colorS);
		panel.setColor(color);
	}

	public void erase(View view) {
		Log.v("DrawActivity", "erase selected");
		// white
		panel.setColor(Color.parseColor("#FFFFFF"));
		panel.setStroke(40);
	}

	public void fb(View view) {
		Log.v("DrawActivity", "fb selected");
		// post on facebook
	}
}

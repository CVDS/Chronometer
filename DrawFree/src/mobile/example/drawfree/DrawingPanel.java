package mobile.example.drawfree;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DrawingPanel extends View {
	private Path drawPath = new Path();
	private Paint drawPaint = new Paint();
	// canvas
	private Canvas drawCanvas;
	// canvas bitmap
	private Bitmap canvasBitmap;

	public DrawingPanel(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
		drawCanvas = new Canvas(canvasBitmap);
		// is called on creation with old values 0 and 0
		super.onSizeChanged(w, h, oldw, oldh);

		drawPaint.setAntiAlias(true);
		drawPaint.setStyle(Paint.Style.STROKE);
		drawPaint.setStrokeJoin(Paint.Join.ROUND);
		drawPaint.setStrokeCap(Paint.Cap.ROUND);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// is called automatically when “invalidate()” is used
		canvas.drawBitmap(canvasBitmap, 0, 0, null);
		canvas.drawPath(drawPath, drawPaint);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		float beginX;
		float beginY;
		float endX;
		float endY;
		event.getY();
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			beginX = event.getX();
			beginY = event.getY();
			drawPath.moveTo(beginX, beginY);
			break;
		case MotionEvent.ACTION_MOVE:
			endX = event.getX();
			endY = event.getY();
			drawPath.lineTo(endX, endY);
			break;
		case MotionEvent.ACTION_UP:
			drawCanvas.drawPath(drawPath, drawPaint);
			drawPath.reset();
			invalidate();
			break;
		}
		return true;
	}

	public void setColor(int color) {
		drawPaint.setColor(color);
	}

	public void setStroke(int strokeSize) {
		drawPaint.setStrokeWidth(strokeSize);
	}

	public void resetCanvas() {
		drawCanvas.drawColor(Color.WHITE);
		invalidate();
	}
}

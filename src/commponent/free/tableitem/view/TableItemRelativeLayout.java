package commponent.free.tableitem.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class TableItemRelativeLayout extends RelativeLayout {

	public TableItemRelativeLayout(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
	}

	public TableItemRelativeLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public TableItemRelativeLayout(Context context) {
		super(context);
	}

	Paint paint= new Paint();
	@Override
	protected void onDraw(Canvas canvas) {
		System.out.println("ondrawondrawondrawondrawondrawondrawondrawondrawondrawondrawondrawondraw");
		super.onDraw(canvas);
		paint.setColor(Color.BLUE);
		paint.setStrokeWidth(1);
		paint.setStyle(Style.STROKE);
		paint.setAntiAlias(true);
		RectF rectF = new RectF(0, 0, this.getWidth(), this.getHeight());
		canvas.drawRoundRect(rectF, 8, 0, paint);
	}
	
	
}

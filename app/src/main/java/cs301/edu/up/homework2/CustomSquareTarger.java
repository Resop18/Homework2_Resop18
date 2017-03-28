package cs301.edu.up.homework2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import static android.graphics.Color.blue;
import static android.graphics.Color.green;
import static android.graphics.Color.red;
import static android.graphics.Color.rgb;

/**
 * Created by Javier on 26-Mar-17.
 */

public class CustomSquareTarger extends CustomRect
{
	private Rect outerSquare, innerSquare;
	private Paint myPaint2;
	/**
	 * the ctor requires that you give the object a name and a color
	 *
	 * @param name
	 * @param color
	 */
	public CustomSquareTarger(String name, int color, int left, int top, int right, int bottom)
	{
		super(name, color, left, top, right, bottom);
		this.outerSquare = new Rect(left/2 + left,top/2 + top ,right/2+ right,bottom/2+bottom);
		this.innerSquare = new Rect(left/3 + left, top/3 + top, right/3+ right, bottom/3+ bottom);

		myPaint2 = new Paint(myPaint);
		myPaint2.setColor(rgb(blue(myPaint2.getColor()),red(myPaint2.getColor()), green(myPaint2.getColor())));
	}

	@Override
	public void drawMe(Canvas canvas)
	{


		canvas.drawRect(myRect, myPaint);  //main rectangle

		canvas.drawRect(myRect, outlinePaint);

		canvas.drawRect(outerSquare, outlinePaint);
		canvas.drawRect(outerSquare, myPaint);



		canvas.drawRect(innerSquare, myPaint2);
		canvas.drawRect(innerSquare, outlinePaint);
	}

	@Override
	public boolean containsPoint(int x, int y)
	{
		int left1 = this.myRect.left - TAP_MARGIN;
		int top1 = this.myRect.top - TAP_MARGIN;
		int right1 = this.myRect.right + TAP_MARGIN;
		int bottom1 = this.myRect.bottom + TAP_MARGIN;
		Rect r1 = new Rect(left1, top1, right1, bottom1);
		int left2 = this.outerSquare.left - TAP_MARGIN;
		int top2 = this.outerSquare.top - TAP_MARGIN;
		int right2 = this.outerSquare.right + TAP_MARGIN;
		int bottom2 = this.outerSquare.bottom + TAP_MARGIN;
		Rect r2 = new Rect(left2, top2, right2, bottom2);
		int left3 = this.innerSquare.left - TAP_MARGIN;
		int top3 = this.innerSquare.top - TAP_MARGIN;
		int right3 = this.innerSquare.right + TAP_MARGIN;
		int bottom3 = this.innerSquare.bottom + TAP_MARGIN;
		Rect r3 = new Rect(left3, top3, right3, bottom3);

		return (r1.contains(x, y)|| r2.contains(x, y) || r3.contains(x, y));
	}

	@Override
	public int getSize()
	{
		return 0;
	}

	@Override
	public void drawHighlight(Canvas canvas)
	{
		canvas.drawRect(myRect, highlightPaint);
		canvas.drawRect(myRect, outlinePaint);

		canvas.drawRect(outerSquare, highlightPaint);
		canvas.drawRect(outerSquare, outlinePaint);
		canvas.drawRect(innerSquare, myPaint2);
		canvas.drawRect(innerSquare, highlightPaint);
		canvas.drawRect(innerSquare, outlinePaint);
	}

	@Override
	public void setColor(int color){
		super.setColor(color);

		myPaint2 = new Paint(myPaint);
		myPaint2.setColor(rgb(blue(myPaint2.getColor()),red(myPaint2.getColor()), green(myPaint2.getColor())));
	}
}

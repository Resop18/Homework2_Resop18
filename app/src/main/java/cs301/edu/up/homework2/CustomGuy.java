package cs301.edu.up.homework2;

import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by Javier on 26-Mar-17.
 */

public class CustomGuy extends CustomElement{

		private int x;
		private int y;
		private int radius;
		protected Rect myRect;
		private Rect arm;

	/**
	 * the ctor requires that you give the object a name and a color
	 *
	 * @param name
	 * @param color
	 */
	public CustomGuy(String name, int color, int left, int top, int right, int bottom)
	{
		super(name, color);

		this.x = left + (right - left)/2;
		this.y = top;

		this.arm = new Rect(left - 150, top + (150), left +10, top + (200));

		this.myRect = new Rect(left, top, right, bottom);
		this.radius = 100;
	}

	@Override
	public void drawMe(Canvas canvas)
	{
		canvas.drawRect(myRect, myPaint);  //main rectangle
		canvas.drawRect(myRect, outlinePaint);  //outline around rectangle
		canvas.drawCircle(x, y, radius, myPaint);  //main circle
		canvas.drawCircle(x, y, radius, outlinePaint);  //outline around circle
		canvas.drawRect(arm, myPaint);
		canvas.drawRect(arm, outlinePaint);
	}

	@Override
	public boolean containsPoint(int x, int y)
	{
		//Calculate the distance between this point and the center
		int xDist = Math.abs(x - this.x);
		int yDist = Math.abs(y - this.y);
		int dist = (int)Math.sqrt(xDist*xDist + yDist*yDist);  //Thanks, Pythagoras :)

		//Want to check for a tap within a slightly larger rectangle
		int left1 = this.myRect.left - TAP_MARGIN;
		int top1 = this.myRect.top - TAP_MARGIN;
		int right1 = this.myRect.right + TAP_MARGIN;
		int bottom1 = this.myRect.bottom + TAP_MARGIN;
		Rect r1 = new Rect(left1, top1, right1, bottom1);

		int left2 = this.arm.left - TAP_MARGIN;
		int top2 = this.arm.top - TAP_MARGIN;
		int right2 = this.arm.right + TAP_MARGIN;
		int bottom2 = this.arm.bottom + TAP_MARGIN;
		Rect r2 = new Rect(left2, top2, right2, bottom2);


		return ((dist < this.radius + TAP_MARGIN)|| r1.contains(x, y) || r2.contains(x,y));
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
		canvas.drawCircle(x, y, radius, myPaint);
		canvas.drawCircle(x, y, radius, highlightPaint);
		canvas.drawCircle(x, y, radius, outlinePaint);
		canvas.drawRect(arm, myPaint);
		canvas.drawRect(arm, highlightPaint);
		canvas.drawRect(arm, outlinePaint);
	}
}

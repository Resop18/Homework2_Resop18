package cs301.edu.up.homework2;

import android.graphics.Canvas;

/**
 * Created by Javier on 26-Mar-17.
 */

public class CustomSetOfEgg extends CustomElement
{
	private int x1,x2;
	private int y1,y2;
	private int radius;

	/**
	 * the ctor requires that you give the object a name and a color
	 *
	 * @param name
	 * @param color
	 */
	public CustomSetOfEgg(String name, int color, int x, int y, int radius)
	{
		super(name, color);
		this.x1 = x;
		this.x2 = x + 50;
		this.y1 = y;
		this.y2 = y -50;
		this.radius = radius;
	}

	/*
	* draws the pair of circles
	* */
	@Override
	public void drawMe(Canvas canvas)
	{
		canvas.drawCircle(x1, y1, radius, myPaint);  //main circle
		canvas.drawCircle(x1, y1, radius, outlinePaint);  //outline around circle
		canvas.drawCircle(x2, y2, radius, myPaint);  //main circle
		canvas.drawCircle(x2, y2, radius, outlinePaint);  //outline around circle
	}

	/*
	* checks to see if the point is within the pair of circles
	* */
	@Override
	public boolean containsPoint(int x, int y)
	{
		//Calculate the distance between this point and the center
		int xDist1 = Math.abs(x - this.x1);
		int yDist1 = Math.abs(y - this.y1);

		int dist1 = (int)Math.sqrt(xDist1*xDist1 + yDist1*yDist1);  //Thanks, Pythagoras :)

		int xDist2 = Math.abs(x - this.x1);
		int yDist2 = Math.abs(y - this.y1);

		int dist2 = (int)Math.sqrt(xDist2*xDist2 + yDist2*yDist2);  //Thanks, Pythagoras :)


		return ((dist1 < this.radius + TAP_MARGIN)||(dist2 < this.radius + TAP_MARGIN));
	}

	@Override
	public int getSize()
	{
		return 0;
	}

	/*
	* higlights the circles but redraws a circle to add depth
	* */
	@Override
	public void drawHighlight(Canvas canvas)
	{
		canvas.drawCircle(x1, y1, radius, highlightPaint);
		canvas.drawCircle(x1, y1, radius, outlinePaint);
		canvas.drawCircle(x2, y2, radius, myPaint);
		canvas.drawCircle(x2, y2, radius, highlightPaint);
		canvas.drawCircle(x2, y2, radius, outlinePaint);
	}
}

package cs301.edu.up.homework2;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;

/**
 * Created by Javier on 26-Mar-17.
 */

public class CustomStar extends CustomElement
{
	Point a,b,c,d,e,f,g,h,i,j;
	private Rect myRect;
	private Path path;
	/**
	 * the ctor requires that you give the object a name, a color, x position, y position and size
	 *
	 * @param name
	 * @param color
	 * @param posX
	 * @param posY
	 * @param size
	 */
	public CustomStar(String name, int color, int posX, int posY, int size)
	{
		super(name, color);

		myRect = new Rect(posX,posY + size/2 + TAP_MARGIN/2,posX + size/2 + 2*TAP_MARGIN,posY + size - TAP_MARGIN);

		int hMargin = size/9;
		int vMargin = size/4;

		a = new Point((int) (posX + size/2), (int) posY);
		b = new Point((int) (posX + size/2 + hMargin), (int) (posY + vMargin));
		c = new Point((int) (posX + size), (int) (posY + vMargin));
		d = new Point((int) (posX + size/2 + 2*hMargin), (int) (posY + size/2 + vMargin/2));
		e = new Point((int) (posX + size/2 + 3*hMargin), (int) (posY + size));
		f = new Point((int) (posX + size/2), (int) (posY + size - vMargin));
		g = new Point((int) (posX + size/2 - 3*hMargin), (int) (posY + size));
		h = new Point((int) (posX + size/2 - 2*hMargin), (int) (posY + size/2 + vMargin/2));
		i = new Point((int) posX, (int) (posY + vMargin));
		j = new Point((int) (posX + size/2 - hMargin), (int) (posY + vMargin));

	}

	/*
	* creates and draws a star
	* */
	@Override
	public void drawMe(Canvas canvas)
	{


		path = new Path();
		path.moveTo(a.x, a.y);
		path.lineTo(b.x, b.y);
		path.lineTo(c.x, c.y);
		path.lineTo(d.x, d.y);
		path.lineTo(e.x, e.y);
		path.lineTo(f.x, f.y);
		path.lineTo(f.x, f.y);
		path.lineTo(g.x, g.y);
		path.lineTo(h.x, h.y);
		path.lineTo(i.x, i.y);
		path.lineTo(j.x, j.y);
		path.lineTo(a.x, a.y);

		path.close();

		canvas.drawPath(path, myPaint);
		canvas.drawPath(path, outlinePaint);
	}

	/*
	* check to see if the point is within the star
	* */
	@Override
	public boolean containsPoint(int x, int y)
	{
		//Want to check for a tap within a slightly larger rectangle
		int left = this.myRect.left - TAP_MARGIN;
		int top = this.myRect.top - TAP_MARGIN;
		int right = this.myRect.right + TAP_MARGIN;
		int bottom = this.myRect.bottom + TAP_MARGIN;
		Rect r = new Rect(left, top, right, bottom);

		return r.contains(x, y);
	}

	@Override
	public int getSize()
	{
		return 0;
	}

	/*
	* highlights the star
	* */
	@Override
	public void drawHighlight(Canvas canvas)
	{
		canvas.drawPath(path, highlightPaint);
		canvas.drawPath(path, outlinePaint);
	}
}

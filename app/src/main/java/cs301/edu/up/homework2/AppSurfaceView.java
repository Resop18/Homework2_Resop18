package cs301.edu.up.homework2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;

import static android.graphics.Color.blue;
import static android.graphics.Color.green;
import static android.graphics.Color.red;

/**
 * Created by Javier on 26-Mar-17.
 */

public class AppSurfaceView extends SurfaceView{

	public CustomCircle circle;
	public CustomRect rect;
	public CustomGuy sorcerer;
	public CustomStar star;
	public CustomSetOfEgg weird;
	public CustomSquareTarger target;
	private int width, height;
	public int itemNumber;

    public AppSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
		setWillNotDraw(false);

		WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		width = size.x;
		height = size.y;


		circle 	= new CustomCircle("Chromatic Orb", 0xFFE3DEDB, width/4, 5*height/7, 100);
		rect 	= new CustomRect("Wall of Stone", 0xFF8B8D7A, 0, height/4, width/6, height);
		sorcerer= new CustomGuy("Tiberious Stormwind", 0xFFFF0000, 3* width/ 5, 4 * height/7, 7 *width/10, 6 * height/7);
		star 	= new CustomStar("Too short", 0xFF04FF2F,  width / 2, 2 * height /9, 250);
		weird	= new CustomSetOfEgg("Dragon Eggs", 0xFF00F0DF,  7*width/9 , 2 * height / 5, 125);
		target	= new CustomSquareTarger("Aim Here", 0xFF55FFB9, 3 * width /16, height/ 8, 5*width /16, 2 * height / 8);
    }

    @Override
    public void onDraw(Canvas canvas) {


		Paint topBar = new Paint();


		topBar.setColor(0xFF0E05FB);

		canvas.drawRect(0,0,width,height/8,topBar);
		circle.drawMe(canvas);
		rect.drawMe(canvas);
		sorcerer.drawMe(canvas);
		star.drawMe(canvas);
		weird.drawMe(canvas);
		target.drawMe(canvas);

		if(itemNumber == 1) {
			circle.drawHighlight(canvas);
		}
		else if(itemNumber == 2) {
			rect.drawHighlight(canvas);
		}
		else if(itemNumber == 3) {
			sorcerer.drawHighlight(canvas);
		}
		else if(itemNumber == 4) {
			star.drawHighlight(canvas);
		}
		else if(itemNumber == 5) {
			weird.drawHighlight(canvas);
		}
		else if(itemNumber == 6) {
			target.drawHighlight(canvas);
		}

    }

}

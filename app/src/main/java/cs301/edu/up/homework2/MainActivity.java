package cs301.edu.up.homework2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import static android.graphics.Color.blue;
import static android.graphics.Color.green;
import static android.graphics.Color.red;
import static android.graphics.Color.rgb;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{
	public SeekBar redSeek, greenSeek, blueSeek;
	public TextView redVal, greenVal, blueVal, object;
	private AppSurfaceView gui;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		gui = (AppSurfaceView) findViewById(R.id.TheSurfaceView);
		gui.setOnTouchListener(this);

		redSeek		= (SeekBar)findViewById(R.id.RedSeek);
		if(redSeek==null){Log.i("red seek", "null");}
		greenSeek	= (SeekBar)findViewById(R.id.GreenSeek);
		blueSeek 	= (SeekBar)findViewById(R.id.BlueSeek);


		redVal 	= (TextView)findViewById(R.id.RedIntVal);
		greenVal= (TextView)findViewById(R.id.GreenIntVal);
		blueVal = (TextView)findViewById(R.id.BlueIntVal);
		object	= (TextView)findViewById(R.id.ObjectName);

		redSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onStopTrackingTouch(SeekBar arg0)
			{

			}

			@Override
			public void onStartTrackingTouch(SeekBar arg0)
			{
			}

			@Override
			public void onProgressChanged(SeekBar arg0, int progress, boolean arg2)
			{
				redVal.setText("" + redSeek.getProgress());
				if(gui.itemNumber == 1) {
					gui.circle.setColor(rgb(redSeek.getProgress(),
							green(gui.circle.getColor()), blue(gui.circle.getColor())));
					gui.invalidate();
				}
				else if(gui.itemNumber == 2){
					gui.rect.setColor(rgb(redSeek.getProgress(),
							green(gui.rect.getColor()), blue(gui.rect.getColor())));
					gui.invalidate();
				}
				else if(gui.itemNumber == 3){
					gui.sorcerer.setColor(rgb(redSeek.getProgress(),
							green(gui.sorcerer.getColor()), blue(gui.sorcerer.getColor())));
					gui.invalidate();
				}
				else if(gui.itemNumber == 4){
					gui.star.setColor(rgb(redSeek.getProgress(),
							green(gui.star.getColor()), blue(gui.star.getColor())));
					gui.invalidate();
				}
				else if(gui.itemNumber == 5){
					gui.weird.setColor(rgb(redSeek.getProgress(),
							green(gui.weird.getColor()), blue(gui.weird.getColor())));
					gui.invalidate();
				}
				else if(gui.itemNumber == 6){
					gui.target.setColor(rgb(redSeek.getProgress(),
							green(gui.target.getColor()), blue(gui.target.getColor())));
					gui.invalidate();
				}
			}
		});


		greenSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onStopTrackingTouch(SeekBar arg0)
			{

			}

			@Override
			public void onStartTrackingTouch(SeekBar arg0)
			{
			}

			@Override
			public void onProgressChanged(SeekBar arg0, int progress, boolean arg2)
			{
				greenVal.setText("" + greenSeek.getProgress());
				if(gui.itemNumber == 1) {
					gui.circle.setColor(rgb(red(gui.circle.getColor()),
							greenSeek.getProgress(), blue(gui.circle.getColor())));
					gui.invalidate();
				}
				else if(gui.itemNumber == 2){
					gui.rect.setColor(rgb(red(gui.rect.getColor()),
							greenSeek.getProgress(), blue(gui.rect.getColor())));
					gui.invalidate();
				}
				else if(gui.itemNumber == 3){
					gui.sorcerer.setColor(rgb(red(gui.sorcerer.getColor()),
							greenSeek.getProgress(), blue(gui.sorcerer.getColor())));
					gui.invalidate();
				}
				else if(gui.itemNumber == 4){
					gui.star.setColor(rgb(red(gui.star.getColor()),
							greenSeek.getProgress(), blue(gui.star.getColor())));
					gui.invalidate();
				}
				else if(gui.itemNumber == 5){
					gui.weird.setColor(rgb(red(gui.weird.getColor()),
							greenSeek.getProgress(), blue(gui.weird.getColor())));
					gui.invalidate();
				}
				else if(gui.itemNumber == 6){
					gui.target.setColor(rgb(red(gui.target.getColor()),
							greenSeek.getProgress(), blue(gui.target.getColor())));
					gui.invalidate();
				}
			}
		});

		blueSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onStopTrackingTouch(SeekBar arg0)
			{

			}

			@Override
			public void onStartTrackingTouch(SeekBar arg0)
			{
			}

			@Override
			public void onProgressChanged(SeekBar arg0, int progress, boolean arg2)
			{
				blueVal.setText("" + blueSeek.getProgress());
				if(gui.itemNumber == 1) {
					gui.circle.setColor(rgb(red(gui.circle.getColor()),
						green(gui.circle.getColor()), blueSeek.getProgress()));

					gui.invalidate();
				}
				else if(gui.itemNumber == 2){
					gui.rect.setColor(rgb(red(gui.rect.getColor()),
						green(gui.rect.getColor()), blueSeek.getProgress()));
					gui.invalidate();
				}
				else if(gui.itemNumber == 3){
					gui.sorcerer.setColor(rgb(red(gui.sorcerer.getColor()),
							green(gui.sorcerer.getColor()), blueSeek.getProgress()));
					gui.invalidate();
				}
				else if(gui.itemNumber == 4){
					gui.star.setColor(rgb(red(gui.star.getColor()),
							green(gui.star.getColor()), blueSeek.getProgress()));
					gui.invalidate();
				}
				else if(gui.itemNumber == 5){
					gui.weird.setColor(rgb(red(gui.weird.getColor()),
							green(gui.weird.getColor()), blueSeek.getProgress()));
					gui.invalidate();
				}
				else if(gui.itemNumber == 6){
					gui.target.setColor(rgb(red(gui.target.getColor()),
							green(gui.target.getColor()), blueSeek.getProgress()));
					gui.invalidate();
				}
			}
		});
    }
	@Override
	public boolean onTouch(View v, MotionEvent event)
	{
		if(event.getActionMasked() == MotionEvent.ACTION_DOWN) {

			if (gui.circle.containsPoint((int) event.getX(), (int) event.getY())) {
				gui.itemNumber = 1;
				redSeek.setProgress(red(gui.circle.getColor()));
				redVal.setText("" + red(gui.circle.getColor()));
				greenSeek.setProgress(green(gui.circle.getColor()));
				greenVal.setText("" + green(gui.circle.getColor()));
				blueSeek.setProgress(blue(gui.circle.getColor()));
				blueVal.setText("" + blue(gui.circle.getColor()));
				object.setText(gui.circle.getName());
			} else if (gui.rect.containsPoint((int) event.getX(), (int) event.getY())) {
				gui.itemNumber = 2;
				redSeek.setProgress(red(gui.rect.getColor()));
				redVal.setText("" + red(gui.rect.getColor()));
				greenSeek.setProgress(green(gui.rect.getColor()));
				greenVal.setText("" + green(gui.rect.getColor()));
				blueSeek.setProgress(blue(gui.rect.getColor()));
				blueVal.setText("" + blue(gui.rect.getColor()));
				object.setText(gui.rect.getName());
			} else if (gui.sorcerer.containsPoint((int) event.getX(), (int) event.getY())) {
				gui.itemNumber = 3;
				redSeek.setProgress(red(gui.sorcerer.getColor()));
				redVal.setText("" + red(gui.sorcerer.getColor()));
				greenSeek.setProgress(green(gui.sorcerer.getColor()));
				greenVal.setText("" + green(gui.sorcerer.getColor()));
				blueSeek.setProgress(blue(gui.sorcerer.getColor()));
				blueVal.setText("" + blue(gui.sorcerer.getColor()));
				object.setText(gui.sorcerer.getName());
			} else if (gui.star.containsPoint((int) event.getX(), (int) event.getY())) {
				gui.itemNumber = 4;
				redSeek.setProgress(red(gui.star.getColor()));
				redVal.setText("" + red(gui.star.getColor()));
				greenSeek.setProgress(green(gui.star.getColor()));
				greenVal.setText("" + green(gui.star.getColor()));
				blueSeek.setProgress(blue(gui.star.getColor()));
				blueVal.setText("" + blue(gui.star.getColor()));
				object.setText(gui.star.getName());
			} else if (gui.weird.containsPoint((int) event.getX(), (int) event.getY())) {
				gui.itemNumber = 5;
				redSeek.setProgress(red(gui.weird.getColor()));
				redVal.setText("" + red(gui.weird.getColor()));
				greenSeek.setProgress(green(gui.weird.getColor()));
				greenVal.setText("" + green(gui.weird.getColor()));
				blueSeek.setProgress(blue(gui.weird.getColor()));
				blueVal.setText("" + blue(gui.weird.getColor()));
				object.setText(gui.weird.getName());
			} else if (gui.target.containsPoint((int) event.getX(), (int) event.getY())) {
				gui.itemNumber = 6;
				redSeek.setProgress(red(gui.target.getColor()));
				redVal.setText("" + red(gui.target.getColor()));
				greenSeek.setProgress(green(gui.target.getColor()));
				greenVal.setText("" + green(gui.target.getColor()));
				blueSeek.setProgress(blue(gui.target.getColor()));
				blueVal.setText("" + blue(gui.target.getColor()));
				object.setText(gui.target.getName());
			}
		}
		gui.invalidate();
		return true;
	}


}

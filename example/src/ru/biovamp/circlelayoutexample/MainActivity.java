package ru.biovamp.circlelayoutexample ;

import ru.biovamp.widget.CircleLayout ;
import android.os.Bundle ;
import android.util.Log ;
import android.view.View ;
import android.widget.Button ;
import android.app.Activity ;
import android.content.Intent ;

public class MainActivity extends Activity {

	private char mState = 0 ;

	@ Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState) ;
		setContentView(R.layout.activity_main) ;
		/*
		 * All code below is NOT required. I've added it just for demonstration
		 * of different layout modes
		 */
		final View pie = findViewById(R.id.pie) ;
		final View normal = findViewById(R.id.normal) ;
		final View normalWithRange = findViewById(R.id.normalWithRange) ;
		final Button switchBtn = (Button) findViewById(R.id.switchBtn) ;
		((CircleLayout) normal).setInnerCircle(R.drawable.empty_photo);
		switchBtn.setOnClickListener(new View.OnClickListener() {

			@ Override
			public void onClick(View v) {
				switch(mState) {
					case 0 :
						normalWithRange.setVisibility(View.GONE) ;
						pie.setVisibility(View.GONE) ;
						normal.setVisibility(View.VISIBLE) ;
						switchBtn.setText(R.string.normalWidthRange) ;
						mState ++ ;
						break ;
					case 1 :
						normalWithRange.setVisibility(View.VISIBLE) ;
						pie.setVisibility(View.GONE) ;
						normal.setVisibility(View.GONE) ;
						switchBtn.setText(R.string.pie) ;
						mState ++ ;
						break ;
					case 2 :
						normalWithRange.setVisibility(View.GONE) ;
						pie.setVisibility(View.VISIBLE) ;
						normal.setVisibility(View.GONE) ;
						switchBtn.setText(R.string.normal) ;
						mState = 0 ;
						break ;
					default :
						break ;
				}
			}
		}) ;
	}

	public void enter(View inView) {
		Log.i("tag" , "enter") ;
		startActivity(new Intent(getApplicationContext() , DemoActivity.class)) ;
	}

	public void fuck(View inView) {
		Log.i("tag" , "fuck") ;
	}
}

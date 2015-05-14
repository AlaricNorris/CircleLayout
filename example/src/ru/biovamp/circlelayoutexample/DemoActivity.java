package ru.biovamp.circlelayoutexample ;

import java.util.ArrayList ;
import java.util.Iterator ;
import ru.biovamp.widget.CircleLayout ;
import android.os.Bundle ;
import android.util.Log ;
import android.view.View ;
import android.view.View.OnClickListener ;
import android.view.ViewGroup.LayoutParams ;
import android.widget.Button ;
import android.app.Activity ;

public class DemoActivity extends Activity implements OnClickListener {

	private CircleLayout mCircleLayout ;

	private ArrayList<String> mArrayList = new ArrayList<String>() ;
	{
		mArrayList.add("1``") ;
		mArrayList.add("2``") ;
		mArrayList.add("3``") ;
		mArrayList.add("4``") ;
		mArrayList.add("5``") ;
		mArrayList.add("5``") ;
		mArrayList.add("6``") ;
		mArrayList.add("7``") ;
		mArrayList.add("8``") ;
	}

	@ Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState) ;
		setContentView(R.layout.activity_demo) ;
		mCircleLayout = (CircleLayout) findViewById(R.id.circle) ;
		Iterator<String> mIterator = mArrayList.iterator() ;
		while(mIterator.hasNext()) {
			Log.i("tag" , "add") ;
			String string = (String) mIterator.next() ;
			CircleImageView mCircleImageView = new CircleImageView(this) ;
			mCircleImageView.setLayoutParams(new LayoutParams(30 , 30)) ;
			mCircleImageView.setImageResource(R.drawable.empty_photo) ;
			mCircleImageView.setTag(string) ;
			mCircleImageView.setOnClickListener(this) ;
			mCircleLayout.addChild(mCircleImageView) ;
		}
		mCircleLayout.requestLayout() ;
		mCircleLayout.invalidate() ;
	}

	/**
	 * 	(non-Javadoc)
	 * 	@see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@ Override
	public void onClick(View arg0) {
		if(arg0 instanceof CircleImageView) {
			Log.i("tag" , "" + arg0.getTag().toString()) ;
		}
	}
}

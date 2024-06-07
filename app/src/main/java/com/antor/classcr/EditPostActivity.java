package com.antor.classcr;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;

import java.util.ArrayList;
import java.util.Random;

public class EditPostActivity extends AppCompatActivity {
	
	private double n = 0;
	
	private LinearLayout linear00;
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout linear8;
	private LinearLayout linear2;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private LinearLayout linear17;
	private LinearLayout linear18;
	private LinearLayout linear19;
	private Button button1;
	private ImageView imageview_back;
	private TextView textview3;
	private TextView textview_mycode;
	private TextView textview_logout;
	private TextView textview1;
	private TextView textview9;
	private ImageView imageview1;
	private TextView textview10;
	private ImageView imageview2;
	private TextView textview35;
	private Spinner spinner1;
	private TextView textview36;
	private Spinner spinner2;
	private TextView textview37;
	private Spinner spinner3;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.edit_post);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear00 = findViewById(R.id.linear00);
		vscroll1 = findViewById(R.id.vscroll1);
		linear1 = findViewById(R.id.linear1);
		linear8 = findViewById(R.id.linear8);
		linear2 = findViewById(R.id.linear2);
		linear9 = findViewById(R.id.linear9);
		linear10 = findViewById(R.id.linear10);
		linear17 = findViewById(R.id.linear17);
		linear18 = findViewById(R.id.linear18);
		linear19 = findViewById(R.id.linear19);
		button1 = findViewById(R.id.button1);
		imageview_back = findViewById(R.id.imageview_back);
		textview3 = findViewById(R.id.textview3);
		textview_mycode = findViewById(R.id.textview_mycode);
		textview_logout = findViewById(R.id.textview_logout);
		textview1 = findViewById(R.id.textview1);
		textview9 = findViewById(R.id.textview9);
		imageview1 = findViewById(R.id.imageview1);
		textview10 = findViewById(R.id.textview10);
		imageview2 = findViewById(R.id.imageview2);
		textview35 = findViewById(R.id.textview35);
		spinner1 = findViewById(R.id.spinner1);
		textview36 = findViewById(R.id.textview36);
		spinner2 = findViewById(R.id.spinner2);
		textview37 = findViewById(R.id.textview37);
		spinner3 = findViewById(R.id.spinner3);
	}
	
	private void initializeLogic() {
		for(int _repeat10 = 0; _repeat10 < (int)(0); _repeat10++) {
			
		}
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}

package com.antor.classcr;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;

import java.util.ArrayList;
import java.util.Random;

public class CodeShowActivity extends AppCompatActivity {
	
	private LinearLayout linear00;
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout linear8;
	private LinearLayout linear2;
	private TextView textview7;
	private Button button1;
	private ImageView imageview_back;
	private TextView textview1;
	private TextView textview2;
	private TextView textview3;
	private LinearLayout linear7;
	private TextView textview4;
	private LinearLayout linear9;
	private TextView textcode_cr;
	private TextView textcode_stu;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.code_show);
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
		textview7 = findViewById(R.id.textview7);
		button1 = findViewById(R.id.button1);
		imageview_back = findViewById(R.id.imageview_back);
		textview1 = findViewById(R.id.textview1);
		textview2 = findViewById(R.id.textview2);
		textview3 = findViewById(R.id.textview3);
		linear7 = findViewById(R.id.linear7);
		textview4 = findViewById(R.id.textview4);
		linear9 = findViewById(R.id.linear9);
		textcode_cr = findViewById(R.id.textcode_cr);
		textcode_stu = findViewById(R.id.textcode_stu);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", "CR Code: ".concat(getIntent().getStringExtra("cr")).concat("\n".concat("STU Code: ".concat(getIntent().getStringExtra("stu"))))));
				SketchwareUtil.showMessage(getApplicationContext(), "Copied (All Codes)");
			}
		});
		
		imageview_back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		textcode_cr.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", getIntent().getStringExtra("cr")));
				SketchwareUtil.showMessage(getApplicationContext(), "Copied (CR Code)");
			}
		});
		
		textcode_stu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", getIntent().getStringExtra("stu")));
				SketchwareUtil.showMessage(getApplicationContext(), "Copied (STU Code)");
			}
		});
	}
	
	private void initializeLogic() {
		vscroll1.setVerticalScrollBarEnabled(false);
		Window window = this.getWindow();
		window.setNavigationBarColor(Color.parseColor("#201A30"));
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
			Window w =CodeShowActivity.this.getWindow();
			w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(0xFF201A30);
		}
		_round_view_s1(textcode_cr, "#38304C", "#38304C", 20);
		_round_view_s1(textcode_stu, "#38304C", "#38304C", 20);
		_round_view_s1(button1, "#0DF5E3", "#0DF5E3", 30);
		textcode_cr.setElevation((float)5);
		textcode_stu.setElevation((float)5);
		button1.setElevation((float)8);
		textcode_cr.setText(getIntent().getStringExtra("cr"));
		textcode_stu.setText(getIntent().getStringExtra("stu"));
		if (getIntent().getStringExtra("cr").equals("null")) {
			textview3.setVisibility(View.GONE);
			textview7.setVisibility(View.GONE);
			button1.setVisibility(View.GONE);
			textview1.setText("Your Code");
			textview2.setText("Make sure you save that codes and screenshot it, Or you will lose it");
		}
	}
	
	@Override
	public void onBackPressed() {
		
	}
	public void _round_view_s1(final View _view, final String _bg_c, final String _s_c, final double _r) {
		android.graphics.drawable.GradientDrawable gds1 = new android.graphics.drawable.GradientDrawable();
		
		gds1.setColor(Color.parseColor(_bg_c));
		gds1.setCornerRadius((float)_r);
		gds1.setStroke(3, Color.parseColor(_s_c));
		
		_view.setBackground(gds1);
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

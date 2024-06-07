package com.antor.classcr;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class SignUpActivity extends AppCompatActivity {
	
	private String code = "";
	private String Char = "";
	private String cr_code = "";
	private String stu_code = "";
	private HashMap<String, Object> settings = new HashMap<>();
	private double i = 0;
	private double j = 0;
	private HashMap<String, Object> class_map = new HashMap<>();
	private HashMap<String, Object> exam_map = new HashMap<>();
	private double n = 0;
	private HashMap<String, Object> links = new HashMap<>();
	
	private LinearLayout linear00;
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout linear8;
	private LinearLayout linear2;
	private Button button1;
	private ImageView imageview3;
	private TextView textview1;
	private TextView textview2;
	private LinearLayout linear7;
	private LinearLayout linear3;
	private LinearLayout linear6;
	private TextView text1;
	private TextView text2;
	private TextView text3;
	private TextView text4;
	private TextView text5;
	private TextView text6;
	private EditText edittext1;
	
	private Intent in = new Intent();
	private SharedPreferences data;
	private SharedPreferences CE_data;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.sign_up);
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
		button1 = findViewById(R.id.button1);
		imageview3 = findViewById(R.id.imageview3);
		textview1 = findViewById(R.id.textview1);
		textview2 = findViewById(R.id.textview2);
		linear7 = findViewById(R.id.linear7);
		linear3 = findViewById(R.id.linear3);
		linear6 = findViewById(R.id.linear6);
		text1 = findViewById(R.id.text1);
		text2 = findViewById(R.id.text2);
		text3 = findViewById(R.id.text3);
		text4 = findViewById(R.id.text4);
		text5 = findViewById(R.id.text5);
		text6 = findViewById(R.id.text6);
		edittext1 = findViewById(R.id.edittext1);
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		CE_data = getSharedPreferences("CE_data", Activity.MODE_PRIVATE);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext1.getText().toString().trim().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Enter Above Captcha");
				}
				else {
					if (code.equals(edittext1.getText().toString().trim())) {
						_SIGN_UP();
					}
					else {
						_setCaptcha();
						SketchwareUtil.showMessage(getApplicationContext(), "Try Again");
					}
				}
			}
		});
	}
	
	private void initializeLogic() {
		vscroll1.setVerticalScrollBarEnabled(false);
		edittext1.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
		Window window = this.getWindow();
		window.setNavigationBarColor(Color.parseColor("#201A30"));
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
			Window w =SignUpActivity.this.getWindow();
			w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(0xFF201A30);
		}
		_round_view_s1(linear3, "#38304C", "#38304C", 20);
		_round_view_s1(button1, "#0DF5E3", "#0DF5E3", 30);
		linear3.setElevation((float)5);
		button1.setElevation((float)8);
		_setCaptcha();
	}
	
	public void _round_view_s1(final View _view, final String _bg_c, final String _s_c, final double _r) {
		android.graphics.drawable.GradientDrawable gds1 = new android.graphics.drawable.GradientDrawable();
		
		gds1.setColor(Color.parseColor(_bg_c));
		gds1.setCornerRadius((float)_r);
		gds1.setStroke(3, Color.parseColor(_s_c));
		
		_view.setBackground(gds1);
	}
	
	
	public void _getChar(final double _n) {
		if (_n == 1) {
			Char = "C";
		}
		if (_n == 2) {
			Char = "D";
		}
		if (_n == 3) {
			Char = "E";
		}
		if (_n == 4) {
			Char = "F";
		}
		if (_n == 5) {
			Char = "G";
		}
		if (_n == 6) {
			Char = "H";
		}
		if (_n == 7) {
			Char = "K";
		}
		if (_n == 8) {
			Char = "L";
		}
		if (_n == 9) {
			Char = "M";
		}
		if (_n == 10) {
			Char = "N";
		}
		if (_n == 11) {
			Char = "R";
		}
		if (_n == 12) {
			Char = "T";
		}
		if (_n == 13) {
			Char = "Y";
		}
		if (_n == 14) {
			Char = "Z";
		}
	}
	
	
	public void _setCaptcha() {
		code = "";
		edittext1.setText("");
		_getChar(SketchwareUtil.getRandom((int)(1), (int)(14)));
		code = code.concat(Char);
		text1.setText(Char);
		_getChar(SketchwareUtil.getRandom((int)(1), (int)(14)));
		code = code.concat(Char);
		text2.setText(Char);
		_getChar(SketchwareUtil.getRandom((int)(1), (int)(14)));
		code = code.concat(Char);
		text3.setText(Char);
		_getChar(SketchwareUtil.getRandom((int)(1), (int)(14)));
		code = code.concat(Char);
		text4.setText(Char);
		_getChar(SketchwareUtil.getRandom((int)(1), (int)(14)));
		code = code.concat(Char);
		text5.setText(Char);
		_getChar(SketchwareUtil.getRandom((int)(1), (int)(14)));
		code = code.concat(Char);
		text6.setText(Char);
	}
	
	
	public void _SIGN_UP() {
		cr_code = "cr-ndkgslowsjlydn";
		stu_code = "stu-mdjjekewopbcsy";
		in.putExtra("cr", cr_code);
		in.putExtra("stu", stu_code);
		in.setClass(getApplicationContext(), CodeShowActivity.class);
		startActivity(in);
		finish();
	}
	
	
	public void _makeFirstData() {
		settings = new HashMap<>();
		settings.put("class", "1");
		settings.put("exam", "1");
		settings.put("c_row", "6");
		settings.put("e_row", "2");
		settings.put("e_col", "3");
		data.edit().putString("settings", new Gson().toJson(settings)).commit();
		i = 0;
		j = 1;
		class_map = new HashMap<>();
		for(int _repeat105 = 0; _repeat105 < (int)(8); _repeat105++) {
			for(int _repeat106 = 0; _repeat106 < (int)(9); _repeat106++) {
				class_map.put("r".concat(String.valueOf((long)(i))).concat("_".concat("t".concat(String.valueOf((long)(j))))), "");
				j++;
			}
			i++;
			j = 1;
		}
		CE_data.edit().putString("class", new Gson().toJson(class_map)).commit();
		i = 1;
		exam_map = new HashMap<>();
		for(int _repeat84 = 0; _repeat84 < (int)(7); _repeat84++) {
			exam_map.put("ed".concat(String.valueOf((long)(i))), "");
			i++;
		}
		i = 0;
		j = 1;
		for(int _repeat58 = 0; _repeat58 < (int)(8); _repeat58++) {
			for(int _repeat71 = 0; _repeat71 < (int)(6); _repeat71++) {
				exam_map.put("er".concat(String.valueOf((long)(i))).concat("_".concat("t".concat(String.valueOf((long)(j))))), "");
				j++;
			}
			i++;
			j = 1;
		}
		CE_data.edit().putString("exam", new Gson().toJson(exam_map)).commit();
		n = 0;
		links = new HashMap<>();
		for(int _repeat45 = 0; _repeat45 < (int)(9); _repeat45++) {
			n++;
			links.put("L".concat(String.valueOf((long)(n))), "");
			links.put("L".concat(String.valueOf((long)(n))).concat("t"), "");
		}
		data.edit().putString("links", new Gson().toJson(links)).commit();
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

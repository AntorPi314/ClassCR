package com.antor.classcr;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;



public class MainActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private HashMap<String, Object> settings = new HashMap<>();
	private HashMap<String, Object> links = new HashMap<>();
	private double n = 0;
	private HashMap<String, Object> class_map = new HashMap<>();
	private double i = 0;
	private double j = 0;
	private HashMap<String, Object> exam_map = new HashMap<>();
	
	private ArrayList<HashMap<String, Object>> map1 = new ArrayList<>();
	
	private LinearLayout linear00;
	
	private TimerTask t;
	private Intent in = new Intent();
	private TimePickerDialog tp;
	private TimePickerDialog.OnTimeSetListener tp_listener;
	private SharedPreferences data;
	private SharedPreferences CE_data;
	private SharedPreferences post;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear00 = findViewById(R.id.linear00);
		tp = new TimePickerDialog(this, tp_listener, Calendar.HOUR_OF_DAY, Calendar.MINUTE, false);
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		CE_data = getSharedPreferences("CE_data", Activity.MODE_PRIVATE);
		post = getSharedPreferences("post", Activity.MODE_PRIVATE);
	}
	
	private void initializeLogic() {
		if ("".equals(data.getString("makeFirstData", ""))) {
			_makeFirstData();
			data.edit().putString("admin", "stu").commit();
			data.edit().putString("code", "test_key").commit();
			data.edit().putString("root_path", "code/test_key").commit();
			data.edit().putString("makeFirstData", "1").commit();
		}
		in.setClass(getApplicationContext(), HomeActivity.class);
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
		post.edit().putString("post", "[]").commit();
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

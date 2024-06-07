package com.antor.classcr;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

public class AccountActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String color = "";
	private double n = 0;
	private HashMap<String, Object> settings = new HashMap<>();
	private String root_path = "";
	
	private ArrayList<HashMap<String, Object>> msp1 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> msp2 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> msp3 = new ArrayList<>();
	
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
	private Switch switch1;
	private Switch switch2;
	private TextView textview35;
	private Spinner spinner1;
	private TextView textview36;
	private Spinner spinner2;
	private TextView textview37;
	private Spinner spinner3;
	
	private Intent in = new Intent();
	private SharedPreferences data;
	private DatabaseReference fdb = _firebase.getReference("/");
	private ChildEventListener _fdb_child_listener;
	private Calendar cal = Calendar.getInstance();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.account);
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
		switch1 = findViewById(R.id.switch1);
		switch2 = findViewById(R.id.switch2);
		textview35 = findViewById(R.id.textview35);
		spinner1 = findViewById(R.id.spinner1);
		textview36 = findViewById(R.id.textview36);
		spinner2 = findViewById(R.id.spinner2);
		textview37 = findViewById(R.id.textview37);
		spinner3 = findViewById(R.id.spinner3);
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		
		linear9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		linear10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_firebaseSetValue("", root_path.concat("/setting"));
				fdb.child("data").updateChildren(settings);
				cal = Calendar.getInstance();
				_firebaseSetValue(String.valueOf((long)(cal.getTimeInMillis())), root_path.concat("/update/setting"));
				data.edit().putString("settings", new Gson().toJson(settings)).commit();
				_custom_toast("Saving...");
			}
		});
		
		imageview_back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		textview_mycode.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_custom_toast("Coming Soon");
			}
		});
		
		textview_logout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getApplicationContext(), SignInActivity.class);
				startActivity(in);
				finishAffinity();
			}
		});
		
		switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					settings.put("class", "1");
				}
				else {
					settings.put("class", "0");
				}
			}
		});
		
		switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					settings.put("exam", "1");
				}
				else {
					settings.put("exam", "0");
				}
			}
		});
		
		spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				settings.put("c_row", msp1.get((int)_position).get("k").toString());
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				settings.put("e_row", msp2.get((int)_position).get("k").toString());
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				settings.put("e_col", msp3.get((int)_position).get("k").toString());
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		_fdb_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		fdb.addChildEventListener(_fdb_child_listener);
	}
	
	private void initializeLogic() {
		
		Window window = this.getWindow();
		window.setNavigationBarColor(Color.parseColor("#152232"));
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
			Window w =AccountActivity.this.getWindow();
			w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(0xFF152232);
		}
		_round_view_s1(textview_mycode, "#009688", "#009688", 12);
		_round_view_s1(textview_logout, "#D32F2F", "#D32F2F", 12);
		color = "#101825";
		_round_view_s1(linear9, color, color, 8);
		_round_view_s1(linear10, color, color, 8);
		_round_view_s1(linear17, color, color, 8);
		_round_view_s1(linear18, color, color, 8);
		_round_view_s1(linear19, color, color, 8);
		_round_view_s1(button1, "#7CB342", "#7CB342", 30);
		n = 0;
		for(int _repeat38 = 0; _repeat38 < (int)(9); _repeat38++) {
			n++;
			{
				HashMap<String, Object> _item = new HashMap<>();
				_item.put("k", String.valueOf((long)(n)));
				msp1.add(_item);
			}
			
		}
		n = 0;
		for(int _repeat45 = 0; _repeat45 < (int)(6); _repeat45++) {
			n++;
			{
				HashMap<String, Object> _item = new HashMap<>();
				_item.put("k", String.valueOf((long)(n)));
				msp2.add(_item);
			}
			
		}
		n = 0;
		for(int _repeat51 = 0; _repeat51 < (int)(7); _repeat51++) {
			n++;
			{
				HashMap<String, Object> _item = new HashMap<>();
				_item.put("k", String.valueOf((long)(n)));
				msp3.add(_item);
			}
			
		}
		spinner1.setAdapter(new Spinner1Adapter(msp1));
		spinner2.setAdapter(new Spinner2Adapter(msp2));
		spinner3.setAdapter(new Spinner3Adapter(msp3));
		root_path = data.getString("root_path", "");
		settings = new Gson().fromJson(data.getString("settings", ""), new TypeToken<HashMap<String, Object>>(){}.getType());
		if (settings.get("class").toString().equals("1")) {
			switch1.setChecked(true);
		}
		else {
			switch1.setChecked(false);
		}
		if (settings.get("exam").toString().equals("1")) {
			switch2.setChecked(true);
		}
		else {
			switch2.setChecked(false);
		}
		spinner1.setSelection((int)(Double.parseDouble(settings.get("c_row").toString()) - 1));
		spinner2.setSelection((int)(Double.parseDouble(settings.get("e_row").toString()) - 1));
		spinner3.setSelection((int)(Double.parseDouble(settings.get("e_col").toString()) - 1));
	}
	
	public void _round_view_s1(final View _view, final String _bg_c, final String _s_c, final double _r) {
		android.graphics.drawable.GradientDrawable gds1 = new android.graphics.drawable.GradientDrawable();
		
		gds1.setColor(Color.parseColor(_bg_c));
		gds1.setCornerRadius((float)_r);
		gds1.setStroke(3, Color.parseColor(_s_c));
		
		_view.setBackground(gds1);
	}
	
	
	public void _custom_toast(final String _text) {
		LayoutInflater inflater = getLayoutInflater(); View toastLayout = inflater.inflate(R.layout.custom_toast, null);
		
		TextView textview1 = (TextView) toastLayout.findViewById(R.id.textview1);
		textview1.setText(_text);
		LinearLayout linear1 = (LinearLayout) toastLayout.findViewById(R.id.linear1);
		
		
		
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor("#38304C"));
		gd.setCornerRadius(6);
		gd.setStroke(2, Color.parseColor("#38304C"));
		linear1.setBackground(gd);
		
		
		Toast toast = new Toast(getApplicationContext()); toast.setDuration(Toast.LENGTH_SHORT);
		toast.setView(toastLayout);
		toast.show();
	}
	
	
	public void _firebaseSetValue(final String _value, final String _path) {
		if (!"".equals(_path)) {
			fdb = _firebase.getReference(_path);
		}
		if (!"".equals(_value)) {
			fdb.setValue(_value);
		}
	}
	
	public class Spinner1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Spinner1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.sp1, null);
			}
			
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final LinearLayout linear_line = _view.findViewById(R.id.linear_line);
			
			textview1.setText(msp1.get((int)_position).get("k").toString());
			
			return _view;
		}
	}
	
	public class Spinner2Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Spinner2Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.sp1, null);
			}
			
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final LinearLayout linear_line = _view.findViewById(R.id.linear_line);
			
			textview1.setText(msp2.get((int)_position).get("k").toString());
			
			return _view;
		}
	}
	
	public class Spinner3Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Spinner3Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.sp1, null);
			}
			
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final LinearLayout linear_line = _view.findViewById(R.id.linear_line);
			
			textview1.setText(msp3.get((int)_position).get("k").toString());
			
			return _view;
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

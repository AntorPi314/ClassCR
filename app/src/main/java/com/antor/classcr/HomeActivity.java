package com.antor.classcr;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.view.inputmethod.InputMethodManager;

public class HomeActivity extends AppCompatActivity {

	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private Context context;

	private String color = "";
	private HashMap<String, Object> settings = new HashMap<>();
	private double c_row = 0;
	private String s = "";
	private String day_count = "";
	private double e_row = 0;
	private double e_col = 0;
	private String admin = "";
	private HashMap<String, Object> links = new HashMap<>();
	private double size = 0;
	private double percentage = 0;
	private double sumCount = 0;
	private String filename = "";
	private String newfilename = "";
	private String result = "";
	private String path = "";
	private boolean b_image = false;
	private boolean b_downloadError = false;
	private String myurl = "";
	private double L_n = 0;
	private String link_image_bg = "";
	private String S_edi1 = "";
	private String S_edi2 = "";
	private HashMap<String, Object> class_map = new HashMap<>();
	private HashMap<String, Object> exam_map = new HashMap<>();
	private HashMap<String, Object> fdb_map = new HashMap<>();
	private String root_path = "";
	private String data_path = "";
	private HashMap<String, Object> post_map = new HashMap<>();
	private String current_ms = "";
	private HashMap<String, Object> notify_map = new HashMap<>();

	private ArrayList<HashMap<String, Object>> map1 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> postMap = new ArrayList<>();

	private LinearLayout linear0;
	private ListView listview1;

	private TimerTask t;
	private Intent in = new Intent();
	private SharedPreferences data;
	private Calendar cal = Calendar.getInstance();
	private AlertDialog.Builder dia;
	private SharedPreferences CE_data;
	private SharedPreferences post;
	private DatabaseReference fdb = _firebase.getReference("/");
	private ChildEventListener _fdb_child_listener;
	private DatabaseReference fdb0 = _firebase.getReference("/");
	private ChildEventListener _fdb0_child_listener;
	private DatabaseReference fdb1 = _firebase.getReference("/");
	private ChildEventListener _fdb1_child_listener;
	private DatabaseReference fdb2 = _firebase.getReference("/");
	private ChildEventListener _fdb2_child_listener;
	private DatabaseReference fdb3 = _firebase.getReference("/");
	private ChildEventListener _fdb3_child_listener;
	private DatabaseReference fdb4 = _firebase.getReference("/");
	private ChildEventListener _fdb4_child_listener;

	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.home);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}

	private void initialize(Bundle _savedInstanceState) {
		linear0 = findViewById(R.id.linear0);
		listview1 = findViewById(R.id.listview1);
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		dia = new AlertDialog.Builder(this);
		CE_data = getSharedPreferences("CE_data", Activity.MODE_PRIVATE);
		post = getSharedPreferences("post", Activity.MODE_PRIVATE);

		listview1.setOnScrollListener(new AbsListView.OnScrollListener() {
			@Override
			public void onScrollStateChanged(AbsListView abs, int _scrollState) {

			}

			@Override
			public void onScroll(AbsListView abs, int _firstVisibleItem, int _visibleItemCount, int _totalItemCount) {

			}
		});

		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;

			}
		});

		listview1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;

				return true;
			}
		});

		_fdb_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
				};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);

			}

			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
				};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);

			}

			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {

			}

			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
				};
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

		_fdb0_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
				};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals("data")) {
					if (!_childValue.isEmpty()) {
						settings = _childValue;
						data.edit().putString("update_setting", fdb_map.get("setting").toString()).commit();
						((BaseAdapter) listview1.getAdapter()).notifyDataSetChanged();
						data.edit().putString("settings", new Gson().toJson(settings)).commit();
					}
				}
			}

			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
				};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);

			}

			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {

			}

			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
				};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);

			}

			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();

			}
		};
		fdb0.addChildEventListener(_fdb0_child_listener);

		_fdb1_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
				};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals("data")) {
					if (!_childValue.isEmpty()) {
						class_map = _childValue;
						data.edit().putString("update_class", fdb_map.get("class").toString()).commit();
						((BaseAdapter) listview1.getAdapter()).notifyDataSetChanged();
						CE_data.edit().putString("class", new Gson().toJson(class_map)).commit();
					}
				}
			}

			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
				};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);

			}

			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {

			}

			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
				};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);

			}

			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();

			}
		};
		fdb1.addChildEventListener(_fdb1_child_listener);

		_fdb2_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
				};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals("data")) {
					if (!_childValue.isEmpty()) {
						exam_map = _childValue;
						data.edit().putString("update_exam", fdb_map.get("exam").toString()).commit();
						((BaseAdapter) listview1.getAdapter()).notifyDataSetChanged();
						CE_data.edit().putString("exam", new Gson().toJson(exam_map)).commit();
					}
				}
			}

			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
				};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);

			}

			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {

			}

			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
				};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);

			}

			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();

			}
		};
		fdb2.addChildEventListener(_fdb2_child_listener);

		_fdb3_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
				};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals("data")) {
					if (!_childValue.isEmpty()) {
						notify_map = _childValue;
						data.edit().putString("update_notify", fdb_map.get("notify").toString()).commit();
						_androidxNotification(notify_map.get("a").toString(), notify_map.get("b").toString());
					}
				}
			}

			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
				};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);

			}

			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {

			}

			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
				};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);

			}

			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();

			}
		};
		fdb3.addChildEventListener(_fdb3_child_listener);

		_fdb4_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
				};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals("data")) {
					if (!_childValue.isEmpty()) {
						links = _childValue;
						data.edit().putString("update_link", fdb_map.get("link").toString()).commit();
						((BaseAdapter) listview1.getAdapter()).notifyDataSetChanged();
						data.edit().putString("links", new Gson().toJson(links)).commit();
					}
				}
			}

			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
				};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);

			}

			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {

			}

			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
				};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);

			}

			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();

			}
		};
		fdb4.addChildEventListener(_fdb4_child_listener);
	}

	private void initializeLogic() {
		listview1.setVerticalScrollBarEnabled(false);
		Window window = this.getWindow();
		window.setNavigationBarColor(Color.parseColor("#152232"));

		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		admin = data.getString("admin", "");
		root_path = data.getString("root_path", "");
		settings = new Gson().fromJson(data.getString("settings", ""), new TypeToken<HashMap<String, Object>>() {
		}.getType());
		links = new Gson().fromJson(data.getString("links", ""), new TypeToken<HashMap<String, Object>>() {
		}.getType());
		class_map = new Gson().fromJson(CE_data.getString("class", ""), new TypeToken<HashMap<String, Object>>() {
		}.getType());
		exam_map = new Gson().fromJson(CE_data.getString("exam", ""), new TypeToken<HashMap<String, Object>>() {
		}.getType());
		postMap = new Gson().fromJson(post.getString("post", ""), new TypeToken<ArrayList<HashMap<String, Object>>>() {
		}.getType());
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("k", "Class");
			map1.add(_item);
		}

		for (int _repeat17 = 0; _repeat17 < (int) (postMap.size()); _repeat17++) {
			{
				HashMap<String, Object> _item = new HashMap<>();
				_item.put("k", "post");
				map1.add(_item);
			}

		}
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("k", "last");
			map1.add(_item);
		}

		listview1.setAdapter(new Listview1Adapter(map1));
		_checkUpdateAll();
	}

	@Override
	public void onResume() {
		super.onResume();
		settings = new Gson().fromJson(data.getString("settings", ""), new TypeToken<HashMap<String, Object>>() {
		}.getType());
		((BaseAdapter) listview1.getAdapter()).notifyDataSetChanged();
	}

	public void _round_view_s1(final View _view, final String _bg_c, final String _s_c, final double _r) {
		android.graphics.drawable.GradientDrawable gds1 = new android.graphics.drawable.GradientDrawable();

		gds1.setColor(Color.parseColor(_bg_c));
		gds1.setCornerRadius((float) _r);
		gds1.setStroke(3, Color.parseColor(_s_c));

		_view.setBackground(gds1);
	}


	public void _round_view(final double _num, final View _view) {
		_view.setElevation(12);
		if (_num == 0) {
			color = "#101825";
		}
		if (_num == 1) {
			color = "#4530B3";
		}
		if (_num == 2) {
			color = "#7CB342";
		}
		_round_view_s1(_view, color, color, 8);
	}


	public void _setRound(final TextView _t1, final TextView _t2, final TextView _t3, final TextView _t4, final TextView _t5, final TextView _t6, final TextView _t7, final TextView _t8, final TextView _t9) {
		c_row = Double.parseDouble(settings.get("c_row").toString());
		_round_view(0, _t1);
		_round_view(0, _t2);
		_round_view(0, _t3);
		_round_view(0, _t4);
		_round_view(0, _t5);
		_round_view(0, _t6);
		_round_view(0, _t7);
		_round_view(0, _t8);
		_round_view(0, _t9);
		if (c_row < Double.parseDouble(_resourceName(_t1).substring((int) (4), (int) (5)))) {
			_t1.setVisibility(View.GONE);
		} else {
			_t1.setVisibility(View.VISIBLE);
		}
		if (c_row < Double.parseDouble(_resourceName(_t2).substring((int) (4), (int) (5)))) {
			_t2.setVisibility(View.GONE);
		} else {
			_t2.setVisibility(View.VISIBLE);
		}
		if (c_row < Double.parseDouble(_resourceName(_t3).substring((int) (4), (int) (5)))) {
			_t3.setVisibility(View.GONE);
		} else {
			_t3.setVisibility(View.VISIBLE);
		}
		if (c_row < Double.parseDouble(_resourceName(_t4).substring((int) (4), (int) (5)))) {
			_t4.setVisibility(View.GONE);
		} else {
			_t4.setVisibility(View.VISIBLE);
		}
		if (c_row < Double.parseDouble(_resourceName(_t5).substring((int) (4), (int) (5)))) {
			_t5.setVisibility(View.GONE);
		} else {
			_t5.setVisibility(View.VISIBLE);
		}
		if (c_row < Double.parseDouble(_resourceName(_t6).substring((int) (4), (int) (5)))) {
			_t6.setVisibility(View.GONE);
		} else {
			_t6.setVisibility(View.VISIBLE);
		}
		if (c_row < Double.parseDouble(_resourceName(_t7).substring((int) (4), (int) (5)))) {
			_t7.setVisibility(View.GONE);
		} else {
			_t7.setVisibility(View.VISIBLE);
		}
		if (c_row < Double.parseDouble(_resourceName(_t8).substring((int) (4), (int) (5)))) {
			_t8.setVisibility(View.GONE);
		} else {
			_t8.setVisibility(View.VISIBLE);
		}
		if (c_row < Double.parseDouble(_resourceName(_t9).substring((int) (4), (int) (5)))) {
			_t9.setVisibility(View.GONE);
		} else {
			_t9.setVisibility(View.VISIBLE);
		}
	}


	public void _setRound2(final TextView _t1, final TextView _t2, final TextView _t3, final TextView _t4, final TextView _t5, final TextView _t6) {
		e_row = Double.parseDouble(settings.get("e_row").toString());
		_round_view(0, _t1);
		_round_view(0, _t2);
		_round_view(0, _t3);
		_round_view(0, _t4);
		_round_view(0, _t5);
		_round_view(0, _t6);
		if (e_row < Double.parseDouble(_resourceName(_t1).substring((int) (5), (int) (6)))) {
			_t1.setVisibility(View.GONE);
		} else {
			_t1.setVisibility(View.VISIBLE);
		}
		if (e_row < Double.parseDouble(_resourceName(_t2).substring((int) (5), (int) (6)))) {
			_t2.setVisibility(View.GONE);
		} else {
			_t2.setVisibility(View.VISIBLE);
		}
		if (e_row < Double.parseDouble(_resourceName(_t3).substring((int) (5), (int) (6)))) {
			_t3.setVisibility(View.GONE);
		} else {
			_t3.setVisibility(View.VISIBLE);
		}
		if (e_row < Double.parseDouble(_resourceName(_t4).substring((int) (5), (int) (6)))) {
			_t4.setVisibility(View.GONE);
		} else {
			_t4.setVisibility(View.VISIBLE);
		}
		if (e_row < Double.parseDouble(_resourceName(_t5).substring((int) (5), (int) (6)))) {
			_t5.setVisibility(View.GONE);
		} else {
			_t5.setVisibility(View.VISIBLE);
		}
		if (e_row < Double.parseDouble(_resourceName(_t6).substring((int) (5), (int) (6)))) {
			_t6.setVisibility(View.GONE);
		} else {
			_t6.setVisibility(View.VISIBLE);
		}
	}


	public void _setRound0(final TextView _t0, final TextView _t1, final TextView _t2, final TextView _t3, final TextView _t4, final TextView _t5, final TextView _t6, final TextView _t7) {
		_round_view(0, _t0);
		_round_view(0, _t1);
		_round_view(0, _t2);
		_round_view(0, _t3);
		_round_view(0, _t4);
		_round_view(0, _t5);
		_round_view(0, _t6);
		_round_view(0, _t7);
	}


	public void _setColorDay(final TextView _t1, final TextView _t2, final TextView _t3, final TextView _t4, final TextView _t5, final TextView _t6, final TextView _t7) {
		cal = Calendar.getInstance();
		if (_t1.getText().toString().toLowerCase().equals(new SimpleDateFormat("cccc").format(cal.getTime()).substring((int) (0), (int) (3)).toLowerCase())) {
			_round_view(2, _t1);
			day_count = "1";
		}
		if (_t2.getText().toString().toLowerCase().equals(new SimpleDateFormat("cccc").format(cal.getTime()).substring((int) (0), (int) (3)).toLowerCase())) {
			_round_view(2, _t2);
			day_count = "2";
		}
		if (_t3.getText().toString().toLowerCase().equals(new SimpleDateFormat("cccc").format(cal.getTime()).substring((int) (0), (int) (3)).toLowerCase())) {
			_round_view(2, _t3);
			day_count = "3";
		}
		if (_t4.getText().toString().toLowerCase().equals(new SimpleDateFormat("cccc").format(cal.getTime()).substring((int) (0), (int) (3)).toLowerCase())) {
			_round_view(2, _t4);
			day_count = "4";
		}
		if (_t5.getText().toString().toLowerCase().equals(new SimpleDateFormat("cccc").format(cal.getTime()).substring((int) (0), (int) (3)).toLowerCase())) {
			_round_view(2, _t5);
			day_count = "5";
		}
		if (_t6.getText().toString().toLowerCase().equals(new SimpleDateFormat("cccc").format(cal.getTime()).substring((int) (0), (int) (3)).toLowerCase())) {
			_round_view(2, _t6);
			day_count = "6";
		}
		if (_t7.getText().toString().toLowerCase().equals(new SimpleDateFormat("cccc").format(cal.getTime()).substring((int) (0), (int) (3)).toLowerCase())) {
			_round_view(2, _t7);
			day_count = "7";
		}
	}


	public String _resourceName(final TextView _t1) {
		String _resourceName = getResources().getResourceEntryName(_t1.getId());
		return _resourceName;
	}


	public void _setRound_date(final TextView _t1, final TextView _t2, final TextView _t3, final TextView _t4, final View _l1, final View _l2, final View _l3, final View _l4) {
		e_col = Double.parseDouble(settings.get("e_col").toString());
		_round_view(0, _t1);
		_round_view(0, _t2);
		_round_view(0, _t3);
		_round_view(0, _t4);
		if (e_col < Double.parseDouble(_resourceName(_t1).substring((int) (2), (int) (_resourceName(_t1).length())))) {
			_t1.setVisibility(View.GONE);
			_l1.setVisibility(View.GONE);
		} else {
			_t1.setVisibility(View.VISIBLE);
			_l1.setVisibility(View.VISIBLE);
		}
		if (e_col < Double.parseDouble(_resourceName(_t2).substring((int) (2), (int) (_resourceName(_t2).length())))) {
			_t2.setVisibility(View.GONE);
			_l2.setVisibility(View.GONE);
		} else {
			_t2.setVisibility(View.VISIBLE);
			_l2.setVisibility(View.VISIBLE);
		}
		if (e_col < Double.parseDouble(_resourceName(_t3).substring((int) (2), (int) (_resourceName(_t3).length())))) {
			_t3.setVisibility(View.GONE);
			_l3.setVisibility(View.GONE);
		} else {
			_t3.setVisibility(View.VISIBLE);
			_l3.setVisibility(View.VISIBLE);
		}
		if (e_col < Double.parseDouble(_resourceName(_t4).substring((int) (2), (int) (_resourceName(_t4).length())))) {
			_t4.setVisibility(View.GONE);
			_l4.setVisibility(View.GONE);
		} else {
			_t4.setVisibility(View.VISIBLE);
			_l4.setVisibility(View.VISIBLE);
		}
	}


	public void _POST(final View _linear, final ImageView _image, final TextView _title, final TextView _des, final TextView _date, final double _position) {
		if (!((_position == 0) || (_position == (map1.size() - 1)))) {
			_title.setText(postMap.get((int) _position - 1).get("a").toString());
			_des.setText(postMap.get((int) _position - 1).get("b").toString());
			cal.setTimeInMillis((long) (167978425807799999d - Double.parseDouble(postMap.get((int) _position - 1).get("d").toString())));
			_date.setText(new SimpleDateFormat("dd").format(cal.getTime()).concat("\n".concat(_monthName(new SimpleDateFormat("MM").format(cal.getTime())))));
		}
		_getLinks(_des, "");
		if ("cr".equals(admin)) {
			_linear.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View _view) {
					final AlertDialog dialog2 = new AlertDialog.Builder(HomeActivity.this).create();
					View inflate = getLayoutInflater().inflate(R.layout.cust2, null);
					dialog2.setView(inflate);
					dialog2.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

					LinearLayout bg = (LinearLayout) inflate.findViewById(R.id.bg);
					TextView but1 = (TextView) inflate.findViewById(R.id.button1);
					TextView but2 = (TextView) inflate.findViewById(R.id.button2);

					but1.setTransformationMethod(null);
					but2.setTransformationMethod(null);

					_round_view_s1(bg, "#101825", "#101825", 12);
					_round_view_s1(but1, "#F44336", "#F44336", 12);
					_round_view_s1(but2, "#201A30", "#201A30", 12);
					but1.setElevation((float) 5);
					but2.setElevation((float) 5);

					but1.setOnClickListener(new OnClickListener() {
						public void onClick(View view) {

							dialog2.dismiss();
							_deletePost(_position);
						}
					});
					but2.setOnClickListener(new OnClickListener() {
						public void onClick(View view) {


							dialog2.dismiss();


						}
					});
					dialog2.show();
					return true;
				}
			});
		}
	}


	public void _LINK_IMAGE(final ImageView _m1, final ImageView _m2, final ImageView _m3, final ImageView _m4, final ImageView _m5, final ImageView _m6, final ImageView _m7, final ImageView _m8, final ImageView _m9) {
		link_image_bg = "#201A30";
		_round_view_s1(_m1, link_image_bg, link_image_bg, 90);
		_round_view_s1(_m2, link_image_bg, link_image_bg, 90);
		_round_view_s1(_m3, link_image_bg, link_image_bg, 90);
		_round_view_s1(_m4, link_image_bg, link_image_bg, 90);
		_round_view_s1(_m5, link_image_bg, link_image_bg, 90);
		_round_view_s1(_m6, link_image_bg, link_image_bg, 90);
		_round_view_s1(_m7, link_image_bg, link_image_bg, 90);
		_round_view_s1(_m8, link_image_bg, link_image_bg, 90);
		_round_view_s1(_m9, link_image_bg, link_image_bg, 90);
		_m1.setElevation((float) 4);
		_m2.setElevation((float) 4);
		_m3.setElevation((float) 4);
		_m4.setElevation((float) 4);
		_m5.setElevation((float) 4);
		_m6.setElevation((float) 4);
		_m7.setElevation((float) 4);
		_m8.setElevation((float) 4);
		_m9.setElevation((float) 4);
		_setLINK_IMAGE(_m1, "L1");
		_setLINK_IMAGE(_m2, "L2");
		_setLINK_IMAGE(_m3, "L3");
		_setLINK_IMAGE(_m4, "L4");
		_setLINK_IMAGE(_m5, "L5");
		_setLINK_IMAGE(_m6, "L6");
		_setLINK_IMAGE(_m7, "L7");
		_setLINK_IMAGE(_m8, "L8");
		_setLINK_IMAGE(_m9, "L9");
	}


	public void _LINK_TITLE(final TextView _t1, final TextView _t2, final TextView _t3, final TextView _t4, final TextView _t5, final TextView _t6, final TextView _t7, final TextView _t8, final TextView _t9) {
		_setLinkTitle(_t1, "L1t");
		_setLinkTitle(_t2, "L2t");
		_setLinkTitle(_t3, "L3t");
		_setLinkTitle(_t4, "L4t");
		_setLinkTitle(_t5, "L5t");
		_setLinkTitle(_t6, "L6t");
		_setLinkTitle(_t7, "L7t");
		_setLinkTitle(_t8, "L8t");
		_setLinkTitle(_t9, "L9t");
	}


	public void _LINK_MAP(final View _v1, final View _v2, final View _v3, final View _v4, final View _v5, final View _v6, final View _v7, final View _v8, final View _v9) {
		_LINK_CLICK(_v1, _v2, _v3, _v4, _v5, _v6, _v7, _v8, _v9);
		if (admin.equals("cr")) {
			_LINK_EDIT(_v1, _v2, _v3, _v4, _v5, _v6, _v7, _v8, _v9);
		}
		if (admin.equals("stu")) {
			_linkMapStu(_v2, "L2");
			_linkMapStu(_v3, "L3");
			_linkMapStu(_v4, "L4");
			_linkMapStu(_v5, "L5");
			_linkMapStu(_v6, "L6");
			_linkMapStu(_v7, "L7");
			_linkMapStu(_v8, "L8");
			_linkMapStu(_v9, "L9");
		}
	}


	public void _custom_toast(final String _text) {
		LayoutInflater inflater = getLayoutInflater();
		View toastLayout = inflater.inflate(R.layout.custom_toast, null);

		TextView textview1 = (TextView) toastLayout.findViewById(R.id.textview1);
		textview1.setText(_text);
		LinearLayout linear1 = (LinearLayout) toastLayout.findViewById(R.id.linear1);


		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor("#38304C"));
		gd.setCornerRadius(6);
		gd.setStroke(2, Color.parseColor("#38304C"));
		linear1.setBackground(gd);


		Toast toast = new Toast(getApplicationContext());
		toast.setDuration(Toast.LENGTH_SHORT);
		toast.setView(toastLayout);
		toast.show();
	}


	public void _browser(final String _url) {
		if (_url.equals("http://") || _url.contains("https://")) {
			androidx.browser.customtabs.CustomTabsIntent.Builder builder = new androidx.browser.customtabs.CustomTabsIntent.Builder();
			androidx.browser.customtabs.CustomTabsIntent customTabsIntent = builder.build();
			customTabsIntent.launchUrl(getCurrentContext(this), Uri.parse(_url));


		}


	}

	public Context getCurrentContext(Context c) {
		return c;
	}

	public Context getCurrentContext(Fragment c) {
		return c.getActivity();
	}

	public Context getCurrentContext(DialogFragment c) {
		return c.getActivity();
	}

	{
	}


	public void _LINK_CLICK(final View _v1, final View _v2, final View _v3, final View _v4, final View _v5, final View _v6, final View _v7, final View _v8, final View _v9) {
		_v1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_browser(links.get("L1").toString());
				if ("".contains(links.get("L1").toString()) || "".contains(links.get("L1").toString())) {

				}
			}
		});
		_v2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_browser(links.get("L2").toString());
			}
		});
		_v3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!"".equals(links.get("L3").toString())) {
					_browser(links.get("L3").toString());
				}
			}
		});
		_v4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!"".equals(links.get("L4").toString())) {
					_browser(links.get("L4").toString());
				}
			}
		});
		_v5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!"".equals(links.get("L5").toString())) {
					_browser(links.get("L5").toString());
				}
			}
		});
		_v6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!"".equals(links.get("L6").toString())) {
					_browser(links.get("L6").toString());
				}
			}
		});
		_v7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!"".equals(links.get("L7").toString())) {
					_browser(links.get("L7").toString());
				}
			}
		});
		_v8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!"".equals(links.get("L8").toString())) {
					_browser(links.get("L8").toString());
				}
			}
		});
		_v9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!"".equals(links.get("L9").toString())) {
					_browser(links.get("L9").toString());
				}
			}
		});
	}


	public void _LINK_EDIT(final View _v1, final View _v2, final View _v3, final View _v4, final View _v5, final View _v6, final View _v7, final View _v8, final View _v9) {
		if ("cr".equals(admin)) {
			_v1.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View _view) {
					_editLink_dia("L1");
					return true;
				}
			});
			_v2.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View _view) {
					_editLink_dia("L2");
					return true;
				}
			});
			_v3.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View _view) {
					_editLink_dia("L3");
					return true;
				}
			});
			_v4.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View _view) {
					_editLink_dia("L4");
					return true;
				}
			});
			_v5.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View _view) {
					_editLink_dia("L5");
					return true;
				}
			});
			_v6.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View _view) {
					_editLink_dia("L6");
					return true;
				}
			});
			_v7.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View _view) {
					_editLink_dia("L7");
					return true;
				}
			});
			_v8.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View _view) {
					_editLink_dia("L8");
					return true;
				}
			});
			_v9.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View _view) {
					_editLink_dia("L9");
					return true;
				}
			});
		}
	}


	public void _getLinks(final TextView _textview, final String _colour) {
		_textview.setClickable(true);
		android.text.util.Linkify.addLinks(_textview, android.text.util.Linkify.ALL);
		if (_colour.equals("")) {
			_textview.setLinkTextColor(Color.parseColor("#2196F3"));
		} else {
			_textview.setLinkTextColor(Color.parseColor("_colour"));
		}
		_textview.setLinksClickable(true);
	}


	public void _deletePost(final double _position) {
		_firebaseSetValue("", root_path.concat("/post/data"));
		fdb.child(postMap.get((int) _position - 1).get("d").toString()).removeValue();
		cal = Calendar.getInstance();
		_firebaseSetValue(String.valueOf((long) (cal.getTimeInMillis())), root_path.concat("/update/post"));
		_custom_toast("Deleting...");
	}


	public void _editLink_dia(final String _k) {
		if (links.containsKey(_k.concat("t"))) {
			S_edi1 = links.get(_k.concat("t")).toString();
		} else {
			S_edi1 = "";
		}
		if (links.containsKey(_k)) {
			S_edi2 = links.get(_k).toString();
		} else {
			S_edi2 = "";
		}
		final AlertDialog dialog2 = new AlertDialog.Builder(HomeActivity.this).create();
		View inflate = getLayoutInflater().inflate(R.layout.cust3, null);
		dialog2.setView(inflate);
		dialog2.setCanceledOnTouchOutside(false);
		dialog2.setCancelable(false);
		dialog2.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

		TextView title = (TextView) inflate.findViewById(R.id.title);
		LinearLayout bg = (LinearLayout) inflate.findViewById(R.id.bg);
		final EditText edi1 = (EditText) inflate.findViewById(R.id.edittext1);
		final EditText edi2 = (EditText) inflate.findViewById(R.id.edittext2);
		TextView but1 = (TextView) inflate.findViewById(R.id.button1);
		TextView but2 = (TextView) inflate.findViewById(R.id.button2);

		edi1.setText(S_edi1);
		edi2.setText(S_edi2);

		but1.setTransformationMethod(null);
		but2.setTransformationMethod(null);

		_round_view_s1(bg, "#101825", "#101825", 12);
		_round_view_s1(edi1, "#38304C", "#38304C", 12);
		_round_view_s1(edi2, "#38304C", "#38304C", 12);
		_round_view_s1(but1, "#1A237E", "#1A237E", 12);
		_round_view_s1(but2, "#201A30", "#201A30", 12);
		but1.setElevation((float) 5);
		but2.setElevation((float) 5);

		but1.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {

				String S_edi1 = edi1.getText() + "";
				String S_edi2 = edi2.getText() + "";

				dialog2.dismiss();
				_firebaseSetValueEmpty(S_edi1.trim(), root_path.concat("/link/data/".concat(_k.concat("t"))));
				_firebaseSetValueEmpty(S_edi2.trim(), root_path.concat("/link/data/".concat(_k)));
				cal = Calendar.getInstance();
				_firebaseSetValue(String.valueOf((long) (cal.getTimeInMillis())), root_path.concat("/update/link"));
				_custom_toast("Saving...");
			}
		});
		but2.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {

				dialog2.dismiss();


				_hideKeyboard();
			}
		});

		edi1.setFocusableInTouchMode(true);
		edi2.setFocusableInTouchMode(true);
		edi1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(200)});
		edi2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
		edi1.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
		edi2.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);


		dialog2.show();
	}


	public void _newPOST() {
		final AlertDialog dialog2 = new AlertDialog.Builder(HomeActivity.this).create();
		View inflate = getLayoutInflater().inflate(R.layout.cust4, null);
		dialog2.setView(inflate);
		dialog2.setCanceledOnTouchOutside(false);
		dialog2.setCancelable(false);
		dialog2.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

		TextView title = (TextView) inflate.findViewById(R.id.title);
		LinearLayout bg = (LinearLayout) inflate.findViewById(R.id.bg);
		final EditText edi1 = (EditText) inflate.findViewById(R.id.edittext1);
		final EditText edi2 = (EditText) inflate.findViewById(R.id.edittext2);
		TextView but1 = (TextView) inflate.findViewById(R.id.button1);
		TextView but2 = (TextView) inflate.findViewById(R.id.button2);


		but1.setTransformationMethod(null);
		but2.setTransformationMethod(null);

		_round_view_s1(bg, "#101825", "#101825", 12);
		_round_view_s1(edi1, "#38304C", "#38304C", 12);
		_round_view_s1(edi2, "#38304C", "#38304C", 12);
		_round_view_s1(but1, "#1A237E", "#1A237E", 12);
		_round_view_s1(but2, "#201A30", "#201A30", 12);
		but1.setElevation((float) 5);
		but2.setElevation((float) 5);

		but1.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {

				String S_edi1 = edi1.getText() + "";
				String S_edi2 = edi2.getText() + "";

				dialog2.dismiss();
				_hideKeyboard();
				_firebaseSetValue("", root_path.concat("/post/data"));
				post_map = new HashMap<>();
				post_map.put("a", S_edi1.trim());
				post_map.put("b", S_edi2.trim());
				cal = Calendar.getInstance();
				current_ms = String.valueOf((long) (167978425807799999d - cal.getTimeInMillis()));
				post_map.put("d", current_ms);
				fdb.child(current_ms).updateChildren(post_map);
				_firebaseSetValue(current_ms, root_path.concat("/update/post"));
				_firebaseSetValue(S_edi1.trim(), root_path.concat("/notify/data/a"));
				_firebaseSetValue(S_edi2.trim(), root_path.concat("/notify/data/b"));
				_firebaseSetValue(current_ms, root_path.concat("/update/notify"));
				_custom_toast("Posting....");
			}
		});
		but2.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {

				dialog2.dismiss();


				_hideKeyboard();
			}
		});

		edi1.setFocusableInTouchMode(true);
		edi2.setFocusableInTouchMode(true);
		edi1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(200)});
		edi2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
		edi1.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_MULTI_LINE | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
		edi2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_MULTI_LINE | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);

		dialog2.show();
	}


	public void _selectClassTime(final TextView _t1, final TextView _t2, final TextView _t3, final TextView _t4, final TextView _t5, final TextView _t6, final TextView _t7, final TextView _t8, final TextView _t9) {
		_setAllText(_t1, "c");
		_setAllText(_t2, "c");
		_setAllText(_t3, "c");
		_setAllText(_t4, "c");
		_setAllText(_t5, "c");
		_setAllText(_t6, "c");
		_setAllText(_t7, "c");
		_setAllText(_t8, "c");
		_setAllText(_t9, "c");
		if ("cr".equals(admin)) {
			_clickClassTime(_t1);
			_clickClassTime(_t2);
			_clickClassTime(_t3);
			_clickClassTime(_t4);
			_clickClassTime(_t5);
			_clickClassTime(_t6);
			_clickClassTime(_t7);
			_clickClassTime(_t8);
			_clickClassTime(_t9);
		}
	}


	public void _clickClassTime(final TextView _t1) {
		_clickAllText(_t1, "Edit Time", "Time", "c");
	}


	public void _selectClassSubject(final TextView _t1, final TextView _t2, final TextView _t3, final TextView _t4, final TextView _t5, final TextView _t6, final TextView _t7, final TextView _t8, final TextView _t9) {
		_setAllText(_t1, "c");
		_setAllText(_t2, "c");
		_setAllText(_t3, "c");
		_setAllText(_t4, "c");
		_setAllText(_t5, "c");
		_setAllText(_t6, "c");
		_setAllText(_t7, "c");
		_setAllText(_t8, "c");
		_setAllText(_t9, "c");
		if ("cr".equals(admin)) {
			_clickClassSubject(_t1);
			_clickClassSubject(_t2);
			_clickClassSubject(_t3);
			_clickClassSubject(_t4);
			_clickClassSubject(_t5);
			_clickClassSubject(_t6);
			_clickClassSubject(_t7);
			_clickClassSubject(_t8);
			_clickClassSubject(_t9);
		}
		_setColorSubject(_t1, _t2, _t3, _t4, _t5, _t6, _t7, _t8, _t9);
	}


	public void _clickClassSubject(final TextView _t1) {
		_clickAllText(_t1, "Edit Subject", "Subject", "c");
	}


	public void _selectExamTime(final TextView _t1, final TextView _t2, final TextView _t3, final TextView _t4, final TextView _t5, final TextView _t6) {
		_setAllText(_t1, "e");
		_setAllText(_t2, "e");
		_setAllText(_t3, "e");
		_setAllText(_t4, "e");
		_setAllText(_t5, "e");
		_setAllText(_t6, "e");
		if ("cr".equals(admin)) {
			_clickExamTime(_t1);
			_clickExamTime(_t2);
			_clickExamTime(_t3);
			_clickExamTime(_t4);
			_clickExamTime(_t5);
			_clickExamTime(_t6);
		}
	}


	public void _clickExamTime(final TextView _t1) {
		_clickAllText(_t1, "Edit Time", "Time", "e");
	}


	public void _selectExamDate(final TextView _t1, final TextView _t2, final TextView _t3, final TextView _t4, final TextView _t5, final TextView _t6, final TextView _t7) {
		_setAllText(_t1, "e");
		_setAllText(_t2, "e");
		_setAllText(_t3, "e");
		_setAllText(_t4, "e");
		_setAllText(_t5, "e");
		_setAllText(_t6, "e");
		_setAllText(_t7, "e");
		if ("cr".equals(admin)) {
			_clickExamDate(_t1);
			_clickExamDate(_t2);
			_clickExamDate(_t3);
			_clickExamDate(_t4);
			_clickExamDate(_t5);
			_clickExamDate(_t6);
			_clickExamDate(_t7);
		}
	}


	public void _clickExamDate(final TextView _t1) {
		_clickAllText(_t1, "Edit Date", "Date", "e");
	}


	public void _selectExamSubject(final TextView _t1, final TextView _t2, final TextView _t3, final TextView _t4, final TextView _t5, final TextView _t6) {
		_setAllText(_t1, "e");
		_setAllText(_t2, "e");
		_setAllText(_t3, "e");
		_setAllText(_t4, "e");
		_setAllText(_t5, "e");
		_setAllText(_t6, "e");
		if ("cr".equals(admin)) {
			_clickExamSubject(_t1);
			_clickExamSubject(_t2);
			_clickExamSubject(_t3);
			_clickExamSubject(_t4);
			_clickExamSubject(_t5);
			_clickExamSubject(_t6);
		}
	}


	public void _clickExamSubject(final TextView _t1) {
		_clickAllText(_t1, "Edit Subject", "Subject", "e");
	}


	public void _setLinkTitle(final TextView _t1, final String _key) {
		if (links.containsKey(_key)) {
			if (links.get(_key).toString() != null) {
				if ("".equals(links.get(_key).toString())) {
					_t1.setText("Title");
				} else {
					_t1.setText(links.get(_key).toString());
				}
			}
		}
	}


	public void _setAllText(final TextView _t1, final String _c_or_e) {
		if (_c_or_e.equals("c")) {
			if (class_map.containsKey(_resourceName(_t1))) {
				if (class_map.get(_resourceName(_t1)) != null) {
					if (!"".equals(class_map.get(_resourceName(_t1)).toString())) {
						_t1.setText(class_map.get(_resourceName(_t1)).toString());
					}
				}
			}
		}
		if (_c_or_e.equals("e")) {
			if (exam_map.containsKey(_resourceName(_t1))) {
				if (exam_map.get(_resourceName(_t1)) != null) {
					if (!"".equals(exam_map.get(_resourceName(_t1)).toString())) {
						_t1.setText(exam_map.get(_resourceName(_t1)).toString());
					}
				}
			}
		}
	}


	public void _hideKeyboard() {
		View view = getCurrentFocus();
		if (view != null) {
			InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
		}
	}


	public void _clickAllText(final TextView _t1, final String _title, final String _hint, final String _c_or_e) {
		_t1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final AlertDialog dialog2 = new AlertDialog.Builder(HomeActivity.this).create();
				View inflate = getLayoutInflater().inflate(R.layout.cust5, null);
				dialog2.setView(inflate);
				dialog2.setCanceledOnTouchOutside(false);
				dialog2.setCancelable(false);
				dialog2.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

				TextView title = (TextView) inflate.findViewById(R.id.title);
				LinearLayout bg = (LinearLayout) inflate.findViewById(R.id.bg);
				final EditText edi1 = (EditText) inflate.findViewById(R.id.edittext1);
				final EditText edi2 = (EditText) inflate.findViewById(R.id.edittext2);
				TextView but1 = (TextView) inflate.findViewById(R.id.button1);
				TextView but2 = (TextView) inflate.findViewById(R.id.button2);

				edi1.setText(_t1.getText().toString());

				title.setText(_title);
				edi1.setHint(_hint);
				int color = _t1.getCurrentTextColor();
				edi1.setTextColor(color);


				but1.setTransformationMethod(null);
				but2.setTransformationMethod(null);

				_round_view_s1(bg, "#101825", "#101825", 12);
				_round_view_s1(edi1, "#38304C", "#38304C", 12);
				_round_view_s1(edi2, "#38304C", "#38304C", 12);
				_round_view_s1(but1, "#1A237E", "#1A237E", 12);
				_round_view_s1(but2, "#201A30", "#201A30", 12);
				but1.setElevation((float) 5);
				but2.setElevation((float) 5);

				but1.setOnClickListener(new OnClickListener() {
					public void onClick(View view) {

						String S_edi1 = edi1.getText() + "";
						String S_edi2 = edi2.getText() + "";

						dialog2.dismiss();
						_hideKeyboard();
						_t1.setText(S_edi1.trim());
						if (_c_or_e.equals("c")) {
							_firebaseSetValueEmpty(S_edi1.trim(), root_path.concat("/class/data/".concat(_resourceName(_t1))));
							cal = Calendar.getInstance();
							_firebaseSetValue(String.valueOf((long) (cal.getTimeInMillis())), root_path.concat("/update/class"));
						} else {
							_firebaseSetValueEmpty(S_edi1.trim(), root_path.concat("/exam/data/".concat(_resourceName(_t1))));
							cal = Calendar.getInstance();
							_firebaseSetValue(String.valueOf((long) (cal.getTimeInMillis())), root_path.concat("/update/exam"));
						}
						_custom_toast("Saving...");
					}
				});
				but2.setOnClickListener(new OnClickListener() {
					public void onClick(View view) {

						dialog2.dismiss();


						_hideKeyboard();
					}
				});

				edi1.setFocusableInTouchMode(true);
				edi2.setFocusableInTouchMode(true);
				edi1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(100)});
				edi2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(200)});
				edi1.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_MULTI_LINE | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
				edi2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_MULTI_LINE | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);

				dialog2.show();
			}
		});
	}


	public String _monthName(final String _m) {
		String _m2 = "";
		if (_m.equals("01")) {
			_m2 = "Jan";
		}
		if (_m.equals("02")) {
			_m2 = "Feb";
		}
		if (_m.equals("03")) {
			_m2 = "Mar";
		}
		if (_m.equals("04")) {
			_m2 = "Apr";
		}
		if (_m.equals("05")) {
			_m2 = "May";
		}
		if (_m.equals("06")) {
			_m2 = "Jun";
		}
		if (_m.equals("07")) {
			_m2 = "Jul";
		}
		if (_m.equals("08")) {
			_m2 = "Aug";
		}
		if (_m.equals("09")) {
			_m2 = "Sep";
		}
		if (_m.equals("10")) {
			_m2 = "Oct";
		}
		if (_m.equals("11")) {
			_m2 = "Nov";
		}
		if (_m.equals("12")) {
			_m2 = "Dec";
		}
		return _m2;
	}


	public void _checkUpdateAll() {
		fdb0.removeEventListener(_fdb0_child_listener);
		fdb1.removeEventListener(_fdb1_child_listener);
		fdb2.removeEventListener(_fdb2_child_listener);
		fdb3.removeEventListener(_fdb3_child_listener);
		fdb4.removeEventListener(_fdb4_child_listener);
		fdb.removeEventListener(_fdb_child_listener);
		data_path = root_path.concat("/update");
		fdb = _firebase.getReference(data_path);

		ValueEventListener valuelistener = new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
				};

				try {
					HashMap<String, Object> _map = _param1.getValue(_ind);
					// textview1.setText(_map.get("a").toString());

					fdb_map = _map;
					if (fdb_map.get("post").toString().equals(data.getString("update_post", ""))) {

					} else {
						data_path = root_path.concat("/post/data");
						fdb3.removeEventListener(_fdb1_child_listener);
						fdb3 = _firebase.getReference(data_path);
						fdb3.addChildEventListener(_fdb3_child_listener);
						fdb3.addListenerForSingleValueEvent(new ValueEventListener() {
							@Override
							public void onDataChange(DataSnapshot _dataSnapshot) {
								postMap = new ArrayList<>();
								try {
									GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
									};
									for (DataSnapshot _data : _dataSnapshot.getChildren()) {
										HashMap<String, Object> _map = _data.getValue(_ind);
										postMap.add(_map);
									}
								} catch (Exception _e) {
									_e.printStackTrace();
								}
								map1.clear();
								{
									HashMap<String, Object> _item = new HashMap<>();
									_item.put("k", "Class");
									map1.add(_item);
								}

								for (int _repeat121 = 0; _repeat121 < (int) (postMap.size()); _repeat121++) {
									{
										HashMap<String, Object> _item = new HashMap<>();
										_item.put("k", "post");
										map1.add(_item);
									}

								}
								{
									HashMap<String, Object> _item = new HashMap<>();
									_item.put("k", "last");
									map1.add(_item);
								}

								((BaseAdapter) listview1.getAdapter()).notifyDataSetChanged();
								data.edit().putString("update_post", fdb_map.get("post").toString()).commit();
								post.edit().putString("post", new Gson().toJson(postMap)).commit();
							}

							@Override
							public void onCancelled(DatabaseError _databaseError) {
							}
						});
					}
					if (fdb_map.get("notify").toString().equals(data.getString("update_notify", ""))) {

					} else {
						data_path = root_path.concat("/notify");
						fdb3 = _firebase.getReference(data_path);
						fdb3.addChildEventListener(_fdb3_child_listener);
					}
					if (fdb_map.get("setting").toString().equals(data.getString("update_setting", ""))) {

					} else {
						data_path = root_path.concat("/setting");
						fdb0.removeEventListener(_fdb1_child_listener);
						fdb0 = _firebase.getReference(data_path);
						fdb0.addChildEventListener(_fdb0_child_listener);
					}
					if (fdb_map.get("link").toString().equals(data.getString("update_link", ""))) {

					} else {
						data_path = root_path.concat("/link");
						fdb4.removeEventListener(_fdb1_child_listener);
						fdb4 = _firebase.getReference(data_path);
						fdb4.addChildEventListener(_fdb4_child_listener);
					}
					if (fdb_map.get("class").toString().equals(data.getString("update_class", ""))) {

					} else {
						data_path = root_path.concat("/class");
						fdb1.removeEventListener(_fdb1_child_listener);
						fdb1 = _firebase.getReference(data_path);
						fdb1.addChildEventListener(_fdb1_child_listener);
					}
					if (fdb_map.get("exam").toString().equals(data.getString("update_exam", ""))) {

					} else {
						data_path = root_path.concat("/exam");
						fdb2.removeEventListener(_fdb1_child_listener);
						fdb2 = _firebase.getReference(data_path);
						fdb2.addChildEventListener(_fdb2_child_listener);
					}

				} catch (Exception e) {
					showMessage(e.toString());
				}
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {
			}
		};

		fdb.addValueEventListener(valuelistener);

	}


	public void _firebaseSetValue(final String _value, final String _path) {
		if (!"".equals(_path)) {
			fdb = _firebase.getReference(_path);
		}
		if (!"".equals(_value)) {
			fdb.setValue(_value);
		}
	}


	public void _androidxNotification(final String _Title, final String _Content) {
		if (android.os.Build.VERSION.SDK_INT <= android.os.Build.VERSION_CODES.R) {


			final Context context = getApplicationContext();


			NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

			Intent intent = new Intent(this, HomeActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
			PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
			androidx.core.app.NotificationCompat.Builder builder;

			int notificationId = 1;
			String channelId = "channel-01";
			String channelName = "Channel Name";
			int importance = NotificationManager.IMPORTANCE_HIGH;

			if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
				NotificationChannel mChannel = new NotificationChannel(
						channelId, channelName, importance);
				notificationManager.createNotificationChannel(mChannel);
			}

		/*
Developer :- androidbulb
*/
			androidx.core.app.NotificationCompat.Builder mBuilder = new androidx.core.app.NotificationCompat.Builder(context, channelId)
					.setSmallIcon(R.drawable.app_icon)
					.setContentTitle(_Title)
					.setContentText(_Content)
					.setAutoCancel(true)
					.setOngoing(false)
					.setContentIntent(pendingIntent);
			TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
			stackBuilder.addNextIntent(intent);
			PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(
					0,
					PendingIntent.FLAG_UPDATE_CURRENT
			);
			mBuilder.setContentIntent(resultPendingIntent);

			notificationManager.notify(notificationId, mBuilder.build());

		}
	}



	public void _setLINK_IMAGE(final ImageView _m1, final String _key) {
		if (links.containsKey(_key)) {
			if (links.get(_key).toString().contains("smuct")) {
				_m1.setImageResource(R.drawable.pipilika);
			}
			else {
				if (links.get(_key).toString().contains("drive.google.com")) {
					_m1.setImageResource(R.drawable.gdrive);
				}
				else {
					_m1.setImageResource(R.drawable.link_icon);
				}
			}
		}
	}
	
	
	public void _firebaseSetValueEmpty(final String _value, final String _path) {
		if (!"".equals(_path)) {
			fdb = _firebase.getReference(_path);
		}
		fdb.setValue(_value);
	}
	
	
	public void _linkMapStu(final View _v1, final String _key) {
		if (links.containsKey(_key)) {
			if (links.get(_key).toString().equals("")) {
				_v1.setVisibility(View.GONE);
			}
			else {
				_v1.setVisibility(View.VISIBLE);
			}
		}
		else {
			_v1.setVisibility(View.GONE);
		}
	}

	public void _setColorSubject(final TextView _t1, final TextView _t2, final TextView _t3, final TextView _t4, final TextView _t5, final TextView _t6, final TextView _t7, final TextView _t8, final TextView _t9) {
		if (_resourceName(_t1).contains("r".concat(day_count))) {
			_setColorSubject1(_t1);
			_setColorSubject1(_t2);
			_setColorSubject1(_t3);
			_setColorSubject1(_t4);
			_setColorSubject1(_t5);
			_setColorSubject1(_t6);
			_setColorSubject1(_t7);
			_setColorSubject1(_t8);
			_setColorSubject1(_t9);
		}
	}


	public void _setColorSubject1(final TextView _t1) {
		if (!"".equals(_t1.getText().toString().trim())) {
			_t1.setTextColor(0xFFFFFFFF);
			_round_view(1, _t1);
		}
	}
	
	public class Listview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
				_view = _inflater.inflate(R.layout.cust1, null);
			}
			
			final LinearLayout linear__00 = _view.findViewById(R.id.linear__00);
			final LinearLayout linear_class = _view.findViewById(R.id.linear_class);
			final LinearLayout linear_exam = _view.findViewById(R.id.linear_exam);
			final LinearLayout linear_message00 = _view.findViewById(R.id.linear_message00);
			final LinearLayout linear_link = _view.findViewById(R.id.linear_link);
			final LinearLayout linear_top = _view.findViewById(R.id.linear_top);
			final TextView textview96 = _view.findViewById(R.id.textview96);
			final ImageView imageview_acc = _view.findViewById(R.id.imageview_acc);
			final ImageView imageview_add = _view.findViewById(R.id.imageview_add);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final HorizontalScrollView hscroll1 = _view.findViewById(R.id.hscroll1);
			final TextView t_class = _view.findViewById(R.id.t_class);
			final TextView textview_d1 = _view.findViewById(R.id.textview_d1);
			final TextView textview_d2 = _view.findViewById(R.id.textview_d2);
			final TextView textview_d3 = _view.findViewById(R.id.textview_d3);
			final TextView textview_d4 = _view.findViewById(R.id.textview_d4);
			final TextView textview_d5 = _view.findViewById(R.id.textview_d5);
			final TextView textview_d6 = _view.findViewById(R.id.textview_d6);
			final TextView textview_d7 = _view.findViewById(R.id.textview_d7);
			final LinearLayout linear_r1 = _view.findViewById(R.id.linear_r1);
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear6 = _view.findViewById(R.id.linear6);
			final LinearLayout linear8 = _view.findViewById(R.id.linear8);
			final LinearLayout linear9 = _view.findViewById(R.id.linear9);
			final LinearLayout linear10 = _view.findViewById(R.id.linear10);
			final LinearLayout linear11 = _view.findViewById(R.id.linear11);
			final LinearLayout linear12 = _view.findViewById(R.id.linear12);
			final LinearLayout linear13 = _view.findViewById(R.id.linear13);
			final TextView r0_t1 = _view.findViewById(R.id.r0_t1);
			final TextView r0_t2 = _view.findViewById(R.id.r0_t2);
			final TextView r0_t3 = _view.findViewById(R.id.r0_t3);
			final TextView r0_t4 = _view.findViewById(R.id.r0_t4);
			final TextView r0_t5 = _view.findViewById(R.id.r0_t5);
			final TextView r0_t6 = _view.findViewById(R.id.r0_t6);
			final TextView r0_t7 = _view.findViewById(R.id.r0_t7);
			final TextView r0_t8 = _view.findViewById(R.id.r0_t8);
			final TextView r0_t9 = _view.findViewById(R.id.r0_t9);
			final TextView r1_t1 = _view.findViewById(R.id.r1_t1);
			final TextView r1_t2 = _view.findViewById(R.id.r1_t2);
			final TextView r1_t3 = _view.findViewById(R.id.r1_t3);
			final TextView r1_t4 = _view.findViewById(R.id.r1_t4);
			final TextView r1_t5 = _view.findViewById(R.id.r1_t5);
			final TextView r1_t6 = _view.findViewById(R.id.r1_t6);
			final TextView r1_t7 = _view.findViewById(R.id.r1_t7);
			final TextView r1_t8 = _view.findViewById(R.id.r1_t8);
			final TextView r1_t9 = _view.findViewById(R.id.r1_t9);
			final TextView r2_t1 = _view.findViewById(R.id.r2_t1);
			final TextView r2_t2 = _view.findViewById(R.id.r2_t2);
			final TextView r2_t3 = _view.findViewById(R.id.r2_t3);
			final TextView r2_t4 = _view.findViewById(R.id.r2_t4);
			final TextView r2_t5 = _view.findViewById(R.id.r2_t5);
			final TextView r2_t6 = _view.findViewById(R.id.r2_t6);
			final TextView r2_t7 = _view.findViewById(R.id.r2_t7);
			final TextView r2_t8 = _view.findViewById(R.id.r2_t8);
			final TextView r2_t9 = _view.findViewById(R.id.r2_t9);
			final TextView r3_t1 = _view.findViewById(R.id.r3_t1);
			final TextView r3_t2 = _view.findViewById(R.id.r3_t2);
			final TextView r3_t3 = _view.findViewById(R.id.r3_t3);
			final TextView r3_t4 = _view.findViewById(R.id.r3_t4);
			final TextView r3_t5 = _view.findViewById(R.id.r3_t5);
			final TextView r3_t6 = _view.findViewById(R.id.r3_t6);
			final TextView r3_t7 = _view.findViewById(R.id.r3_t7);
			final TextView r3_t8 = _view.findViewById(R.id.r3_t8);
			final TextView r3_t9 = _view.findViewById(R.id.r3_t9);
			final TextView r4_t1 = _view.findViewById(R.id.r4_t1);
			final TextView r4_t2 = _view.findViewById(R.id.r4_t2);
			final TextView r4_t3 = _view.findViewById(R.id.r4_t3);
			final TextView r4_t4 = _view.findViewById(R.id.r4_t4);
			final TextView r4_t5 = _view.findViewById(R.id.r4_t5);
			final TextView r4_t6 = _view.findViewById(R.id.r4_t6);
			final TextView r4_t7 = _view.findViewById(R.id.r4_t7);
			final TextView r4_t8 = _view.findViewById(R.id.r4_t8);
			final TextView r4_t9 = _view.findViewById(R.id.r4_t9);
			final TextView r5_t1 = _view.findViewById(R.id.r5_t1);
			final TextView r5_t2 = _view.findViewById(R.id.r5_t2);
			final TextView r5_t3 = _view.findViewById(R.id.r5_t3);
			final TextView r5_t4 = _view.findViewById(R.id.r5_t4);
			final TextView r5_t5 = _view.findViewById(R.id.r5_t5);
			final TextView r5_t6 = _view.findViewById(R.id.r5_t6);
			final TextView r5_t7 = _view.findViewById(R.id.r5_t7);
			final TextView r5_t8 = _view.findViewById(R.id.r5_t8);
			final TextView r5_t9 = _view.findViewById(R.id.r5_t9);
			final TextView r6_t1 = _view.findViewById(R.id.r6_t1);
			final TextView r6_t2 = _view.findViewById(R.id.r6_t2);
			final TextView r6_t3 = _view.findViewById(R.id.r6_t3);
			final TextView r6_t4 = _view.findViewById(R.id.r6_t4);
			final TextView r6_t5 = _view.findViewById(R.id.r6_t5);
			final TextView r6_t6 = _view.findViewById(R.id.r6_t6);
			final TextView r6_t7 = _view.findViewById(R.id.r6_t7);
			final TextView r6_t8 = _view.findViewById(R.id.r6_t8);
			final TextView r6_t9 = _view.findViewById(R.id.r6_t9);
			final TextView r7_t1 = _view.findViewById(R.id.r7_t1);
			final TextView r7_t2 = _view.findViewById(R.id.r7_t2);
			final TextView r7_t3 = _view.findViewById(R.id.r7_t3);
			final TextView r7_t4 = _view.findViewById(R.id.r7_t4);
			final TextView r7_t5 = _view.findViewById(R.id.r7_t5);
			final TextView r7_t6 = _view.findViewById(R.id.r7_t6);
			final TextView r7_t7 = _view.findViewById(R.id.r7_t7);
			final TextView r7_t8 = _view.findViewById(R.id.r7_t8);
			final TextView r7_t9 = _view.findViewById(R.id.r7_t9);
			final LinearLayout linear50 = _view.findViewById(R.id.linear50);
			final HorizontalScrollView hscroll4 = _view.findViewById(R.id.hscroll4);
			final TextView t_exam = _view.findViewById(R.id.t_exam);
			final TextView ed1 = _view.findViewById(R.id.ed1);
			final TextView ed2 = _view.findViewById(R.id.ed2);
			final TextView ed3 = _view.findViewById(R.id.ed3);
			final TextView ed4 = _view.findViewById(R.id.ed4);
			final TextView ed5 = _view.findViewById(R.id.ed5);
			final TextView ed6 = _view.findViewById(R.id.ed6);
			final TextView ed7 = _view.findViewById(R.id.ed7);
			final LinearLayout linear51 = _view.findViewById(R.id.linear51);
			final LinearLayout linear_0 = _view.findViewById(R.id.linear_0);
			final LinearLayout linear_1 = _view.findViewById(R.id.linear_1);
			final LinearLayout linear_2 = _view.findViewById(R.id.linear_2);
			final LinearLayout linear_3 = _view.findViewById(R.id.linear_3);
			final LinearLayout linear_4 = _view.findViewById(R.id.linear_4);
			final LinearLayout linear_5 = _view.findViewById(R.id.linear_5);
			final LinearLayout linear_6 = _view.findViewById(R.id.linear_6);
			final LinearLayout linear_7 = _view.findViewById(R.id.linear_7);
			final TextView er0_t1 = _view.findViewById(R.id.er0_t1);
			final TextView er0_t2 = _view.findViewById(R.id.er0_t2);
			final TextView er0_t3 = _view.findViewById(R.id.er0_t3);
			final TextView er0_t4 = _view.findViewById(R.id.er0_t4);
			final TextView er0_t5 = _view.findViewById(R.id.er0_t5);
			final TextView er0_t6 = _view.findViewById(R.id.er0_t6);
			final TextView er1_t1 = _view.findViewById(R.id.er1_t1);
			final TextView er1_t2 = _view.findViewById(R.id.er1_t2);
			final TextView er1_t3 = _view.findViewById(R.id.er1_t3);
			final TextView er1_t4 = _view.findViewById(R.id.er1_t4);
			final TextView er1_t5 = _view.findViewById(R.id.er1_t5);
			final TextView er1_t6 = _view.findViewById(R.id.er1_t6);
			final TextView er2_t1 = _view.findViewById(R.id.er2_t1);
			final TextView er2_t2 = _view.findViewById(R.id.er2_t2);
			final TextView er2_t3 = _view.findViewById(R.id.er2_t3);
			final TextView er2_t4 = _view.findViewById(R.id.er2_t4);
			final TextView er2_t5 = _view.findViewById(R.id.er2_t5);
			final TextView er2_t6 = _view.findViewById(R.id.er2_t6);
			final TextView er3_t1 = _view.findViewById(R.id.er3_t1);
			final TextView er3_t2 = _view.findViewById(R.id.er3_t2);
			final TextView er3_t3 = _view.findViewById(R.id.er3_t3);
			final TextView er3_t4 = _view.findViewById(R.id.er3_t4);
			final TextView er3_t5 = _view.findViewById(R.id.er3_t5);
			final TextView er3_t6 = _view.findViewById(R.id.er3_t6);
			final TextView er4_t1 = _view.findViewById(R.id.er4_t1);
			final TextView er4_t2 = _view.findViewById(R.id.er4_t2);
			final TextView er4_t3 = _view.findViewById(R.id.er4_t3);
			final TextView er4_t4 = _view.findViewById(R.id.er4_t4);
			final TextView er4_t5 = _view.findViewById(R.id.er4_t5);
			final TextView er4_t6 = _view.findViewById(R.id.er4_t6);
			final TextView er5_t1 = _view.findViewById(R.id.er5_t1);
			final TextView er5_t2 = _view.findViewById(R.id.er5_t2);
			final TextView er5_t3 = _view.findViewById(R.id.er5_t3);
			final TextView er5_t4 = _view.findViewById(R.id.er5_t4);
			final TextView er5_t5 = _view.findViewById(R.id.er5_t5);
			final TextView er5_t6 = _view.findViewById(R.id.er5_t6);
			final TextView er6_t1 = _view.findViewById(R.id.er6_t1);
			final TextView er6_t2 = _view.findViewById(R.id.er6_t2);
			final TextView er6_t3 = _view.findViewById(R.id.er6_t3);
			final TextView er6_t4 = _view.findViewById(R.id.er6_t4);
			final TextView er6_t5 = _view.findViewById(R.id.er6_t5);
			final TextView er6_t6 = _view.findViewById(R.id.er6_t6);
			final TextView er7_t1 = _view.findViewById(R.id.er7_t1);
			final TextView er7_t2 = _view.findViewById(R.id.er7_t2);
			final TextView er7_t3 = _view.findViewById(R.id.er7_t3);
			final TextView er7_t4 = _view.findViewById(R.id.er7_t4);
			final TextView er7_t5 = _view.findViewById(R.id.er7_t5);
			final TextView er7_t6 = _view.findViewById(R.id.er7_t6);
			final LinearLayout linear_message = _view.findViewById(R.id.linear_message);
			final ImageView imageview_post_image = _view.findViewById(R.id.imageview_post_image);
			final LinearLayout linear____post = _view.findViewById(R.id.linear____post);
			final LinearLayout linear32 = _view.findViewById(R.id.linear32);
			final TextView textview____des = _view.findViewById(R.id.textview____des);
			final TextView textview___title = _view.findViewById(R.id.textview___title);
			final TextView textview_date = _view.findViewById(R.id.textview_date);
			final HorizontalScrollView hscroll2 = _view.findViewById(R.id.hscroll2);
			final LinearLayout linear_link2 = _view.findViewById(R.id.linear_link2);
			final LinearLayout linearL1 = _view.findViewById(R.id.linearL1);
			final LinearLayout linearL2 = _view.findViewById(R.id.linearL2);
			final LinearLayout linearL3 = _view.findViewById(R.id.linearL3);
			final LinearLayout linearL4 = _view.findViewById(R.id.linearL4);
			final LinearLayout linearL5 = _view.findViewById(R.id.linearL5);
			final LinearLayout linearL6 = _view.findViewById(R.id.linearL6);
			final LinearLayout linearL7 = _view.findViewById(R.id.linearL7);
			final LinearLayout linearL8 = _view.findViewById(R.id.linearL8);
			final LinearLayout linearL9 = _view.findViewById(R.id.linearL9);
			final ImageView imageviewL1 = _view.findViewById(R.id.imageviewL1);
			final TextView textviewL1 = _view.findViewById(R.id.textviewL1);
			final ImageView imageviewL2 = _view.findViewById(R.id.imageviewL2);
			final TextView textviewL2 = _view.findViewById(R.id.textviewL2);
			final ImageView imageviewL3 = _view.findViewById(R.id.imageviewL3);
			final TextView textviewL3 = _view.findViewById(R.id.textviewL3);
			final ImageView imageviewL4 = _view.findViewById(R.id.imageviewL4);
			final TextView textviewL4 = _view.findViewById(R.id.textviewL4);
			final ImageView imageviewL5 = _view.findViewById(R.id.imageviewL5);
			final TextView textviewL5 = _view.findViewById(R.id.textviewL5);
			final ImageView imageviewL6 = _view.findViewById(R.id.imageviewL6);
			final TextView textviewL6 = _view.findViewById(R.id.textviewL6);
			final ImageView imageviewL7 = _view.findViewById(R.id.imageviewL7);
			final TextView textviewL7 = _view.findViewById(R.id.textviewL7);
			final ImageView imageviewL8 = _view.findViewById(R.id.imageviewL8);
			final TextView textviewL8 = _view.findViewById(R.id.textviewL8);
			final ImageView imageviewL9 = _view.findViewById(R.id.imageviewL9);
			final TextView textviewL9 = _view.findViewById(R.id.textviewL9);
			
			hscroll1.setHorizontalScrollBarEnabled(false);
			hscroll1.setOverScrollMode(View.OVER_SCROLL_NEVER);
			hscroll2.setHorizontalScrollBarEnabled(false);
			hscroll2.setOverScrollMode(View.OVER_SCROLL_NEVER);
			
			textview____des.setTextIsSelectable(true);
			
			
			t_class.setText(map1.get((int)_position).get("k").toString());
			imageview_post_image.setVisibility(View.GONE);
			if ("cr".equals(admin)) {
				imageview_add.setVisibility(View.VISIBLE);
			}
			else {
				imageview_add.setVisibility(View.GONE);
			}
			if (_position == 0) {
				linear__00.setVisibility(View.VISIBLE);
				linear_class.setVisibility(View.VISIBLE);
				linear_exam.setVisibility(View.VISIBLE);
				linear_message00.setVisibility(View.GONE);
				linear_link.setVisibility(View.GONE);
				_round_view(0, linear_top);
				imageview_acc.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						if ("cr".equals(admin)) {
							in.setClass(getApplicationContext(), AccountActivity.class);
							startActivity(in);
						}
						else {
							in.setClass(getApplicationContext(), Account2Activity.class);
							startActivity(in);
						}
					}
				});
				imageview_add.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						_newPOST();
					}
				});
				_setRound0(t_class, textview_d1, textview_d2, textview_d3, textview_d4, textview_d5, textview_d6, textview_d7);
				_setColorDay(textview_d1, textview_d2, textview_d3, textview_d4, textview_d5, textview_d6, textview_d7);
				_setRound(r0_t1, r0_t2, r0_t3, r0_t4, r0_t5, r0_t6, r0_t7, r0_t8, r0_t9);
				_setRound(r1_t1, r1_t2, r1_t3, r1_t4, r1_t5, r1_t6, r1_t7, r1_t8, r1_t9);
				_setRound(r2_t1, r2_t2, r2_t3, r2_t4, r2_t5, r2_t6, r2_t7, r2_t8, r2_t9);
				_setRound(r3_t1, r3_t2, r3_t3, r3_t4, r3_t5, r3_t6, r3_t7, r3_t8, r3_t9);
				_setRound(r4_t1, r4_t2, r4_t3, r4_t4, r4_t5, r4_t6, r4_t7, r4_t8, r4_t9);
				_setRound(r5_t1, r5_t2, r5_t3, r5_t4, r5_t5, r5_t6, r5_t7, r5_t8, r5_t9);
				_setRound(r6_t1, r6_t2, r6_t3, r6_t4, r6_t5, r6_t6, r6_t7, r6_t8, r6_t9);
				_setRound(r7_t1, r7_t2, r7_t3, r7_t4, r7_t5, r7_t6, r7_t7, r7_t8, r7_t9);
				if ("1".equals(settings.get("class").toString())) {
					linear_class.setVisibility(View.VISIBLE);
				}
				else {
					linear_class.setVisibility(View.GONE);
				}

				
				_round_view(0, t_exam);
				_setRound_date(ed1, ed2, ed3, ed4, linear_1, linear_2, linear_3, linear_4);
				_setRound_date(ed5, ed6, ed7, ed7, linear_5, linear_6, linear_7, linear_7);
				_setRound2(er0_t1, er0_t2, er0_t3, er0_t4, er0_t5, er0_t6);
				_setRound2(er1_t1, er1_t2, er1_t3, er1_t4, er1_t5, er1_t6);
				_setRound2(er2_t1, er2_t2, er2_t3, er2_t4, er2_t5, er2_t6);
				_setRound2(er3_t1, er3_t2, er3_t3, er3_t4, er3_t5, er3_t6);
				_setRound2(er4_t1, er4_t2, er4_t3, er4_t4, er4_t5, er4_t6);
				_setRound2(er5_t1, er5_t2, er5_t3, er5_t4, er5_t5, er5_t6);
				_setRound2(er6_t1, er6_t2, er6_t3, er6_t4, er6_t5, er6_t6);
				_setRound2(er7_t1, er7_t2, er7_t3, er7_t4, er7_t5, er7_t6);
				if ("1".equals(settings.get("exam").toString())) {
					linear_exam.setVisibility(View.VISIBLE);
				}
				else {
					linear_exam.setVisibility(View.GONE);
				}
				
				_selectClassTime(r0_t1, r0_t2, r0_t3, r0_t4, r0_t5, r0_t6, r0_t7, r0_t8, r0_t9);
				    _selectClassSubject(r1_t1, r1_t2, r1_t3, r1_t4, r1_t5, r1_t6, r1_t7, r1_t8, r1_t9);
					_selectClassSubject(r2_t1, r2_t2, r2_t3, r2_t4, r2_t5, r2_t6, r2_t7, r2_t8, r2_t9);
					_selectClassSubject(r3_t1, r3_t2, r3_t3, r3_t4, r3_t5, r3_t6, r3_t7, r3_t8, r3_t9);
					_selectClassSubject(r4_t1, r4_t2, r4_t3, r4_t4, r4_t5, r4_t6, r4_t7, r4_t8, r4_t9);
					_selectClassSubject(r5_t1, r5_t2, r5_t3, r5_t4, r5_t5, r5_t6, r5_t7, r5_t8, r5_t9);
					_selectClassSubject(r6_t1, r6_t2, r6_t3, r6_t4, r6_t5, r6_t6, r6_t7, r6_t8, r6_t9);
					_selectClassSubject(r7_t1, r7_t2, r7_t3, r7_t4, r7_t5, r7_t6, r7_t7, r7_t8, r7_t9);
				_selectExamTime(er0_t1, er0_t2, er0_t3, er0_t4, er0_t5, er0_t6);
				_selectExamDate(ed1, ed2, ed3, ed4, ed5, ed6, ed7);
					_selectExamSubject(er1_t1, er1_t2, er1_t3, er1_t4, er1_t5, er1_t6);
					_selectExamSubject(er2_t1, er2_t2, er2_t3, er2_t4, er2_t5, er2_t6);
					_selectExamSubject(er3_t1, er3_t2, er3_t3, er3_t4, er3_t5, er3_t6);
					_selectExamSubject(er4_t1, er4_t2, er4_t3, er4_t4, er4_t5, er4_t6);
					_selectExamSubject(er5_t1, er5_t2, er5_t3, er5_t4, er5_t5, er5_t6);
					_selectExamSubject(er6_t1, er6_t2, er6_t3, er6_t4, er6_t5, er6_t6);
					_selectExamSubject(er7_t1, er7_t2, er7_t3, er7_t4, er7_t5, er7_t6);
			}
			else {
				if (_position == (map1.size() - 1)) {
					linear__00.setVisibility(View.GONE);
					linear_class.setVisibility(View.GONE);
					linear_exam.setVisibility(View.GONE);
					linear_message00.setVisibility(View.GONE);
					linear_link.setVisibility(View.VISIBLE);
					_LINK_MAP(linearL1, linearL2, linearL3, linearL4, linearL5, linearL6, linearL7, linearL8, linearL9);
					_LINK_IMAGE(imageviewL1, imageviewL2, imageviewL3, imageviewL4, imageviewL5, imageviewL6, imageviewL7, imageviewL8, imageviewL9);
					_LINK_TITLE(textviewL1, textviewL2, textviewL3, textviewL4, textviewL5, textviewL6, textviewL7, textviewL8, textviewL9);
				}
				else {
					linear__00.setVisibility(View.GONE);
					linear_class.setVisibility(View.GONE);
					linear_exam.setVisibility(View.GONE);
					linear_message00.setVisibility(View.VISIBLE);
					linear_link.setVisibility(View.GONE);
					_round_view_s1(textview_date, "#212121", "#212121", 90);
					_round_view(0, linear_message);
					_round_view_s1(imageview_post_image, "#201A30", "#201A30", 90);
					imageview_post_image.setElevation((float)12);
					_POST(linear_message00, imageview_post_image, textview___title, textview____des, textview_date, _position);
				}
			}
			linear_link.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;
			linear_link.requestLayout();
			
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

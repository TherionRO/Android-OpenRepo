package com.therionroOS.simplestresstools;

import android.app.Activity;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import android.widget.TextView;
import android.widget.CheckBox;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.content.SharedPreferences;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.ClipData;
import android.view.View;
import android.widget.CompoundButton;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.DialogFragment;
import android.Manifest;
import android.content.pm.PackageManager;

public class MainActivity extends Activity {
	
	public final int REQ_CD_FILE_INJECTORS = 101;
	public final int REQ_CD_DATAFILES = 102;
	
	private TextView ttstextlabelMAIN;
	private TextView susususus;
	private TextView therionroonytb;
	private CheckBox therionrocom;
	private Button mainbutton;
	private TextView oslicenceOG;
	
	private Intent p = new Intent();
	private SharedPreferences deprecatedsaver;
	private AlertDialog.Builder dialog_acces;
	private Intent file_injectors = new Intent(Intent.ACTION_GET_CONTENT);
	private Intent datafiles = new Intent(Intent.ACTION_GET_CONTENT);
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		
		if (Build.VERSION.SDK_INT >= 23) {
			if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
				requestPermissions(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
			} else {
				initializeLogic();
			}
		} else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		ttstextlabelMAIN = findViewById(R.id.ttstextlabelMAIN);
		susususus = findViewById(R.id.susususus);
		therionroonytb = findViewById(R.id.therionroonytb);
		therionrocom = findViewById(R.id.therionrocom);
		mainbutton = findViewById(R.id.mainbutton);
		oslicenceOG = findViewById(R.id.oslicenceOG);
		deprecatedsaver = getSharedPreferences("dps", Activity.MODE_PRIVATE);
		dialog_acces = new AlertDialog.Builder(this);
		file_injectors.setType("*/*");
		file_injectors.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		datafiles.setType("*/*");
		datafiles.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		
		therionrocom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					mainbutton.setVisibility(View.VISIBLE);
				}
				else {
					mainbutton.setVisibility(View.GONE);
				}
			}
		});
		
		mainbutton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				deprecatedsaver.edit().putString("dpcacceptedandTOS", "yes").commit();
				p.setClass(getApplicationContext(), ToolspageActivity.class);
				startActivity(p);
			}
		});
	}
	
	private void initializeLogic() {
		if (deprecatedsaver.getString("dpcacceptedandTOS", "").equals("yes")) {
			p.setClass(getApplicationContext(), ToolspageActivity.class);
			startActivity(p);
		}
		mainbutton.setVisibility(View.GONE);
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
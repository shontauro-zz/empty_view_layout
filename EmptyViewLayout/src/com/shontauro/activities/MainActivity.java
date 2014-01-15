package com.shontauro.activities;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.shontauro.emptyviewlayout.EmptyViewLayout;
import com.shontauro.emptyviewlayout.R;

public class MainActivity extends Activity {

	private EmptyViewLayout mEmptyViewLayout;
	private ListView mListView;
	private ArrayAdapter<String> mAdapter;

	// the list items
	static final String[] NUMBERS = new String[] { "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
			"18", "19", "20" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mListView = (ListView) findViewById(android.R.id.list);
		((Button) findViewById(R.id.but_show_content))
				.setOnClickListener(mButtonsClickListener);
		((Button) findViewById(R.id.but_show_loading))
				.setOnClickListener(mButtonsClickListener);
		((Button) findViewById(R.id.but_show_empty))
				.setOnClickListener(mButtonsClickListener);
		((Button) findViewById(R.id.but_show_error))
				.setOnClickListener(mButtonsClickListener);

		/**
		 * Setup empty view layout, you should configure your empty view layout
		 * before of use It. Otherwise It will work with the default values
		 */
		mEmptyViewLayout = new EmptyViewLayout(this, mListView);
		mEmptyViewLayout.setEmptyMessage(getString(R.string.empty_msg));
		mEmptyViewLayout.setEmptyButtonClickListener(mEmptyClickListener);
		mEmptyViewLayout.setErrorMessage(getString(R.string.error_msg));
		mEmptyViewLayout.setErrorButtonClickListener(mErrorClickListener);

		mEmptyViewLayout.showLoading();
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				getData();
				mEmptyViewLayout.showContentView();
			}
		}, 1000 * 3);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// View.OnClickListeners
	private View.OnClickListener mEmptyClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Toast.makeText(MainActivity.this,
					getResources().getString(R.string.try_again_but_pressed),
					Toast.LENGTH_SHORT).show();
		}
	};

	private View.OnClickListener mErrorClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Toast.makeText(MainActivity.this,
					getResources().getString(R.string.try_again_but_pressed),
					Toast.LENGTH_SHORT).show();
		}
	};

	private View.OnClickListener mButtonsClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v.getId() == R.id.but_show_content) {
				mEmptyViewLayout.showContentView();
			} else if (v.getId() == R.id.but_show_loading) {
				mEmptyViewLayout.showLoading();
			} else if (v.getId() == R.id.but_show_empty) {
				mEmptyViewLayout.showEmpty();
			} else if (v.getId() == R.id.but_show_error) {
				mEmptyViewLayout.showError();
			}
		}
	};

	private void getData() {
		ArrayList<String> list = new ArrayList<String>();
		list.addAll(Arrays.asList(NUMBERS));
		mAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, list);
		mListView.setAdapter(mAdapter);
	}
}

package com.xpg.appbase.activity.control;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.xpg.appbase.R;
import com.xpg.appbase.activity.BaseActivity;
import com.xpg.appbase.adapter.AlarmListAdapter;
import com.xpg.appbase.entity.DeviceAlarm;

public class AlarmListActicity extends BaseActivity {
	private ListView lvList;
	private Button btnCall;
	private ArrayList<DeviceAlarm> alarmList;
	private AlarmListAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarmlist);
		initViews();
		initDatas();
	}

	private void initDatas() {
		alarmList = new ArrayList<DeviceAlarm>();
		alarmList = (ArrayList<DeviceAlarm>) getIntent()
				.getSerializableExtra("alarm_list");
		mAdapter = new AlarmListAdapter(this, alarmList);
		lvList.setAdapter(mAdapter);
		
	}

	private void initViews() {
		lvList = (ListView) findViewById(R.id.lvList);
		btnCall = (Button) findViewById(R.id.btnCall);
		btnCall.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_CALL, Uri
						.parse("tel:10086"));
				startActivity(intent);

			}
		});
	}
}

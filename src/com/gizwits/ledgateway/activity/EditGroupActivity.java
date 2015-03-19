package com.gizwits.ledgateway.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.gizwits.framework.activity.BaseActivity;
import com.gizwits.ledgateway.R;

public class EditGroupActivity extends BaseActivity implements OnClickListener {

	/** The iv back. */
	private ImageView ivBack;
	/** The ll scroll layout. */
	private LinearLayout ll_scroll;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_group);
		initViews();
		initEvent();
		setItemTollScroll();
	}
	
	private void initViews(){
		ivBack = (ImageView) findViewById(R.id.ivBack);
		ll_scroll = (LinearLayout) findViewById(R.id.ll_scroll);
	}
	
	private void initEvent(){
		ivBack.setOnClickListener(this);
	}
	
	//设置滑动layout中子项
	private void setItemTollScroll(){
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		

}}
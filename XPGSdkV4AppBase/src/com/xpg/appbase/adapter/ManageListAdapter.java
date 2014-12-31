package com.xpg.appbase.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xpg.appbase.R;
import com.xpg.appbase.entity.Device;
import com.xtremeprog.xpgconnect.XPGWifiDevice;

public class ManageListAdapter extends BaseAdapter {

	private LayoutInflater inflater;

	/** The wifidevicelist. */
	private List<XPGWifiDevice> devicelist;

	/** The devicelist. */
	private List<Device> devices;

	/** The context. */
	private Context context;

	/** check isWifiDevice 0:wifidevice 1:device */
	private int i = 0;

	/**
	 * 设备列表数据适配器构造方法(Wifi查询数据列表).
	 * 
	 * @param c
	 *            上下文环境
	 * @param list
	 *            设备列表
	 */
	public ManageListAdapter(Context c, List<XPGWifiDevice> list) {
		this.i = 0;
		this.devicelist = list;
		this.context = c;
		this.inflater = LayoutInflater.from(context);
	}

	/**
	 * 设备列表数据适配器构造方法(设备保存查询数据列表).
	 * 
	 * @param c
	 *            上下文环境
	 * @param list
	 *            设备列表
	 * @param String
	 *            构造方法重写（null）
	 */
	public ManageListAdapter(Context c, List<Device> list, String i) {
		this.i = 1;
		this.devices = list;
		this.context = c;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return devicelist.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return devicelist.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.search_list_item, null);
			holder.tvName = (TextView) convertView.findViewById(R.id.tvName);
			holder.ivType = (ImageView) convertView.findViewById(R.id.icon);
			holder.ivArrow = (ImageView) convertView.findViewById(R.id.ivArrow);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		XPGWifiDevice device = devicelist.get(position);
		if (device.isLAN() || device.isOnline()) {
			holder.tvName.setText("智能空调" + device.getMacAddress());
			holder.tvName.setTextColor(context.getResources().getColor(
					R.color.text_blue));
			holder.ivArrow.setVisibility(View.VISIBLE);
		} else {
			holder.tvName.setText("智能空调" + device.getMacAddress());
			holder.tvName.setTextColor(context.getResources().getColor(
					R.color.text_gray));
			holder.ivArrow.setVisibility(View.GONE);
		}
		return convertView;
	}

	private static class ViewHolder {

		TextView tvName;
		ImageView ivType;
		ImageView ivArrow;
	}

}

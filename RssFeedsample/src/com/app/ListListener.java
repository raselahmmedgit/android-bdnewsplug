package com.app;

import java.util.List;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class ListListener implements OnItemClickListener {

	List<RssFeedModel> rssFeedModelList;
	Activity _activity;
	
	public ListListener(List<RssFeedModel> _rssFeedModelList, Activity activity)
	{
		this.rssFeedModelList = _rssFeedModelList;
		this._activity = activity;
	}
	
	public void onItemClick(AdapterView<?> parent, View view, int pos, long id)
	{
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(rssFeedModelList.get(pos).getLink()));
		_activity.startActivity(i);
	}
}

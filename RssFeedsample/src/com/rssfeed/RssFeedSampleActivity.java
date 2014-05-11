package com.rssfeed;


import com.app.ListListener;
import com.app.RssFeedModel;
import com.app.RssReader;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class RssFeedSampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        try
        {
        	RssReader rssReader = new RssReader("http://blog.raselahmmed.com/feed/");
        	
        	ListView lv = (ListView)findViewById(R.id.lvRssFeed);
        	
        	ArrayAdapter<RssFeedModel> adapter = new ArrayAdapter<RssFeedModel>(this, android.R.layout.simple_list_item_1, rssReader.GetItems());
        	
        	lv.setAdapter(adapter);
        	
        	lv.setOnItemClickListener(new ListListener(rssReader.GetItems(), this )); 
        	        	
        }
        catch(Exception ex)
        {
        	Log.e("RssFeedSample", ex.getMessage());
        }
    }
}
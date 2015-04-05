package app.wichman_rss_news.android.example.com.wichman_rss_news_feed;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    /**
     * Called when the activity is first created.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the ListView resource.
        ListView mainListView = (ListView) findViewById(R.id.myMainListView);

        // Create and populate a List of RSS List items.
        String[] rss_feeds_items = getResources().getStringArray(R.array.rss_feeds_items);

        // Create ArrayAdapter using the RSS Feeds Items list.
        ArrayAdapter<?> listAdapter = new ArrayAdapter<>(this, R.layout.myrsslistitem, rss_feeds_items);

        // Set the ArrayAdapter as the ListView's adapter.
        mainListView.setAdapter(listAdapter);

        /// listening to single list item on click
        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                String url;

                switch (position) {
                    case 0:
                        url = "http://feeds.reuters.com/reuters/topNews";
                        break;
                    case 1:
                        url = "http://feeds.reuters.com/reuters/sportsNews";
                        break;
                    case 2:
                        url = "http://rss.cnn.com/rss/cnn_topstories.rss";
                        break;
                    case 3:
                        url = "http://feeds.foxnews.com/foxnews/sports";
                        break;
                    case 4:
                        url = "http://www.msn.com/en-us/weather";
                        break;
                    case 5:
                        url = "http://www.reuters.com/tools/rss";
                        break;
                    default:
                        url = "http://www.google.com";
                        break;
                }

                 Intent i = new Intent(getApplicationContext(), RSSFeedActivity.class);

                try {
                   i.putExtra("url", url);
                    startActivity(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
}








package app.wichman_rss_news.android.example.com.wichman_rss_news_feed;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class RSSFeedActivity extends Activity {

    private WebView webview;
    protected int wvCount;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rssfeed);

        wvCount = 0;

         Intent i = getIntent();
         Bundle b = i.getExtras();
         String strUrl = (String) b.get("url");
         Uri uri = Uri.parse(strUrl);

        webview = (WebView) findViewById(R.id.rss_web_view);
        webview.getSettings().setJavaScriptEnabled(true);
        // Simplest usage: note that an exception will NOT be thrown
        // if there is an error loading this page (see below).
        webview.loadUrl(String.valueOf(uri));
        WebViewClient client = new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                super.shouldOverrideUrlLoading(view, url);
                view.loadUrl(url);
                wvCount++;
                return true;
            }
        };

        webview.setWebViewClient(client);

    }

     //This onBackPressed() method allows the user to go back to previous page
     //instead of just back to  the app's main menu when using the back button
    @Override
    public void onBackPressed() {
        if (wvCount == 0) {
            super.onBackPressed();
        } else {
            if (webview.canGoBack()) {
                webview.goBack();
                wvCount--;
            } else {
                super.onBackPressed();
            }
        }
    }
}
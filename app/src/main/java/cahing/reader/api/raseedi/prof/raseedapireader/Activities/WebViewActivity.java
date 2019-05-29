package cahing.reader.api.raseedi.prof.raseedapireader.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cahing.reader.api.raseedi.prof.raseedapireader.R;
/*
created by me as an implementation for the fifth task in the received rubric (direct to ad url)
Mohamed Atef on 29/5/2019
 */

import static cahing.reader.api.raseedi.prof.raseedapireader.Adapter.AdsRecyclerViewAdapter.AdUrl;

public class WebViewActivity extends AppCompatActivity {

    @BindView(R.id.webview)
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        setTheme(R.style.WebTheme);
        ButterKnife.bind(this);

        Intent intent=getIntent();
        String url=intent.getExtras().getString(AdUrl);
        webView.loadUrl(url);
    }
}

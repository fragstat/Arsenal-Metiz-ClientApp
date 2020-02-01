package arsenal.metiz.catalog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class mWebView extends AppCompatActivity {

    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        getIntentTo();
        WebView webView = findViewById(R.id.WebView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }

    public void getIntentTo(){
        Intent intent = getIntent();
        url = intent.getStringExtra("Url");
    }
}

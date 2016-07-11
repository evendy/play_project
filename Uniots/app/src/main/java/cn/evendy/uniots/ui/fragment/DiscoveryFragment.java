package cn.evendy.uniots.ui.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import cn.evendy.uniots.R;
import cn.evendy.uniots.ui.fragment.base.BasePageFragment;

/**
 * Created by evendy .
 */
public class DiscoveryFragment extends BasePageFragment {
    private WebView webView;
    private ProgressBar webLoadingView;

    @Override
    public int inflateView() {
        return R.layout.fragment_discovery;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        openWeb("http://i.meituan.com/");
    }

    @Override
    protected void initViews() {
        webView = getView(R.id.web_view);
        webLoadingView = getView(R.id.web_loading);
    }

    @Override
    protected void initToolbar() {
        setToolbarTitle(R.string.discovery);
    }

    private void openWeb(String url) {
        //启用支持javascript
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                webLoadingView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                webLoadingView.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public boolean onBackPressed() {
        if (webView.canGoBack()) {
            //goBack()表示返回WebView的上一页面
            webView.goBack();
            return true;
        }
        return false;
    }
}

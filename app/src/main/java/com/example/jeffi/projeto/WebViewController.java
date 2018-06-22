package com.example.jeffi.projeto;

import android.webkit.WebView;
import android.webkit.WebViewClient;
//Classe para abrir o WebView na tela da aplicação
public class WebViewController extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}

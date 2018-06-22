package com.example.jeffi.projeto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class Navegador extends AppCompatActivity {
    private EditText uRL;
    private WebView mWebView;
    private Button pesquisar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navegador);
        uRL = (EditText) findViewById(R.id.URL);
        pesquisar = (Button) findViewById(R.id.pesquisar);
        mWebView = (WebView) findViewById(R.id.navegador);

        //Definiçoes padrões para o WebView
        mWebView.getSettings().setJavaScriptEnabled(true);

        //Metodo do botão pesquisar, coletando o site ecrito no EditText e
        // carrega no WebView dentro do aplicativo
        pesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String site = "https://" + uRL.getText();
                mWebView.loadUrl(site);
                mWebView.setWebViewClient(new WebViewController());
            }
        });
    }
    //Metodo do botão voltar
    public void onBackPressed(){
        startActivity(new Intent(this, MainActivity.class));
        return;
    }
}

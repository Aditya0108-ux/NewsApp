package com.adityaa0108.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.widget.Toolbar

class webViewActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var webView: WebView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        toolbar = findViewById(R.id.toolbar)
        webView = findViewById(R.id.webView)
        var url = intent.getStringExtra("url")
        webView.webViewClient = WebViewClient()
        if (url != null) {
            webView.loadUrl(url)
        }
    }
}
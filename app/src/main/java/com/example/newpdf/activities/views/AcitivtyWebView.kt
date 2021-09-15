package com.example.newpdf.activities.views

import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.newpdf.databinding.ActivityAcitivtyWebViewBinding


class AcitivtyWebView : AppCompatActivity() {
    private lateinit var binding: ActivityAcitivtyWebViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAcitivtyWebViewBinding.inflate(layoutInflater)

        setContentView(binding.root)


        // Assuming you got your pdf file:
        pdf2()


    }


    private fun pdf2() {


        binding.webV.getSettings().setJavaScriptEnabled(true);
        binding.webV.getSettings().setPluginState(WebSettings.PluginState.ON);
        //---you need this to prevent the webview from
        // launching another browser when a url
        // redirection occurs---
        binding.webV.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return false
            }

        };
        var urlPdf = "http://www.didatticarte.it/storiadellarte/18%20picasso.pdf"
        binding.webV.loadUrl(
            "https://docs.google.com/gview?embedded=true&url=$urlPdf"
        );
    }


}






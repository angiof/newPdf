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


        binding.webV.settings.javaScriptEnabled = true;
        binding.webV.settings.setSupportZoom(true);
        binding.webV.settings.setBuiltInZoomControls(true);
        binding.webV.settings.setDisplayZoomControls(false);

        binding.webV.settings.pluginState = WebSettings.PluginState.ON;

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
        }
        var urlPdf0 = "https://firebasestorage.googleapis.com/v0/b/corriere-up-dev.appspot.com/o/biden.pdf?alt=media&token=726774eb-e5af-40f7-b99a-63a7b7b72fc9"

        binding.webV.loadUrl("https://docs.google.com/viewer?url=$urlPdf0)")

    }


}






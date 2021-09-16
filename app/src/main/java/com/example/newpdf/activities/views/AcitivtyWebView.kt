package com.example.newpdf.activities.views

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
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
        binding.webV.settings.pluginState = WebSettings.PluginState.ON;
        binding.webV.loadUrl("javascript:(function() {" + "document.querySelector('[role=toolbar]').remove();})()")

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

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                binding.webV.loadUrl("javascript:(function() { " + "document.querySelector('[role=toolbar]').remove();})()")
                binding.webV.visibility = View.VISIBLE

            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)

                //binding.webV.loadUrl("javascript:(function() { " +"document.querySelector('[role=toolbar]').remove();})()")
            }


        };
        binding.webV.loadUrl("javascript:(function() {" + "document.querySelector('[role=toolbar]').remove();})()")
        binding.webV.reload()
        var urlPdf =
            "https://firebasestorage.googleapis.com/v0/b/corriere-up-dev.appspot.com/o/biden.pdf?alt=media&token=d80d4ea5-eaa0-41e3-9d3a-8d042194274c"
        binding.webV.loadUrl("https://docs.google.com/viewer?url=$urlPdf");
        binding.webV.visibility = View.INVISIBLE
        binding.webV.zoomIn()
        binding.webV.zoomIn()
        binding.webV.zoomIn()

    }


}






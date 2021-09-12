package com.example.newpdf.activities.views

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newpdf.R
import com.pspdfkit.configuration.activity.PdfActivityConfiguration
import com.pspdfkit.ui.PdfActivity

class ActivityPdfKit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_kit)

        provaKit()
    }



    private fun provaKit(){
        val uri = Uri.parse("file:///android_asset/pdf.pdf")
        val config = PdfActivityConfiguration.Builder(this).build()
        PdfActivity.showDocument(this, uri, config)
    }
}
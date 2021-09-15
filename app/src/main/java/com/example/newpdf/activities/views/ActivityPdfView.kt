package com.example.newpdf.activities.views

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.newpdf.R
import com.github.barteksc.pdfviewer.PDFView
import com.github.barteksc.pdfviewer.util.FitPolicy
import java.io.ByteArrayOutputStream

class ActivityPdfView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_view)

        provaOnline()


    }


    private fun provaOnline() {
        // val url = "https://www.adobe.com/support/products/enterprise/knowledgecenter/media/c4611_sample_explain.pdf"
        var pdfButton: PDFView = findViewById(R.id.pdfviewlocale)

        // val file: File? = this.getExternalFilesDir("emulated/0/dowload/folderino/mypdfv1.pdf")
        // val fileContent: ByteArray = Files.readAllBytes(file?.toPath())


        val input = this.assets.open("ppa.pdf")

        val buffer = ByteArrayOutputStream()
        var nRead: Int
        val data = ByteArray(10965864)
        while (input.read(data, 0, data.size).also { nRead = it } != -1) {
            buffer.write(data, 0, nRead)
        }

        val byteArray = buffer.toByteArray()

        pdfButton.fromBytes(byteArray)
            .onError {
                Toast.makeText(this, "errore local", Toast.LENGTH_SHORT).show()
            }
            .swipeHorizontal(true)
            .autoSpacing(true)
            .enableSwipe(true)
            .pageFitPolicy(FitPolicy.WIDTH) // mode to fit pages in the view
            .fitEachPage(false) // fit each page to the view, else smaller pages are scaled relative to largest page.

            .enableAntialiasing(true)
            .defaultPage(0)
            .enableAnnotationRendering(true)
            .onPageError { _, t ->
                Toast.makeText(this, "${t?.stackTrace}", Toast.LENGTH_SHORT).show()
                Log.d("mariaErrore", "${t?.message}")
            }.load()

    }
}
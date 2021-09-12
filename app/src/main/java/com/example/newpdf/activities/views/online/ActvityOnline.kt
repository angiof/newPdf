package com.example.newpdf.activities.views.online

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.newpdf.R
import com.pspdfkit.configuration.PdfConfiguration
import com.pspdfkit.configuration.activity.PdfActivityConfiguration
import com.pspdfkit.document.download.DownloadJob
import com.pspdfkit.document.download.DownloadRequest
import com.pspdfkit.document.download.Progress
import com.pspdfkit.ui.PdfActivity
import java.io.File
import java.net.MalformedURLException
import java.net.URL

class ActvityOnline : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actvity_online)


        val source: WebDownloadSource = try {
            // Try to parse the URL pointing to the PDF document. If an error occurs, log it and leave the example.
            WebDownloadSource(URL("https://www.adobe.com/content/dam/acom/en/devnet/pdf/pdfs/pdf_reference_archives/PDFReference.pdf"))
        } catch (e: MalformedURLException) {
            Log.e("error", "Error while trying to parse the PDF Download URL.", e)
            return
        }


        provaOnline(source)

    }


    fun provaOnline(source:WebDownloadSource) {
        val configuration: PdfActivityConfiguration.Builder = PdfActivityConfiguration.Builder(this)


        //var del progress bar
        progressBar =findViewById(R.id.progressBar)


        val request = DownloadRequest.Builder(this)
            .source(source)
            .outputFile(File(this.getDir("documents", Context.MODE_PRIVATE), "case-study-box.pdf"))
            .overwriteExisting(true)
            .build()



        //var che prende la riciesta  ed starta
        val job: DownloadJob = DownloadJob.startDownload(request)

        //job
        job.setProgressListener(object : DownloadJob.ProgressListenerAdapter() {
            override fun onProgress(progress: Progress) {
                progressBar.progress = (100f * progress.bytesReceived / progress.totalBytes).toInt()
            }

            override fun onComplete(output: File) {
                progressBar.visibility=View.GONE
                PdfActivity.showDocument(this@ActvityOnline, Uri.fromFile(output), configuration.build())

            }

            override fun onError(exception: Throwable) {
              //  handleDownloadError(exception)
            }
        })


    }


}
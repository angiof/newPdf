package com.example.newpdf.activities.views.pdfKitOnline

import com.pspdfkit.document.download.source.DownloadSource
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLConnection

/** This download source can be used to download a PDF document from the web.  */
class WebDownloadSource(private val documentURL: URL) :
    DownloadSource {
    /**
     * The open method needs to return an [InputStream] that will provide the complete
     * document.
     */
    @Throws(IOException::class)
    override fun open(): InputStream {
        val connection = documentURL.openConnection() as HttpURLConnection
        connection.connect()
        return connection.inputStream
    }

    /**
     * If the length is available it can be returned here. This is optional, and can improve the
     * reported download progress, since it will then contain a percentage of download.
     */
    override fun getLength(): Long {
        var length = DownloadSource.UNKNOWN_DOWNLOAD_SIZE

        // We try to estimate the download size using the content length header.
        var urlConnection: URLConnection? = null
        try {
            urlConnection = documentURL.openConnection()
            val contentLength = urlConnection.contentLength
            if (contentLength != -1) {
                length = contentLength.toLong()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            if (urlConnection != null && urlConnection is HttpURLConnection) {
                urlConnection.disconnect()
            }
        }
        return length
    }

    override fun toString(): String {
        return "WebDownloadSource{documentURL=$documentURL}"
    }
}
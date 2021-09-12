package com.example.newpdf.activities.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.newpdf.R
import com.example.newpdf.activities.views.online.ActvityOnline

class MainActivity : AppCompatActivity() {
    private lateinit var btn: View
    private lateinit var btn2: View
    private lateinit var btn3: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "pdf render demo v1"



        btn2 = findViewById(R.id.btnPdfView)
        btn2.setOnClickListener {

            startActivity(Intent(this, ActivityPdfView::class.java))
            Toast.makeText(this, "versione free", Toast.LENGTH_SHORT).show()
        }


        btn = findViewById(R.id.btnPspKit)
        btn.setOnClickListener {
            startActivity(Intent(this, ActivityPdfKit::class.java))
            Toast.makeText(this, "versione a pagamento", Toast.LENGTH_SHORT).show()
        }


        btn3 = findViewById(R.id.goOnline)
        btn3.setOnClickListener {

            startActivity(Intent(this, ActvityOnline::class.java))
            Toast.makeText(this, "versione a online URL adobe a pagamento", Toast.LENGTH_SHORT)
                .show()

        }

    }


}

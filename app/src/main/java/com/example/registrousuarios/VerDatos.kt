package com.example.registrousuarios

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class VerDatos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ver_datos)

        val tvcod = findViewById<TextView>(R.id.tvcod)
        val tvnom = findViewById<TextView>(R.id.tvnom)
        val tvape = findViewById<TextView>(R.id.tvape)
        val tvem = findViewById<TextView>(R.id.tvem)
        val tvurl = findViewById<TextView>(R.id.tvurl)
        val btnver = findViewById<Button>(R.id.btnver)
        val web = findViewById<WebView>(R.id.web)

        //trae los datos de la Activity anterior
        val cod = intent.getStringExtra("Doc")
        val nom = intent.getStringExtra("Nom")
        val ape = intent.getStringExtra("Apel")
        val em = intent.getStringExtra("Email")
        val url = intent.getStringExtra("Url")

        //Imprimir datos en el Activity
        tvcod.text = "Documento: $cod"
        tvnom.text = "Nombre: $nom"
        tvape.text = "Apellido: $ape"
        tvem.text = "Correo: $em"
        tvurl.text = "Url: $url"

        //Activar el evento click en el boton
        btnver.setOnClickListener()
        {
            web.webViewClient = WebViewClient()
            if(url != null)
            {
                web.loadUrl(url)
                web.visibility = View.VISIBLE
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
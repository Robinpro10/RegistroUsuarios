package com.example.registrousuarios

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val txtDocumento = findViewById<EditText>(R.id.txtDocumento)
        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtApellido = findViewById<EditText>(R.id.txtApellido)
        val txtCorreo = findViewById<EditText>(R.id.txtCorreo)
        val txtUrl = findViewById<EditText>(R.id.txtUrl)
        val btnEnviar = findViewById<Button>(R.id.btnEnviar)

        btnEnviar.setOnClickListener(){
            val documento = txtDocumento.text.toString().toIntOrNull()
            val nombre = txtNombre.text.toString()
            val apellido = txtApellido.text.toString()
            val correo = txtCorreo.text.toString()
            val url = txtUrl.text.toString()

            val intent = Intent(this,VerDatos::class.java).apply {
                putExtra("Doc", documento)
                putExtra("Nom", nombre)
                putExtra("Apel", apellido)
                putExtra("Email", correo)
                putExtra("Url", url)
            }
            startActivity(intent)
        }
    }
}
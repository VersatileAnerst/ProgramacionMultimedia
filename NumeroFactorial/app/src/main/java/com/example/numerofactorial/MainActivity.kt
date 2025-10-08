package com.example.numerofactorial

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val numero: EditText = findViewById(R.id.editTextText)
        val boton: Button = findViewById(R.id.button)
        val texto: TextView = findViewById(R.id.textView)
        boton.setOnClickListener {
            val numeroResultado = numero.text.toString().toIntOrNull()
            CalcularFactorial(numeroResultado)
        }
    }
    private fun CalcularFactorial(numero : Int?) {


    }
}

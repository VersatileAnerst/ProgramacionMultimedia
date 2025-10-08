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
        val textoResultado: TextView = findViewById(R.id.textView)
        boton.setOnClickListener {
            val numeroResultado = numero.text.toString().toIntOrNull()
            if(numeroResultado!= null)
                textoResultado.text=CalcularFactorial(numeroResultado).toString()
            else {
                textoResultado.text= "Introduce un numero Valido"
            }
        }
    }
    private fun CalcularFactorial(numero : Int) : Int{
        var resultado =1
        for (i in 1..numero){
            resultado*=i
        }
    return resultado
    }
}

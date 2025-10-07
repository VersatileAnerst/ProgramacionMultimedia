package com.example.numeroaleatorio

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val numeroIntroducido : EditText = findViewById(R.id.entradatexto)
        val miboton : Button = findViewById(R.id.MIboton)
        val mensajesalida : TextView = findViewById(R.id.entradavalor)
        val numeroaleatorio = Random.nextInt(1, 101)
        var cont = 0
        miboton.setOnClickListener{
            //Recogemos el valor
            cont++
            val valor = numeroIntroducido.text.toString().toIntOrNull()
            if (valor == null) mensajesalida.text ="debe introducir un numero"
            else if (valor == numeroaleatorio) mensajesalida.text= "Acertaste es "+numeroaleatorio.toString()+" y lo has intentado "+cont
            else if (valor > numeroaleatorio )mensajesalida.text = "Mayor que el Aleatorio"
            else mensajesalida.text = "Menor que el aleatorio"

        }
            }
    }

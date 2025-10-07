package com.example.mayor_edad

import android.os.Bundle
import android.renderscript.ScriptGroup
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.mayor_edad.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView (binding.root)
        val numero : EditText =  findViewById(R.id.editTextText)
        val boton : Button= findViewById(R.id.button)
        val Texto : TextView = findViewById(R.id.textView)
        boton.setOnClickListener {
            val numeroResultado = numero.text.toString().toIntOrNull()
            /*if (numeroResultado == null)
                Texto.text=("Debe introducir un numero")
            else if (numeroResultado < 18)
                Texto.text=("Es menor de edad")
            else if (numeroResultado >  18)
                Texto.text=("Es mayor de edad")
            else
                Texto.text=("Tienes 18 años")
                */
             Texto.text = if (numeroResultado== null) "Introducir un numero"
             else if (numeroResultado >18) "Eres mayor de edad"
             else if (numeroResultado < 18) "Es menor de edad"
             else "Tienes 18 años"
        }
    }
}
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
    /* for de 1 a 6 de 2 en 2
    for (i in 0..6 step 2)
        print("$")
    * */
    /* for decreciente
    * for (i in 5 down to 1)
    * print ("$")
    * /*Array vacio*/
    lateinit var arrayVacio : Array<String>
    arrayVacio=arrayOf("Hola","Adios")
    println(arrayVacio[1])
    /*Imprimir todo el array*/
    println(arrayVacio[])
    /*Array de cadenas*/
    val nombres : Array<String> = arrayOf("Aitor","Puchol","Juan","Felipe")
    println(nombres[0])
    nombres[0]= "Pedro"
    println(nombres[0])
    /*Array inicializado a 0*/
    val miArray = Array(5){0}
    for (i in 0..4){
    println(miArray[i])
    /*Array de 5 numeros inicializando a 0*/
    val otroArray= arrayOf(1,2,3,4,5)
    println(otroArray[0])
    //con un for each
    for(nombre in nombres)

    }
    * */
    /*fun main() {
    val nombres = listOf("Aitor","Antonio","Alex")
    for (i in nombres.indices){
        println("nombres[$i]=" nombres[i])
    }
    /*recorremos la lista con el indice*/
    for (i in nombres.indices){
        println("nombres[$i]:${nombres[i]}")
    }
    /*otra forma con withIndex*/
    for((index,value) in nombres.withIndex()){
        println("El elemento con indice $index es: $value")
    }
}*/
}

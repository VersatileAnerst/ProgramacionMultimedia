package com.example.cuadrado

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import model.Cuadrado
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)
        //identificacion de la vista
        val cuadradoView : View=findViewById(R.id.cuadrado)
        /*Usamos el metodo post para que se ejecute este bloque de codigo en el hilo de la interfaz de ususario justo despues
        que se carge la vista, construya y se mida */
        cuadradoView.post {
            //Variables que recogen los datos de la view inicial
            val iniciarAncho = cuadradoView.width
            val iniciarAlto = cuadradoView.height
            val iniciarX : Int = cuadradoView.x.toInt()
            val iniciarY : Int = cuadradoView.y.toInt()
            //asociar la vista con el objeto cuadrado
            //contextcompac es una clase estatica
            val cuadrado: Cuadrado= Cuadrado(ContextCompat.getColor(this,R.color.red),iniciarAncho,iniciarAlto).apply {
                x=iniciarX
                y=iniciarY
            }
            //identificar de botones
            val buttontonArriba : Button=findViewById(R.id.buttonArriba)
            val buttonAbajo : Button=findViewById(R.id.buttonAbajo)
            val buttonDerecha :  Button=findViewById(R.id.buttonDerecha)
            val buttonIzquierda : Button=findViewById(R.id.buttonIzquierda)
            val buttonTamanio : Button=findViewById(R.id.buttonCambiarTamanio)
            val buttonColor : Button=findViewById(R.id.buttonCambiarColor)
            val buttonAumentar : Button=findViewById(R.id.buttonAumentar)
            val buttonDisminuir : Button=findViewById(R.id.buttonDisminuir)

            //ponemos botones a la escucha
            buttontonArriba.setOnClickListener {
                cuadrado.moverArriba()
                actualizarVista(cuadrado, cuadradoView)
            }
            buttonAbajo.setOnClickListener {
                cuadrado.moverAbajo()
                actualizarVista(cuadrado, cuadradoView)
            }
            buttonDerecha.setOnClickListener {
                cuadrado.moverDerecha()
                actualizarVista(cuadrado, cuadradoView)
            }
            buttonIzquierda.setOnClickListener {
                cuadrado.moverIzquierda()
                actualizarVista(cuadrado, cuadradoView)
            }
            buttonTamanio.setOnClickListener {
                cuadrado.cambiarTamanio(150,150)
                actualizarVista(cuadrado, cuadradoView)
            }
            buttonColor.setOnClickListener {
                //cuadrado.color= ContextCompat.getColor(this,R.color.blue)
                cuadrado.color = generarColorAleatorio()
                actualizarVista(cuadrado, cuadradoView)
            }
            buttonAumentar.setOnClickListener {
                 cuadrado.aumentar()
                actualizarVista(cuadrado, cuadradoView)
            }
            buttonDisminuir.setOnClickListener {
                cuadrado.disminuir()
                actualizarVista(cuadrado, cuadradoView)
            }

        }//post

    }
    //fuera del oncreate


    fun generarColorAleatorio(): Int{
        //generar 3 numeros aleatorios R, G, B, entre 0 y 255 incluido
        //Creamos una variable random
        val random = Random.Default
        val rojo= random.nextInt(256)
        val azul= random.nextInt(256)
        val verde= random.nextInt(256)
        //Color es la clase para almacenar colores y ek metodo rgb() saca el numero
        return Color.rgb(rojo,verde,azul)
    }
    private fun actualizarVista(cuadrado: Cuadrado,cuadradoView:View){
        //aqui es donde elazamos la vista con el objeto
        //la vista se actualizara su ancho y alto con los datos del objeto
        cuadradoView.layoutParams.width=cuadrado.ancho
        cuadradoView.layoutParams.height=cuadrado.alto
        //cambiar color
        cuadradoView.setBackgroundColor(cuadrado.color)
        //actualizar las coordenadas
        cuadradoView.x=cuadrado.x.toFloat()
        cuadradoView.y=cuadrado.y.toFloat()
        //ejecutar los cambios
        cuadradoView.requestLayout()
    }
}
package model;

import android.graphics.Color;
//Por defecto todas las clases son final cambiar la clase cuadrado  a open
class CuadradoBorde(color:Int, ancho: Int, alto: Int, var bordeColor: Int=Color.BLACK):Cuadrado(color,ancho,alto){

    fun cambiarColorBorde(nuevoColorBorde: Int){
        bordeColor = nuevoColorBorde
    }

    //Ejemplo de clase Nested
    class ManejoColor{
        //Definimos un objeto comun a toda clase que son los colores
        companion object {
            val ROJO = Color.RED
            val AZUL = Color.BLUE
            val VERDE = Color.GREEN
            val NEGRO = Color.BLACK
        //definimos el metodo de cambiar color
        fun obtenerCuatroColoresAleatorio(): Int {
            //Creamos una lista con los valores del companion object
            val colores = listOf(ROJO, AZUL, VERDE, NEGRO)
            return colores.random()
        }
        }
    }
}

package model;

import android.graphics.Color;
//Por defecto todas las clases son final cambiar la clase cuadrado  a open
class CuadradoBorde(color:Int, ancho: Int, alto: Int, var bordeColor: Int=Color.BLACK):Cuadrado(color,ancho,alto){

    fun cambiarColorBorde(nuevoColorBorde: Int){
        bordeColor = nuevoColorBorde
    }
}

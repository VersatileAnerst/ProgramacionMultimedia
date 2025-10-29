package model

open class Cuadrado (var color:Int, var ancho:Int, var alto:Int) {
    //coordenadas iniciales
    var x : Int=0
    var y : Int=0
    //metodos para mover -cambiar el cuadrado
    fun moverArriba(){
        y-=10 // y=  y-10
    }
    fun moverAbajo(){
        y+=10
    }
    fun moverDerecha(){
        x+=10
    }
    fun moverIzquierda(){
        x-=10
    }
    fun cambiarTamanio(nuevoAncho:Int, nuevoAlto:Int){
        ancho = nuevoAncho
        alto = nuevoAlto
        val x:Int=50
        val y:Int=50
    }
    fun aumentar(){
        ancho += 10
        alto += 10
    }
    fun disminuir(){
        ancho -= 10
        alto -= 10
    }
}class CuadradoBordes(color:Int, ancho: Int, alto: Int, var bordecolor: Int=android.graphics.Color.BLACK)
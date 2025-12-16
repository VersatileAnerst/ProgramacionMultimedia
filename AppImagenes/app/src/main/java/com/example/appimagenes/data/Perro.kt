package com.example.appimagenes.data
import com.example.appimagenes.R

data class Perro (val id:Int, val nombre:String, val imagen:Int, val genero: String, val raza:String, val descripcion:String){
    object RepositorioPerros {
        val listaPerros = listOf(
            Perro(id = 1, nombre = "Manchas", imagen = R.drawable.perro1, genero = "Hembra", raza = "Lebrel Afgano", descripcion = "Manchas es muy juguetona y curiosa, le encanta correr en el parque y siempre está lista para hacer nuevos amigos."),
            Perro(id = 2, nombre = "Rocco", imagen = R.drawable.perro2, genero = "Macho", raza= "Yorkshire", descripcion = "Rocco es un perro protector y leal, siempre atento a su entorno. Disfruta de largas caminatas el compañero perfecto para un deportista."),
            Perro(id = 3, nombre = "Elsa", imagen = R.drawable.perro3, genero = "Hembra", raza = "Corgi", descripcion = "Luna es tranquila y cariñosa, le encanta acurrucarse y recibir mimos. Tiene un carácter dulce y se lleva muy bien con otros animales y niños."))
        //funcion que devuleve el perro por id, Si no encuentra el perro que devuelva nulo
        /*fun getPerroById(id:Int):Perro? {
            for (perro in listaPerros) {
                if(perro.id == id){
                    return perro
                }
            }
            return null
        }*/
        fun getPerroById(id:Int):Perro?{
            return listaPerros.find { it.id == id }
        }
    }

}
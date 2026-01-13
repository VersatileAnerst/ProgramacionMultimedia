package com.example.appimagenes.data
import com.example.appimagenes.R

data class Perro (val id:Int, val nombre:String, val imagen:Int, val genero: String, val raza:String,val sonido: Int, val descripcion:String){
    object RepositorioPerros {
        val listaPerros = listOf(
            Perro(id = 1, nombre = "Manchas", imagen = R.drawable.perro1, genero = "Hembra", raza = "Lebrel Afgano", sonido = R.raw.ladrido1, descripcion = "Manchas es muy juguetona y curiosa, le encanta correr en el parque y siempre está lista para hacer nuevos amigos."),
            Perro(id = 2, nombre = "Rocco", imagen = R.drawable.perro2, genero = "Macho", raza= "Yorkshire", sonido = R.raw.ladrido2, descripcion = "Rocco es un perro protector y leal, siempre atento a su entorno. Disfruta de largas caminatas el compañero perfecto para un deportista."),
            Perro(id = 3, nombre = "Elsa", imagen = R.drawable.perro3, genero = "Hembra", raza = "Corgi", sonido = R.raw.ladrido3, descripcion = "Luna es tranquila y cariñosa, le encanta acurrucarse y recibir mimos. Tiene un carácter dulce y se lleva muy bien con otros animales y niños."),
            Perro(id = 4, nombre = "Principe", imagen = R.drawable.perro4, genero = "Macho", raza = "Corgi", sonido = R.raw.ladrido4, descripcion = "Principe es un perro muy inteligente y aprende trucos con mucha rapidez. A pesar de su tamaño le encanta llamar la atención."),
            Perro(id = 5, nombre = "Laika", imagen = R.drawable.perro5, genero = "Hembra", raza = "Galgo Persa", sonido = R.raw.ladrido5, descripcion = "Laika es elegante y veloz. Cuando entra en confianza se convierte en la compañera más fiel de la casa y se lleva bien con cualquier otro animal."),
            Perro(id = 6, nombre = "Niebla", imagen = R.drawable.perro6, genero = "Macho", raza = "Yorkshire", sonido = R.raw.ladrido6, descripcion = "Niebla es un perro pequeño y protector. Explorara cada rincon y vigilara que todo este en su lugar. "))

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

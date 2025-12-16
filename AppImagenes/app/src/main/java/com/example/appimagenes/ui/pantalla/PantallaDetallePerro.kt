package com.example.appimagenes.ui.pantalla

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appimagenes.data.Perro.RepositorioPerros

@Composable
fun PantallaDetallePerro(navController: NavController, id:Int){
    //creamos variable casa donde almacenar el objeto casa que se tiene que cargar segun el id que recibamos
    //la casa esta en el fichero de datos en un objeto perro en el objeto Repositorio Perro
    val perro = RepositorioPerros.getPerroById(id)?: return //Para evitar errores de ids no validos se pone return(no devuelve nada)
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = {navController.popBackStack()}, modifier = Modifier.align(Alignment.End)) {
            Text("Volver")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(perro.nombre, style = MaterialTheme.typography.titleLarge)
        Text(perro.raza, style =  MaterialTheme.typography.titleMedium)
        Text(perro.descripcion, style = MaterialTheme.typography.displayLarge)
        //Para poner animaciones a la imagen en un Box
        Box(modifier = Modifier.fillMaxWidth().height(300.dp),
            contentAlignment = Alignment.Center){
            Image(painter = painterResource(id = perro.imagen),
                contentDescription = perro.nombre)
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {}) {
            Text("Boton que haga algo")
        }
    }
}
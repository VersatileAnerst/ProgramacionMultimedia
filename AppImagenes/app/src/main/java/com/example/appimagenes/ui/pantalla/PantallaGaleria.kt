package com.example.appimagenes.ui.pantalla

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appimagenes.data.Perro.RepositorioPerros

@Composable
fun PantallaGaleria(navController : NavController){
    //Va a meter un LazyColumn y que ocupe todo con margen de 10
    LazyColumn (modifier = Modifier.fillMaxSize().padding(10.dp)){
        //empezamos metiendo los elementos sacando los de la lista
        items(RepositorioPerros.listaPerros.size){
            index:Int-> val perro = RepositorioPerros.listaPerros[index]
            //con cada elemento de la lista lo metemos en un card
            Card (modifier = Modifier.padding((8.dp)).fillMaxWidth().clickable{PantallaDetallePerro(navController, perro.id)}){
                Row(modifier = Modifier.padding(8.dp)){
                    Image(painter = painterResource(id = perro.imagen),
                        contentDescription = perro.nombre,
                        modifier = Modifier.size(80.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(perro.nombre, style = MaterialTheme.typography.titleLarge)
                        Text(perro.raza, style = MaterialTheme.typography.titleMedium)
                        //La descripcion solo queremos se visualice las dos primeras lineas
                        Text(perro.descripcion, maxLines = 2)
                    }
                }
            }
        }//hasta aqui viene los items
        //boton tiene que estar dentro de un item
        item {
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = {navController.popBackStack()},
                modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp)
            ) {
                Text("Volver")
            }
        }
    }//lazycolumn

}
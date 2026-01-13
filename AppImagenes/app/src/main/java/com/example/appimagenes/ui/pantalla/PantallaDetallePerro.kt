package com.example.appimagenes.ui.pantalla

import android.R.attr.offset
import android.media.MediaPlayer
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.input.pointer.pointerInput
import androidx.navigation.NavController
import com.example.appimagenes.R
import com.example.appimagenes.data.Perro.RepositorioPerros

@Composable
fun PantallaDetallePerro(navController: NavController, id:Int) {
    //creamos variable casa donde almacenar el objeto casa que se tiene que cargar segun el id que recibamos
    //la casa esta en el fichero de datos en un objeto perro en el objeto Repositorio Perro
    val perro = RepositorioPerros.getPerroById(id)
        ?: return //Para evitar errores de ids no validos se pone return(no devuelve nada)

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Volver")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(perro.nombre, style = MaterialTheme.typography.displayLarge)
        Text(perro.raza, style = MaterialTheme.typography.displayMedium)
        Text(perro.descripcion, style = MaterialTheme.typography.displaySmall)

        //Funcion para la imagen
        ImagenZoom(perro.imagen, perro.nombre)

        Spacer(modifier = Modifier.height(24.dp))

        val context = LocalContext.current  // Obtenemos el "contexto" de Android dentro de Compose

        Button(onClick = {
            val mediaPlayer = MediaPlayer.create(context, perro.sonido)//Necesita el context para saber donde reproducirlo
            mediaPlayer.start()
        }) {
            Text("Ladrido")
        }
    }
}
@Composable
fun ImagenZoom(perroId: Int, nombre: String) {
    //Escala de la imagen
    var escala by remember { mutableStateOf(1f) }
    //Posicion de la imagen
    var posicion by remember { mutableStateOf(Offset.Zero) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .pointerInput(Unit) {
                detectTransformGestures { _, desplazamiento, zoom, _ ->
                        //Actualizar posición
                        posicion += desplazamiento
                        //Actualizar escala
                        escala = (escala * zoom).coerceIn(0.5f, 5f)
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = perroId),
            contentDescription = nombre,
            modifier = Modifier.graphicsLayer(
                //escala
                scaleX = escala,
                scaleY = escala,
                //posicion
                translationX = posicion.x,
                translationY = posicion.y
            )
        )
    }
}



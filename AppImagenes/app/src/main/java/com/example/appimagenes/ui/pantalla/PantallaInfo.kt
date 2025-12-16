package com.example.appimagenes.ui.pantalla

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PantallaInfo(navController : NavController){
    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(
            //Queremos navegar hacia atras
            onClick = {navController.popBackStack()},
            //Ponemos el boton a la izquierda
            modifier = Modifier.align(Alignment.Start)
        ) {Text("Volver") }
        Spacer(modifier = Modifier.height(12.dp))
        Text("Desarrollado por D.B.B.A", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(12.dp))
        Text("Aplicacion sobre adopcion de perros", style = MaterialTheme.typography.titleMedium)
    }
}
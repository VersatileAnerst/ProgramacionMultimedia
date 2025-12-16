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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun PantallaInicio(navController : NavController){
    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ){
        Text("Bienvenid@ a la Galeria de Perros",
            style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {navController.navigate("galeria")})
        {Text("Ir a la galeria") }
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = {navController.navigate("info")})
        {Text("Sobre la App") }
    }
}
/*@Preview(showBackground = true)
@Composable
fun PantallaInicioPreview(){
    pantallaInicio(navController = NavController.Companion)
}*/
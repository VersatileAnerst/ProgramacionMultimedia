package com.example.appimagenes

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.appimagenes.ui.pantalla.PantallaDetallePerro
import com.example.appimagenes.ui.pantalla.PantallaGaleria
import com.example.appimagenes.ui.pantalla.PantallaInfo
import com.example.appimagenes.ui.pantalla.PantallaInicio
import com.example.appimagenes.ui.theme.AppImagenesTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppImagenesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                   PerrosApp()
                }
            }
        }
    }
}
@Composable
fun PerrosApp(){
    //creamos un controlador de navegacion
    val navController = rememberNavController()
    //creamos contenedor de navegacion para definir las rutas
    NavHost(navController= navController,startDestination = "Inicio"){
        composable("inicio") {PantallaInicio(navController)}
        composable ("info") {PantallaInfo(navController)}
        composable  ("galeria") {PantallaGaleria(navController)}
        //Pasandole el id correcto
        composable("detalle/{id}") { backStackEntry ->
            val idString = backStackEntry.arguments!!.getString("id")!!
            val id = idString.toInt()
            PantallaDetallePerro(navController, id)
        }

    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppImagenesTheme {
        Greeting("Android")
    }
}
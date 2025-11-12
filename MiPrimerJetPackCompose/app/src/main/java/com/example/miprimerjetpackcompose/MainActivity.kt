package com.example.miprimerjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.miprimerjetpackcompose.ui.theme.MiPrimerJetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //MiPrimeraComposable()
            MiSegundaComposable()
        }
    }
}

@Composable
fun MiPrimeraComposable() {
    Column(modifier = Modifier.fillMaxSize().padding(top=40.dp)) {
        Row {
            Text(text = "Primera Fila")
            Spacer(modifier = Modifier.width(35.dp))
            Text(text = "Segunda Fila")
        }
            Spacer(modifier = Modifier.height(45.dp))
            Text(text = "Esta es mi primera funcion")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Aqui escribimos la segunda linea")
    }
}

@Composable
fun MiSegundaComposable(){
    Box(
        modifier = Modifier.fillMaxSize().padding(20.dp)
    ){
        Text(text = "Pep", modifier = Modifier.align(Alignment.TopStart) )
        Text(text = "Jimmy", modifier = Modifier.align(Alignment.TopCenter) )
        Text(text = "Antonio Garcia", modifier = Modifier.align(Alignment.TopEnd))
        Text(text = "Puchol", modifier = Modifier.align(Alignment.CenterStart))
        Text(text = "Chad", modifier = Modifier.align(Alignment.Center))
        Text(text = "Daniel", modifier = Modifier.align(Alignment.CenterEnd))
        Text(text = "Aitor", modifier = Modifier.align(Alignment.BottomStart))
        Text(text = "Cynthia", modifier = Modifier.align(Alignment.BottomCenter))
        Text(text = "Puma", modifier = Modifier.align(Alignment.BottomEnd))

    }
}
//@Preview(showBackground = true, name = "Primera")
@Composable
fun MiPrimeraComposablePreview() {
    MiPrimeraComposable()
}
@Preview(showBackground = true, name = "Segunda")
@Composable
fun MiSegundaComposablePreview(){
    MiSegundaComposable()
}
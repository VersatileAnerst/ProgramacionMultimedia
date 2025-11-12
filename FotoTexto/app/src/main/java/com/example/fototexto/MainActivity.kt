package com.example.fototexto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.fototexto.ui.theme.FotoTextoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FotoTextoTheme {
                mostrarimagen()
                }
            }
        }
    }

@Preview(showBackground = true, name = "mostrarImagenPreview")
@Composable
fun mostrarimagen() {
    Box(
        modifier = Modifier.fillMaxSize()
        ,contentAlignment = Alignment.Center
    ) {

        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.img),
            contentDescription = "Imagen de Batman"
        )
        Text(text="Batman",
            color = colorResource(id = R.color.purple_200),
            fontSize = 40.sp
        )
    }
}

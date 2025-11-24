package com.example.fototexto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntOffset
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
    //Declaramos una variable observable para almacenar el color de fondo
    //val colorFondo : Color by remember { mutableStateOf(android.R.color.white) }
    var colorFondo by remember { mutableStateOf(Color.White) }
    var posicionTexto by remember { mutableStateOf(Offset(0F,0F)) }
    //Calculamos el alto y el ancho de la pantalla
    var anchoPantalla by remember { mutableStateOf(0F) }
    var altoPantalla by remember { mutableStateOf(0F) }
    var anchoTexto by remember { mutableStateOf(0f) }
    var altoTexto by remember { mutableStateOf(0f) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(colorFondo)//colorFondo.value
            .onGloballyPositioned{ coordinates ->
                altoPantalla = coordinates.size.height.toFloat()
                anchoPantalla = coordinates.size.width.toFloat()
            }
    ) {

       /* Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "Imagen de Batman",
            modifier = Modifier.align(Alignment.Center).fillMaxSize()
        )*/
        imagenInteractiva()
        Text(
            text="Batman texto largo",
            color = colorResource(id = R.color.black),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            //modifier = Modifier.align(Alignment.Center)
            modifier = Modifier
                .onGloballyPositioned{ coordinates ->
                    altoTexto = coordinates.size.height.toFloat()
                    anchoTexto = coordinates.size.width.toFloat()
                    //if (posicionTexto.x==0 && posicionTexto.y==0)
                    if(posicionTexto == Offset(0f,0F)) {
                            posicionTexto = Offset((anchoPantalla-anchoTexto) / 2, (altoPantalla-altoTexto) / 2)
                        }
                    }
                .offset{
                    IntOffset(posicionTexto.x.toInt(),
                        posicionTexto.y.toInt())
                }
                .pointerInput(Unit){
                     detectDragGestures { change, dragAmount ->
                         change.consume() //Evita que se activen otros eventos al pasar por encima de otros objetos
                         posicionTexto = Offset(
                                 posicionTexto.x + dragAmount.x,
                                posicionTexto.y + dragAmount.y
                                 )
                     }
                }
        )
        Button(
            onClick = {colorFondo = colorAleatorio()},
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            Text(text = "Cambiar fondo")
        }
    }
}
@Composable
fun imagenInteractiva(){
    //Necesitamos almacenar y observar la escala
    var escala by remember { mutableStateOf(1F) }
    //Necesitamos la posicion de la imagen
    var posicion by remember { mutableStateOf(Offset.Zero) }
    Box(modifier = Modifier
        .fillMaxSize()
        .pointerInput(Unit){
            detectTransformGestures { _, desplazamiento, zoom, _ ->
                posicion += desplazamiento //aplicamos el desplazamiento a la posicion
                //Aplicamos el zoom a la escala
                escala *= zoom
            }
        }, contentAlignment = Alignment.Center)
    {
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "Imagen de Batman",
            modifier = Modifier
                //grapichs layer permite aicar una escala y una posicion en la imagen
                .graphicsLayer(
                    translationX = posicion.x,
                    translationY = posicion.y,
                    //escala
                    scaleX = escala.coerceIn(0.5f,3f),//limite zoom eje x
                    scaleY = escala.coerceIn(0.5f,3f)//limite zoom eje y

                )
        )

    }

}
fun colorAleatorio():Color{
    val rojo = kotlin.random.Random.nextFloat()
    //val rojo = (0 .. 255).random().toFloat()
    val verde = kotlin.random.Random.nextFloat()
    val azul = kotlin.random.Random.nextFloat()

    return Color(rojo,verde,azul)
}

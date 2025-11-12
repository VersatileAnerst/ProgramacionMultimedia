package com.example.misegundocompose

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.misegundocompose.ui.theme.MiSegundoComposeTheme
import org.intellij.lang.annotations.JdkConstants

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiSegundoComposeTheme {
                    Textos()
            }
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

@Composable
fun Mifuncion1(){
    Box (
        modifier = Modifier.fillMaxSize()
        ,contentAlignment = Alignment.Center
    ){
        Greeting(name = "Daniel",
            modifier = Modifier.background(Color.Yellow))
        Greeting(name = "Android",
            modifier = Modifier.align(Alignment.BottomEnd)
            .background(Color.Blue))
    }
}
@Composable
fun Mifuncion2(){
    Column (
        modifier = Modifier.fillMaxWidth()
            .height(200.dp)
        ,verticalArrangement = Arrangement.SpaceAround
        ,horizontalAlignment = Alignment.CenterHorizontally
    ){
        Greeting(name = "Daniel",
            modifier = Modifier.background(Color.Yellow)
                .weight(2f)
        )
        Greeting(name = "Android",
            modifier = Modifier.background(Color.Blue)
                .weight(2f)
        )
        Greeting(name = "Jimmy",
            modifier = Modifier.background(Color.Red)
                .weight(1f)
        )
}
}
@Composable
fun Mifuncion3(){
    Row (
        modifier = Modifier .fillMaxWidth()
            .height(200.dp)
        , verticalAlignment = Alignment.CenterVertically
        , horizontalArrangement = Arrangement.SpaceEvenly
    ){
        Greeting(name = "Android", modifier = Modifier.background(Color.Yellow))
        Greeting(name = "Daniel", modifier = Modifier.background(Color.Magenta))
    }

}
//@Preview(showBackground = true, name = "MiBoton Preview", widthDp = 200, heightDp = 100)
@Composable
fun MiBoton(){
    Box(
        modifier = Modifier.fillMaxSize()
        ,contentAlignment = Alignment.Center
    ){
        Text(
            text = "Pulsa Aqui",
            modifier = Modifier
                .clickable{}
                .background(Color.Green)
                .border(width = 2.dp, color = Color.Magenta)
                .padding(horizontal = 20.dp, vertical = 10.dp)
        )
    }
}
@Preview(showBackground = true, widthDp = 200, heightDp = 100)
@Composable
fun Textos(){
    Box(
        modifier = Modifier
            .fillMaxSize(),
            contentAlignment = Alignment.Center
    ){
        Text(text = stringResource(id = R.string.lore),
            //Color = Color.Red
            //Color = Color(255,0,0)
            color = colorResource(id = R.color.purple_200),
            fontSize = 15.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.ExtraBold,
            fontStyle = FontStyle.Italic,
            letterSpacing = 5.sp,
            textDecoration = TextDecoration.Underline,
            lineHeight = 3.em,
            //solo es una linea
            maxLines = 2
        )
    }
}

//@Preview(showBackground = true, name = "Daniel Preview")
@Composable
fun Mifuncion1Preview() {
    MiSegundoComposeTheme {
        Mifuncion1()
    }
}

//@Preview(showBackground = true, name = "Daniel2Preview")
@Composable
fun Mifuncion2Preview() {
    MiSegundoComposeTheme {
        Mifuncion2()
    }
}
//@Preview(showBackground = true, name = "Daniel3Preview")
@Composable
fun Mifuncion3Preview() {
    MiSegundoComposeTheme {
        Mifuncion3()
    }
}

package com.example.galeriadeimagenes

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.galeriadeimagenes.ui.theme.GaleriaDeImagenesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GaleriaDeImagenesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    val context = LocalContext.current

    LazyVerticalGrid(
        modifier = modifier.fillMaxSize(),
        columns = GridCells.Adaptive(180.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(getImagenes()) {
            ItemImangen(it) {
                Toast.makeText(
                    context, "${it.titulo}",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }

    }


}


@Composable
fun ItemImangen(model: Galeria, onItemSelected: (Galeria) -> Unit) {

    Card(
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Column {
            Image(
                painter = painterResource(id = model.imagen),
                contentDescription = model.titulo,
                modifier = Modifier
                    .clickable {onItemSelected(model)}
                    .fillMaxWidth()
                    .width(200.dp)
                    .height(300.dp),
                contentScale = ContentScale.Crop
            )
            Text(model.titulo, modifier = Modifier.align(Alignment.CenterHorizontally))
        }

    }

}

fun getImagenes(): List<Galeria> {

    return listOf(

        Galeria("Mona Lisa", R.drawable.mona_lisa),
        Galeria("La noche estrellada", R.drawable.noche_estrellada),
        Galeria("El grito", R.drawable.el_grito),
        Galeria("La última cena", R.drawable.ultima_cena),
        Galeria("Persistencia de memoria", R.drawable.persistencia_memoria),
        Galeria("Guernica", R.drawable.guernica),
        Galeria("Las Meninas", R.drawable.meninas),
        Galeria("El jardín de las delicias", R.drawable.jardin_delicias),
        Galeria("El beso", R.drawable.beso),
        Galeria("El nacimiento de Venus", R.drawable.venus)


    )


}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GaleriaDeImagenesTheme {
        Greeting("Android")
    }
}
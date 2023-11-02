package com.dam.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dam.artspaceapp.ui.theme.ArtSpaceAppTheme
import com.dam.artspaceapp.ui.theme.Background

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpace()
                }
            }
        }
    }
}

@Composable
fun ArtSpace() {
    var picture by rememberSaveable { mutableStateOf(0) }
    var title by rememberSaveable { mutableStateOf(0) }
    var subtitle by rememberSaveable { mutableStateOf(0) }
    var description by rememberSaveable { mutableStateOf(0) }
    var currentArtwork by rememberSaveable { mutableStateOf(3) }

    when (currentArtwork) {
        1 -> {
            picture = R.drawable.el_grito_1
            title = R.string.title_1
            subtitle = R.string.subtitle_1
            description = R.string.description_1
        }

        2 -> {
            picture = R.drawable.impresion_salida_del_sol_2
            title = R.string.title_2
            subtitle = R.string.subtitle_2
            description = R.string.description_2
        }

        3 -> {
            picture = R.drawable.meninas_3
            title = R.string.title_3
            subtitle = R.string.subtitle_3
            description = R.string.description_3
        }

        4 -> {
            picture = R.drawable.mona_lisa_4
            title = R.string.title_4
            subtitle = R.string.subtitle_4
            description = R.string.description_4
        }

        5 -> {
            picture = R.drawable.noche_estrellada_5
            title = R.string.title_5
            subtitle = R.string.subtitle_5
            description = R.string.description_5
        }

        6 -> {
            picture = R.drawable.noctambulos_6
            title = R.string.title_6
            subtitle = R.string.subtitle_6
            description = R.string.description_6
        }

        7 -> {
            picture = R.drawable.senoritas_de_avignon_7
            title = R.string.title_7
            subtitle = R.string.subtitle_7
            description = R.string.description_7
        }
    }
    val onNextClick: () -> Unit = {
        if (currentArtwork == 7) currentArtwork = 1 else currentArtwork++
    }
    val onPreviousClick: () -> Unit = {
        if (currentArtwork == 1) currentArtwork = 7 else currentArtwork--
    }
    Screen(
        picture = picture,
        title = title,
        subtitle = subtitle,
        description = description,
        onNextClick = onNextClick,
        onPreviousClick = onPreviousClick
    )

}

@Composable
fun Screen(
    picture: Int,
    title: Int,
    subtitle: Int,
    description: Int,
    modifier: Modifier = Modifier,
    onNextClick: () -> Unit,
    onPreviousClick: () -> Unit
) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(32.dp)
    ) {
        Spacer(modifier = modifier.weight(1f))
        Surface(
            modifier = modifier
                .shadow(4.dp)
                .padding(36.dp)
                .weight(5f)
        ) {
            Image(
                painter = painterResource(id = picture),
                contentDescription = stringResource(id = description),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(
            modifier = modifier.weight(1f)
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .background(color = Background)
                .padding(24.dp)
        ) {
            Text(
                text = stringResource(id = title),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = modifier.padding(bottom = 8.dp)
            )
            Text(
                text = stringResource(id = subtitle),
                fontSize = 18.sp,
                fontFamily = FontFamily.Cursive
            )
        }


        Spacer(modifier = modifier.weight(0.5f))
        Row(modifier = modifier.padding(bottom = 24.dp)) {
            Button(modifier = modifier.width(120.dp), onClick = onPreviousClick) {
                Text(text = "Previous")
            }
            Spacer(
                modifier = modifier
                    .weight(1f)
            )
            Button(modifier = modifier.width(120.dp), onClick = onNextClick) {
                Text(text = "Next")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ArtSpaceAppTheme {
        ArtSpace()
    }
}
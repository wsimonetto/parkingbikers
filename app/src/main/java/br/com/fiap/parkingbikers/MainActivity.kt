package br.com.fiap.parkingbikers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.parkingbikers.screens.LoginScreen
import br.com.fiap.parkingbikers.screens.MapaScreen
import br.com.fiap.parkingbikers.screens.OpeningScreen
import br.com.fiap.parkingbikers.ui.theme.ParkingBikersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ParkingBikersTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "opening",
                        exitTransition = {
                            slideOutOfContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.End,
                                tween(1000),
                            ) + fadeOut(animationSpec = tween(1000))
                        },
                        enterTransition = {
                            slideIntoContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Down,
                                animationSpec = tween(1000)
                            )
                        }
                    )
                    {
                        composable(route = "opening") {
                            OpeningScreen(navController)
                        }
                        composable(route = "login") {
                            LoginScreen(navController)
                        }
                        composable(route = "MapaScreen") {
                            MapaScreen(context = this@MainActivity)
                        }


                        //MapScreen(this)
                    }
                }
            }
        }
    }
}

/*
@Composable
fun MapScreen(activity: Activity) {

    val centralParkingsBikes = LatLng(-23.549866, -46.6333734) // Posição inicial
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(centralParkingsBikes, 12f)
    }
    val locais = getAllLocation() // Obter a lista de locais
    // Mapa
    Box(
        modifier = Modifier.fillMaxSize()
    )
    {
        GoogleMap(
            cameraPositionState = cameraPositionState,
        )
        {
            locais.forEach { local ->
                MapaMarker(
                    context = activity, // Passando o contexto da MainActivity para o MapaMarker
                    position = LatLng(local.latitude, local.longitude),
                    title = local.title,
                    iconResourceId = local.iconResourceId,
                )
            }
        }

        // TextField sobre o mapa
        OutlinedTextField(
            value = "",
            onValueChange = { /* handle value change */ },
            modifier = Modifier
                .align(Alignment.TopCenter) // Centraliza horizontalmente e mantém no topo
                .padding(top = 16.dp)
                .width(width = 335.dp),
            label = {
                Text(
                    text = "Parking Bikers",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.Laranja)
                )
            },
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "buscar")
                    colorResource(
                        id = R.color.Laranja
                    )
                }
            },
            placeholder = {
                Text(
                    text = "Digite a Estação do Metrô?",
                    color = colorResource(id = R.color.Red)
                )
            },
            maxLines = 1,
            shape = RoundedCornerShape(16.dp),

            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = colorResource(id = R.color.Laranja),
                focusedBorderColor = colorResource(id = R.color.Red),
            ),

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )


    }
}

@Composable
fun MapaMarker(
    context: Context,
    position: LatLng,
    title: String,
    @DrawableRes iconResourceId: Int,
) {
    val icon = bitmapDescriptorFromVector(
        context, iconResourceId
    )
    Marker(
        state = MarkerState(position = position),
        title = title,
        icon = icon,
    )
}

@Composable
fun bitmapDescriptorFromVector(
    context: Context,
    vectorResId: Int,
): BitmapDescriptor? {
    val drawable = ContextCompat.getDrawable(context, vectorResId)
    if (drawable == null) {
        Log.e("MapaScreen", "Ícone nulo para o vetor de recursos ID: $vectorResId")
        return null
    }
    drawable.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
    val bm = Bitmap.createBitmap(
        drawable.intrinsicWidth,
        drawable.intrinsicHeight,
        Bitmap.Config.ARGB_8888
    )

    val canvas = android.graphics.Canvas(bm)
    drawable.draw(canvas)
    return BitmapDescriptorFactory.fromBitmap(bm)
} */

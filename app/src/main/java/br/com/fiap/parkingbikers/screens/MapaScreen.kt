package br.com.fiap.parkingbikers.screens

import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import br.com.fiap.parkingbikers.R
import br.com.fiap.parkingbikers.model.LocationParkingBikers
import br.com.fiap.parkingbikers.repository.getAllLocation
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import java.text.Normalizer

@Composable
fun MapaScreen(context: Context) {

    val centralParkingsBikes = LatLng(-23.549866, -46.6333734) // Posição inicial
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(centralParkingsBikes, 12f)
    }
    val locais = getAllLocation() // Obter a lista de locais

    var searchParkingBikers by remember {
        mutableStateOf("")
    }
    var selectedStation by remember {
        mutableStateOf<LocationParkingBikers?>(null)
    }

    // buscar a estação com base no nome
    /*fun searchStation() {
        selectedStation = locais.find { it.title.equals(searchParkingBikers, ignoreCase = true) }
    } */

    // remover acentos de uma string
    fun String.removeAccents(): String {
        return Normalizer.normalize(this, Normalizer.Form.NFD)
            .replace("\\p{InCombiningDiacriticalMarks}+".toRegex(), "")
    }

    // buscar a estação com base no nome
    fun searchStation() {
        val searchTextNormalized = searchParkingBikers.removeAccents() // Normalizar texto de busca
        selectedStation = locais.find {
            it.title.removeAccents().equals(searchTextNormalized, ignoreCase = true)
        }
        //selectedStation = locais.find { it.title.equals(searchParkingBikers, ignoreCase = true) }
        selectedStation?.let { station ->
            // Atualizar a posição da câmera para a estação selecionada
            cameraPositionState.position = CameraPosition.Builder()
                .target(LatLng(station.latitude, station.longitude))
                .zoom(16f) // Zoom opcional, pode ajustar conforme necessário
                .build()
        }
    }

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
                    context = context, // Passando o contexto da MainActivity para o MapaMarker
                    position = LatLng(local.latitude, local.longitude),
                    title = local.title,
                    iconResourceId = local.iconResourceId,
                )
            }
        }

        // ficar sobre o mapa
        OutlinedTextField(
            value = searchParkingBikers,
            onValueChange = { searchParkingBikers = it },
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 16.dp)
                .width(width = 335.dp),
            label = {
                Text(
                    text = "Digite a estação desejada",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.blue)
                )
            },
            trailingIcon = {
                IconButton(onClick = { searchStation() }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "buscar",
                        tint = colorResource(id = R.color.blue)
                    )
                    colorResource(
                        id = R.color.blue
                    )
                }
            },
            placeholder = {
                Text(
                    text = "Digite a Estação do Metrô?",
                    color = colorResource(id = R.color.blue)
                )
            },
            maxLines = 1,
            shape = CutCornerShape(bottomEnd = 15.dp, topStart = 15.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = colorResource(id = R.color.blue),
                focusedBorderColor = colorResource(id = R.color.blue),
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            textStyle = TextStyle(color = colorResource(id = R.color.blue)),
        )
    }

    selectedStation?.let { station ->

        Box(
            modifier = Modifier
                .padding(8.dp)
                .size(width = 325.dp, height = 150.dp)
        ) {
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(Color.White),
                elevation = CardDefaults.cardElevation(25.dp),
                shape = CutCornerShape(bottomEnd = 20.dp, topStart = 20.dp),
                border = BorderStroke(1.dp, colorResource(id = R.color.blue))
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Parking Bikers - ${station.title}",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.dark_blue)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Capacidade: ${station.vagasCapacidade} vagas",
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.blue_light)
                    )
                    Text(
                        text = "Disponíveis: ${station.vagasDisponiveis} vagas",
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.blue_light)
                    )
                    Text(
                        text = "*** Vagas podem alterar até sua chegada ***",
                        fontSize = 12.sp,
                        color = colorResource(id = R.color.red)
                    )
                    Text(
                        text = "Endereço: ${station.endereco}",
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.blue_light)
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        IconButton(
                            onClick = {

                            }
                        ) {
                            Icon(
                                Icons.Default.Favorite,
                                contentDescription = "Favorito",
                                tint = colorResource(id = R.color.green)
                            )
                        }
                        IconButton(
                            onClick = {
                                searchParkingBikers = ""
                                selectedStation = null
                                cameraPositionState.position = CameraPosition.Builder()
                                    .target(centralParkingsBikes)
                                    .zoom(12f)
                                    .build()
                            }
                        ) {
                            Icon(
                                Icons.Default.Close,
                                contentDescription = "Fechar",
                                tint = colorResource(id = R.color.red)
                            )
                        }
                    }
                }
            }
        }
    }
} // FIM

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
fun bitmapDescriptorFromVector(context: Context, vectorResId: Int): BitmapDescriptor? {
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
}





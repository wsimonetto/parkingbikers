package br.com.fiap.parkingbikers.screens

import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import br.com.fiap.parkingbikers.R
import br.com.fiap.parkingbikers.repository.getAllLocation
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapaScreen(context: Context) {

    val centralParkingsBikes = LatLng(-23.549866, -46.6333734) // Posição inicial
    var cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(centralParkingsBikes, 12f)
    }
    val locais = getAllLocation() // Obter a lista de locais

    var searchParkingBikers by remember {
        mutableStateOf("")
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

        // sobre o mapa
        OutlinedTextField(
            value = searchParkingBikers,
            onValueChange = { searchParkingBikers = it },
            modifier = Modifier
                .align(Alignment.TopCenter) // Centraliza horizontalmente e mantém no topo
                .padding(top = 16.dp)
                .width(width = 335.dp),
            label = {
                Text(
                    text = "Parking Bikers",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.laranja)
                )
            },
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "buscar",
                        tint = colorResource(id = R.color.laranja)
                    )
                    colorResource(
                        id = R.color.laranja
                    )
                }
            },
            placeholder = {
                Text(
                    text = "Digite a Estação do Metrô?",
                    color = colorResource(id = R.color.red)
                )
            },
            maxLines = 1,
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = colorResource(id = R.color.laranja),
                focusedBorderColor = colorResource(id = R.color.red),
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            textStyle = TextStyle(color = colorResource(id = R.color.red)),
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
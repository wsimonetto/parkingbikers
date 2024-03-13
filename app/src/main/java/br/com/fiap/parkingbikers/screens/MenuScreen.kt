package br.com.fiap.parkingbikers.screens

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.parkingbikers.R
import br.com.fiap.parkingbikers.component.CanvasComponent
import br.com.fiap.parkingbikers.component.ColorsScreen

@Composable
fun MenuScreen(navController: NavController) {

    val colors = ColorsScreen()
    CanvasComponent(colors = colors).drawCanvas()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Text(
                text = "Parking Bikers",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                color = colorResource(id = R.color.blue),
            )
            Spacer(modifier = Modifier.width(6.dp))
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = "Lock icon",
                modifier = Modifier.size(36.dp),
                tint = Color.White
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        MenuItemCard(
            icon = ImageVector.vectorResource(id = R.drawable.baseline_map_24),
            title = "Mapa",
            description = "Mapa, pesquisa Estações do Metrô",
            onClick = { navController.navigate("MapaScreen") }
        )
        MenuItemCard(
            icon = ImageVector.vectorResource(id = R.drawable.baseline_search_24),
            title = "Pesquisa",
            description = "Histórico de pesquisas",
            onClick = { navController.navigate("pesquisa") }
        )
        MenuItemCard(
            icon = ImageVector.vectorResource(id = R.drawable.baseline_favorite_24),
            title = "Favoritos",
            description = "Parking Bikers Salvos",
            onClick = { navController.navigate("favoritos") }
        )
        MenuItemCard(
            icon = ImageVector.vectorResource(id = R.drawable.baseline_settings_24),
            title = "Perfil",
            description = "Gerenciamento do Perfil do usuário",
            onClick = { navController.navigate("perfil") }
        )
        Spacer(modifier = Modifier.height(45.dp))
    }
}

@Composable
fun MenuItemCard(
    icon: ImageVector,
    title: String,
    description: String,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(25.dp),
        shape = CutCornerShape(bottomEnd = 20.dp, topStart = 20.dp),
        colors = CardDefaults.cardColors(Color.White.copy(alpha = 0.90f))
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(
                    onClick = onClick, // Defina a ação de clique no IconButton
                    modifier = Modifier.padding(8.dp)
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        modifier = Modifier.size(48.dp),
                        tint = colorResource(id = R.color.blue)
                    )
                }
                Text(
                    text = title,
                    fontSize = 16.sp
                )
            }
            Column(
                modifier = Modifier.padding(start = 15.dp),
                horizontalAlignment = AbsoluteAlignment.Right
            ) {
                Text(
                    text = description,
                    fontSize = 14.sp
                )
            }
        }
    }
}
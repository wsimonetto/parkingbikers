package br.com.fiap.parkingbikers.screens

import android.annotation.SuppressLint
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.parkingbikers.R
import androidx.compose.animation.core.*
import androidx.compose.ui.graphics.painter.Painter
import br.com.fiap.parkingbikers.component.CanvasComponent
import br.com.fiap.parkingbikers.component.ColorsScreen
import kotlinx.coroutines.delay

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun OpeningScreen(navController: NavController) {

    val colors = ColorsScreen()

    var visibleScreen by remember {
        mutableStateOf(false)
    }
    var enterScreen by remember {
        mutableStateOf(fadeIn())
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.blue))
        ) {
            CanvasComponent(colors = colors).drawCanvas()
            ImageAnimationPoint()
            ImageAnimationBike()
        }
    }
    // Inicia um efeito que executa uma única vez após app iniciado.
    LaunchedEffect(key1 = true) {
        delay(1700)
        navController.navigate("login") {
            popUpTo(navController.graph.startDestinationId) {
                inclusive = true
            }
        }
    }
}

@Composable
fun ImageAnimationPoint() {

    var offsetY by remember { mutableStateOf(0f) }
    var animationFinished by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        val offsetYAnimation = Animatable(initialValue = -500f)
        val targetValue = 43f
        val animationSpec = tween<Float>(
            durationMillis = 1000,
            easing = FastOutSlowInEasing
        )
        offsetYAnimation.animateTo(
            targetValue = targetValue,
            animationSpec = animationSpec
        )
        offsetY = offsetYAnimation.value
        animationFinished = true
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = offsetY.dp),
        contentAlignment = Alignment.Center
    ) {
        if (!animationFinished) {
            // Coloque a imagem que você quer animar aqui
            AnimatedImagePoint(
                painter = painterResource(id = R.drawable.point),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
        } else {
            Image(
                painter = painterResource(id = R.drawable.point),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
        }
    }
}

@Composable
fun AnimatedImagePoint(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
) {
    val infiniteTransition = rememberInfiniteTransition()

    val yOffset by infiniteTransition.animateFloat(
        initialValue = -500f,
        targetValue = 43f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1300,
                easing = FastOutSlowInEasing
            ),
        ), label = ""
    )

    Box(
        modifier = modifier.offset(y = yOffset.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            modifier = Modifier.size(100.dp)
        )
    }
}

@Composable
fun ImageAnimationBike() {

    var offsetX by remember { mutableStateOf(0f) }
    var animationFinished by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        val offsetXAnimation = Animatable(initialValue = 500f)
        val targetValue = 0f
        val animationSpec = tween<Float>(
            durationMillis = 1000,
            easing = FastOutSlowInEasing
        )
        offsetXAnimation.animateTo(
            targetValue = targetValue,
            animationSpec = animationSpec
        )
        offsetX = offsetXAnimation.value
        animationFinished = true
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 65.dp, top = offsetX.dp),
        contentAlignment = Alignment.Center
    ) {
        if (!animationFinished) {
            // Coloque a imagem que você quer animar aqui
            AnimatedImageBike(
                painter = painterResource(id = R.drawable.bike),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
        } else {
            Image(
                painter = painterResource(id = R.drawable.bike),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
        }
    }
}

@Composable
fun AnimatedImageBike(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
) {
    val infiniteTransition = rememberInfiniteTransition()

    val xOffset by infiniteTransition.animateFloat(
        initialValue = 500f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1300,
                easing = FastOutSlowInEasing
            ),
        ), label = ""
    )

    Box(
        modifier = modifier.offset(y = xOffset.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            modifier = Modifier.size(100.dp)
        )
    }
}



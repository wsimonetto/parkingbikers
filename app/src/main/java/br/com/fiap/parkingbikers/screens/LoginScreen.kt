package br.com.fiap.parkingbikers.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.parkingbikers.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import br.com.fiap.parkingbikers.component.CanvasComponent
import br.com.fiap.parkingbikers.component.ColorsScreen
import br.com.fiap.parkingbikers.component.InputOutlinedPassword
import br.com.fiap.parkingbikers.component.InputOutlinedText


@Composable
fun LoginScreen(navController: NavController) {

    val colors = ColorsScreen()

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var passwordVisibility by remember {
        mutableStateOf(false)
    }

    fun setEmail(newEmail: String) {
        email = newEmail
    }

    fun setPassword(newPassword: String) {
        password = newPassword
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CanvasComponent(colors = colors).drawCanvas()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
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
            Text(
                text = "Gerenciamento Inteligente",
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.white),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Estacionamento de Bicicletas",
                fontSize = 17.sp,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.blue),
                fontWeight = FontWeight.SemiBold
            )
            Spacer(
                modifier = Modifier.height(30.dp)
            )
            InputOutlinedText(
                value = email,
                label = "Email",
                placeholder = "Digite o seu e-mail!",
                keyboardType = KeyboardType.Email,
                maxLines = 1,
                shape = CutCornerShape(bottomEnd = 15.dp, topStart = 15.dp),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_email_24),
                        contentDescription = "Ícone",
                        tint = Color.White
                    )
                },
                textStyle = TextStyle(color = Color.White),
                actionValueChange = {
                    setEmail(it)
                },
            )
            Spacer(modifier = Modifier.height(15.dp))
            InputOutlinedPassword(
                value = password,
                label = "Senha",
                placeholder = "Digite a sua Senha!",
                keyboardType = KeyboardType.Text,
                maxLines = 1,
                shape = CutCornerShape(bottomEnd = 15.dp, topStart = 15.dp),
                trailingIcon = {
                    IconButton(
                        onClick = {
                            passwordVisibility = !passwordVisibility
                        },
                        modifier = Modifier.size(24.dp)
                    )
                    {
                        val icon = if (passwordVisibility) {
                            painterResource(id = R.drawable.eye_visible)

                        } else {
                            painterResource(id = R.drawable.eye_invisible)
                        }
                        Icon(
                            icon,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                },
                textStyle = TextStyle(color = Color.White),
                actionValueChange = {
                    setPassword(it)
                },
                passwordVisibility = passwordVisibility
            )
            Spacer(
                modifier = Modifier.height(32.dp)
            )
            Button(
                onClick = { navController.navigate("MenuScreen") },
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier
                    .width(270.dp),
                shape = CutCornerShape(bottomEnd = 15.dp, topStart = 15.dp)
            ) {
                Text(
                    text = "Acessar",
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.blue)
                )
            }
            Spacer(
                modifier = Modifier.height(16.dp)
            )
            Button(
                onClick = { navController.navigate("UserRegisterScreen") },
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier
                    .width(270.dp),
                shape = CutCornerShape(bottomEnd = 15.dp, topStart = 15.dp)
            ) {
                Text(
                    text = "Cadastro",
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.blue)
                )
            }
            Spacer(
                modifier = Modifier.height(25.dp)
            )
            Text(
                text = "Por uma Cidade Inteligente",
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.white)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = " * Eficiente,",
                fontSize = 16.sp,
                textAlign = TextAlign.Left,
                color = colorResource(id = R.color.white)
            )
            Text(
                text = " * Sustentável,",
                fontSize = 16.sp,
                textAlign = TextAlign.Left,
                color = colorResource(id = R.color.white)
            )
            Text(
                text = " * Saudável,",
                fontSize = 16.sp,
                textAlign = TextAlign.Left,
                color = colorResource(id = R.color.white)
            )
            Spacer(modifier = Modifier.height(56.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.flag_br),
                    contentDescription = "Português",
                    modifier = Modifier
                        .size(
                            width = 48.dp,
                            height = 32.dp
                        )
                        .padding(end = 8.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.flag_es),
                    contentDescription = "Espanhol",
                    modifier = Modifier
                        .size(
                            width = 48.dp,
                            height = 32.dp
                        )
                        .padding(end = 8.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.flag_en),
                    contentDescription = "Inglês",
                    modifier = Modifier
                        .size(
                            width = 48.dp,
                            height = 32.dp
                        )
                        .padding(end = 8.dp)
                )
            }
        }
    }
} // FIM

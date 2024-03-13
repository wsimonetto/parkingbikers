package br.com.fiap.parkingbikers.screens

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.parkingbikers.R
import br.com.fiap.parkingbikers.component.CanvasComponent
import br.com.fiap.parkingbikers.component.ColorsScreen
import br.com.fiap.parkingbikers.component.InputOutlinedPassword
import br.com.fiap.parkingbikers.component.InputOutlinedText

@Composable
fun UserRegisterScreen() {

    var email by remember {
        mutableStateOf("")
    }

    var nomeCompleto by remember {
        mutableStateOf("")
    }

    var cpf by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var passwordRepeat by remember {
        mutableStateOf("")
    }

    var passwordVisibilityOne by remember {
        mutableStateOf(false)
    }

    var passwordVisibilityTwo by remember {
        mutableStateOf(false)
    }

    val colors = ColorsScreen()

    fun setEmail(newEmail: String) {
        email = newEmail
    }

    fun setNomeCompleto(newNomeCompleto: String) {
        nomeCompleto = newNomeCompleto
    }

    fun setCPF(newCPF: String) {
        cpf = newCPF
    }

    fun setPassword(newPassword: String) {
        password = newPassword
    }

    fun setPasswordRepeat(newPasswordRepeat: String) {
        passwordRepeat = newPasswordRepeat

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
                text = "Cadastro",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                color = colorResource(id = R.color.white),
            )
            Spacer(modifier = Modifier.height(20.dp))
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
            Spacer(modifier = Modifier.height(16.dp))
            InputOutlinedText(
                value = nomeCompleto,
                label = "Nome Completo",
                placeholder = "Digite o seu nome completo!",
                keyboardType = KeyboardType.Text,
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
                    setNomeCompleto(it)
                },
            )
            Spacer(modifier = Modifier.height(16.dp))
            InputOutlinedText(
                value = cpf,
                label = "CPF",
                placeholder = "Digite o seu CPF!",
                keyboardType = KeyboardType.Number,
                maxLines = 1,
                shape = CutCornerShape(bottomEnd = 15.dp, topStart = 15.dp),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_numbers_24),
                        contentDescription = "Ícone",
                        tint = Color.White
                    )
                },
                textStyle = TextStyle(color = Color.White),
                actionValueChange = {
                    setCPF(it)
                },
            )
            Spacer(modifier = Modifier.height(16.dp))
            InputOutlinedPassword(
                value = password,
                label = "Senha",
                placeholder = "Digite uma Senha!",
                keyboardType = KeyboardType.Text,
                maxLines = 1,
                shape = CutCornerShape(bottomEnd = 15.dp, topStart = 15.dp),
                trailingIcon = {
                    IconButton(
                        onClick = {
                            passwordVisibilityOne = !passwordVisibilityOne
                        },
                        modifier = Modifier.size(24.dp)
                    )
                    {
                        val icon = if (passwordVisibilityOne) {
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
                passwordVisibility = passwordVisibilityOne
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "(mínimo 8 e máximo 12 caracteres)",
                fontSize = 12.sp,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 56.dp)
            )
            InputOutlinedPassword(
                value = passwordRepeat,
                label = "Senha",
                placeholder = "Digite uma Senha!",
                keyboardType = KeyboardType.Text,
                maxLines = 1,
                shape = CutCornerShape(bottomEnd = 15.dp, topStart = 15.dp),
                trailingIcon = {
                    IconButton(
                        onClick = {
                            passwordVisibilityTwo = !passwordVisibilityTwo
                        },
                        modifier = Modifier.size(24.dp)
                    )
                    {
                        val icon = if (passwordVisibilityTwo) {
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
                    setPasswordRepeat(it)
                },
                passwordVisibility = passwordVisibilityTwo
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = {
                    // posteriormente
                },
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier
                    .width(270.dp),
                shape = CutCornerShape(bottomEnd = 15.dp, topStart = 15.dp)
            ) {
                Text(
                    text = "Cadastrar",
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.blue)
                )
            }
        }
    }
}
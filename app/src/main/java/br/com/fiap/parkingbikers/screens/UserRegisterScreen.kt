package br.com.fiap.parkingbikers.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.parkingbikers.R
import br.com.fiap.parkingbikers.component.CanvasComponent
import br.com.fiap.parkingbikers.component.ColorsScreen

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
            Spacer(modifier = Modifier.width(20.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },

                label = {
                    Text(
                        text = "E-mail",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(id = R.color.white)
                    )
                },
                placeholder = {
                    Text(
                        text = "Digite o seu e-mail!",
                        color = colorResource(id = R.color.white)
                    )
                },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_email_24),
                        contentDescription = "Ícone",
                        tint = Color.White
                    )
                },
                maxLines = 1,
                shape = CutCornerShape(bottomEnd = 15.dp, topStart = 15.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = colorResource(id = R.color.white),
                    focusedBorderColor = colorResource(id = R.color.dark_blue),
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                textStyle = TextStyle(color = Color.White)
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = nomeCompleto,
                onValueChange = { nomeCompleto = it },

                label = {
                    Text(
                        text = "Nome completo",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(id = R.color.white)
                    )
                },
                placeholder = {
                    Text(
                        text = "Digite o seu nome completo!",
                        color = colorResource(id = R.color.white)
                    )
                },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_person_24),
                        contentDescription = "Ícone",
                        tint = Color.White
                    )
                },
                maxLines = 1,
                shape = CutCornerShape(bottomEnd = 15.dp, topStart = 15.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = colorResource(id = R.color.white),
                    focusedBorderColor = colorResource(id = R.color.dark_blue),
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                textStyle = TextStyle(color = Color.White)
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = cpf,
                onValueChange = { cpf = it },

                label = {
                    Text(
                        text = "CPF",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(id = R.color.white)
                    )
                },
                placeholder = {
                    Text(
                        text = "Digite o seu CPF!",
                        color = colorResource(id = R.color.white)
                    )
                },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_numbers_24),
                        contentDescription = "Ícone",
                        tint = Color.White
                    )
                },
                maxLines = 1,
                shape = CutCornerShape(bottomEnd = 15.dp, topStart = 15.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = colorResource(id = R.color.white),
                    focusedBorderColor = colorResource(id = R.color.dark_blue),
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                textStyle = TextStyle(color = Color.White)
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = {
                    Text(
                        text = "Senha",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(id = R.color.white)
                    )
                },
                placeholder = {
                    Text(
                        text = "Digite uma senha!",
                        color = colorResource(id = R.color.white)
                    )
                },
                visualTransformation = if (passwordVisibilityOne) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
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
                maxLines = 1,
                shape = CutCornerShape(bottomEnd = 15.dp, topStart = 15.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = colorResource(id = R.color.white),
                    focusedBorderColor = colorResource(id = R.color.dark_blue),
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                textStyle = TextStyle(color = Color.White),
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = passwordRepeat,
                onValueChange = { passwordRepeat = it },
                label = {
                    Text(
                        text = "Repita Senha",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(id = R.color.white)
                    )
                },
                placeholder = {
                    Text(
                        text = "Repita a senha!",
                        color = colorResource(id = R.color.white)
                    )
                },
                visualTransformation = if (passwordVisibilityTwo) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
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
                maxLines = 1,
                shape = CutCornerShape(bottomEnd = 15.dp, topStart = 15.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = colorResource(id = R.color.white),
                    focusedBorderColor = colorResource(id = R.color.dark_blue),
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                textStyle = TextStyle(color = Color.White),
            )
            Spacer(
                modifier = Modifier.height(32.dp)
            )
            Button(
                onClick = {  },
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



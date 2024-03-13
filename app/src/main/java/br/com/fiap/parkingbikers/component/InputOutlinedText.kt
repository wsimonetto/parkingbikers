package br.com.fiap.parkingbikers.component

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import br.com.fiap.parkingbikers.R

@Composable
fun InputOutlinedText(
    value: String,
    label: String,
    placeholder: String,
    keyboardType: KeyboardType,
    maxLines: Int = 1,
    shape: Shape,
    trailingIcon: @Composable () -> Unit,
    actionValueChange: (String) -> Unit,
    textStyle: TextStyle
) {
    val colors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = colorResource(id = R.color.dark_blue),
        unfocusedBorderColor = colorResource(id = R.color.white),
   )

    OutlinedTextField(
        value = value,
        onValueChange = { actionValueChange(it) },
        label = {
            Text(
                text = label,
                color = Color.White
            )
        },
        placeholder = {
            Text(
                text = placeholder,
                color = Color.White
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        maxLines = maxLines,
        shape = shape,
        colors = colors,
        trailingIcon = { trailingIcon() },
        textStyle = textStyle
    )
}
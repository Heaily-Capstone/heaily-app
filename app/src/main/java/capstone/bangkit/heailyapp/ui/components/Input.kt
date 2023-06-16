package capstone.bangkit.heailyapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import capstone.bangkit.heailyapp.ui.theme.Black
import capstone.bangkit.heailyapp.ui.theme.Grey1
import capstone.bangkit.heailyapp.ui.theme.Grey2
import capstone.bangkit.heailyapp.ui.theme.Poppins

@Composable
fun Input(
    icon: @Composable() (() -> Unit)?,
    placeholder: String,
    label:  String,
    onValueChange: (String) -> Unit,
    value: String,
    modifier: Modifier = Modifier
){
    Column(
    ) {
        Text(
            text = label,
            style = TextStyle(
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            ),
            color = Black
        )
        Spacer(Modifier.padding(0.dp, 8.dp,  0.dp, 0.dp))
        TextField(
            value = value,
            onValueChange = onValueChange,
            leadingIcon = icon,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Grey1,
                disabledIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            placeholder = {
                Text(
                    text = placeholder,
                    style = TextStyle(
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp
                    ),
                    color = Grey2

                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 48.dp)
                .clip(MaterialTheme.shapes.large),
        )
    }
}


@Composable
@Preview(showBackground = true)
fun FormInputPreview(){
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Input(
        icon = { Icon(
            imageVector = Icons.Default.Lock,
            contentDescription = null,
            tint = Color(0xFFB1B1B1)
        )
        },
        placeholder = "Masukkan Password Anda",
        label = "Password",
        value = password.value,
        onValueChange = { password.value = it }
    )
}
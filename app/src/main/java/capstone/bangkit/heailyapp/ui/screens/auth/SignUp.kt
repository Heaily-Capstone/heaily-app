package capstone.bangkit.heailyapp.ui.screens.auth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import capstone.bangkit.heailyapp.ui.components.Input
import capstone.bangkit.heailyapp.ui.components.PrimaryButton
import capstone.bangkit.heailyapp.ui.components.SecondaryButton
import capstone.bangkit.heailyapp.ui.theme.*

@Composable
fun SignUp(){
    val configuration = LocalConfiguration.current
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(16.dp, 0.dp)
            .height(configuration.screenHeightDp.dp)
    ){

        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()



        ){
            Text(
                text = "Halo, Ayah Bunda",
                style = TextStyle(
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                )
            )
            Text(
                text = "Buat Akun Baru",
                style = TextStyle(
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            )
        }
        Spacer(Modifier.height(16.dp))
        Input(
            icon = { Icon(
                imageVector = Icons.Default.Email,
                contentDescription = null,
                tint = Grey3
            )},
            placeholder = "Masukkan Email Anda",
            label = "Email",
            value = email.value,
            onValueChange = { email.value = it}
        )
        Spacer(Modifier.height(16.dp))
        Input(
            icon = { Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = null,
                tint = Grey3
            )},
            placeholder = "Masukkan Password Anda",
            label = "Password",
            value = password.value,
            onValueChange = { password.value = it }
        )
        Spacer(Modifier.height(24.dp))
        PrimaryButton(
            text = "Masuk",
            onClick = {},
        )
        Spacer(Modifier.height(16.dp))
        SecondaryButton(
            text = "Lanjutkan dengan google",
            onClick = {},
        )

        Spacer(Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ){
            Text(
                text= "Sudah memiliki Akun?",
                style = TextStyle(
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = Black
                ),
            )
            Spacer(modifier = Modifier.width(4.dp))
            ClickableText(
                text = AnnotatedString("Masuk"),
                style = TextStyle(
                    fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = Pink1
                ),
                onClick = {})
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SignUpPreview(){
    HeailyAppTheme() {
        SignUp()
    }
}
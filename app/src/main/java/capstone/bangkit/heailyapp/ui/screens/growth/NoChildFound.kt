package capstone.bangkit.heailyapp.ui.screens.growth


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import capstone.bangkit.heailyapp.R
import capstone.bangkit.heailyapp.ui.components.PrimaryButton


@Composable
fun NoChildFound() {
    val configuration = LocalConfiguration.current

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(20.dp, 20.dp)
            .height(configuration.screenHeightDp.dp)
    ) {
        Image(
            painter = painterResource(
                R.drawable.undraw_dreamer_re
            ),
            contentDescription = null,
            modifier = Modifier
                .width(250.dp)
                .height(185.dp)
        )
        Spacer(Modifier.height(40.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(20.dp, 0.dp)

        ) {
            Text(
                text = "Anda belum memiliki Data Anak",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color= Color(0xFF1D1617),
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = "Harap masukkan Data Anak untuk dapat melihat statistik tumbuh & membuat meal plan",
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                color= Color(0xFF7B6F72)
            )
            Spacer(Modifier.height(20.dp))
            PrimaryButton(text = "Tambah Data Anak") {

            }
        }

    }
}

@Composable
@Preview(showBackground = true)
fun NoChildContentPreview(){
    NoChildFound()
}
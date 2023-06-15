package capstone.bangkit.heailyapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import capstone.bangkit.heailyapp.ui.theme.HeailyAppTheme
import capstone.bangkit.heailyapp.ui.theme.Poppins

@Composable
fun MealBanner(
    title: String,
    value: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier

){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(162.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0XFF92A3FD))
            .padding(16.dp)
    ){
        Column(
            modifier = Modifier
                .align(Alignment.TopEnd)
        ){
            Text(
                text = title,
                style = TextStyle(
                    fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                ),
                color = Color.White
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = value,
                style = TextStyle(
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                ),
                color = Color.White
            )
            Spacer(Modifier.height(16.dp))
        }
        BannerButton(
            text = "Buat Meal Plan",
            onClick = onClick,
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun MealBannerPreview(){
    HeailyAppTheme() {
        MealBanner(title = "Bingung menentukan menu makan untuk anak Anda?", value = "Kami bantu pilihkan menu makanan terbaik", onClick = {})
    }
}
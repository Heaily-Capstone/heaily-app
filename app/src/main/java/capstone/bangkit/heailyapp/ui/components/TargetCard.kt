package capstone.bangkit.heailyapp.ui.components

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
import coil.compose.AsyncImage
import capstone.bangkit.heailyapp.R
import capstone.bangkit.heailyapp.ui.theme.HeailyAppTheme
import capstone.bangkit.heailyapp.ui.theme.Poppins

@Composable
fun TargetCard(
    imageUrl: String,
    title: String,
    value: String,
    modifier: Modifier = Modifier
){
    Row (
        modifier = modifier
            .padding(8.dp, 12.dp)
            .clip(RoundedCornerShape(16.dp))
            .height(70.dp)
            .background(Color(0xFFFFFFFF))
            .padding(8.dp, 12.dp),

        verticalAlignment = Alignment.CenterVertically,

        ){
        AsyncImage(
            model = imageUrl,
            contentDescription = title,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.baseline_fastfood_24),
            modifier = Modifier.size(32.dp)
        )
        Spacer(Modifier.width(8.dp))
        Column(){
            Text(
                text = title,
                style = TextStyle(
                    fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                ),
                color = Color(0xFF9DCEFF),
            )
            Text(
                text = value,
                style = TextStyle(
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                ),
                color = Color(0xFF7B6F72)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun TargetItemPreview(){
    HeailyAppTheme() {
        TargetCard(
            "https://cdn.discordapp.com/attachments/1039937760649298001/1113355093392248893/Calories-Icon.png","Kalori", "1100 kalori"
        )
    }
}
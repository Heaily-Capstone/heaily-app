package capstone.bangkit.heailyapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import capstone.bangkit.heailyapp.ui.theme.HeailyAppTheme
import capstone.bangkit.heailyapp.ui.theme.Pink1

@Composable
fun BannerButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
){
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(16.dp)),

        colors = ButtonDefaults.buttonColors(
            backgroundColor = Pink1,
            contentColor = Color.White
        ),

        ){
        Text(
            text = text,
            style = MaterialTheme.typography.h6,
            modifier = modifier
                .align(Alignment.CenterVertically)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun BannerButtonPreview() {
    HeailyAppTheme() {
        BannerButton(
            text = "Buat Meal Plan",
            onClick = {}
        )
    }
}
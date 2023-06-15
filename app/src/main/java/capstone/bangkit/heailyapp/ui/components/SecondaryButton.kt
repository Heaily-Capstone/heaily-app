package capstone.bangkit.heailyapp.ui.components

import androidx.compose.foundation.border
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import capstone.bangkit.heailyapp.ui.theme.HeailyAppTheme
import capstone.bangkit.heailyapp.ui.theme.Poppins
import capstone.bangkit.heailyapp.ui.theme.Purple1

@Composable
fun SecondaryButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
){
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(width = 1.dp, color = Purple1, shape = RoundedCornerShape(12.dp)),
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            ),
            modifier = modifier
                .align(Alignment.CenterVertically),
            color = Purple1
        )
    }
}

@Composable
@Preview(showBackground = true)
fun SecondaryButtonPreview() {
    HeailyAppTheme() {
        SecondaryButton(
            text = "Masuk",
            onClick = {}
        )
    }
}
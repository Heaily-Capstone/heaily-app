package capstone.bangkit.heailyapp.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import capstone.bangkit.heailyapp.ui.theme.Black
import capstone.bangkit.heailyapp.ui.theme.Poppins
import capstone.bangkit.heailyapp.ui.theme.Purple1

@Composable
fun SectionText(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        style = TextStyle(
            fontFamily = Poppins,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        ),
        color  = Black,
    )
}

@Composable
fun SectionTextForm(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        style = MaterialTheme.typography.h3,
        color  = Purple1,
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
    )
}
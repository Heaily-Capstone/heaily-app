package capstone.bangkit.heailyapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import capstone.bangkit.heailyapp.data.model.Meal
import coil.compose.AsyncImage

@Composable
fun MealCard(
    meal: Meal,
    modifier: Modifier = Modifier,
){
    Card (
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .shadow(4.dp, ambientColor = Color(29, 22, 23, 7), shape = RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),
        backgroundColor = Color.White

    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(0.dp,0.dp, 16.dp, 0.dp)

        ){
            Row (
                verticalAlignment = Alignment.CenterVertically,
                    ){
                AsyncImage(
                    model = meal.image ,
                    contentDescription = null,
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .width(80.dp)
                        .height(80.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column(
                    modifier = Modifier.padding(8.dp)) {
                    Text(
                        text = meal.name,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.h6
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = meal.calorie.toString() + " Kalori | " + meal.cookTime ,
                        style = MaterialTheme.typography.body2,
                    )
                }
            }
            Spacer(modifier = Modifier.width(4.dp))
            IconButton(
                onClick = { },
                modifier = Modifier
                    .background(color = Color(0xFFF9F3FE), shape = RoundedCornerShape(8.dp))
                    .width(26.dp)
                    .height(26.dp)

            ) {
                Icon(Icons.Rounded.KeyboardArrowRight, contentDescription = "Localized description", tint = Color(0XffC58BF2))
            }
        }
    }
}

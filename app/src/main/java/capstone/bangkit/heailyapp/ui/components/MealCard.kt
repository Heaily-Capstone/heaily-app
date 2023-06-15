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
import capstone.bangkit.heailyapp.data.model.IngredientsItem
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
                    contentScale = ContentScale.Fit,
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

@Composable
@Preview(showBackground = true)
fun MealCardPreview(){
    MaterialTheme{
        MealCard(    Meal(
            id = 10,
            generatedPlanId = null,
            name = "Porridge",
            description = "Pancakes are some people's favorite breakfast, who doesn't like pancakes? Especially with the real honey splash on top of the pancakes, of course everyone loves that! ",
            category = "Bayi",
            image = "https://media.discordapp.net/attachments/1039937760649298001/1118499471295254588/blue_package.jpg?width=1168&height=1168",
            cookTime = "30 menit",
            calorie = 200,
            ingredients = listOf(
                IngredientsItem(
                    name = "Rice",
                    qty = "200g"
                ),
                IngredientsItem(
                    name = "Salt",
                    qty = "1 tsp"
                ),
                IngredientsItem(
                    name = "Chicken Powder",
                    qty = "1 tsp"
                ),
                IngredientsItem(
                    name = "Butter",
                    qty = "10 gr"
                ),
            ),
            nutritions = listOf("180kCal", "50g Fat", "20g protein", "50g carbon"),
            steps= listOf(
                "Prepare all of the ingredients that needed",
                "Mix flour, sugar, salt, and baking powder",
                "In a seperate place, mix the eggs and liquid milk until blended",
                "Put the egg and milk mixture into the dry ingredients, Stir untul smooth and smooth",
                "Prepare all of the ingredients that needed"
            )
        )
        )
    }
}
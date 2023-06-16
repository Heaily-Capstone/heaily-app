package capstone.bangkit.heailyapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import capstone.bangkit.heailyapp.data.model.Meal
import capstone.bangkit.heailyapp.data.model.mealPlansItemDummy

@Composable
fun MealSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column() {
        SectionText(title, modifier = modifier)
        content()
    }
}

@Composable
fun MealColumn(
    listMeal: List<Meal>,
    modifier: Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .padding(0.dp, 12.dp, 0.dp, 16.dp)
            .wrapContentHeight()
    ){
        for (meal in listMeal){
            key(meal.mealId) {
                MealCard(meal)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MealSectionPreview(){
    MaterialTheme{
        MealSection(
            title = "Makan Malam",
            content = { MealColumn(listMeal = mealPlansItemDummy, modifier = Modifier) },
            modifier = Modifier)
    }
}
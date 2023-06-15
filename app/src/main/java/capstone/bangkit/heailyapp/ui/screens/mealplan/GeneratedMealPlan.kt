package capstone.bangkit.heailyapp.ui.screens.mealplan

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import capstone.bangkit.heailyapp.model.dummyMeal
import capstone.bangkit.heailyapp.data.model.mealPlansItemDummy
import capstone.bangkit.heailyapp.ui.components.MealColumn
import capstone.bangkit.heailyapp.ui.components.MealSection
import capstone.bangkit.heailyapp.ui.components.SearchBar
import capstone.bangkit.heailyapp.utils.randomMeal

@Composable
fun GeneratedMealPlan(){
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
        .verticalScroll(rememberScrollState())
        .padding(16.dp, 0.dp)
    )

    {
        SearchBar(placeholder = "Cari Menu")

        MealSection(
            title = "Makan Pagi",
            content = { MealColumn(listMeal = randomMeal(result = 2, listMealPlan = mealPlansItemDummy), modifier = Modifier) },
            modifier = Modifier
        )
        MealSection(
            title = "Makan Siang",
            content = { MealColumn(listMeal = randomMeal(result = 2, listMealPlan = mealPlansItemDummy), modifier = Modifier) },
            modifier = Modifier
        )
        MealSection(
            title = "Makan Malam",
            content = { MealColumn(listMeal = randomMeal(result = 2, listMealPlan = mealPlansItemDummy), modifier = Modifier) },
            modifier = Modifier
        )
        MealSection(
            title = "Snack",
            content = { MealColumn(listMeal = randomMeal(result = 2, listMealPlan = mealPlansItemDummy), modifier = Modifier) },
            modifier = Modifier
        )
    }
}

@Composable
@Preview(showBackground = true)
fun GeneratedMealPlanPreview(){
    MaterialTheme{
        GeneratedMealPlan()
    }
}
package capstone.bangkit.heailyapp.ui.screens.mealplan

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import capstone.bangkit.heailyapp.data.model.mealPlansItemDummy
import capstone.bangkit.heailyapp.ui.components.MealBanner
import capstone.bangkit.heailyapp.ui.components.MealColumn
import capstone.bangkit.heailyapp.ui.components.MealSection
import capstone.bangkit.heailyapp.ui.components.SearchBar
import capstone.bangkit.heailyapp.utils.randomMeal

@Composable
fun LandingMealPlan(
    navigateBack: () -> Unit,
){
 LandingMealContent(navigateBack)
}

@Composable
fun LandingMealContent(
    navigateBack: () -> Unit,
){
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp, 16.dp)
    ){
        Text(
            text = "Meal Plan Hari ini",
            style = MaterialTheme.typography.h2
        )
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
        MealSection(
            title = "Menu Populer",
            content = { MealColumn(listMeal = mealPlansItemDummy, modifier = Modifier) },
            modifier = Modifier
        )

        MealBanner(
            title = "Bingung menentukan menu makan untuk anak Anda?",
            value = "Kami bantu pilihkan menu makanan terbaik",
            onClick = {})
    }
}
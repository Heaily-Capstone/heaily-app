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
import capstone.bangkit.heailyapp.ui.components.MealBanner
import capstone.bangkit.heailyapp.ui.components.MealColumn
import capstone.bangkit.heailyapp.ui.components.MealSection
import capstone.bangkit.heailyapp.ui.components.SearchBar

@Composable
fun LandingMealPlan(){
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp, 0.dp)
    ){
        MealBanner(
            title = "Bingung menentukan menu makan untuk anak Anda?",
            value = "Kami bantu pilihkan menu makanan terbaik",
            onClick = {})
        SearchBar(placeholder = "Cari Menu")
        MealSection(
            title = "Menu Populer",
            content = { MealColumn(listMeal = dummyMeal, modifier = Modifier) },
            modifier = Modifier
        )
    }
}

@Composable
@Preview(showBackground = true)
fun LandingMealPlanPreview(){
    MaterialTheme{
        LandingMealPlan()
    }
}
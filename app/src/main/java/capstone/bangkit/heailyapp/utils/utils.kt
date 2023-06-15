package capstone.bangkit.heailyapp.utils

import capstone.bangkit.heailyapp.data.model.Meal

fun randomMeal(result: Int, listMealPlan: List<Meal>) : List<Meal>{
    val randomElements = listMealPlan.asSequence().shuffled().take(result).toList()
    return randomElements
}
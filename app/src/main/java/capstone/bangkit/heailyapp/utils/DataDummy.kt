package capstone.bangkit.heailyapp.utils

import capstone.bangkit.heailyapp.data.model.IngredientsItem
import capstone.bangkit.heailyapp.data.model.Meal
import capstone.bangkit.heailyapp.data.model.MealsWithIngredient
import capstone.bangkit.heailyapp.data.model.mealPlansItemDummy

object DataDummy{
    fun generateMealsEntity(): List<Meal> {
        val mealList = ArrayList<Meal>()

        for (meal in mealPlansItemDummy){
            mealList.add(meal)
        }

        return mealList
    }

    fun generateIngredientsEntity(): List<IngredientsItem>{
        val ingredientList = ArrayList<IngredientsItem>()

        for (ingredient in ingredientList){
            ingredientList.add(ingredient)
        }
        return ingredientList
    }

    fun mealWithIngredientsEntity(): List<MealsWithIngredient>{
        val mealWithIngredients = ArrayList<MealsWithIngredient>()

        for (mealWithingredient in mealWithIngredients){
            mealWithIngredients.add(mealWithingredient)
        }
        return mealWithIngredients
    }
}

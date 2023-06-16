package capstone.bangkit.heailyapp.data.local

//import androidx.room.*
//import capstone.bangkit.heailyapp.data.model.GeneratedMealPlan
//import capstone.bangkit.heailyapp.data.model.Meal
//import capstone.bangkit.heailyapp.data.model.MealPlansItem
//import capstone.bangkit.heailyapp.data.model.UserModel
//import java.util.*
//
//@Dao
//interface MealDao {
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun insertMeal(listMeal: List<Meal>)
//
//    @Transaction
//    @Query("SELECT * FROM GeneratedMealPlan where childrenOwnerId  = :childrenId & date = :date ")
//    suspend fun getGeneratedMealPlanByDate(childrenId: Int, date: Date) : List<GeneratedMealPlan>
//
//    @Transaction
//    @Query("SELECT * FROM Meal WHERE name LIKE '%' || :value || '%'")
//    suspend fun getMealByName(value: String) : List<MealPlansItem>
//
//    @Transaction
//    @Query("SELECT * FROM Meal ORDER BY mealId LIMIT 20")
//    suspend fun getTwentyFirstMeal() : List<MealPlansItem>
//}
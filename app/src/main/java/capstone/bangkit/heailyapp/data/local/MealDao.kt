package capstone.bangkit.heailyapp.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import java.util.*

@Dao
interface MealDao {
    @Transaction
    @Query("SELECT * FROM GeneratedMealPlan where childrenOwnerId  = :childrenId & date = :date ")
    suspend fun getChildrenWithGeneratedMealPlanByDate(childrenId: Int, date: Date)

    @Transaction
    @Query("SELECT * FROM Meal WHERE name LIKE '%' || :value || '%'")
    suspend fun getMealByName(value: String)
}
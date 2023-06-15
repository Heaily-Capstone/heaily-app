package capstone.bangkit.heailyapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import capstone.bangkit.heailyapp.data.model.*

@Database(
    entities = [GeneratedMealPlan::class, MealPlansItem::class, IngredientsItem::class, Meal::class, MealsWithIngredient::class, UserModel::class, ChildrenItem::class, GrowthDataItem::class, UserWithChildren::class, ChildrenWithGrowth::class, ChildrenWithGeneratedMealPlan::class],
    version = 1,
    exportSchema = false
)
abstract class HeailyDatabase : RoomDatabase() {
    abstract fun mealDao(): MealDao
    abstract fun userDao(): UserDao


    companion object {
        @Volatile
        private var instance: HeailyDatabase? = null
        fun getInstance(context: Context): HeailyDatabase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    HeailyDatabase::class.java, "Heaily.db"
                ).fallbackToDestructiveMigration().build()
            }
    }
}
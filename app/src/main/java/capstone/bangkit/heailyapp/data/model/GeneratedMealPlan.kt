package capstone.bangkit.heailyapp.data.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import androidx.room.*

@Parcelize
//@Entity
data class GeneratedMealPlan(
//	@PrimaryKey (autoGenerate = true)
	val generatedMealPlanId: Int? = null,

	val childrenOwnerId: Int?,
	val date: String
) : Parcelable


//@Entity
@Parcelize
data class MealPlansItem(
//	@PrimaryKey (autoGenerate = true)
	val mealPlanId: Int? = null,

	val generatedMealOwnerId: Int?,
	val type: String?,
) : Parcelable


@Parcelize
//@Entity
data class Meal(
	@PrimaryKey val mealId: Int,

	val mealPlanId: Int?,
	val cookTime: String,
	val image: String,
	val name: String,
	val description: String,
	val calorie: Int,
) : Parcelable

//data class GeneratedMealWithMealPlan(
//	@Embedded val generatedMeal: GeneratedMealPlan,
//
//	@Relation(
//		parentColumn = "generatedMealPlanId",
//		entityColumn = "generatedMealOwnerId"
//	)
//	val mealPlans: List<MealPlansItem>
//)
//
//data class MealPlansWithMeal(
//	@Embedded val mealPlan: MealPlansItem,
//	@Relation(
//		parentColumn = "mealPlanId",
//		entityColumn = "mealPlanId"
//	)
//	val meals: List<Meal>
//)
//
//data class ChildrenWithGeneratedMealPlan(
//	@Embedded val children : ChildrenItem,
//	@Relation(
//		parentColumn = "childrenId",
//		entityColumn = "childrenOwnerId"
//	)
//	val generatedMealData: List<GeneratedMealPlan>
//)
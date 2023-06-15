package capstone.bangkit.heailyapp.data.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import androidx.room.*
import java.util.Date

@Parcelize
@Entity
data class GeneratedMealPlan(
	@PrimaryKey val generatedMealPlanId: Int,

	val childrenOwnerId: Int,
	val date: Date,
	val mealPlans: List<MealPlansItem>
) : Parcelable

@Parcelize
@Entity
data class MealPlansItem(
	@PrimaryKey val mealPlanId: Int,

	val generatedMealOwnerId: Int,
	val meal: Meal,
	val type: String
) : Parcelable

@Parcelize
@Entity
data class IngredientsItem(
	@PrimaryKey val ingredientsId: Int,

	val qty: String,
	val name: String
) : Parcelable

@Parcelize
@Entity
data class Meal(
	@PrimaryKey val mealId: Int,

	val cookTime: String,
	val image: String,
	val category : String,
	val name: String,
	val description: String,
	val generatedPlanId: Int?,
	val calorie: Int,
	val steps: List<String>,
	val nutritions: List<String>

) : Parcelable

@Parcelize
@Entity (primaryKeys = ["mealPlanId", "mealId"])
data class MealPlanMealCrossRef(
	val mealPlanId: Int,
	val mealId: Int,
) :Parcelable

data class MealPlanWithMeal(
	@Embedded val mealPlan: MealPlansItem,
	@Relation(
		parentColumn = "mealPlanId",
		entityColumn = "mealId",
		associateBy = Junction(MealPlanMealCrossRef::class)
	)
	val meals: List<Meal>
)

data class MealWithMealPlan(
	@Embedded val meal: Meal,
	@Relation(
		parentColumn = "mealId",
		entityColumn = "mealPlanId",
		associateBy = Junction(MealPlanMealCrossRef::class)
	)
	val mealPlan: List<MealPlansItem>
)

data class GeneratedMealWithMealPlan(
	@Embedded val generatedMeal: GeneratedMealPlan,
	@Relation(
		parentColumn = "generatedMealPlanId",
		entityColumn = "generatedMealOwnerId"
	)
	val meals: List<MealPlansItem>
)

data class MealsWithIngredient(
	@Embedded val meal: Meal,
	@Relation(
		parentColumn = "userId",
		entityColumn = "userCreatorId"
	)
	val ingredients: List<IngredientsItem>
)
package capstone.bangkit.heailyapp.data.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Parcelize
@Entity
data class UserModel(
	@PrimaryKey val userid: Int,

	val password: String,
	val children: List<ChildrenItem?>? = null,
	val email: String
) : Parcelable

@Parcelize
@Entity
data class ChildrenItem(
	@PrimaryKey val childrenId: Int,

	val userParentId: Int,
	val name: String,
	val gender: String,
	val dob: String,
	val allergies: List<String?>? = null,
	val generatedMealPlans: List<GeneratedMealPlan?>? = null,
	val growthData: List<GrowthDataItem?>? = null,
) : Parcelable

@Parcelize
@Entity
data class GrowthDataItem(
	@PrimaryKey val growthId: Int,

	val childOwnerId: Int,
	val headCircumference: Int? = null,
	val measurementDate: String,
	val weight: Int,
	val height: Int,
	val status: String
) : Parcelable


data class UserWithChildren(
	@Embedded val meal: Meal,
	@Relation(
		parentColumn = "userId",
		entityColumn = "userParentId"
	)
	val ingredients: List<ChildrenItem>
)

data class ChildrenWithGrowth(
	@Embedded val children: ChildrenItem,
	@Relation(
		parentColumn = "childrenId",
		entityColumn = "childOwnerId"
	)
	val growthData: List<GrowthDataItem>
)

data class ChildrenWithGeneratedMealPlan(
	@Embedded val children : ChildrenItem,
	@Relation(
		parentColumn = "childrenId",
		entityColumn = "childrenOwnerId"
	)
	val generatedMealData: List<GeneratedMealPlan>
)
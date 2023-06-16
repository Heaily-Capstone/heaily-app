package capstone.bangkit.heailyapp.data.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import androidx.room.*

@Parcelize
@Entity
data class UserModel(
	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(index = true)
	val userId: Int? = null,

	@ColumnInfo(index = true)
	val email: String,

	@ColumnInfo(index = true)
	val password: String,
) : Parcelable

@Parcelize
@Entity
data class ChildrenItem(
	@PrimaryKey(autoGenerate = true)
	val childrenId: Int? = null,

	val userParentId: Int,
	val name: String,
	val gender: String,
	val dob: String,
) : Parcelable

@Parcelize
@Entity
data class GrowthDataItem(
	@PrimaryKey(autoGenerate = true)
	val growthId: Int? = null,

	val childOwnerId: Int,
	val measurementDate: String,
	val age: Int,
	val weight: Int,
	val height: Int,
	val status: String
) : Parcelable

data class UserWithChildren(
	@Embedded val user: UserModel,

	@Relation(
		parentColumn = "userId",
		entityColumn = "userParentId"
	)
	val childrens: List<ChildrenItem>
)

data class ChildrenWithGrowth(
	@Embedded val children: ChildrenItem,

	@Relation(
		parentColumn = "childrenId",
		entityColumn = "childOwnerId"
	)
	val growthData: List<GrowthDataItem>
)
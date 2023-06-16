package capstone.bangkit.heailyapp.data.local

import androidx.room.*
import capstone.bangkit.heailyapp.data.model.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: UserModel)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertChildren(children: ChildrenItem)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertGrowthData(growthData: GrowthDataItem)

    @Transaction
    @Query("SELECT * FROM UserModel where userId = :userid")
    suspend fun getUser(userid: Int): UserModel

    @Transaction
    @Query("SELECT * FROM UserModel where email = :email")
    suspend fun getUserByEmail(email: String): UserModel

    @Transaction
    @Query("SELECT * FROM ChildrenItem where childrenId  = :childrenId")
    suspend fun getChildren(childrenId: Int) : ChildrenItem

    @Transaction
    @Query("SELECT * FROM GrowthDataItem where childOwnerId = :childrenId")
    suspend fun getGrowthDataByChildren(childrenId: Int) : List<GrowthDataItem>

}



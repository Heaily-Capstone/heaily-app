package capstone.bangkit.heailyapp.data.local

import androidx.room.*
import capstone.bangkit.heailyapp.data.model.*
import java.util.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: UserModel)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertChildren(children: ChildrenItem)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertGrowthData(growthData: GrowthDataItem)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend  fun insertUserWithChildren(userWithChildren: UserWithChildren)

    @Transaction
    @Query("SELECT * FROM UserModel where userid = :userid")
    suspend fun getUser(userid: Int): UserModel

    @Transaction
    @Query("SELECT * FROM UserModel where userid = :userid")
    suspend fun getUsersWithChildren(userid : Int): List<UserWithChildren>

    @Transaction
    @Query("SELECT * FROM ChildrenItem where childrenId = :childrenId  ")
    suspend fun getChildrenWithGrowth(childrenId:Int): List<ChildrenWithGrowth>

    @Transaction
    @Query("SELECT * FROM ChildrenItem where childrenId  = :childrenId")
    suspend fun getChildren(childrenId: Int) : ChildrenItem
}
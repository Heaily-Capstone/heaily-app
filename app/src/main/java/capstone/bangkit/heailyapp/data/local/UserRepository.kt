package capstone.bangkit.heailyapp.data.local

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import capstone.bangkit.heailyapp.data.model.GrowthDataItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import capstone.bangkit.heailyapp.data.Result
import capstone.bangkit.heailyapp.data.SettingPreferences
import capstone.bangkit.heailyapp.data.model.ChildrenItem
import capstone.bangkit.heailyapp.data.model.Profile
import capstone.bangkit.heailyapp.data.model.UserModel
import capstone.bangkit.heailyapp.utils.DataDummy
import getChildHealthStatus
import kotlinx.coroutines.flow.collect
import java.time.LocalDate
import java.time.Year
import java.util.*

class UserRepository private constructor(
    private val mUserDao: UserDao,
    private val pref: SettingPreferences
){

    suspend fun insertAllData() {
        mUserDao.insertUser(DataDummy.getUser())
        mUserDao.insertChildren(DataDummy.getChildren())
        for (i in DataDummy.getGrowthData()){
            mUserDao.insertGrowthData(i)
        }
    }


//    suspend fun insertGrowthData(childrenItem: ChildrenItem, weight: Int, height: Int, measurementDate: String) :  Flow<Result<GrowthDataItem>> = flow {
//        emit(Result.Loading)
//        val getYear = childrenItem.dob.substring(childrenItem.dob.length-4)
//        val calculateAge = Calendar.getInstance().get(Calendar.YEAR) - getYear.toInt()
//        try {
//            val status = getChildHealthStatus(
//                gender = childrenItem.gender,
//                weight = weight,
//                height = height,
//                age = calculateAge
//            )
//
//            val newData = childrenItem.childrenId?.let {
//                GrowthDataItem(
//                    childOwnerId = it,
//                    measurementDate = measurementDate,
//                    age = calculateAge,
//                    weight = weight,
//                    height = height,
//                    status = status
//                )
//            }
//
//
//            if (newData != null) {
//                mUserDao.insertGrowthData(newData)
//            }
//
//            emit(Result.Success(newData!!))
//        } catch (e: Exception){
//            Log.e("Error User Repository", e.toString())
//            emit(Result.Error("Data cannot be inserted"))
//        }
//
//    }

    suspend fun getChild(childId: Int) : Flow<Result<ChildrenItem>> = flow {
        emit(Result.Loading)
        try{
            val result : ChildrenItem = mUserDao.getChildren(childId)
            emit(Result.Success(result))
        } catch (e: Exception){
            Log.e("Error User Repository", e.toString())
            emit(Result.Error("Data cannot be retrieved"))
        }
    }

    suspend fun getGrowthData(childId: Int) : Flow<Result<List<GrowthDataItem>>> = flow {
        emit(Result.Loading)
        try{
            val result : List<GrowthDataItem> = mUserDao.getGrowthDataByChildren(childrenId = childId);
            emit(Result.Success(result))
        } catch (e: Exception){
            emit(Result.Error("Data cannot be retrieved"))
        }
    }

    suspend fun getProfile() : Flow<Profile> {
        return pref.getProfileSetting()
    }



//    suspend fun signUp(email: String, password: String) : Flow<Result<UserModel>> = flow{
//        emit(Result.Loading)
//        try {
//            val user :UserModel = mUserDao.getUserByEmail(email)
//            if (user == null){
//                mUserDao.insertUser(UserModel(userId=null, email = email, password = password))
//                emit(Result.Success(user))
//            } else {
//                emit(Result.Error("Email already exists"))
//            }
//
//        } catch (e: Exception) {
//            emit(Result.Error("Data login cannot be retrieved"))
//        }
//    }
//
//    suspend fun login(email: String, password: String) : Flow<Result<UserModel>> = flow{
//        emit(Result.Loading)
//        try {
//            val user :UserModel = mUserDao.getUserByEmail(email)
//            val passwordCheck : Boolean = user.password === password
//
//            if (passwordCheck){
//                emit(Result.Success(user))
//            } else {
//                emit(Result.Error("Password User Salah"))
//            }
//
//        } catch (e: Exception) {
//            emit(Result.Error("Data login cannot be retrieved"))
//        }
//    }

    suspend fun logout() {
        pref.clearProfileSetting()
    }

    companion object {
        @Volatile
        private var instance: UserRepository? = null
        fun getInstance(
            mUserDao: UserDao,
            pref: SettingPreferences
        ): UserRepository =
            instance ?: synchronized(this) {
                instance ?: UserRepository(mUserDao, pref)
            }.also { instance = it }
    }
}
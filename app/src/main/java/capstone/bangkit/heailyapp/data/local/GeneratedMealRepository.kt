package capstone.bangkit.heailyapp.data.local

import capstone.bangkit.heailyapp.data.model.GeneratedMealPlan
import capstone.bangkit.heailyapp.data.Result
import capstone.bangkit.heailyapp.data.model.MealPlansItem
import capstone.bangkit.heailyapp.utils.DataDummy
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*
//
//class GeneratedMealRepository private constructor(
//    private val mMealDao: MealDao
//){
//
//    suspend fun insertAllMealData(){
//        mMealDao.insertMeal(listMeal = DataDummy.generateMealsEntity())
//    }
//
//    suspend fun getGeneratedMealPlanByDate(childrenId: Int, date: Date): Flow<Result<List<GeneratedMealPlan>>> = flow {
//        emit(Result.Loading)
//        try {
//            val result : List<GeneratedMealPlan> = mMealDao.getGeneratedMealPlanByDate(childrenId = childrenId, date =  date);
//            emit(Result.Success(result))
//        }catch(e: Exception){
//            emit(Result.Error("Data cannot be retrieved"))
//        }
//    }
//
//    suspend fun getMealByName(value: String) :  Flow<Result<List<MealPlansItem>>> = flow {
//        emit(Result.Loading)
//        try {
//            val result : List<MealPlansItem> = mMealDao.getMealByName(value);
//            emit(Result.Success(result))
//        }catch(e: Exception){
//            emit(Result.Error("Data cannot be retrieved"))
//        }
//    }
//
//    suspend fun getTwentyFirstMeal() : Flow<Result<List<MealPlansItem>>> = flow {
//        emit(Result.Loading)
//
//        try {
//            val result : List<MealPlansItem> = mMealDao.getTwentyFirstMeal();
//            emit(Result.Success(result))
//        }catch(e: Exception){
//            emit(Result.Error("Data cannot be retrieved"))
//        }
//
//    }
//    companion object {
//        @Volatile
//        private var instance: GeneratedMealRepository? = null
//        fun getInstance(
//            mMealDao: MealDao
//        ): GeneratedMealRepository =
//            instance ?: synchronized(this) {
//                instance ?: GeneratedMealRepository(mMealDao)
//            }.also { instance = it }
//    }
//
//}
package capstone.bangkit.heailyapp.utils

import capstone.bangkit.heailyapp.data.model.*
import getChildHealthStatus

object DataDummy{
//    fun generateMealsEntity(): List<Meal> {
//        val mealList = ArrayList<Meal>()
//
//        for (meal in mealPlansItemDummy){
//            mealList.add(meal)
//        }
//
//        return mealList
//    }

    fun getUser(): UserModel = UserModel(userId = 1 ,email = "emailUser@gmail.com", password =  "password")
    fun getChildren(): ChildrenItem = ChildrenItem(childrenId = 1, userParentId = 1, name="Lala", gender="female", dob="22-02-2020")

    fun getGrowthData(): List<GrowthDataItem> = listOf(
        GrowthDataItem(
            growthId = 1,
            childOwnerId = 1,
            measurementDate = "22-02-2021",
            age= 3,
            weight= 8,
            height = 75,
            status=getChildHealthStatus(gender = "female", age = 3, height = 75, weight = 8 )
        ),
        GrowthDataItem(
            growthId = 2,
            childOwnerId = 1,
            measurementDate = "22-03-2021",
            age= 3,
            weight= 9,
            height = 75,
            status=getChildHealthStatus(gender = "female", age = 3, height = 75, weight = 9 )
        ),
        GrowthDataItem(
            growthId = 3,
            childOwnerId = 1,
            measurementDate = "22-04-2021",
            age= 3,
            weight= 10,
            height = 77,
            status=getChildHealthStatus(gender = "female", age = 3, height = 77, weight = 10 )
        ),
        GrowthDataItem(
            growthId = 4,
            childOwnerId = 1,
            measurementDate = "22-05-2021",
            age= 3,
            weight= 9,
            height = 79,
            status=getChildHealthStatus(gender = "female", age = 3, height = 79, weight = 9 )
        ),
        GrowthDataItem(
            growthId = 5,
            childOwnerId = 1,
            measurementDate = "22-06-2021",
            age= 3,
            weight= 10,
            height = 80,
            status=getChildHealthStatus(gender = "female", age = 3, height = 80, weight = 10 )
        ),
        GrowthDataItem(
            growthId = 6,
            childOwnerId = 1,
            measurementDate = "22-07-2021",
            age= 3,
            weight= 10,
            height = 80,
            status=getChildHealthStatus(gender = "female", age = 3, height = 81, weight = 10 )
        ),
        GrowthDataItem(
            growthId = 7,
            childOwnerId = 1,
            measurementDate = "22-08-2021",
            age= 3,
            weight= 10,
            height = 81,
            status=getChildHealthStatus(gender = "female", age = 3, height = 81, weight = 10 )
        ),

    )

}

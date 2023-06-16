package capstone.bangkit.heailyapp.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import capstone.bangkit.heailyapp.data.SettingPreferences
//import capstone.bangkit.heailyapp.data.local.GeneratedMealRepository
import capstone.bangkit.heailyapp.data.local.HeailyDatabase
import capstone.bangkit.heailyapp.data.local.UserRepository

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

object Injection {
    fun provideUserRepository(context: Context): UserRepository {
        val database = HeailyDatabase.getInstance(context)
        val mUserDao = database.userDao()
        val pref = SettingPreferences.getInstance(context.dataStore)
        return UserRepository.getInstance(mUserDao, pref)
    }

//    fun provideGeneratedMealRepository(context: Context): GeneratedMealRepository {
//        val database = HeailyDatabase.getInstance(context)
//        val mMealDao = database.mealDao()
//        return GeneratedMealRepository.getInstance(mMealDao)
//    }
}
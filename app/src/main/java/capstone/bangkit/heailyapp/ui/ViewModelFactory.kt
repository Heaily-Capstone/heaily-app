package capstone.bangkit.heailyapp.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
//import capstone.bangkit.heailyapp.data.local.GeneratedMealRepository
import capstone.bangkit.heailyapp.data.local.UserRepository
import capstone.bangkit.heailyapp.di.Injection
import capstone.bangkit.heailyapp.ui.screens.home.UserViewModel

class ViewModelFactory private constructor(
    private val userRepository: UserRepository,
//    private val generatedMealRepository: GeneratedMealRepository,
) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(userRepository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null
        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(
                    Injection.provideUserRepository(context),
//                    Injection.provideGeneratedMealRepository(context),
                )
            }.also { instance = it }
    }
}
package capstone.bangkit.heailyapp.ui.screens.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
//import capstone.bangkit.heailyapp.data.local.GeneratedMealRepository
import capstone.bangkit.heailyapp.data.local.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(
    private val userRepository: UserRepository,
//    private val generatedMealRepository: GeneratedMealRepository
): ViewModel() {



    fun logout() {
        viewModelScope.launch {
            userRepository.logout()
        }
    }

//    suspend fun login(email: String, password: String) = userRepository.login(email, password)

//    fun signUp(email: String, password: String){
//        viewModelScope.launch{
//            userRepository.signUp(email, password)
//        }
//    }

    fun addChild(){

    }
}
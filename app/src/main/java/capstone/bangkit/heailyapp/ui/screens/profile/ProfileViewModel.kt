package capstone.bangkit.heailyapp.ui.screens.profile

import androidx.lifecycle.ViewModel
import capstone.bangkit.heailyapp.data.SettingPreferences
import capstone.bangkit.heailyapp.data.local.UserRepository
import capstone.bangkit.heailyapp.data.model.Profile
import kotlinx.coroutines.flow.Flow

class ProfileViewModel(
    private val userRepository: UserRepository,
    private val pref: SettingPreferences
): ViewModel() {
    fun getProfile(): Flow<Profile> = pref.getProfileSetting()
}

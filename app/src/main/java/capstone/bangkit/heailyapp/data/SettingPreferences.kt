package capstone.bangkit.heailyapp.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import capstone.bangkit.heailyapp.data.model.Profile
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SettingPreferences private constructor(private val dataStore: DataStore<Preferences>) {
    suspend fun saveProfileSetting(profile : Profile) {
        dataStore.edit {preferences ->
            preferences[USER_ID] = profile.id
            preferences[EMAIL_KEY] = profile.email
            preferences[PROFIL_PIC_KEY] = profile.profilePicName
        }
    }

    fun getProfileSetting() : Flow<Profile> {
        return dataStore.data.map { preferences ->
            Profile(
                id = preferences[USER_ID] ?: 0,
                email = preferences[EMAIL_KEY] ?: "",
                profilePicName = preferences[PROFIL_PIC_KEY] ?: ""
            )
        }
    }

    suspend fun clearProfileSetting(){
        dataStore.edit {preferences ->
            preferences[USER_ID] = 0
            preferences[EMAIL_KEY] = ""
            preferences[PROFIL_PIC_KEY] = ""
        }
    }

    companion object{
        @Volatile
        private var INSTANCE: SettingPreferences? = null
        private var USER_ID = intPreferencesKey("userId")
        private var EMAIL_KEY = stringPreferencesKey("email")
        private var PROFIL_PIC_KEY = stringPreferencesKey("profilPhoto")

        fun getInstance(dataStore: DataStore<Preferences>) :SettingPreferences{
            return INSTANCE ?: synchronized(this) {
                val instance = SettingPreferences(dataStore)
                INSTANCE = instance
                instance
            }
        }
    }
}
package capstone.bangkit.heailyapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Profile (
    val id: Int,
    val email: String,
    val profilePicName : String
) : Parcelable
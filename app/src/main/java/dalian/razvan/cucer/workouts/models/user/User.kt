package dalian.razvan.cucer.workouts.models.user

import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName

@IgnoreExtraProperties
data class User(@SerializedName("username") val username: String = "",
                @SerializedName("email") val email: String = "")
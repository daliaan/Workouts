package dalian.razvan.cucer.workouts.models.user

import com.google.gson.annotations.SerializedName

data class User(@SerializedName("id") var id: Int = 0,
                @SerializedName("username") var username: String = "",
                @SerializedName("email") var email: String = "")
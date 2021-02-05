package dalian.razvan.cucer.workouts.core.data.network.login

import com.google.gson.annotations.SerializedName

class LoginRequest(@SerializedName("email") val email: String,
                   @SerializedName("password") val password: String)

package dalian.razvan.cucer.workouts.core.data.network.register

import com.google.gson.annotations.SerializedName

class RegisterRequest(@SerializedName("email") val email: String,
                      @SerializedName("username") val username: String,
                      @SerializedName("password") val password: String,
                      @SerializedName("confirm_password") val confirmPassword: String)

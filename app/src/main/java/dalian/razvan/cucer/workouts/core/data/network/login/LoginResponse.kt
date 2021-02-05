package dalian.razvan.cucer.workouts.core.data.network.login

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

class LoginResponse(@SerializedName("email") val email: String,
                    @SerializedName("username") val username: String)

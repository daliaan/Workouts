package dalian.razvan.cucer.workouts.models.workout

import android.graphics.Bitmap
import com.google.gson.annotations.SerializedName

data class Workout(@SerializedName("workout_name") var workoutName: String = "",
                   @SerializedName("workout_date") var workoutDate: String = "",
                   @SerializedName("burned_calories") var burnedCalories: String = "",
                   @SerializedName("workout_duration") var workoutDuration: String = "",
                   @SerializedName("photo") var photo: Bitmap? = null)
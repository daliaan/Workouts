package dalian.razvan.cucer.workouts.models.workout

import android.graphics.Bitmap
import com.google.gson.annotations.SerializedName

data class Workout(@SerializedName("workout_name") var workoutName: String = "",
                   @SerializedName("workout_date") var workoutDate: String = "",
                   @SerializedName("burned_calories") var burnedCalories: Int = 0,
                   @SerializedName("workout_duration") var workoutDuration: Int = 0,
                   @SerializedName("photo") var photo: Bitmap?)
package dalian.razvan.cucer.workouts.core.data.network.addNewWorkout

import com.google.gson.annotations.SerializedName

class AddNewWorkoutRequest(@SerializedName("workout_name") val workoutName: String,
                           @SerializedName("burned_calories") val burnedCalories: String,
                           @SerializedName("workout_date") val workoutDate: String,
                           @SerializedName("workout_duration") val workoutDuration: String)
package dalian.razvan.cucer.workouts.models.workout

import android.graphics.Bitmap
import dalian.razvan.cucer.workouts.core.baseClasses.BaseModelView

class WorkoutModelViewImpl(var workout: Workout): BaseModelView(), WorkoutModelView {
    override fun getWorkoutName(): String = workout.workoutName
    override fun getWorkoutDate(): String = workout.workoutDate
    override fun getBurnedCalories(): Int = workout.burnedCalories
    override fun getWorkoutDuration(): Int = workout.workoutDuration
    override fun getPhotoBitmap(): Bitmap? = workout.photo
}
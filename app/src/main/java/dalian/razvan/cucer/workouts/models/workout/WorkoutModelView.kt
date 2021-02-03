package dalian.razvan.cucer.workouts.models.workout

import android.graphics.Bitmap

interface WorkoutModelView {
    fun getWorkoutName(): String
    fun getWorkoutDate(): String
    fun getBurnedCalories(): Int
    fun getWorkoutDuration(): Int
    fun getPhotoBitmap(): Bitmap?
}
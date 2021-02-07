package dalian.razvan.cucer.workouts.core.data.repository.workout

import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.database.DataSnapshot
import dalian.razvan.cucer.workouts.core.data.repository.BaseRepository
import dalian.razvan.cucer.workouts.models.user.User
import dalian.razvan.cucer.workouts.models.workout.Workout

interface WorkoutRepository: BaseRepository {
    fun enrollUser(workoutsUser: User?)
    fun refreshForUser(workoutsUser: User?, onCompleteListener: OnCompleteListener<DataSnapshot>, onFailureListener: OnFailureListener)
    fun getUserWorkouts(): ArrayList<Workout>
    fun addNewWorkout(generateWorkout: Workout)
}
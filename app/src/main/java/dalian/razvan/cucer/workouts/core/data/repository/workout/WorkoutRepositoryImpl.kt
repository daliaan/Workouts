package dalian.razvan.cucer.workouts.core.data.repository.workout

import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import dalian.razvan.cucer.workouts.core.data.repository.BaseRepositoryImpl
import dalian.razvan.cucer.workouts.core.data.repository.DatabasePaths
import dalian.razvan.cucer.workouts.models.user.User
import dalian.razvan.cucer.workouts.models.workout.Workout

class WorkoutRepositoryImpl: BaseRepositoryImpl(), WorkoutRepository {
    private var workouts = arrayListOf<Workout>()

    override fun enrollUser(workoutsUser: User?) {
        workoutsUser?.let {
            getUserPath(it)?.setValue(it)
        }
    }

    override fun getUserWorkouts(): ArrayList<Workout> = workouts

    override fun refreshForUser(workoutsUser: User?, onCompleteListener: OnCompleteListener<DataSnapshot>, onFailureListener: OnFailureListener) {
        workoutsUser?.let {
            getUserWorkoutsPath(it)?.get()?.addOnCompleteListener { response ->
                if (response.isSuccessful) {
                    workouts.clear()
                    response.result?.children?.forEach { item ->
                        Log.e("workout",item.value.toString())
                    }
                } else {
                    Log.e("workout","isNotSuccessful")
                }
                onCompleteListener.onComplete(response)
            }?.addOnFailureListener { failure ->
                Log.e("workout","isNotSuccessful")
                onFailureListener.onFailure(failure)
            }
        }
    }
}
package dalian.razvan.cucer.workouts.core.data.repository.user

import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import dalian.razvan.cucer.workouts.core.data.repository.BaseRepositoryImpl
import dalian.razvan.cucer.workouts.core.data.repository.DatabasePaths
import dalian.razvan.cucer.workouts.core.data.repository.workout.WorkoutRepository
import dalian.razvan.cucer.workouts.models.user.User
import java.util.*

class UserRepositoryImpl(var workoutRepository: WorkoutRepository): BaseRepositoryImpl(), UserRepository {

    private var workoutsUser: FirebaseUser? = null

    override fun setUser(currentUser: FirebaseUser?) {
        workoutsUser = currentUser
        workoutRepository.refreshForUser(convertToUser(workoutsUser),{

        }, {

        })
    }

    private fun convertToUser(workoutsUser: FirebaseUser?): User? {
        workoutsUser?.let { user ->
            return user.email?.let { userEmail -> User(email = userEmail) }
        }
        return null
    }

    override fun getUser(): FirebaseUser? = workoutsUser
    override fun setUsername(username: String) {
        getUserUsernamePath(convertToUser(workoutsUser))?.setValue(username)
    }
}
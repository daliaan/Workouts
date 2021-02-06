package dalian.razvan.cucer.workouts.core.data.repository.user

import com.google.firebase.auth.FirebaseUser

class UserRepositoryImpl: UserRepository {

    private var workoutsUser: FirebaseUser? = null

    override fun setUser(currentUser: FirebaseUser?) {
        workoutsUser = currentUser
    }

    override fun getUser(): FirebaseUser? = workoutsUser
}
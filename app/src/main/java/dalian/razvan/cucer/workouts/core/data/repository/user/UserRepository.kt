package dalian.razvan.cucer.workouts.core.data.repository.user

import com.google.firebase.auth.FirebaseUser

interface UserRepository {
    fun setUser(currentUser: FirebaseUser?)
    fun getUser(): FirebaseUser?
}
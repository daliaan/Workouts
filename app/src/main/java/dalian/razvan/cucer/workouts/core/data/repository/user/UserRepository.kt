package dalian.razvan.cucer.workouts.core.data.repository.user

import com.google.firebase.auth.FirebaseUser
import dalian.razvan.cucer.workouts.core.data.repository.BaseRepository

interface UserRepository: BaseRepository {
    fun setUser(currentUser: FirebaseUser?)
    fun getUser(): FirebaseUser?
    fun setUsername(username: String)
}
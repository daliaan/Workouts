package dalian.razvan.cucer.workouts.core.data.repository

import com.google.firebase.database.DatabaseReference
import dalian.razvan.cucer.workouts.models.user.User

interface BaseRepository {
    fun getId(email: String): String
    fun getUserPath(user: User?): DatabaseReference?
    fun getUserUsernamePath(user: User?): DatabaseReference?
    fun getUserWorkoutsPath(user: User?): DatabaseReference?
}

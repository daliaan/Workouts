package dalian.razvan.cucer.workouts.core.data.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import dalian.razvan.cucer.workouts.models.user.User

open class BaseRepositoryImpl: BaseRepository {

    protected var database: DatabaseReference = FirebaseDatabase.getInstance().reference

    override fun getId(email: String): String = email
        .replace(".","")
        .replace("#","")
        .replace("$","")
        .replace("[","")
        .replace("]","")

    override fun getUserPath(user: User?): DatabaseReference? = user?.let {
        database.child(DatabasePaths.USERS.toString()).child(getId(it.email))
    }

    override fun getUserUsernamePath(user: User?): DatabaseReference? = user?.let {
        database.child(DatabasePaths.USERS.toString()).child(getId(it.email)).child(DatabasePaths.USERNAME.toString())
    }

    override fun getUserWorkoutsPath(user: User?): DatabaseReference? = user?.let {
        database.child(DatabasePaths.USERS.toString()).child(getId(it.email))
            .child(DatabasePaths.WORKOUTS.toString())
    }
}
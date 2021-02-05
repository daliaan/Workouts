package dalian.razvan.cucer.workouts.screens.splash

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dalian.razvan.cucer.workouts.core.baseClasses.BaseViewModel

class SplashViewModel: BaseViewModel() {

    private var auth = FirebaseAuth.getInstance()
    private var user: FirebaseUser? = null

    fun isUserLoggedIn(): Boolean {
        user = auth.currentUser
        return user != null
    }
}
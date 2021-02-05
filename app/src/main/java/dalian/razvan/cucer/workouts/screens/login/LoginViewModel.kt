package dalian.razvan.cucer.workouts.screens.login

import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import dalian.razvan.cucer.workouts.R
import dalian.razvan.cucer.workouts.core.baseClasses.BaseViewModel
import dalian.razvan.cucer.workouts.core.data.repository.user.UserRepository
import dalian.razvan.cucer.workouts.core.useCases.user.login.LoginUseCase

class LoginViewModel(useCase: LoginUseCase, repository: UserRepository): BaseViewModel() {
    fun login(loginScreen: LoginFragmentView) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(loginScreen.getEmail(), loginScreen.getPassword())
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    loginScreen.goToHomepage()
                } else {
                    loginScreen.showPopup(R.string.authentication_failed)
                }
            }.addOnFailureListener {
                it.message?.let { message ->
                    loginScreen.showPopup(message)
                }
            }
    }
}
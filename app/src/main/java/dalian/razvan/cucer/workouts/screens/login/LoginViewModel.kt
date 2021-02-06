package dalian.razvan.cucer.workouts.screens.login

import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dalian.razvan.cucer.workouts.R
import dalian.razvan.cucer.workouts.core.baseClasses.BaseViewModel
import dalian.razvan.cucer.workouts.core.data.repository.user.UserRepository
import dalian.razvan.cucer.workouts.core.useCases.user.login.LoginUseCase

class LoginViewModel(var useCase: LoginUseCase, var repository: UserRepository): BaseViewModel() {
    fun login(loginScreen: LoginFragmentView) {
        if (useCase.canMakeRequest(loginScreen))
            FirebaseAuth.getInstance().signInWithEmailAndPassword(loginScreen.getEmail(), loginScreen.getPassword())
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        loginScreen.goToHomepage()
                        repository.setUser(Firebase.auth.currentUser)
                    }
                }.addOnFailureListener {
                    it.message?.let { message ->
                        loginScreen.showPopup(message)
                    }
                }
    }
}
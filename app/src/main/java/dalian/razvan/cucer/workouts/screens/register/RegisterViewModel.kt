package dalian.razvan.cucer.workouts.screens.register

import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.ktx.Firebase
import dalian.razvan.cucer.workouts.R
import dalian.razvan.cucer.workouts.core.baseClasses.BaseViewModel
import dalian.razvan.cucer.workouts.core.data.repository.user.UserRepository
import dalian.razvan.cucer.workouts.core.useCases.user.login.LoginUseCase
import dalian.razvan.cucer.workouts.core.useCases.user.register.RegisterUseCase

class RegisterViewModel(var useCase: RegisterUseCase, var repository: UserRepository): BaseViewModel() {
    fun register(registerScreen: RegisterFragmentView) {
        if ( registerScreen.hasAgreedToTerms()) {
            if (useCase.canMakeRequest(registerScreen))
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(registerScreen.getEmail(), registerScreen.getPassword())
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                repository.setUser(Firebase.auth.currentUser)
                                repository.setUsername(registerScreen.getUsername())
                                registerScreen.goToHomepage()
                            }
                        }.addOnFailureListener {
                            it.message?.let { message ->
                                registerScreen.showPopup(message)
                            }
                        }
        } else {
            registerScreen.showPopup(R.string.agree_to_terms_first)
        }
    }
}
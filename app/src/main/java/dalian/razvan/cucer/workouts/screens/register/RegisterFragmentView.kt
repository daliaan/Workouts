package dalian.razvan.cucer.workouts.screens.register

import dalian.razvan.cucer.workouts.core.baseClasses.BaseFragmentView

interface RegisterFragmentView: BaseFragmentView {

    fun getUsername(): String
    fun getEmail(): String
    fun getPassword(): String
    fun getConfirmPassword(): String

    fun validateUsername(): Boolean
    fun validateEmail(): Boolean
    fun validatePassword(): Boolean
    fun validateConfirmPassword(): Boolean

    fun hasAgreedToTerms(): Boolean

    fun goToHomepage()
    fun successfulRegister()
}

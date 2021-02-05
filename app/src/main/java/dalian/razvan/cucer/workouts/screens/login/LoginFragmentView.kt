package dalian.razvan.cucer.workouts.screens.login

import android.view.View
import dalian.razvan.cucer.workouts.core.baseClasses.BaseFragmentView

interface LoginFragmentView: BaseFragmentView {

    fun getEmail(): String
    fun getPassword(): String

    fun goToRegister(v: View)
    fun goToHomepage()

}

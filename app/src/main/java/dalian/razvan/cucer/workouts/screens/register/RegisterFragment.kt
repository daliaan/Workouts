package dalian.razvan.cucer.workouts.screens.register

import dalian.razvan.cucer.workouts.R
import dalian.razvan.cucer.workouts.core.baseClasses.BaseFragment
import dalian.razvan.cucer.workouts.core.baseClasses.BaseViewModel

class RegisterFragment: BaseFragment() {

    override fun whichLayout(): Int = R.layout.fragment_register
    override fun getTitle(): Int = R.string.register

    override fun showHomeAsUp(): Boolean = false
    override fun homeAsUpEnabled(): Boolean = false
    override fun showToolbar(): Boolean = true
}
package dalian.razvan.cucer.workouts.screens.splash

import dalian.razvan.cucer.workouts.R
import dalian.razvan.cucer.workouts.core.BaseFragment
import dalian.razvan.cucer.workouts.core.BaseViewModel

class SplashFragment: BaseFragment() {

    override fun whichLayout(): Int = R.layout.fragment_splash
    override fun getTitle(): Int = 0

    override fun showHomeAsUp(): Boolean = false
    override fun homeAsUpEnabled(): Boolean = false
    override fun showToolbar(): Boolean = false

    override fun getViewModelClass(): Class<out BaseViewModel> {
        TODO("Not yet implemented")
    }

    override fun getViewModelInstance(): BaseViewModel {
        TODO("Not yet implemented")
    }
}
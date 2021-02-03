package dalian.razvan.cucer.workouts.screens.splash

import android.os.Handler
import android.os.HandlerThread
import dalian.razvan.cucer.workouts.R
import dalian.razvan.cucer.workouts.core.baseClasses.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class SplashFragment: BaseFragment() {

    private val splashViewModel by viewModel<SplashViewModel>()

    override fun whichLayout(): Int = R.layout.fragment_splash
    override fun getTitle(): Int = 0

    override fun showHomeAsUp(): Boolean = false
    override fun homeAsUpEnabled(): Boolean = false
    override fun showToolbar(): Boolean = false

    override fun onResume() {
        super.onResume()
        Handler().postDelayed(Runnable{

        }, 1500)
    }
}
package dalian.razvan.cucer.workouts.screens.splash

import android.os.Handler
import android.os.HandlerThread
import androidx.navigation.Navigation
import dalian.razvan.cucer.workouts.R
import dalian.razvan.cucer.workouts.core.baseClasses.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class SplashFragment: BaseFragment() {

    private val splashViewModel by viewModel<SplashViewModel>()

    override fun whichLayout(): Int = R.layout.fragment_splash
    override fun getTitle(): Int = R.string.splash

    override fun showToolbar(): Boolean = false

    override fun onResume() {
        super.onResume()
        Handler().postDelayed(Runnable{
            view?.let {
                Navigation.findNavController(it).popBackStack()
            }
            if (splashViewModel.isUserLoggedIn()) {
                goToHomepage()
            } else {
                goToLogin()
            }
        }, 1500)
    }

    private fun goToHomepage() {
        view?.let {
            Navigation.findNavController(it).navigate(R.id.goToHome)
        }
    }

    private fun goToLogin() {
        view?.let {
            Navigation.findNavController(it).navigate(R.id.goToLogin)
        }
    }
}
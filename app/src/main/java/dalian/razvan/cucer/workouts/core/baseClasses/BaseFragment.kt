package dalian.razvan.cucer.workouts.core.baseClasses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import dalian.razvan.cucer.workouts.R
import kotlinx.android.synthetic.main.fragment_base.*

abstract class BaseFragment: Fragment(), BaseFragmentView {

    abstract fun whichLayout(): Int
    abstract fun getTitle(): Int
    abstract fun showHomeAsUp(): Boolean
    abstract fun homeAsUpEnabled(): Boolean
    abstract fun showToolbar(): Boolean

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
                = inflater.inflate(R.layout.fragment_base, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fragment_content.addView(LayoutInflater.from(view.context).inflate(whichLayout(), null))
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun showProgressBar(show: Boolean) {
        TODO("Not yet implemented")
    }

    override fun showPopup(text: String) {
        TODO("Not yet implemented")
    }

    override fun goBack() {
        view?.let {
            val navController = Navigation.findNavController(it)
            if (navController.previousBackStackEntry == null) {
                activity?.finish()
            } else {
                navController.popBackStack()
            }
        }
    }

    override fun isActivityStateSaved(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isActivityVisible(): Boolean {
        TODO("Not yet implemented")
    }

    private fun setupToolbar() {

    }
}
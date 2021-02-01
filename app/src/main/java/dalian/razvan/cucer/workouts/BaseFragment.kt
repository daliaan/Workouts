package dalian.razvan.cucer.workouts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import dalian.razvan.cucer.core.baseClasses.BaseFragmentView

abstract class BaseFragment: Fragment(), BaseFragmentView, DrawerLayout.DrawerListener {

    private lateinit var behaviour: BottomSheetBehavior<ConstraintLayout>
    protected lateinit var viewModel: BaseViewModel

    abstract fun whichLayout(): Int
    abstract fun setTitle(): Int
    abstract fun showBottomBar(): Boolean
    abstract fun showDrawer(): Boolean
    abstract fun getViewModelClass(): Class<out BaseViewModel>
    abstract fun getViewModelInstance(): BaseViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_base, container, false)
    }

    //this has to run before super so that the layout
    //which is provided in function whichLayout()
    //will be inflated and added in the proper place
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fragment_content.addView(LayoutInflater.from(view.context).inflate(whichLayout(), null))

        behaviour = BottomSheetBehavior.from(bottom_sheet)

        setupToolbar()
        setupBottomBar()

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(getViewModelClass())
    }

    override fun showProgressBar(show: Boolean) {
        TODO("Not yet implemented")
    }

    override fun showPopup(drawableResID: Int, text: String) {
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

    override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
        if (!showDrawer()) {
            drawer_layout.closeDrawer(GravityCompat.START)
        }
    }

    override fun onDrawerOpened(drawerView: View) {

    }

    override fun onDrawerClosed(drawerView: View) {

    }

    override fun onDrawerStateChanged(newState: Int) {
        if (newState == DrawerLayout.STATE_DRAGGING && !showDrawer()) {
            drawer_layout.closeDrawer(GravityCompat.START)
        }
     }

    private fun setupToolbar() {
        title.text = getString(setTitle())
        setupNavDrawer()
    }

    private fun setupBottomBar() {
        bottombar_layout.visibility = if (showBottomBar()) View.VISIBLE else View.GONE
        goToHome.setOnClickListener {
            if (this !is HomeFragment) {
                Navigation.findNavController(it).popBackStack()
                Navigation.findNavController(it).navigate(R.id.goToHome)
            }
        }
        goToSearch.setOnClickListener {
            if (this !is SearchFragment) {
                Navigation.findNavController(it).popBackStack()
                Navigation.findNavController(it).navigate(R.id.goToSearch)
            }
        }
        goToPharmacies.setOnClickListener {
            if (this !is PharmaciesFragment) {
                Navigation.findNavController(it).popBackStack()
                Navigation.findNavController(it).navigate(R.id.goToPharmacies)
            }
        }
        goToPrescriptions.setOnClickListener {
            if (this !is PrescriptionsFragment) {
                Navigation.findNavController(it).popBackStack()
                Navigation.findNavController(it).navigate(R.id.goToPrescriptions)
            }
        }
        goToCart.setOnClickListener {
            if (this !is CartFragment) {
                Navigation.findNavController(it).popBackStack()
                Navigation.findNavController(it).navigate(R.id.goToCart)
            }
        }
    }

    private fun setupNavDrawer() {

        drawer_layout.setDrawerLockMode(if (showDrawer()) DrawerLayout.LOCK_MODE_UNLOCKED else DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        nav_drawer.visibility = if (showDrawer()) View.VISIBLE else View.GONE

        homeAsUp.isSelected = showDrawer()
        homeAsUp.setOnClickListener {
            if (showDrawer()) {
                if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
                    drawer_layout.closeDrawer(GravityCompat.START)
                } else {
                    drawer_layout.openDrawer(GravityCompat.START)
                }
            } else {
                goBack()
            }
        }
    }

    protected fun showFilterButton(resId: Int, onClickListener: View.OnClickListener) {
        filter.setImageResource(resId)
        filter.setOnClickListener(onClickListener)
        filter.visibility = View.VISIBLE
    }

    protected fun showBottomSheet(show: Boolean) {
        if (show) {
            behaviour.state = BottomSheetBehavior.STATE_EXPANDED
            dimmable_background.visibility = View.VISIBLE
        } else {
            behaviour.state = BottomSheetBehavior.STATE_COLLAPSED
            dimmable_background.visibility = View.GONE
        }
    }

    protected fun isBottomSheetVisible(): Boolean = behaviour.state == BottomSheetBehavior.STATE_HIDDEN || behaviour.state == BottomSheetBehavior.STATE_COLLAPSED
}
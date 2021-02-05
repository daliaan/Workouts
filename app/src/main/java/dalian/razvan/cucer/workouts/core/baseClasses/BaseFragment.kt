package dalian.razvan.cucer.workouts.core.baseClasses

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import dalian.razvan.cucer.workouts.R
import dalian.razvan.cucer.workouts.screens.WorkoutsActivity
import kotlinx.android.synthetic.main.fragment_base.*

abstract class BaseFragment: Fragment(), BaseFragmentView {

    protected lateinit var appActivity: WorkoutsActivity

    abstract fun whichLayout(): Int
    abstract fun getTitle(): Int
    abstract fun showToolbar(): Boolean

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.let {
            appActivity = it as WorkoutsActivity
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
                = inflater.inflate(R.layout.fragment_base, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fragment_content.addView(LayoutInflater.from(view.context).inflate(whichLayout(), null))
        super.onViewCreated(view, savedInstanceState)
        appActivity.setSupportActionBar(toolbar)
        setupToolbar()
    }

    override fun showProgressBar(show: Boolean) {
        TODO("Not yet implemented")
    }

    override fun showPopup(text: String) {
        val alertDialogBuilder = AlertDialog.Builder(appActivity)
        alertDialogBuilder.setTitle("")
        alertDialogBuilder.setMessage(text)
        alertDialogBuilder.setPositiveButton(resources.getString(android.R.string.ok)) { dialog: DialogInterface?, which: Int ->
            dialog?.dismiss()
        }
        alertDialogBuilder.setOnDismissListener { dialog: DialogInterface? ->
            dialog?.dismiss()
        }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.setOnShowListener { dialog: DialogInterface? ->

        }
        alertDialog.show()
    }

    override fun showPopup(resId: Int) {
        showPopup(resources.getString(resId))
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
        if (getTitle() != 0)
            appActivity.supportActionBar?.title = resources.getString(getTitle())
        toolbar.visibility = if (showToolbar()) View.VISIBLE else View.GONE
    }
}
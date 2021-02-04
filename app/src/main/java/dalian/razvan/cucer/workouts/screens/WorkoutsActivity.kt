package dalian.razvan.cucer.workouts.screens

import android.os.Bundle
import dalian.razvan.cucer.workouts.R
import dalian.razvan.cucer.workouts.core.baseClasses.BaseActivity
import kotlinx.android.synthetic.main.activity_workouts.*

class WorkoutsActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workouts)
    }
}
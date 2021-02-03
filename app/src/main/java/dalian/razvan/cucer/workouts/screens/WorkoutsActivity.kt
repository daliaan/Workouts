package dalian.razvan.cucer.workouts.screens

import android.os.Bundle
import dalian.razvan.cucer.workouts.R
import dalian.razvan.cucer.workouts.core.baseClasses.BaseActivity

class WorkoutsActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workouts)
    }
}
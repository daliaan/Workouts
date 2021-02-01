package dalian.razvan.cucer.workouts.core

interface BaseFragmentView {

    fun showProgressBar(show : Boolean)

    fun showPopup(text : String)

    fun goBack()

    fun isActivityStateSaved() : Boolean

    fun isActivityVisible() : Boolean
}
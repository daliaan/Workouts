package dalian.razvan.cucer.workouts.core.baseClasses

interface BaseFragmentView {

    fun showProgressBar(show : Boolean)

    fun showPopup(text : String)
    fun showPopup(resId : Int)

    fun goBack()

    fun isActivityStateSaved() : Boolean

    fun isActivityVisible() : Boolean
}
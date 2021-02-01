package dalian.razvan.cucer.core.baseClasses

interface BaseFragmentView {

    fun showProgressBar(show : Boolean)

    fun showPopup(drawableResID: Int, text : String)

    fun goBack()

    fun isActivityStateSaved() : Boolean

    fun isActivityVisible() : Boolean
}
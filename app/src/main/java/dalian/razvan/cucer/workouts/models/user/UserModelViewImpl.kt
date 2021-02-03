package dalian.razvan.cucer.workouts.models.user

import dalian.razvan.cucer.workouts.core.baseClasses.BaseModelView

class UserModelViewImpl(var user: User): BaseModelView(), UserModelView {

    override fun getUsername(): String = user.username
    override fun getEmail(): String = user.email
}
package dalian.razvan.cucer.workouts.core

import android.app.Application
import dalian.razvan.cucer.workouts.dependencyInjection.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WorkoutsApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@WorkoutsApplication)
            modules(listOf(repositoryModule,
                            useCaseModule,
                            viewModelsModule,
                            networkModule,
                            serviceModule))
        }
    }
}
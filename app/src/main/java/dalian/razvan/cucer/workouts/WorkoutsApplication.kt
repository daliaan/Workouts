package dalian.razvan.cucer.workouts

import android.app.Application
import com.google.firebase.FirebaseApp
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
        FirebaseApp.initializeApp(this)
    }
}
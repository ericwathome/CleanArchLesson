package tech.ericwathome.cleanarchprac.feature_posts

import android.app.Application
import dagger.hilt.android.AndroidEntryPoint
import tech.ericwathome.cleanarchprac.BuildConfig
import timber.log.Timber

@AndroidEntryPoint
class CleanArchPracApp : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}
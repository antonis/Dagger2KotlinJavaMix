package eu.afse.daggermixedproject

import android.app.Application

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

/**
 * Created by antonis on 3/29/18.
 */

@Module
class AppModule(internal var mApplication: Application) {

    @Provides
    @Singleton
    internal fun providesApplication(): Application {
        return mApplication
    }

    @Provides
    internal fun providesJavaInfo(): JavaInfo {
        return JavaInfo()
    }

    /**
     * We can add this method and ommit the @Inject constructor() in KotlinInfo class declaration
     *
     * @Provides
     * KotlinInfo providesKotlinInfo() {
     *  return new KotlinInfo();
     * }
     */
}
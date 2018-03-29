package eu.afse.daggermixedproject;

import android.app.Application;
import android.content.Context;

/**
 * Created by antonis on 3/29/18.
 */

public class MyApp extends Application {

    private MyComponent mMyComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mMyComponent = DaggerMyComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.github.com"))
                .build();

        /* If a Dagger 2 component does not have any constructor arguments for any of its modules,
         * then we can use .create() as a shortcut instead:
         * mMyComponent = com.codepath.dagger.components.DaggerMyComponent.create();
         */
    }

    public MyComponent getMyComponent() {
        return mMyComponent;
    }

    public static MyApp get(Context context) {
        return ((MyApp) context.getApplicationContext());
    }

    public static MyComponent getMyComponent(Context context) {
        return get(context).mMyComponent;
    }
}
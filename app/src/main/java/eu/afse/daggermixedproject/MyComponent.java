package eu.afse.daggermixedproject;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by antonis on 3/29/18.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface MyComponent {
    void inject(MainActivity activity);
}
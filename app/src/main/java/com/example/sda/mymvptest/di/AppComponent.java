package com.example.sda.mymvptest.di;

import com.example.sda.mymvptest.activities.MainActivity;

import javax.inject.Singleton;

/**
 * Created by sda on 26.06.17.
 */

@Singleton

// podaje tablice komponentów
@dagger.Component(modules = {AppModule.class})
public interface AppComponent {



    void inject(MainActivity mainActivity);
}

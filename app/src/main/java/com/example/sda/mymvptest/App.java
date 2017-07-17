package com.example.sda.mymvptest;

import android.app.Application;

import com.example.sda.mymvptest.di.AppComponent;
import com.example.sda.mymvptest.di.AppModule;
import com.example.sda.mymvptest.di.DaggerAppComponent;

/**
 * Created by sda on 15.07.17.
 */
// towrzy Daggera
//The component is used to connect objects to their dependencies, typically by use of overridden inject() methods
//In order to use the component, it must be accessible from the parts of the app that need injection. Typically, that will happen from the app Application subclass, as follows.
public class App extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
    }

    private void initDagger() {

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this)).build();

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}


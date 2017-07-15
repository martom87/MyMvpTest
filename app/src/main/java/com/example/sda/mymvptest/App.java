package com.example.sda.mymvptest;

import android.app.Application;

import com.example.sda.mymvptest.di.AppComponent;
import com.example.sda.mymvptest.di.AppModule;
import com.example.sda.mymvptest.di.DaggerAppComponent;

/**
 * Created by sda on 15.07.17.
 */

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


package com.example.sda.mymvptest.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Provides;

/**
 * Created by sda on 26.06.17.
 */

//The @Module annotation tells Dagger that the AppModule class will provide dependencies for a part of the application. It is normal to have multiple Dagger modules in a project, and it is typical for one of them to provide app-wide dependencies.
@dagger.Module
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }
//The @Provides annotation tells Dagger that the method provides a certain type of dependency, in this case, a Context object. When a part of the app requests that Dagger inject a Context, the @Provides annotation tells Dagger where to find it.
    // Singleton is the calass that creates itself instance
    @Provides
    @Singleton
    Context providesContext() {
        return context;
    }




}

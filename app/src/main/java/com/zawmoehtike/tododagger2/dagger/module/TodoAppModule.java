package com.zawmoehtike.tododagger2.dagger.module;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class TodoAppModule {
    //expose Application as an injectable context
    @Binds
    abstract Context bindContext(Application application);
}

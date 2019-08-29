package com.zawmoehtike.tododagger2.dagger.module;

import com.zawmoehtike.tododagger2.dagger.scope.ActivityScoped;
import com.zawmoehtike.tododagger2.todos.TodosActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = TodosModule.class)
    abstract TodosActivity todosActivity();
}

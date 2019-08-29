package com.zawmoehtike.tododagger2.dagger.module;

import com.zawmoehtike.tododagger2.dagger.scope.ActivityScoped;
import com.zawmoehtike.tododagger2.dagger.scope.FragmentScoped;
import com.zawmoehtike.tododagger2.todos.TodosContract;
import com.zawmoehtike.tododagger2.todos.TodosFragment;
import com.zawmoehtike.tododagger2.todos.TodosPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class TodosModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract TodosFragment todosFragment();

    @ActivityScoped
    @Binds
    abstract TodosContract.Presenter todosPresenter(TodosPresenter presenter);
}

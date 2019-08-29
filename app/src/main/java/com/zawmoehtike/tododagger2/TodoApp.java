package com.zawmoehtike.tododagger2;

import androidx.annotation.VisibleForTesting;

import com.zawmoehtike.tododagger2.dagger.component.DaggerTodoAppComponent;
import com.zawmoehtike.tododagger2.data.TodoRepository;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class TodoApp extends DaggerApplication {
    @Inject
    TodoRepository todoRepository;

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerTodoAppComponent.builder().application(this).build();
    }

    /**
     * Our Espresso tests need to be able to get an instance of the {@link TodoRepository}
     * so that we can delete all tasks before running each test
     */
    @VisibleForTesting
    public TodoRepository getTodoRepository() {
        return todoRepository;
    }
}

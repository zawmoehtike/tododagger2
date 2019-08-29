package com.zawmoehtike.tododagger2.dagger.component;

import android.app.Application;

import com.zawmoehtike.tododagger2.TodoApp;
import com.zawmoehtike.tododagger2.dagger.module.TodoAppModule;
import com.zawmoehtike.tododagger2.dagger.module.ActivityBindingModule;
import com.zawmoehtike.tododagger2.dagger.module.TodoRepositoryModule;
import com.zawmoehtike.tododagger2.data.TodoRepository;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {TodoRepositoryModule.class,
        TodoAppModule.class,
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class})
public interface TodoAppComponent extends AndroidInjector<TodoApp> {

    TodoRepository getTodoRepository();

    // Gives us syntactic sugar. we can then do DaggerAppComponent.builder().application(this).build().inject(this);
    // never having to instantiate any modules or say which module we are passing the application to.
    // Application will just be provided into our app graph now.
    @Component.Builder
    interface Builder {

        @BindsInstance
        TodoAppComponent.Builder application(Application application);

        TodoAppComponent build();
    }
}

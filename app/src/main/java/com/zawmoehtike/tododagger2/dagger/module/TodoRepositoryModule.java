package com.zawmoehtike.tododagger2.dagger.module;

import android.app.Application;

import androidx.room.Room;

import com.zawmoehtike.tododagger2.dagger.scope.Local;
import com.zawmoehtike.tododagger2.dagger.scope.Remote;
import com.zawmoehtike.tododagger2.data.TodoDataSource;
import com.zawmoehtike.tododagger2.data.local.ToDoDatabase;
import com.zawmoehtike.tododagger2.data.local.TodoDao;
import com.zawmoehtike.tododagger2.data.local.TodoLocalDataSource;
import com.zawmoehtike.tododagger2.data.remote.TodoRemoteDataSource;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
abstract public class TodoRepositoryModule {

    @Singleton
    @Binds
    @Local
    abstract TodoDataSource provideTasksLocalDataSource(TodoLocalDataSource dataSource);

    @Singleton
    @Binds
    @Remote
    abstract TodoDataSource provideTasksRemoteDataSource(TodoRemoteDataSource dataSource);

    @Singleton
    @Provides
    static ToDoDatabase provideDb(Application context) {
        return Room.databaseBuilder(context.getApplicationContext(), ToDoDatabase.class, "tododb.db")
                .build();
    }

    @Singleton
    @Provides
    static TodoDao provideTasksDao(ToDoDatabase db) {
        return db.todoDao();
    }
}

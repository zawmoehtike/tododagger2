package com.zawmoehtike.tododagger2.data.remote;

import androidx.annotation.NonNull;

import com.zawmoehtike.tododagger2.data.TodoDataSource;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TodoRemoteDataSource implements TodoDataSource {

    @Inject
    public TodoRemoteDataSource() {

    }

    @Override
    public void getTodoList(@NonNull LoadTodoListCallback callback) {

    }

    @Override
    public void addTodoListByAI() {

    }

    @Override
    public void removeTodoListByAI() {

    }
}

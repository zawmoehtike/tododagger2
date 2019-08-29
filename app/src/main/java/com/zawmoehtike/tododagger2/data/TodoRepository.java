package com.zawmoehtike.tododagger2.data;

import androidx.annotation.NonNull;

import com.zawmoehtike.tododagger2.dagger.scope.Local;
import com.zawmoehtike.tododagger2.dagger.scope.Remote;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TodoRepository implements TodoDataSource {

    private final TodoDataSource mTodoRemoteDataSource;
    private final TodoDataSource mTodoLocalDataSource;

    @Inject
    public TodoRepository(@Remote TodoDataSource todoRemoteDataSource,
                          @Local TodoDataSource todoLocalDataSource) {
        mTodoRemoteDataSource = todoRemoteDataSource;
        mTodoLocalDataSource = todoLocalDataSource;
    }

    @Override
    public void getTodoList(@NonNull final LoadTodoListCallback callback) {

        mTodoLocalDataSource.getTodoList(new LoadTodoListCallback() {
            @Override
            public void onTodoListLoaded(List<Todo> todoList) {
                callback.onTodoListLoaded(todoList);
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void addTodoListByAI() {
        mTodoLocalDataSource.addTodoListByAI();
    }

    @Override
    public void removeTodoListByAI() {
        mTodoLocalDataSource.removeTodoListByAI();
    }
}

package com.zawmoehtike.tododagger2.data;

import androidx.annotation.NonNull;

import java.util.List;

public interface TodoDataSource {

    interface LoadTodoListCallback {

        void onTodoListLoaded(List<Todo> todoList);

        void onDataNotAvailable();
    }

    void getTodoList(@NonNull LoadTodoListCallback callback);

    void addTodoListByAI();

    void removeTodoListByAI();
}

package com.zawmoehtike.tododagger2.todos;

import androidx.annotation.Nullable;

import com.zawmoehtike.tododagger2.dagger.scope.ActivityScoped;
import com.zawmoehtike.tododagger2.data.Todo;
import com.zawmoehtike.tododagger2.data.TodoDataSource;
import com.zawmoehtike.tododagger2.data.TodoRepository;

import java.util.List;

import javax.inject.Inject;

@ActivityScoped
final public class TodosPresenter implements TodosContract.Presenter {

    private final TodoRepository mTodoRepository;

    @Nullable
    private TodosContract.View mTodosView;

    @Inject
    public TodosPresenter(TodoRepository todoRepository) {
        mTodoRepository = todoRepository;
    }

    @Override
    public void takeView(TodosContract.View view) {
        mTodosView = view;

        loadTodoList();
    }

    @Override
    public void loadTodoList() {
        mTodoRepository.getTodoList(new TodoDataSource.LoadTodoListCallback() {
            @Override
            public void onTodoListLoaded(List<Todo> todoList) {
                mTodosView.showTodoList(todoList);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    @Override
    public void insertTodoListByAI() {
        mTodoRepository.addTodoListByAI();
    }

    @Override
    public void deleteTodoListByAI() {
        mTodoRepository.removeTodoListByAI();
    }

    @Override
    public void dropView() {
        mTodosView = null;
    }
}

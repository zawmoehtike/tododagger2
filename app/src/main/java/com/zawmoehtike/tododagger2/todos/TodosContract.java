package com.zawmoehtike.tododagger2.todos;

import com.zawmoehtike.tododagger2.data.Todo;
import com.zawmoehtike.tododagger2.util.base.BasePresenter;
import com.zawmoehtike.tododagger2.util.base.BaseView;

import java.util.List;

public interface TodosContract {

    interface View extends BaseView<TodosContract.Presenter> {
        void showTodoList(List<Todo> todoList);
    }

    interface Presenter extends BasePresenter<TodosContract.View> {
        void loadTodoList();

        void insertTodoListByAI();

        void deleteTodoListByAI();
    }
}

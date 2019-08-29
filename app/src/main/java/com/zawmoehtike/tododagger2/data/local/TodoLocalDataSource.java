package com.zawmoehtike.tododagger2.data.local;

import androidx.annotation.NonNull;

import com.zawmoehtike.tododagger2.data.Todo;
import com.zawmoehtike.tododagger2.data.TodoDataSource;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TodoLocalDataSource implements TodoDataSource {

    private final TodoDao mTodoDao;

    @Inject
    public TodoLocalDataSource(@NonNull TodoDao todoDao) {
        mTodoDao = todoDao;
    }

    @Override
    public void getTodoList(@NonNull final LoadTodoListCallback callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                List<Todo> todoList = mTodoDao.getTodoList();

                callback.onTodoListLoaded(todoList);
            }
        };

        new Thread(runnable).start();
    }

    @Override
    public void addTodoListByAI() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Todo todo1 = new Todo();
                todo1.setTitle("Lorem1");
                todo1.setDescription("Lorem ipsm ...");

                mTodoDao.insertTodo(todo1);
            }
        };

        new Thread(runnable).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Todo todo2 = new Todo();
                todo2.setTitle("Lorem2.222");
                todo2.setDescription("Lorem ipsm ...");

                mTodoDao.insertTodo(todo2);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Todo todo3 = new Todo();
                todo3.setTitle("Lorem3.14");
                todo3.setDescription("Lorem ipsm ...");

                mTodoDao.insertTodo(todo3);
            }
        }).start();
    }

    @Override
    public void removeTodoListByAI() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                mTodoDao.deleteAllTodo();
            }
        };

        new Thread(runnable).start();
    }
}

package com.zawmoehtike.tododagger2.todos;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zawmoehtike.tododagger2.R;
import com.zawmoehtike.tododagger2.dagger.scope.ActivityScoped;
import com.zawmoehtike.tododagger2.data.Todo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

@ActivityScoped
public class TodosFragment extends DaggerFragment implements TodosContract.View {

    @Inject
    TodosContract.Presenter mPresenter;

    private RecyclerView recyclerView;

    private TodoListAdapter todoListAdapter;

    @Inject
    public TodosFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter.insertTodoListByAI();

        todoListAdapter = new TodoListAdapter(new ArrayList<Todo>(0));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_todos, container, false);

        recyclerView = view.findViewById(R.id.rvTodoList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(todoListAdapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        mPresenter.takeView(this);
    }

    @Override
    public void onPause() {
        super.onPause();

        mPresenter.deleteTodoListByAI();
    }

    @Override
    public void showTodoList(List<Todo> todoList) {
        todoListAdapter.addItems(todoList);
    }
}

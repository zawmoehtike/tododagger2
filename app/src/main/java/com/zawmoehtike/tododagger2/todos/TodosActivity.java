package com.zawmoehtike.tododagger2.todos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.zawmoehtike.tododagger2.R;
import com.zawmoehtike.tododagger2.util.ActivityUtils;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.android.support.DaggerAppCompatActivity;

public class TodosActivity extends DaggerAppCompatActivity {

    @Inject
    TodosPresenter mTodosPresenter;
    @Inject
    Lazy<TodosFragment> todosFragmentProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos);

        TodosFragment todosFragment =
                (TodosFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (todosFragment == null) {
            // Get the fragment from dagger
            todosFragment = todosFragmentProvider.get();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), todosFragment, R.id.contentFrame);
        }
    }
}

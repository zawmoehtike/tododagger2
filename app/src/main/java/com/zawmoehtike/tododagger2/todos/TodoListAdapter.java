package com.zawmoehtike.tododagger2.todos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.zawmoehtike.tododagger2.R;
import com.zawmoehtike.tododagger2.data.Todo;

import java.util.List;

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.TodoViewHolder> {

    private List<Todo> todoList;

    public TodoListAdapter(List<Todo> todoList) {
        this.todoList = todoList;
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_todo, parent, false);

        return new TodoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {
        Todo todo = todoList.get(position);
        holder.bindView(todo);
    }

    @Override
    public int getItemCount() {
        return this.todoList.size();
    }

    public void addItems(List<Todo> todoList) {
        this.todoList = todoList;
        notifyDataSetChanged();
    }

    class TodoViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle, tvDescription;

        private Todo todo;

        public TodoViewHolder(View view) {
            super(view);

            tvTitle = view.findViewById(R.id.tvTitle);
            tvDescription = view.findViewById(R.id.tvDescription);
        }

        public void bindView(Todo todo){

            this.todo = todo;

            tvTitle.setText(this.todo.getTitle());
            tvDescription.setText(this.todo.getDescription());
        }
    }
}


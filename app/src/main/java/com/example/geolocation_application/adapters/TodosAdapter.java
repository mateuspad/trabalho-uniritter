package com.example.geolocation_application.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.geolocation_application.R;
import com.example.geolocation_application.model.Todos;

import java.util.List;

public class TodosAdapter extends RecyclerView.Adapter<TodosAdapter.TodosViewHolder> {
    private List<Todos> listTodos;

    public TodosAdapter(List<Todos> listTodos) {
        this.listTodos = listTodos;
    }

    @NonNull
    @Override
    public TodosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_todos_viewholder, parent, false);

        return new TodosAdapter.TodosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodosAdapter.TodosViewHolder holder, int position) {
        holder.layout.findViewById(R.id.layoutDoFundoDoTodos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        ((TextView) holder.layout.findViewById(R.id.todosUserId)).setText(Integer.toString(listTodos.get(position).getUserId()));
        ((TextView) holder.layout.findViewById(R.id.todosId)).setText(Integer.toString(listTodos.get(position).getId()));
        ((TextView) holder.layout.findViewById(R.id.todosTitle)).setText(listTodos.get(position).getTitle());
        ((TextView) holder.layout.findViewById(R.id.todosCompleted)).setText(String.valueOf(listTodos.get(position).isCompleted()));
    }

    @Override
    public int getItemCount() {
        return listTodos.size();
    }

    public class TodosViewHolder extends RecyclerView.ViewHolder{
        public View layout;

        public TodosViewHolder(@NonNull View itemView) {
            super(itemView);
            this.layout = itemView;
        }
    }
}

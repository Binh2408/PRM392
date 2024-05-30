package com.example.lab2_ex8;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ConcurrentModificationException;
import java.util.List;

class CategoriesAdapter extends
        RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {
    private List<Categories> categoriesList;
    private Context context;
    public CategoriesAdapter(Context context, List<Categories>categoriesList) {
        this.context = context;
        this.categoriesList = categoriesList;
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cate,parent,false);
        return new CategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
        Categories categories = categoriesList.get(position);
        holder.textViewId.setText(String.valueOf(categories.getId()));
        holder.textViewName.setText(categories.getName());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, MainActivity2.class);
            intent.putExtra("id", categories.getId());
            intent.putExtra("name",categories.getName());
            intent.putExtra("description", categories.getDescription());

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }
    static class CategoriesViewHolder extends RecyclerView.ViewHolder {
        TextView textViewId;
        TextView textViewName;
        public CategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewId = itemView.findViewById(R.id.textViewId);
            textViewName = itemView.findViewById(R.id.textViewName);
        }
    }
}
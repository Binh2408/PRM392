package com.example.ex16;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class PostAdapter extends
        RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private Context context;
    private static List<Post> postList;
    private static OnItemClickListener listener;
    public interface OnItemClickListener {
        void onEditClick(Post post);
        void onDeleteClick(Post post);
    }
    public PostAdapter(Context context, List<Post> postList,
                       OnItemClickListener listener) {
        this.context = context;
        this.postList = postList;
        this.listener = listener;
    }
    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup
                                                     parent, int viewType) {
        View view =
                LayoutInflater.from(context).inflate(R.layout.post_item, parent,
                        false);
        return new PostViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder,
                                 int position) {
        Post post = postList.get(position);
        holder.tvTitle.setText(post.getTitle());
        holder.tvBody.setText(post.getBody());
    }
    @Override
    public int getItemCount() {
        return postList.size();
    }
    public static class PostViewHolder extends
            RecyclerView.ViewHolder {
        TextView tvTitle, tvBody;
        Button btnEdit, btnDelete;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvBody = itemView.findViewById(R.id.tvBody);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);

            btnEdit.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onEditClick(postList.get(position));
                    }
                }
            });

            btnDelete.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onDeleteClick(postList.get(position));
                    }
                }
            });
        }
    }
}
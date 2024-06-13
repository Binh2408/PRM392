package com.example.ex16;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditPostActivity extends AppCompatActivity {
    private EditText etTitle, etBody;
    private Button btnUpdate;
    private ApiService apiService;
    private int postId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_post);

        etTitle = findViewById(R.id.etTitle);
        etBody = findViewById(R.id.etBody);
        btnUpdate = findViewById(R.id.btnUpdate);

        apiService = ApiClient.getApiService();

        postId = getIntent().getIntExtra("post_id", 0);
        String postTitle = getIntent().getStringExtra("post_title");
        String postBody = getIntent().getStringExtra("post_body");

        etTitle.setText(postTitle);
        etBody.setText(postBody);

        btnUpdate.setOnClickListener(v -> {
            String title = etTitle.getText().toString();
            String body = etBody.getText().toString();
            if (title.isEmpty() || body.isEmpty()) {
                Toast.makeText(EditPostActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }
            updatePost(new Post(postId, title, body));
        });
    }

    private void updatePost(Post post) {
        apiService.updatePost(post.getId(), post).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Toast.makeText(EditPostActivity.this, "Post updated successfully", Toast.LENGTH_SHORT).show();
                    finish(); // Close the activity and go back to the main activity
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(EditPostActivity.this, "Failed to update post", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

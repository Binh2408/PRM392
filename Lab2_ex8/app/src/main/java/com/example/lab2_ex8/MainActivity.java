package com.example.lab2_ex8;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private  RecyclerView recyclerView;
    private CategoriesAdapter categoriesAdapter;
    private List<Categories> categoriesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new GridLayoutManager(this,3));

        categoriesList = new ArrayList<>();
        categoriesList.add(new Categories(1,"Lion1", "beautiful1"));
        categoriesList.add(new Categories(2,"Lion2", "beautiful2"));
        categoriesList.add(new Categories(3,"Lion3", "beautiful3"));
        categoriesList.add(new Categories(4,"Lion4", "beautiful4"));
        categoriesList.add(new Categories(5,"Lion5", "beautiful5"));
        categoriesList.add(new Categories(6,"Lion6", "beautiful6"));
        categoriesList.add(new Categories(7,"Lion7", "beautiful7"));
        categoriesList.add(new Categories(8,"Lion8", "beautiful8"));
        categoriesList.add(new Categories(9,"Lion9", "beautiful9"));

        categoriesAdapter = new CategoriesAdapter(this,categoriesList);
        recyclerView.setAdapter(categoriesAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        return true;
    }
}
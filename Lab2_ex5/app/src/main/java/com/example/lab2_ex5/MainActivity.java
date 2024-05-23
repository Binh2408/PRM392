package com.example.lab2_ex5;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public Button myButtonAdd;
    public Button myButtonSub;
    public Button myButtonMul;
    public Button myButtonDiv;
    public Button myButtonDel;
    public EditText editNum1;
    public EditText editNum2;
    public EditText editResult;
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

        myButtonAdd = findViewById(R.id.btnAdd);
        myButtonSub = findViewById(R.id.btnSub);
        myButtonMul = findViewById(R.id.btnMul);
        myButtonDiv = findViewById(R.id.btnDiv);
        myButtonDel = findViewById(R.id.btnDel);
        editNum1 = findViewById(R.id.editNum1);
        editNum2 = findViewById(R.id.editNum2);
        editResult = findViewById(R.id.editResult);

        myButtonAdd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                int a = Integer.parseInt(editNum1.getText().toString());
                int b = Integer.parseInt(editNum2.getText().toString());
                int c = a + b;
                editResult.setText(c+"");
            }
        });

        myButtonSub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int a = Integer.parseInt(editNum1.getText().toString());
                int b = Integer.parseInt(editNum2.getText().toString());
                int c = a - b;
                editResult.setText(c+"");
            }
        });

        myButtonMul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int a = Integer.parseInt(editNum1.getText().toString());
                int b = Integer.parseInt(editNum2.getText().toString());
                int c = a * b;
                editResult.setText(c+"");
            }
        });

        myButtonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(editNum1.getText().toString());
                int b = Integer.parseInt(editNum2.getText().toString());
                int c = a / b;
                editResult.setText(c+"");
            }
        });

        myButtonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a,b = "";
                editNum1.setText("");
                editNum2.setText("");
                editResult.setText("");


            }
        });
    }
}
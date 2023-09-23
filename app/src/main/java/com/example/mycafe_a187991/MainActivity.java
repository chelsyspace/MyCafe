package com.example.mycafe_a187991;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnAdd, btnRemove, btnCheckOut;
    TextView tvQuantity;
    EditText etName, etMenu;

    int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btn_add);
        btnRemove = findViewById(R.id.btn_remove);
        btnCheckOut = findViewById(R.id.btn_check_out);
        tvQuantity = findViewById(R.id.tv_quantity);
        etName = findViewById(R.id.et_name);
       // etMenu = findViewById(R.id.et_menu);

        quantity = 1;


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity++;
                tvQuantity.setText(""+quantity);
            }
        });

       btnRemove.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               quantity--;
               tvQuantity.setText(""+quantity);
           }
       });

       btnCheckOut.setOnClickListener(new View.OnClickListener() {
           String name;
           //String menus;
           @Override
           public void onClick(View view) {
               name = etName.getText().toString();
               Toast.makeText(MainActivity.this,"Thank You " + name + " for your order. Total : " + quantity + " Cendol." , Toast.LENGTH_SHORT).show();

               Intent intent = new Intent(MainActivity.this,OrderDetailActivity.class);
               intent.putExtra("quantity", quantity);
               intent.putExtra("name", name);

               startActivity(intent);

           }
       });
    }

    }

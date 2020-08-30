package com.retro.booklibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton addbutton;
    MyDatabaseHelper mydb;
    ArrayList<String> book_id ,book_title,booke_auther,book_pages;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycleview);
        addbutton=findViewById(R.id.addbtn);
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Add_Activity.class));

            }
        });
        mydb=new MyDatabaseHelper(MainActivity.this);
        book_id= new ArrayList<>();
        book_title= new ArrayList<>();
        booke_auther= new ArrayList<>();
        book_pages= new ArrayList<>();
        storeallbookinarrays();

        customAdapter= new CustomAdapter(MainActivity.this,book_id ,book_title ,booke_auther, book_pages);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }
    void storeallbookinarrays(){
        Cursor cursor = mydb.ReadAllBook();
        if(cursor.getCount()== 0){
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();

        } else {
            while (cursor.moveToNext()){
                book_id.add(cursor.getString(0));
                book_title.add(cursor.getString(1));
                booke_auther.add(cursor.getString(2));
                book_pages.add(cursor.getString(3));
            }

        }


    }
}

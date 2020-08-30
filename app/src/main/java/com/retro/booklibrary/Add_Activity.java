package com.retro.booklibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Add_Activity extends AppCompatActivity {
    EditText title_input , auther_input , pages_input ;
    Button add_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_);
        title_input=findViewById(R.id.editText_titlee);
        auther_input=findViewById(R.id.editText_auther);
        pages_input=findViewById(R.id.editText_pages);
        add_btn=findViewById(R.id.add_button);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDatabaseHelper =new MyDatabaseHelper(Add_Activity.this);
                myDatabaseHelper.AddBook(title_input.getText().toString().trim() ,
                        auther_input.getText().toString().trim() ,
                        Integer.valueOf(pages_input.getText().toString().trim()));
            }
        });
    }
}

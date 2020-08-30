package com.retro.booklibrary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHOlder> {

    private Context context;
    private ArrayList book_id ,book_title , book_auther ,book_pages ;

    CustomAdapter(Context context ,ArrayList book_id ,ArrayList book_title , ArrayList book_auther , ArrayList book_pages)
    {
        this.context=context;
        this.book_id=book_id;
        this.book_title=book_title;
        this.book_auther=book_auther;
        this.book_pages=book_pages;



    }


    @NonNull
    @Override
    public MyViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
         View view= inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHOlder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHOlder holder, int position) {
        holder.book_id_textview.setText(String.valueOf(book_id.get(position)));
        holder.book_title_textview.setText(String.valueOf(book_title.get(position)));
        holder.book_auther_textview.setText(String.valueOf(book_auther.get(position)));
        holder.book_pages_textview.setText(String.valueOf(book_pages.get(position)));


    }

    @Override
    public int getItemCount() {
        return book_pages.size();
    }

    public class MyViewHOlder extends RecyclerView.ViewHolder {
        TextView book_id_textview , book_title_textview ,book_auther_textview, book_pages_textview;
        public MyViewHOlder(@NonNull View itemView) {
            super(itemView);
            book_id_textview=itemView.findViewById(R.id.book_id_txt);
            book_title_textview=itemView.findViewById(R.id.book_title_txt);
            book_auther_textview=itemView.findViewById(R.id.book_auther_txt);
            book_pages_textview=itemView.findViewById(R.id.book_pages_txt);
        }
    }
}

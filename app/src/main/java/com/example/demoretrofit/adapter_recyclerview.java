package com.example.demoretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class adapter_recyclerview extends RecyclerView.Adapter<adapter_recyclerview.myviewHolder> {
    List<model> data;


    public adapter_recyclerview(List<model> data) {
        this.data = data;

    }

    @NonNull
    @Override
    public myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item,parent,false);

        return new myviewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull myviewHolder holder, int position) {
        holder.text.setText(data.get(position).getCourseName());
        Glide.with(holder.text.getContext()).load(data.get(position).getCourseimg()).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myviewHolder extends RecyclerView.ViewHolder

{
TextView text;
ImageView img;


    public myviewHolder(@NonNull View itemView) {
        super(itemView);
        text=itemView.findViewById(R.id.texte);
        img=itemView.findViewById(R.id.imag);
    }
}
}

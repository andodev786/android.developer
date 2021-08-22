package com.example.demoretrofit;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class adapter_recyclerview extends RecyclerView.Adapter<adapter_recyclerview.myviewHolder> {
    List<model> data;
    Context context;


    public adapter_recyclerview(Context context, List<model> data) {
        this.data = data;
        this.context=context;

    }

    @NonNull
    @Override
    public myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item,parent,false);

        return new myviewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull myviewHolder holder, int position) {
        final model temp=data.get(position);
        holder.text.setText(data.get(position).getCourseName());
        Glide.with(holder.text.getContext()).load(data.get(position).getCourseimg()).into(holder.img);

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                Intent intent=new Intent(context,courses_details.class);
                intent.putExtra("coursename",temp.getCourseName());
                intent.putExtra("imageUrl",temp.getCourseimg());
                intent.putExtra("courseDuration",temp.getCourseTracks());
                intent.putExtra("courseMode",temp.getCourseMode());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myviewHolder extends RecyclerView.ViewHolder

{
@BindView(R.id.texte)
TextView text;
@BindView(R.id.imag)
ImageView img;


    public myviewHolder(@NonNull View itemView) {
        super(itemView);

        ButterKnife.bind(this,itemView);

    }
}
}

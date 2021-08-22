package com.example.demoretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class courses_details extends AppCompatActivity {
String imageUrl;
String courseMode;
String courseTrack;
ImageView imageView;
TextView courseName;
TextView courseDuration;
TextView coursemode;
    //Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_details);
        imageView=(ImageView)findViewById(R.id.imageset);
        courseName=(TextView)findViewById(R.id.courseName);
        courseDuration=(TextView)findViewById(R.id.courseDuration);
         //toolbar = (Toolbar) findViewById(R.id.toolbar);
        coursemode=(TextView)findViewById(R.id.courseMode);
        imageUrl=getIntent().getStringExtra("imageUrl");
        courseTrack=getIntent().getStringExtra("courseDuration");
        courseMode=getIntent().getStringExtra("courseMode");
        Glide.with(this).load(imageUrl).into(imageView);
        courseName.setText(getIntent().getStringExtra("coursename"));
        courseDuration.setText(getIntent().getStringExtra("courseDuration"));
        coursemode.setText(getIntent().getStringExtra("courseMode"));


    }
}

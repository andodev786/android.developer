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

import butterknife.BindView;
import butterknife.ButterKnife;

public class courses_details extends AppCompatActivity {

String imageUrl;
String courseMode;
String courseTrack;
@BindView(R.id.imageset)
ImageView imageView;
@BindView(R.id.courseName)
TextView courseName;
@BindView(R.id.courseDuration)
TextView courseDuration;
@BindView(R.id.courseMode)
TextView coursemode;
@BindView(R.id.back_arrow)
ImageView back_press;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_details);
        ButterKnife.bind(courses_details.this);
        imageUrl=getIntent().getStringExtra("imageUrl");
        courseTrack=getIntent().getStringExtra("courseDuration");
        courseMode=getIntent().getStringExtra("courseMode");
        Glide.with(this).load(imageUrl).into(imageView);
        courseName.setText(getIntent().getStringExtra("coursename"));
        courseDuration.setText(getIntent().getStringExtra("courseDuration"));
        coursemode.setText(getIntent().getStringExtra("courseMode"));
        back_press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(courses_details.this,MainActivity.class);
                startActivity(i);
            }
        });



    }
}

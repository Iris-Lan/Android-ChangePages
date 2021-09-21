package com.blue.ex41;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Integer> imageIds;
    private int index = 0;
    private ImageView imageView;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageIds = new ArrayList<>();
        imageIds.add(R.drawable.panda);
        imageIds.add(R.drawable.rabbit);
        imageIds.add(R.drawable.tomato);
        imageIds.add(R.drawable.ivy);
        imageIds.add(R.drawable.mary);
        imageIds.add(R.drawable.sue);
        handle();
    }

    private void handle() {
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        Button btBack = findViewById(R.id.btBack);
        Button btNext = findViewById(R.id.btNext);
//        imageView.setImageResource(R.drawable.ivy);
        imageView.setImageResource(imageIds.get(index));
        String text = (index + 1) + " / " + imageIds.size();
        textView.setText(text);

        btBack.setOnClickListener(v -> {
            index--;
            show();
        });

        btNext.setOnClickListener(v -> {
            index++;
            show();
        });
    }

    private void show(){
        if(index < 0){
            index = imageIds.size() - 1;
        }else if(index >= imageIds.size()){
            index = 0;
        }
        imageView.setImageResource(imageIds.get(index));
        String str = (index + 1) + " / " + imageIds.size();
        textView.setText(str);
    }

}
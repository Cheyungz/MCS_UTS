package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsDetail extends AppCompatActivity {

    String newsDetailTitle, newsDetailContent;
    int newsDetailImage;

    TextView newsTitle, newsContent;
    ImageView newsImage, backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        newsDetailTitle = getIntent().getStringExtra("title");
        newsDetailContent = getIntent().getStringExtra("content");
        newsDetailImage = getIntent().getIntExtra("image", 0);

        newsTitle = findViewById(R.id.newsDetailTitle);
        newsContent = findViewById(R.id.newsDetailContent);
        newsImage = findViewById(R.id.newsDetailImage);

        newsTitle.setText(newsDetailTitle);
        newsContent.setText(newsDetailContent);
        newsImage.setImageResource(newsDetailImage);

        backArrow =findViewById(R.id.newsDetailBackArrow);
        backArrow.setOnClickListener(v -> {
            finish();
        });
    }
}
package com.mobile_computing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_display);

        Intent intent = getIntent();
        String title_message = intent.getStringExtra(API_Search.TITLE_MESSAGE);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(title_message);

        this.setTitle(title_message);

        String text_message = intent.getStringExtra(API_Search.TEXT_MESSAGE);
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setText(text_message);

        String img_message = intent.getStringExtra(API_Search.IMAGE_MESSAGE);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        new DownLoadImage(imageView).execute(img_message);

        String date_message = intent.getStringExtra(API_Search.DATE_MESSAGE);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(date_message);

        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}


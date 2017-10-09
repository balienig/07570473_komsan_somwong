package com.example.whatsyourgrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultGrade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_grade);

        Intent intent = getIntent();
        String name= intent.getStringExtra("sendName");
        String scoreText= intent.getStringExtra("sendScore");
        TextView showName = (TextView) findViewById(R.id.Name);
        TextView showGrade = (TextView) findViewById(R.id.grade);
        showName.setText(name);
        showGrade.setText(scoreText);
    }
}

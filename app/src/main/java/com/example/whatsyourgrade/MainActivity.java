package com.example.whatsyourgrade;

import android.content.DialogInterface;
import android.content.Intent;
import android.icu.util.IslamicCalendar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText InputName;
    private EditText InputScore;
    private Button FindGrade;
    private Button Exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputName = (EditText) findViewById(R.id.EnterName);
        InputScore = (EditText) findViewById(R.id.EnterScore);
        FindGrade = (Button) findViewById(R.id.findgrade);
        Exit = (Button) findViewById(R.id.exit);
        FindGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (InputName.getText().length() == 0 && InputScore.getText().length() == 0) {

                    InputName.setError("กรุณาป้อนชื่อ");
                    InputScore.setError("กรุณาป้อนคะแนน");
                } else if (InputName.getText().length() == 0) {

                    InputName.setError("กรุณาป้อนชื่อ");
                } else if (InputScore.getText().length() == 0) {
                    InputScore.setError("กรุณาป้อนคะแนน");
                } else {
                    Integer score = Integer.valueOf(InputScore.getText().toString());
                    String name = InputName.getText().toString();
                    String scoreText = cutGrade(score);
                    Intent intent = new Intent((MainActivity.this), ResultGrade.class);
                    intent.putExtra("sendName", name);
                    intent.putExtra("sendScore", scoreText);
                    startActivity(intent);
                }
            }
        });

        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("คุณต้องการปิดแอปไหม?")
                        .setCancelable(false)
                        .setPositiveButton("ใช่", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                MainActivity.this.finish();
                            }
                        })
                        .setNegativeButton("ไม่ใช่", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }

        });


    }


    private String cutGrade(int score) {
        String grade = "";
        if (score < 50) {
            grade = "F";
        } else if (score < 60) {
            grade = "D";
        } else if (score < 70) {
            grade = "C";
        } else if (score < 80 && score <= 100) {
            grade = "B";
        } else {
            grade = "A";
        }
        return grade;
    }
}
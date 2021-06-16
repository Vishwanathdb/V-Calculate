package com.example.vcalculate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button sgpa;
    Button cgpa;
    Button scale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sgpa = findViewById(R.id.sgpabutton);

        sgpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(MainActivity.this,CalculateSgpa.class);
                startActivity(i1);

            }
        });

        cgpa = findViewById(R.id.cgpabutton);

        cgpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(MainActivity.this,CgpaPerSem.class);
                i1.putExtra("word",1);
                i1.putExtra("number",1);
                i1.putExtra("totalCredits",0);
                i1.putExtra("marks",0);
                startActivity(i1);

            }
        });


        scale = findViewById(R.id.scaleButton);

        scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(MainActivity.this,DisplayGrade.class);
                startActivity(i1);
            }
        });

    }
}
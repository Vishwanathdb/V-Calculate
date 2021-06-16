package com.example.vcalculate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CalculateSgpa extends AppCompatActivity {
    Button first,second,third,fourth,fifth,sixth,seventh,eigth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_sgpa);

        first = findViewById(R.id.firstSem);

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(CalculateSgpa.this,SgpaPerSem.class);
                i1.putExtra("number","1");
                i1.putExtra("word","1ST SEM");
                startActivity(i1);

            }
        });

        second = findViewById(R.id.secondSem);

        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(CalculateSgpa.this,SgpaPerSem.class);
                i1.putExtra("number","2");
                i1.putExtra("word","2ND SEM");
                startActivity(i1);

            }
        });

        third = findViewById(R.id.thirdSem);

        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(CalculateSgpa.this,SgpaPerSem.class);
                i1.putExtra("number","3");
                i1.putExtra("word","3RD SEM");
                startActivity(i1);

            }
        });

        fourth = findViewById(R.id.fourthSem);

        fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(CalculateSgpa.this,SgpaPerSem.class);
                i1.putExtra("number","4");
                i1.putExtra("word","4TH SEM");
                startActivity(i1);

            }
        });

       fifth = findViewById(R.id.fifthSem);

        fifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(CalculateSgpa.this,SgpaPerSem.class);
                i1.putExtra("number","5");
                i1.putExtra("word","5TH SEM");
                startActivity(i1);

            }
        });

        sixth = findViewById(R.id.sixthSem);

        sixth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(CalculateSgpa.this,SgpaPerSem.class);
                i1.putExtra("number","6");
                i1.putExtra("word","6TH SEM");
                startActivity(i1);

            }
        });

        seventh = findViewById(R.id.seventhSem);

        seventh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(CalculateSgpa.this,SgpaPerSem.class);
                i1.putExtra("number","7");
                i1.putExtra("word","7TH SEM");
                startActivity(i1);

            }
        });

        eigth = findViewById(R.id.eigthSem);

        eigth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(CalculateSgpa.this,SgpaPerSem.class);
                i1.putExtra("number","8");
                i1.putExtra("word","8TH SEM");
                startActivity(i1);

            }
        });

    }
}
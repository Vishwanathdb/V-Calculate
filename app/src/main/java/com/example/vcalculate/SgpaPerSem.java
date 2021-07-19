package com.example.vcalculate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Stack;

import static android.widget.Toast.*;

public class SgpaPerSem extends AppCompatActivity {

    TextView sem;
    TextView first,second,third,fourth,fifth,sixth,seventh,eigth,ninth;
    Button calculate;
    EditText firstMarks;
    EditText secondMarks;
    EditText thirdMarks;
    EditText fourthMarks;
    EditText fifthMarks;
    EditText sixthMarks;
    EditText seventhMarks;
    EditText eigthMarks;
    EditText ninthMarks;

    HashMap<String,Integer> extraList = new HashMap<String, Integer>();
    Stack<String> stack = new Stack<String>();

    EditText extra,extraMarks;
    TextView subList,marksList;

    Button remove,next,share;

    int number;
    String word;
    double sgpa,percentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sgpa_per_sem);

        Intent intent = getIntent();

          number = Integer.parseInt(intent.getStringExtra("number"));
          word = intent.getStringExtra("word");

          sem = findViewById(R.id.sem);
          sem.setText(word);

          Subjects sub = new Subjects();

          first = findViewById(R.id.first);
          second = findViewById(R.id.second);
          third = findViewById(R.id.third);
          fourth = findViewById(R.id.fourth);
          fifth = findViewById(R.id.fifth);
          sixth = findViewById(R.id.sixth);
          seventh = findViewById(R.id.seventh);
          eigth = findViewById(R.id.eigth);
          ninth = findViewById(R.id.ninth);

          first.setText(sub.subject[number][1]);
          second.setText(sub.subject[number][2]);
          third.setText(sub.subject[number][3]);
          fourth.setText(sub.subject[number][4]);
          fifth.setText(sub.subject[number][5]);
          sixth.setText(sub.subject[number][6]);
          seventh.setText(sub.subject[number][7]);
          eigth.setText(sub.subject[number][8]);
          ninth.setText(sub.subject[number][9]);

          calculate = findViewById(R.id.calculate);

          calculate.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {


                    firstMarks = findViewById(R.id.firstMarks);
                    secondMarks = findViewById(R.id.secondMarks);
                    thirdMarks = findViewById(R.id.thirdMarks);
                    fourthMarks = findViewById(R.id.fourthMarks);
                    fifthMarks = findViewById(R.id.fifthMarks);
                    sixthMarks = findViewById(R.id.sixthMarks);
                    seventhMarks = findViewById(R.id.seventhMarks);
                    eigthMarks = findViewById(R.id.eigthMarks);
                    ninthMarks = findViewById(R.id.ninthMarks);

                  int sub1 = Integer.valueOf(firstMarks.getText().toString().trim().length()!=0 ? firstMarks.getText().toString() : "0" ) * sub.credits.get(sub.subject[number][1]);
                  int sub2 = Integer.valueOf(secondMarks.getText().toString().trim().length()!=0 ? secondMarks.getText().toString() : "0") * sub.credits.get(sub.subject[number][2]);
                  int sub3 = Integer.valueOf(thirdMarks.getText().toString().trim().length()!=0 ? thirdMarks.getText().toString() : "0") * sub.credits.get(sub.subject[number][3]);
                  int sub4 = Integer.valueOf(fourthMarks.getText().toString().trim().length()!=0 ? fourthMarks.getText().toString() : "0") * sub.credits.get(sub.subject[number][4]);
                  int sub5 = Integer.valueOf(fifthMarks.getText().toString().trim().length()!=0 ? fifthMarks.getText().toString() : "0") * sub.credits.get(sub.subject[number][5]);
                  int sub6 = Integer.valueOf(sixthMarks.getText().toString().trim().length()!=0 ? sixthMarks.getText().toString() : "0") * sub.credits.get(sub.subject[number][6]);
                  int sub7 = Integer.valueOf(seventhMarks.getText().toString().trim().length()!=0 ? seventhMarks.getText().toString() : "0") * sub.credits.get(sub.subject[number][7]);
                  int sub8 = Integer.valueOf(eigthMarks.getText().toString().trim().length()!=0 ? eigthMarks.getText().toString() : "0") * sub.credits.get(sub.subject[number][8]);
                  int sub9 = Integer.valueOf(ninthMarks.getText().toString().trim().length()!=0 ? ninthMarks.getText().toString() : "0") * sub.credits.get(sub.subject[number][9]);

                  int marks = 0;

                  double totalCredits = 0;

                  int index=0;
                  for(String key:extraList.keySet())
                  {
                        marks+=sub.credits.get(key) * extraList.get(key);
                        totalCredits+=sub.credits.get(key);
                  }


                  for(int i=1;i<10;i++)
                    totalCredits+=sub.credits.get(sub.subject[number][i]);


                  double totalMarks = sub1 + sub2 + sub3 + sub4 + sub5 + sub6 + sub7 + sub8 + sub9 + marks;

                  sgpa = totalMarks / totalCredits;

                  sgpa = Math.round(sgpa*100.0)/100.0;

                  percentage = Math.round(((sgpa-0.75)*10)*100.0)/100.0;

                  if(percentage<0)
                      percentage=0.0;

                  calculate.setText(word+" SGPA IS  "+sgpa+" ("+percentage+"%)");

                  share = findViewById(R.id.share);
                  share.setEnabled(true);

                }
            });

    }

    public void addSub(View view) {

        extra = findViewById(R.id.extra);
        extraMarks = findViewById(R.id.extraMarks);
        remove = findViewById(R.id.remove);

        if(extra.getText().toString().trim().length()!=0 && extraMarks.getText().toString().trim().length()!=0) {

            if(!extraList.containsKey(extra.getText().toString()))
                stack.push(extra.getText().toString());

            extraList.put(extra.getText().toString(), Integer.valueOf(extraMarks.getText().toString()));


            String subject = "";
            String marks = "";

            for (String key : extraList.keySet()) {
                subject = key + "\n" + subject;
                marks = extraList.get(key) + "\n" + marks;
            }

            subList = findViewById(R.id.subList);
            marksList = findViewById(R.id.marksList);

            subList.setText(subject);
            marksList.setText(marks);

            remove.setEnabled(true);
        }

    }


    public void remSub(View view) {
        String item = stack.pop();
        extraList.remove(item);

        remove = findViewById(R.id.remove);

        String subject = "";
        String marks = "";

        if(stack.isEmpty())
            remove.setEnabled(false);
        else {

            for (String key : extraList.keySet()) {
                subject = key + "\n"+subject;
                marks = extraList.get(key) + "\n"+marks;
            }
        }
        subList = findViewById(R.id.subList);
        marksList = findViewById(R.id.marksList);

        subList.setText(subject);
        marksList.setText(marks);

    }

    public void clear(View view)
    {
        firstMarks = findViewById(R.id.firstMarks);
        secondMarks = findViewById(R.id.secondMarks);
        thirdMarks = findViewById(R.id.thirdMarks);
        fourthMarks = findViewById(R.id.fourthMarks);
        fifthMarks = findViewById(R.id.fifthMarks);
        sixthMarks = findViewById(R.id.sixthMarks);
        seventhMarks = findViewById(R.id.seventhMarks);
        eigthMarks = findViewById(R.id.eigthMarks);
        ninthMarks = findViewById(R.id.ninthMarks);


        firstMarks.setText("");
        secondMarks.setText("");
        thirdMarks.setText("");
        fourthMarks.setText("");
        fifthMarks.setText("");
        sixthMarks.setText("");
        seventhMarks.setText("");
        eigthMarks.setText("");
        ninthMarks.setText("");

        stack.clear();
        extraList.clear();

        subList = findViewById(R.id.subList);
        marksList = findViewById(R.id.marksList);

        subList.setText("No Subject");
        marksList.setText("No Grade");


        calculate = findViewById(R.id.calculate);
        calculate.setText("SEE SGPA");

        remove = findViewById(R.id.remove);
        remove.setEnabled(false);

        share = findViewById(R.id.share);
        share.setEnabled(false);
    }

    public void share(View view)
    {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));//Handled by mails app only
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT,word+" SGPA ");
        intent.putExtra(Intent.EXTRA_TEXT,word+" SGPA IS  "+sgpa+" ("+percentage+"%)");
        if(intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }
    }

}
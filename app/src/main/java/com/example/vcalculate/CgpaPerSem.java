package com.example.vcalculate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Stack;

public class CgpaPerSem extends AppCompatActivity {

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

    double marks,cgpa,percentage;
    double totalCredits,totalMarks;
    String extension="", result="";
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpa_per_sem);

        Intent intent = getIntent();

        number = intent.getIntExtra("number",0);
        int word = intent.getIntExtra("word",0);
        result = intent.getStringExtra("result");

        sem = findViewById(R.id.sem);


        if(word==1) extension = "ST";
        else if(word==2) extension = "ND";
        else if(word==3) extension = "RD";
        else
            extension = "TH";

        sem.setText(word+extension+" SEM");

        Subjects subj = new Subjects();

        first = findViewById(R.id.first);
        second = findViewById(R.id.second);
        third = findViewById(R.id.third);
        fourth = findViewById(R.id.fourth);
        fifth = findViewById(R.id.fifth);
        sixth = findViewById(R.id.sixth);
        seventh = findViewById(R.id.seventh);
        eigth = findViewById(R.id.eigth);
        ninth = findViewById(R.id.ninth);

        first.setText(subj.subject[number][1]);
        second.setText(subj.subject[number][2]);
        third.setText(subj.subject[number][3]);
        fourth.setText(subj.subject[number][4]);
        fifth.setText(subj.subject[number][5]);
        sixth.setText(subj.subject[number][6]);
        seventh.setText(subj.subject[number][7]);
        eigth.setText(subj.subject[number][8]);
        ninth.setText(subj.subject[number][9]);

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

                int[] sub = new int[10];

                sub[1] = Integer.valueOf(firstMarks.getText().toString().trim().length()!=0 ? firstMarks.getText().toString() : "0" ) * subj.credits.get(subj.subject[number][1]);
                sub[2] = Integer.valueOf(secondMarks.getText().toString().trim().length()!=0 ? secondMarks.getText().toString() : "0") * subj.credits.get(subj.subject[number][2]);
                sub[3] = Integer.valueOf(thirdMarks.getText().toString().trim().length()!=0 ? thirdMarks.getText().toString() : "0") * subj.credits.get(subj.subject[number][3]);
                sub[4] = Integer.valueOf(fourthMarks.getText().toString().trim().length()!=0 ? fourthMarks.getText().toString() : "0") * subj.credits.get(subj.subject[number][4]);
                sub[5] = Integer.valueOf(fifthMarks.getText().toString().trim().length()!=0 ? fifthMarks.getText().toString() : "0") * subj.credits.get(subj.subject[number][5]);
                sub[6] = Integer.valueOf(sixthMarks.getText().toString().trim().length()!=0 ? sixthMarks.getText().toString() : "0") * subj.credits.get(subj.subject[number][6]);
                sub[7] = Integer.valueOf(seventhMarks.getText().toString().trim().length()!=0 ? seventhMarks.getText().toString() : "0") * subj.credits.get(subj.subject[number][7]);
                sub[8] = Integer.valueOf(eigthMarks.getText().toString().trim().length()!=0 ? eigthMarks.getText().toString() : "0") * subj.credits.get(subj.subject[number][8]);
                sub[9] = Integer.valueOf(ninthMarks.getText().toString().trim().length()!=0 ? ninthMarks.getText().toString() : "0") * subj.credits.get(subj.subject[number][9]);


                marks = intent.getDoubleExtra("marks",0);
                totalCredits = intent.getDoubleExtra("totalCredits",0);


                int index=0;
                for(String key:extraList.keySet())
                {
                    int sum=subj.credits.get(key) * extraList.get(key);
                    marks+=sum;
                    if(sum!=0)
                        totalCredits+=subj.credits.get(key);
                }


                for(int i=1;i<10;i++) {

                    if(sub[i]!=0)
                    totalCredits += subj.credits.get(subj.subject[number][i]);
                }


                totalMarks = sub[1] + sub[2] + sub[3] + sub[4] + sub[5] + sub[6] + sub[7] + sub[8] + sub[9] + marks;

                cgpa = totalMarks / totalCredits;

                cgpa = Math.round(cgpa*100.0)/100.0;

                percentage = Math.round(((cgpa-0.75)*10)*100.0)/100.0;

                if(percentage<0)
                    percentage=0.0;

                calculate.setText(word+extension+" SEM CGPA IS  "+cgpa+" ("+percentage+"%)");

                next = findViewById(R.id.next);
                next.setEnabled(true);
                share = findViewById(R.id.share);
                share.setEnabled(true);

            }
        });


        next = findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(CgpaPerSem.this,CgpaPerSem.class);
                i1.putExtra("word",(word+1));
                i1.putExtra("number",(number+1));
                i1.putExtra("totalCredits",(totalCredits));
                i1.putExtra("marks",(totalMarks));
                i1.putExtra("result",result+number+" "+ extension+" SEM CGPA IS "+cgpa+" ("+percentage+"%)"+"\n");
                startActivity(i1);

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

        if(stack.isEmpty())
            remove.setEnabled(false);

        String subject="";
        String marks="";

        for(String key : extraList.keySet())
        {
            subject=key + "\n" + subject;
            marks=extraList.get(key) +"\n"+marks;
        }

        if(subject.length()==0)
            subject="No Subject";

        if(marks.length()==0)
            marks="No Grade";

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


        next = findViewById(R.id.next);
        next.setEnabled(false);

        calculate = findViewById(R.id.calculate);
        calculate.setText("SEE CGPA");

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
        intent.putExtra(Intent.EXTRA_SUBJECT,"CGPA Till "+ number + extension+" SEM");
        intent.putExtra(Intent.EXTRA_TEXT,result+number+" "+ extension+" SEM CGPA IS "+cgpa+" ("+percentage+"%)"+"\n");
        if(intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }
    }

}
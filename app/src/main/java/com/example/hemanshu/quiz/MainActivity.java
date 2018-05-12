package com.example.hemanshu.quiz;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    RadioGroup que1Radio;
    RadioGroup que2Radio;
    EditText que3EditText;
    RadioGroup que4Radio;
    CheckBox cb1;
    CheckBox cb2;
    CheckBox cb3;
    CheckBox cb4;
    RadioGroup que6Radio;

    //CardView
    CardView que1;
    CardView que2;
    CardView que3;
    CardView que4;
    CardView que5;
    CardView que6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        que1Radio = findViewById(R.id.Que1_Radio);
        que2Radio = findViewById(R.id.Que2_Radio);
        que3EditText = findViewById(R.id.Ques3_EditText);
        que4Radio = findViewById(R.id.Que4_Radio);
        cb1 = findViewById(R.id.Que5_CB1);
        cb2 = findViewById(R.id.Que5_CB2);
        cb3 = findViewById(R.id.Que5_CB3);
        cb4 = findViewById(R.id.Que5_CB4);
        que6Radio = findViewById(R.id.Que6_Radio);
        que1 = findViewById(R.id.Que1_CardView);
        que2 = findViewById(R.id.Que2_CardView);
        que3 = findViewById(R.id.Que3_CardView);
        que4 = findViewById(R.id.Que4_CardView);
        que5 = findViewById(R.id.Que5_CardView);
        que6 = findViewById(R.id.Que6_CardView);

    }

    public void Reset(View view) {
        //Question 1
        que1Radio.clearCheck();
        //Question 2
        que2Radio.clearCheck();
        //Question 3
        que3EditText.getText().clear();
        //Question 4
        que4Radio.clearCheck();
        //Question 5
        if (cb1.isChecked() || cb2.isChecked() || cb3.isChecked() || cb4.isChecked()) {
            cb1.setChecked(false);
            cb2.setChecked(false);
            cb3.setChecked(false);
            cb4.setChecked(false);
        }
        //Question 6
        que6Radio.clearCheck();
        //Resetting Colors of CardView's
        que1.setBackgroundColor(Color.parseColor("#FAFAFA"));
        que2.setBackgroundColor(Color.parseColor("#FAFAFA"));
        que3.setBackgroundColor(Color.parseColor("#FAFAFA"));
        que4.setBackgroundColor(Color.parseColor("#FAFAFA"));
        que5.setBackgroundColor(Color.parseColor("#FAFAFA"));
        que6.setBackgroundColor(Color.parseColor("#FAFAFA"));

        //Resetting Score
        score = 0;

        //Toast when quiz is Reset
        Toast.makeText(MainActivity.this, R.string.toast, Toast.LENGTH_SHORT).show();
    }

    public void Result(View view) {
        try {
            //Question 1
            String ans1 = ((RadioButton) findViewById(que1Radio.getCheckedRadioButtonId())).getText().toString();
            if (ans1.equals("GreyHound")) {
                score+= 1;
                que1.setBackgroundColor(Color.parseColor("#C8E6C9")); //Green 100
            } else {
                que1.setBackgroundColor(Color.parseColor("#FFCDD2")); //Red 100
            }

            //Question 2
            String ans2 = ((RadioButton) findViewById(que2Radio.getCheckedRadioButtonId())).getText().toString();
            if (ans2.equals("Basenji")) {
                score+= 1;
                que2.setBackgroundColor(Color.parseColor("#C8E6C9")); //Green 100
            } else {
                que2.setBackgroundColor(Color.parseColor("#FFCDD2")); //Red 100
            }

            //Question 3
            if(que3EditText.getText().toString().equalsIgnoreCase("Saluki")){
                score+= 1;
                que3.setBackgroundColor(Color.parseColor("#C8E6C9")); //Green 100
            } else {
            que3.setBackgroundColor(Color.parseColor("#FFCDD2")); //Red 100
        }

            //Question 4
            String ans4 = ((RadioButton) findViewById(que4Radio.getCheckedRadioButtonId())).getText().toString();
            if (ans4.equals("Mastiff")) {
                score+= 1;
                que4.setBackgroundColor(Color.parseColor("#C8E6C9")); //Green 100
            } else {
                que4.setBackgroundColor(Color.parseColor("#FFCDD2")); //Red 100
            }

            //Question 5
            boolean q5CB1 = cb1.isChecked();
            boolean q5CB2 = cb2.isChecked();
            boolean q5CB3 = cb3.isChecked();
            boolean q5CB4 = cb4.isChecked();
            boolean rightCB = q5CB1 && q5CB2 && q5CB4;
            boolean wrongCB = q5CB3;
            if(rightCB && !wrongCB){
                score+= 1;
                que5.setBackgroundColor(Color.parseColor("#C8E6C9")); //Green 100
            } else {
                que5.setBackgroundColor(Color.parseColor("#FFCDD2")); //Red 100
            }

            //Question 6
            String ans6 = ((RadioButton) findViewById(que6Radio.getCheckedRadioButtonId())).getText().toString();
            if (ans6.equals("Yes")) {
                score+= 1;
                que6.setBackgroundColor(Color.parseColor("#C8E6C9")); //Green 100
            } else {
                que6.setBackgroundColor(Color.parseColor("#FFCDD2")); //Red 100
            }


            //Result
            Toast.makeText(MainActivity.this, getString(R.string.resultScore) + score, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, getString(R.string.error), Toast.LENGTH_LONG).show();
        }
    }
}

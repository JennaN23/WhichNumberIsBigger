package com.example.whichnumberisbigger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonLeft;
    private Button buttonRight;
    private TextView textViewScore;
    private int score;
    private int leftNum;
    private int rightNum;
    public static final int MAX_NUM = 1000;
    public static final int MIN_NUM = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();
        randomizeAndUpdateDisplay();
    }

    private void randomizeAndUpdateDisplay() {
        String scoreString = getResources().getString(R.string.main_score);
        textViewScore.setText(scoreString + score);
        randomizeNumbers();
        buttonLeft.setText(String.valueOf(leftNum));
        buttonRight.setText(String.valueOf(rightNum));

    }
    private int genNumber(){
        int range = MAX_NUM - MIN_NUM + 1;
        return MIN_NUM + (int)(Math.random() * range);
    }

    private void randomizeNumbers() {
        int range = MAX_NUM - MIN_NUM + 1;
        leftNum = MIN_NUM + (int)(Math.random() * range);
        rightNum = MIN_NUM + (int)(Math.random() * range);
        while(leftNum == rightNum){
            rightNum = genNumber();

        }

    }

    private void wireWidgets() {
        buttonLeft = findViewById(R.id.button_main_left);
        buttonRight = findViewById(R.id.button_main_right);
        textViewScore = findViewById(R.id.textview_main_score);
    }


    public void onRightClick(View view) {
        if(rightNum > leftNum){
            score++;
            Toast.makeText(this, "Good job!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            score--;
            Toast.makeText(this, "Try again.", Toast.LENGTH_SHORT).show();
        }
        randomizeAndUpdateDisplay();

    }

    public void onLeftClick(View view) {
        if(rightNum < leftNum){
            score++;
            Toast.makeText(this, "Good job!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            score--;
            Toast.makeText(this, "Try again.", Toast.LENGTH_SHORT).show();
        }
        randomizeAndUpdateDisplay();

    }
}

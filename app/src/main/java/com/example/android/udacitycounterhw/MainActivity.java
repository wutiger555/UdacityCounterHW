package com.example.android.udacitycounterhw;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textTimer;

    private Button StartTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing the views
        textTimer = (TextView) findViewById(R.id.mtextTimer);

        StartTimer = (Button) findViewById(R.id.buttonSend);

        StartTimer.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {


        long maxTimeInMilliseconds = 60000;// in your case

        startTimer(maxTimeInMilliseconds, 1000);

    }

    public void startTimer(final long finish, long tick) {
        CountDownTimer t;
        t = new CountDownTimer(finish, tick) {

            public void onTick(long millisUntilFinished) {
                long remainedSecs = millisUntilFinished / 1000;
                textTimer.setText("" + (remainedSecs / 60) + ":" + (remainedSecs % 60));// manage it accordign to you
            }

            public void onFinish() {
                textTimer.setText("00:00:00");
                Toast.makeText(MainActivity.this, "Finish", Toast.LENGTH_SHORT).show();

                cancel();
            }
        }.start();
    }
    int scoreTeamA=0;
    int scoreTeamB=0;

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        scoreTeamA ++;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void addTwoForTeamA(View v) {
        scoreTeamA += 2;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    public void minusOneForTeamA(View v) {
        scoreTeamA --;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Displays the given score for Team A.
     */
    private void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given score for Team B.
     */
    private void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    public void addThreeForTeamB(View v){
        scoreTeamB+=3;
        displayForTeamB(scoreTeamB);
    }
    public void addTwoForTeamB(View v){
        scoreTeamB+=2;
        displayForTeamB(scoreTeamB);
    }
    public void minusOneForTeamB(View v){
        scoreTeamB--;
        displayForTeamB(scoreTeamB);
    }
    public void resetScore(View v){
        scoreTeamA=0;
        scoreTeamB=0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
}



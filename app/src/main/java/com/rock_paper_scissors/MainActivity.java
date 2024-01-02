package com.rock_paper_scissors;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btn_rock, btn_scissors, btn_paper;
    TextView  c_score, y_score;
    ImageView img_computerChoice, img_humanChoice;

    int HumanScore,ComputerScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        btn_paper = (Button) findViewById(R.id.btn_paper);
        btn_scissors = (Button) findViewById(R.id.btn_scissors);
        btn_rock = (Button) findViewById(R.id.btn_rock);

        img_computerChoice = (ImageView) findViewById(R.id.img_computerChoice);
        img_humanChoice = (ImageView) findViewById(R.id.img_humanChoice);

        c_score = (TextView) findViewById(R.id.c_score);
        y_score = (TextView) findViewById(R.id.y_score);

        btn_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_humanChoice.setImageResource(R.drawable.paper);
                String message = play_turn("paper");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                c_score.setText(Integer.toString(ComputerScore));
                y_score.setText(Integer.toString(HumanScore));
            }
        });

        btn_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_humanChoice.setImageResource(R.drawable.scissors);
                String message = play_turn("scissors");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                c_score.setText(Integer.toString(ComputerScore));
                y_score.setText(Integer.toString(HumanScore));
            }
        });

        btn_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_humanChoice.setImageResource(R.drawable.rock);
                String message = play_turn("rock");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                c_score.setText(Integer.toString(ComputerScore));
                y_score.setText(Integer.toString(HumanScore));
            }
        });
        if(savedInstanceState !=null)
        {
           ComputerScore = savedInstanceState.getInt("Computer");
           c_score.setText(String.valueOf(ComputerScore));
            HumanScore = savedInstanceState.getInt("You");
            y_score.setText(String.valueOf(HumanScore));
        }
    }

    public String play_turn(String player_choice){
        String computer_choice="";
        Random r = new Random();

        int computer_choice_num = r.nextInt(3)+1;

        if(computer_choice_num == 1)
        {
            computer_choice="rock";
        } else if (computer_choice_num == 2){
            computer_choice="scissors";
        } else if (computer_choice_num == 3){
            computer_choice="paper";
        }

        if(computer_choice =="rock") {
            img_computerChoice.setImageResource(R.drawable.rock);
        } else if (computer_choice =="scissors"){
            img_computerChoice.setImageResource(R.drawable.scissors);
        } else if (computer_choice =="paper"){
            img_computerChoice.setImageResource(R.drawable.paper);
        }

        if(computer_choice == player_choice){
            return "Draw";
        } else if (player_choice == "rock" && computer_choice == "scissors") {
            HumanScore++;
            return "You Wins!!";
        }
        else if (player_choice == "rock" && computer_choice == "paper") {
            ComputerScore++;
            return "Computer Wins!!";
        }
        else if (player_choice == "scissors" && computer_choice == "rock") {
            ComputerScore++;
            return "Computer Wins!!";
        }
        else if (player_choice == "scissors" && computer_choice == "paper") {
            HumanScore++;
            return "You Wins!!";
        }
        else if (player_choice == "paper" && computer_choice == "rock") {
            HumanScore++;
            return "Computer Wins!!";
        }
        else if (player_choice == "paper" && computer_choice == "scissors") {
            ComputerScore++;
            return "Computer Wins!!";
        }
        else return "Not Sure";
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Computer",ComputerScore);
        outState.putInt("You",HumanScore);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }
}
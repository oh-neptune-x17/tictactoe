package com.example.tictactoe;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class TicTacToe extends AppCompatActivity implements View.OnClickListener {

    boolean player = true;
    int steps=0;
    int taken[] = {R.id.top1, R.id.top2, R.id.top3,
            R.id.mid1, R.id.mid2, R.id.mid3,
            R.id.bot1, R.id.bot2, R.id.bot3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TicTacToe.super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        int ids[] = {R.id.top1, R.id.top2, R.id.top3,
                R.id.mid1, R.id.mid2, R.id.mid3,
                R.id.bot1, R.id.bot2, R.id.bot3};

        for (int i : ids) {
            Button b = findViewById(i);
            b.setOnClickListener(this);
        }
    }

    public boolean winCondition() {

        if ((taken[0] == (taken[1])) && (taken[1] == (taken[2]))) {
            if (taken[0] == 0) {
                return false;
            }
            return true;
        } else if ((taken[3] == (taken[4])) && (taken[4] == (taken[5]))) {
            if (taken[3] == 0) {
                return false;
            }
            return true;
        } else if ((taken[6] == (taken[7])) && (taken[7] == (taken[8]))) {
            if (taken[6] == 0) {
                return false;
            }
            return true;
        } else if ((taken[0] == (taken[3])) && (taken[3] == (taken[6]))) {
            if (taken[0] == 0) {
                return false;
            }
            return true;
        } else if ((taken[1] == (taken[4])) && (taken[4] == (taken[7]))) {
            if (taken[0] == 0) {
                return false;
            }
            return true;
        } else if ((taken[2] == (taken[5])) && (taken[5] == (taken[8]))) {
            if (taken[0] == 0) {
                return false;
            }
            return true;
        } else if ((taken[0] == (taken[4])) && (taken[4] == (taken[8]))) {
            if (taken[0] == 0) {
                return false;
            }
            return true;
        } else if ((taken[2] == (taken[4])) && (taken[4] == (taken[6]))) {
            if (taken[0] == 0) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {


        int clickedButton = v.getId();
        Button b = findViewById(clickedButton);
        b.setClickable(false);

        if (player) {
            b.setText(R.string.O);
            player = false;
            steps++;
            if(steps==9&&!winCondition()){
                alertDialog((String) getText(R.string.remis));
            }
            for (int i = 0; i < 9; i++) {
                if (taken[i] == clickedButton) {
                    taken[i] = 1;
                    if (winCondition()) {
                        alertDialog((String) getText(R.string.winnero));
                    }
                }
            }
        } else {
            steps++;
            b.setText(R.string.X);
            player = true;
            if(steps==9&&!winCondition()){
                alertDialog((String) getText(R.string.remis));
            }
            for (int i = 0; i < 9; i++) {
                if (taken[i] == clickedButton) {
                    taken[i] = 2;
                    if (winCondition()) {
                       alertDialog((String) getText(R.string.winnerx));
                    }
                }
            }


        }
    }


    private void alertDialog(String a) {
        AlertDialog.Builder dialogBuild = new AlertDialog.Builder(this);
        dialogBuild.setTitle(getText(R.string.koniecgry)+ " " +a);
        dialogBuild.setMessage(R.string.playagain);
        dialogBuild.setCancelable(false);
        dialogBuild.setPositiveButton(R.string.tak, new Dialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TicTacToe.super.recreate();
            }
        });
        dialogBuild.setNegativeButton(R.string.nie, new Dialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TicTacToe.super.finish();
            }
        });
        dialogBuild.create();
        dialogBuild.show();
    }
}

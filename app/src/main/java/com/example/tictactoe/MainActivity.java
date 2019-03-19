package com.example.tictactoe;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public void start(View v) {
        Intent intent = new Intent(this, com.example.tictactoe.TicTacToe.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button tictac= findViewById(R.id.starttictac);
        Button website = findViewById(R.id.website);


        website.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String url = "http://weka.pwr.edu.pl";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        tictac.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                start(v);
            }
        });


    }
}


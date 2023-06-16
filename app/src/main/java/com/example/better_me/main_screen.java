package com.example.better_me;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.widget.Button;

public class main_screen extends AppCompatActivity {
private Button Button,Button1,Button2,Button3,Button4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        getSupportActionBar().hide();
       Button = (Button) findViewById(R.id.button);
       Button1 = (Button) findViewById(R.id.button2);
       Button2= (Button) findViewById(R.id.button3);
       Button3 = (Button) findViewById(R.id.button4);
       Button4=(Button) findViewById(R.id.button5);
                Button2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               opencleanse();
           }
       });
                Button4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        opentodo();
                    }
                });
       Button3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               openunplug();
           }
       });
       Button1.setOnClickListener((new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               openworkout();
           }
       }));
       Button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               openselfcare();
           }
       });

    }
    public void opentodo(){
        Intent intent = new Intent(this,todo.class);
        startActivity(intent);
    }
    public void  opencleanse(){
        Intent intent=new Intent(this,cleanse_page.class);
        startActivity(intent);
    }
    public void openselfcare(){
        Intent intent=new Intent(this,selfcare_page.class);
        startActivity(intent);
    }
    public void openunplug(){
        Intent intent=new Intent(this,unplug_page.class);
        startActivity(intent);
    }
    public void openworkout(){
        Intent intent=new Intent(this,workout_page.class);
        startActivity(intent);
    }

}
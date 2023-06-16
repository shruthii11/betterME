package com.example.better_me;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class cleanse_page2 extends AppCompatActivity {
    private android.widget.Button savebtn;
    private CheckBox day12, day13, day14, day15, day16, day17, day18, day19, day20, day21;
    private SharedPreferences sharedPreferences;


    @Override
    protected void onResume() {
        super.onResume();
        getSupportActionBar().hide();
        sharedPreferences = getSharedPreferences("NewPrefs", MODE_PRIVATE);
        boolean isChecked1 = sharedPreferences.getBoolean("checkbox12", false);
        boolean isChecked2 = sharedPreferences.getBoolean("checkbox13", false);
        boolean isChecked3 = sharedPreferences.getBoolean("checkbox14", false);
        boolean isChecked4 = sharedPreferences.getBoolean("checkbox15", false);
        boolean isChecked5 = sharedPreferences.getBoolean("checkbox16", false);
        boolean isChecked6 = sharedPreferences.getBoolean("checkbox17", false);
        boolean isChecked7 = sharedPreferences.getBoolean("checkbox18", false);
        boolean isChecked8 = sharedPreferences.getBoolean("checkbox19", false);
        boolean isChecked9 = sharedPreferences.getBoolean("checkbox20", false);
        boolean isChecked10 = sharedPreferences.getBoolean("checkbox21", false);

        day12.setChecked(isChecked1);
        day13.setChecked(isChecked2);
        day14.setChecked(isChecked3);
        day15.setChecked(isChecked4);
        day16.setChecked(isChecked5);
        day17.setChecked(isChecked6);
        day18.setChecked(isChecked7);
        day19.setChecked(isChecked8);
        day20.setChecked(isChecked9);
        day21.setChecked(isChecked10);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleanse_page2);
        getSupportActionBar().hide();
        day12 = findViewById(R.id.day12);
        day13 = findViewById(R.id.day13);
        day14 = findViewById(R.id.day14);
        day15 = findViewById(R.id.day15);
        day16 = findViewById(R.id.day16);
        day17 = findViewById(R.id.day17);
        day18 = findViewById(R.id.day18);
        day19 = findViewById(R.id.day19);
        day20 = findViewById(R.id.day20);
        day21 = findViewById(R.id.day21);
        savebtn = findViewById(R.id.savebtn2);

        sharedPreferences = getSharedPreferences("NewPrefs", MODE_PRIVATE);

        // Restore checkbox states
        onResume();

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSaveButtonClicked(view);
            }
        });
    }

    public void onSaveButtonClicked(View view) {
        boolean isChecked1 = day12.isChecked();
        boolean isChecked2 = day13.isChecked();
        boolean isChecked3 = day14.isChecked();
        boolean isChecked4 = day15.isChecked();
        boolean isChecked5 = day16.isChecked();
        boolean isChecked6 = day17.isChecked();
        boolean isChecked7 = day18.isChecked();
        boolean isChecked8 = day19.isChecked();
        boolean isChecked9 = day20.isChecked();
        boolean isChecked10 = day21.isChecked();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("checkbox12", isChecked1);
        editor.putBoolean("checkbox13", isChecked2);
        editor.putBoolean("checkbox14", isChecked3);
        editor.putBoolean("checkbox15", isChecked4);
        editor.putBoolean("checkbox16", isChecked5);
        editor.putBoolean("checkbox17", isChecked6);
        editor.putBoolean("checkbox18", isChecked7);
        editor.putBoolean("checkbox19", isChecked8);
        editor.putBoolean("checkbox20", isChecked9);
        editor.putBoolean("checkbox21", isChecked10);
        editor.apply();

        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
    }


}
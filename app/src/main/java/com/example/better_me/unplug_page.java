package com.example.better_me;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.better_me.R;

public class unplug_page extends AppCompatActivity {
    private Button frontbtn,savebtn;
    private CheckBox day1, day2, day3, day4, day5, day6, day7, day8, day9, day10, day11;
    private SharedPreferences sharedPreferences;
    private SharedPreferences customSharedPreferences; // New shared preferences object
    int i = 0;

    @Override
    protected void onResume() {
        super.onResume();
        customSharedPreferences = getSharedPreferences("CustomPrefs", MODE_PRIVATE); // Initialize the new shared preferences object
        boolean isChecked1 = customSharedPreferences.getBoolean("checkbox1", false);
        boolean isChecked2 = customSharedPreferences.getBoolean("checkbox2", false);
        boolean isChecked3 = customSharedPreferences.getBoolean("checkbox3", false);
        boolean isChecked4 = customSharedPreferences.getBoolean("checkbox4", false);
        boolean isChecked5 = customSharedPreferences.getBoolean("checkbox5", false);
        boolean isChecked6 = customSharedPreferences.getBoolean("checkbox6", false);
        boolean isChecked7 = customSharedPreferences.getBoolean("checkbox7", false);
        boolean isChecked8 = customSharedPreferences.getBoolean("checkbox8", false);
        boolean isChecked9 = customSharedPreferences.getBoolean("checkbox9", false);
        boolean isChecked10 = customSharedPreferences.getBoolean("checkbox10", false);
        boolean isChecked11 = customSharedPreferences.getBoolean("checkbox11", false);

        day1.setChecked(isChecked1);
        day2.setChecked(isChecked2);
        day3.setChecked(isChecked3);
        day4.setChecked(isChecked4);
        day5.setChecked(isChecked5);
        day6.setChecked(isChecked6);
        day7.setChecked(isChecked7);
        day8.setChecked(isChecked8);
        day9.setChecked(isChecked9);
        day10.setChecked(isChecked10);
        day11.setChecked(isChecked11);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unplug_page);
        getSupportActionBar().hide();
        day1 = findViewById(R.id.day11);
        day2 = findViewById(R.id.day22);
        day3 = findViewById(R.id.day33);
        day4 = findViewById(R.id.day44);
        day5 = findViewById(R.id.day55);
        day6 = findViewById(R.id.day66);
        day7 = findViewById(R.id.day77);
        day8 = findViewById(R.id.day88);
        day9 = findViewById(R.id.day99);
        day10 = findViewById(R.id.day100);
        day11 = findViewById(R.id.day111);
        frontbtn = findViewById(R.id.frontbtn);
        savebtn = findViewById(R.id.savebtn);

        customSharedPreferences = getSharedPreferences("CustomPrefs", MODE_PRIVATE); // Initialize the new shared preferences object

        // Restore checkbox states
        onResume();

        frontbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gonext();
            }
        });

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSaveButtonClicked(view);
            }
        });
    }

    public void onSaveButtonClicked(View view) {
        boolean isChecked1 = day1.isChecked();
        boolean isChecked2 = day2.isChecked();
        boolean isChecked3 = day3.isChecked();
        boolean isChecked4 = day4.isChecked();
        boolean isChecked5 = day5.isChecked();
        boolean isChecked6 = day6.isChecked();
        boolean isChecked7 = day7.isChecked();
        boolean isChecked8 = day8.isChecked();
        boolean isChecked9 = day9.isChecked();
        boolean isChecked10 = day10.isChecked();
        boolean isChecked11 = day11.isChecked();

        SharedPreferences.Editor editor = customSharedPreferences.edit(); // Use the new shared preferences object
        editor.putBoolean("checkbox1", isChecked1);
        editor.putBoolean("checkbox2", isChecked2);
        editor.putBoolean("checkbox3", isChecked3);
        editor.putBoolean("checkbox4", isChecked4);
        editor.putBoolean("checkbox5", isChecked5);
        editor.putBoolean("checkbox6", isChecked6);
        editor.putBoolean("checkbox7", isChecked7);
        editor.putBoolean("checkbox8", isChecked8);
        editor.putBoolean("checkbox9", isChecked9);
        editor.putBoolean("checkbox10", isChecked10);
        editor.putBoolean("checkbox11", isChecked11);
        editor.apply();

        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
    }

    public void gonext() {
        Intent intent = new Intent(unplug_page.this, unplug_page2.class);
        startActivity(intent);
    }
}

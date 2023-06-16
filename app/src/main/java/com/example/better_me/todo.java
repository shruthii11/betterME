package com.example.better_me;

import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;
import java.util.Set;

public class todo extends AppCompatActivity {

    private LinearLayout linearLayoutTodoList;
    private EditText editTextTodo;
    private Button buttonAdd, buttonDelete;

    private Set<String> todoSet;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        getSupportActionBar().hide();
        linearLayoutTodoList = findViewById(R.id.linearLayoutTodoList);
        editTextTodo = findViewById(R.id.editTextTodo);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonDelete = findViewById(R.id.buttonDelete);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        todoSet = sharedPreferences.getStringSet("todoSet", new HashSet<>());

        for (String todo : todoSet) {
            addTodoItem(todo);
        }

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String todoText = editTextTodo.getText().toString().trim();
                if (!todoText.isEmpty()) {
                    addTodoItem(todoText);
                    editTextTodo.setText("");
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putStringSet("todoSet", todoSet);
        editor.apply();
    }

    private void addTodoItem(String todoText) {
        final View todoView = getLayoutInflater().inflate(R.layout.todo_item, null);

        TextView textViewTodo = todoView.findViewById(R.id.textViewTodo);
        textViewTodo.setText(todoText);

        final CheckBox checkBoxDone = todoView.findViewById(R.id.checkBoxDone);
        checkBoxDone.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                textViewTodo.setPaintFlags(textViewTodo.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            } else {
                textViewTodo.setPaintFlags(textViewTodo.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
            }
        });

        Button buttonDelete1 = todoView.findViewById(R.id.buttonDelete);
        buttonDelete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayoutTodoList.removeView(todoView);
                todoSet.remove(todoText);
            }
        });

        linearLayoutTodoList.addView(todoView);
        todoSet.add(todoText);
    }
}

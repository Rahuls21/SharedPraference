package com.rahul.sharedpraference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);

        //On click listener on button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //on clicking on button get the string from edit text and store it in a msg string
                String msg = editText.getText().toString();

                //Object of shared preferences
                SharedPreferences shrd = getSharedPreferences("demo", MODE_PRIVATE);
                SharedPreferences.Editor editor = shrd .edit();

                editor.putString("str",msg);
                editor.apply();
                textView.setText(msg);


            }
        });

        //Get the value of shared preference back
        SharedPreferences getShared = getSharedPreferences("demo",MODE_PRIVATE);
        String value = getShared.getString("str", "Save a note and it will show up here");
        textView.setText(value);
    }

}
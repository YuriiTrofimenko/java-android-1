package org.tyaa.helloapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String text = "text 1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Restore state
        if (savedInstanceState != null) {
            String oldText = savedInstanceState.getString("oldText");
            if (oldText != null) {
                text = oldText;
            }
        }
        setContentView(R.layout.activity_main);
        Log.i("tyaa", "My Info 1");

        final EditText mainEditText = findViewById(R.id.mainEditText);

        Button pressMeButton = findViewById(R.id.pressMeButton);
        pressMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView firstLabelTextView = findViewById(R.id.firstLabelTextView);
                firstLabelTextView.setText(getResources().getString(R.string.hello_android_2));
                text = mainEditText.getText().toString();
            }
        });

        Button pressMeButton2 = findViewById(R.id.pressMeButton2);
        pressMeButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("oldText", text);
    }
}
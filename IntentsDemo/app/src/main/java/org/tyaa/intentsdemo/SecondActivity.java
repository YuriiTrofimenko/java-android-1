package org.tyaa.intentsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String userName =
            getIntent().getStringExtra("userName");
        if (userName != null) {
            Toast.makeText(this, "Hello, " + userName, Toast.LENGTH_LONG).show();
        }
    }
}
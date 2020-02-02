package org.tyaa.intentsdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String USER_NAME_EXTRA = "org.tyaa.intentsdemo.MainActivity.USER_NAME_EXTRA";
    private String userName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.clickMeButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =
                        new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(USER_NAME_EXTRA, userName);
                startActivityForResult(intent, 0);
            }
        });

        EditText nameEditText =
                findViewById(R.id.nameEditText);
        nameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                userName = s.toString();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode){
                case 0: {
                    if (data != null) {
                        Toast.makeText(this, "Reply: " + data.getStringExtra("reply"), Toast.LENGTH_LONG).show();
                    }
                }
            }
        }
    }
}
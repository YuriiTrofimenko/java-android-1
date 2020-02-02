package org.tyaa.intentsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    public static final String REPLY_EXTRA = "org.tyaa.intentsdemo.SecondActivity.REPLY_EXTRA";
    private String reply = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String userName =
            getIntent().getStringExtra(MainActivity.USER_NAME_EXTRA);
        if (userName != null) {
            Toast.makeText(this, "Hello, " + userName, Toast.LENGTH_LONG).show();
        }

        EditText replyEditText =
                findViewById(R.id.replyEditText);
        replyEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                reply = s.toString();
                if (!reply.isEmpty()) {
                    Intent intent = new Intent();
                    intent.putExtra(REPLY_EXTRA, reply);
                    setResult(RESULT_OK, intent);
                } else {
                    setResult(RESULT_CANCELED);
                }
            }
        });

        Button comeBackButton = findViewById(R.id.comeBackButton);
        comeBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondActivity.this.finish();
            }
        });
    }


}
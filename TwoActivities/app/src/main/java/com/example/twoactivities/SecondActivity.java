package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = SecondActivity.class.getName();
    private static final String LOG_TAG = SecondActivity.class.getName();

    private EditText mReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.d(LOG_TAG, "-------------------------------");
        Log.d(LOG_TAG, "onCreate");

        mReply = findViewById(R.id.editText_second);

        // Second Activity'yi baslatan intent i getirir.
        Intent intent = getIntent();

        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.text_message);

        textView.setText(message);
    }

    public void returnReply(View view) {
        Log.d(LOG_TAG, "End SecondActivity");

        String reply = mReply.getText().toString();

        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);

        setResult(RESULT_OK, replyIntent);

        finish();
    }
}

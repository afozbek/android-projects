package com.example.simpleasynctask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Key for saving the state of the TextView
    private static final String TEXT_STATE = "currentText";

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView1);

        if(savedInstanceState != null) {
            mTextView.setText(savedInstanceState.getInt(TEXT_STATE));
        }
    }

    public void startTask(View view) {
        mTextView.setText(R.string.napping);

        new SimpleAsyncTask(mTextView).execute();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the state of the TextView
        outState.putString(TEXT_STATE, mTextView.getText().toString());
    }
}

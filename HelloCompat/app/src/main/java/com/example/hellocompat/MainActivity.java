package com.example.hellocompat;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView mHelloTextView;
    private Random random;

    // All Of The Colors' Keys
    private String[] mColorArray = {"red", "pink", "purple", "deep_purple",
            "indigo", "blue", "light_blue", "cyan", "teal", "green",
            "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
            "brown", "grey", "blue_grey", "black" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random = new Random(); // new Random instance
        mHelloTextView = findViewById(R.id.hello_textview);

        // restore saved instance state (the text color)
        if (savedInstanceState != null) {
            System.out.println("SAVED_INSTANCESTATE --> " + savedInstanceState);

            mHelloTextView.setTextColor(savedInstanceState.getInt("color"));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        // save the current text color
        outState.putInt("color", mHelloTextView.getCurrentTextColor());
    }

    public void changeColor(View view) {
        System.out.println("CHANGING THE COLOR!");

        String colorName = mColorArray[random.nextInt(mColorArray.length)];

        int colorResourceName = getResources().getIdentifier(colorName,
                "color", getApplicationContext().getPackageName());


        int colorRes = ContextCompat.getColor(this, colorResourceName);

        mHelloTextView.setTextColor(colorRes); //setting the color...
    }
}

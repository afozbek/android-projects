package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mWebSiteEditText;
    private EditText mLocationEditText;
    private EditText mShareEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mWebSiteEditText = findViewById(R.id.website_editText);
        mLocationEditText = findViewById(R.id.location_editText);
        mShareEditText = findViewById(R.id.share_editText);
    }

    public void openWebsite(View view) {
        String url = mWebSiteEditText.getText().toString();

        Uri webPage = Uri.parse(url);

        Intent urlIntent = new Intent(Intent.ACTION_VIEW, webPage);

        if(urlIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(urlIntent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }

    public void openLocation(View view) {
        // Get the string indicating a location. Input is not validated; it is
        // passed to the location handler intact.
        String location = mLocationEditText.getText().toString();

        // Parse the location and create the intent.
        Uri addressUri = Uri.parse("geo:0,0?q=" + location);
        Intent locationIntent = new Intent(Intent.ACTION_VIEW, addressUri);

        // Find an activity to handle the intent, and start that activity.
        if (locationIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(locationIntent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void shareText(View view) {
        String txt = mShareEditText.getText().toString();

        String mimeType = "text/plain";

        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(txt)
                .startChooser();
    }
}

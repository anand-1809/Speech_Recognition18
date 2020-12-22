package com.example.speechrecognition;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.ActivityNotFoundException;


import android.content.Intent;
import android.speech.RecognizerIntent;
import android.widget.TextView;
import android.view.View;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 100;
    private TextView textOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textOutput = (TextView) findViewById(R.id.textOutput);

    }

//This method is called with the button is pressed//

    public void onClick(View v)

//Create an Intent with “RecognizerIntent.ACTION_RECOGNIZE_SPEECH” action//

    {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        try {

//Start the Activity and wait for the response//

            startActivityForResult(intent, REQUEST_CODE);
        } catch (ActivityNotFoundException a) {

        }
    }

    @Override

//Handle the results//

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQUEST_CODE: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    textOutput.setText(result.get(0));
                }
                break;
            }

        }
    }
}
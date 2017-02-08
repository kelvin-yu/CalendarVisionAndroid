package com.example.joemi.enghacks;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.R.attr.value;

public class DatainpActivity extends AppCompatActivity {

    static SharedPreferences sharedPref;
    EditText title, location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_datainp);

        Button nextButton = (Button)findViewById(R.id.nextButton);
        title = (EditText)findViewById(R.id.eventNameTB);
        location = (EditText)findViewById(R.id.locTB);

        sharedPref = PreferenceManager.getDefaultSharedPreferences(DatainpActivity.this);
        title.setText(sharedPref.getString("title", ""));
        location.setText(sharedPref.getString("location", ""));

        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("title", title.getText().toString());
                editor.putString("location", location.getText().toString());
                editor.commit();

                Intent myIntent = new Intent(DatainpActivity.this, DatePickerActivity.class);
                myIntent.putExtra("key", value); //Optional parameters
                DatainpActivity.this.startActivity(myIntent);
            }
        });

    }

}

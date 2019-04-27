package com.example.sandhyareddy.quickbilling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ArrayDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       EditText editText;
        setContentView(R.layout.activity_array_display);
        editText=findViewById(R.id.editText);
        String s=LoginActivity.itemslist[0];
        editText.setText(s);

    }

}

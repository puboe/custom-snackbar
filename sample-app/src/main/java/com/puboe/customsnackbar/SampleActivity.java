package com.puboe.customsnackbar;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.puboe.snackbar.CustomSnackbar;


public class SampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
    }

    public void openCustomSnackbar(View view) {
        CustomSnackbar.make(view, "Hola", Snackbar.LENGTH_INDEFINITE).show();
    }
}

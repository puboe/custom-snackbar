package com.puboe.customsnackbar;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.puboe.snackbar.CustomSnackbar;


public class SampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
    }

    public void showCustomSnackbar(View view) {
        CustomSnackbar.make(view, "This is a really long text to test how this snackbar looks with plenty of text to show", Snackbar.LENGTH_INDEFINITE)
                .setAction("Dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(view.getContext(), "Dismiss!", Toast.LENGTH_SHORT).show();
                    }
                })
                .setTextColor(ContextCompat.getColor(view.getContext(), R.color.light_primary_color))
                .setActionTextColor(ContextCompat.getColor(view.getContext(), R.color.accent_color))
                .setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.dark_primary_color))
                .show();
    }

    public void showCustomSnackbarWithCustomView(View view) {
        View customView = LayoutInflater.from(this).inflate(R.layout.custom_snackbar, null);
        final CustomSnackbar snackbar = CustomSnackbar.make(view, customView, Snackbar.LENGTH_INDEFINITE);
        ImageView dismiss = (ImageView) customView.findViewById(R.id.snackbar_dismiss_button);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snackbar.dismiss();
            }
        });
        snackbar.show();
    }
}

package com.minneh.minnehkiosk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import butterknife.Bind;

public class CoffeeActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String TAG = CoffeeActivity.class.getSimpleName();

    @Bind(R.id.whiteNumberPicker) NumberPicker mWhiteNumberPicker;
    @Bind(R.id.whiteCoffeeButton) Button mWhiteButton;
    @Bind(R.id.blackNumberPicker) NumberPicker mBlackNumberPicker;
    @Bind(R.id.blackCoffeeButton) EditText mBlackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);


    }

}

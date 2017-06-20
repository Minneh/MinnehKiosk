package com.minneh.minnehkiosk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.enterButton) Button mEnterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mEnterButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v == mEnterButton){
            Log.d(TAG, "Enter Button Clicked");
            Intent intent = new Intent(MainActivity.this, ProductsActivity.class);
            startActivity(intent);

            Toast.makeText(getApplicationContext(), "Entering Kiosk", Toast.LENGTH_SHORT).show();
        }
    }
}

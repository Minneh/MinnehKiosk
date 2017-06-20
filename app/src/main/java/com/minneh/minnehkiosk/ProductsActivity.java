package com.minneh.minnehkiosk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ProductsActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.coffeeButton) Button mCoffeeButton;
    @Bind(R.id.airtimeButton) TextView mAirtimeButton;
    @Bind(R.id.gumButton) TextView mGumButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        ButterKnife.bind(this);

        mCoffeeButton.setOnClickListener(this);
        mAirtimeButton.setOnClickListener(this);
        mGumButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mCoffeeButton) {
            Intent intent = new Intent(ProductsActivity.this, CoffeeActivity.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Order Coffee", Toast.LENGTH_SHORT).show();
        }
        if (v == mAirtimeButton) {
            Intent intent = new Intent(ProductsActivity.this, AirtimeActivity.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Order Airtime", Toast.LENGTH_SHORT).show();
        }
        if (v == mGumButton) {
            Intent intent = new Intent(ProductsActivity.this, GumActivity.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Order Gum", Toast.LENGTH_SHORT).show();
        }
    }

}

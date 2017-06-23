package com.minneh.minnehkiosk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CoffeeActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String TAG = CoffeeActivity.class.getSimpleName();
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mWhiteDatabaseReference;
    private DatabaseReference mBlackDatabaseReference;
    private Order mOrder;
    private final int mWhitePrice = 20;
    private final int mBlackPrice = 10;

    @Bind(R.id.white_coffee_edit_text) EditText mWhiteEditText;
    @Bind(R.id.whiteCoffeeButton) Button mWhiteButton;
    @Bind(R.id.black_coffee_edit_text) EditText mBlackEditText;
    @Bind(R.id.blackCoffeeButton) Button mBlackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);
        ButterKnife.bind(this);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mWhiteDatabaseReference = mFirebaseDatabase.getReference().child(Constants.FIREBASE_CHILD_WHITE_ORDERS);
        mBlackDatabaseReference = mFirebaseDatabase.getReference().child(Constants.FIREBASE_CHILD_BLACK_ORDERS);


        mWhiteButton.setOnClickListener(this);
        mBlackButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == mWhiteButton) {
            String whiteNumber = mWhiteEditText.getText().toString();
            Log.d("TAG: ", whiteNumber);
            Log.e("LOGGING REFERENCE",""+mWhiteDatabaseReference );
            saveWhiteToFirebase(whiteNumber);

        }
        if (view == mBlackButton) {
            String blackNumber = mBlackEditText.getText().toString();
            Log.d("TAG: ", blackNumber);
            saveBlackToFirebase(blackNumber);

        }
    }

    public void saveWhiteToFirebase(String whiteNumber){
        mWhiteDatabaseReference.push().setValue(whiteNumber);
        Toast.makeText(getApplicationContext(), "Your coffee order has been placed. Thank you!", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(CoffeeActivity.this, ProductsActivity.class);
        intent.putExtra("whiteCoffee", whiteNumber);
        startActivity(intent);
        finish();

    }

    public void saveBlackToFirebase(String blackNumber){
        mBlackDatabaseReference.push().setValue(blackNumber);
        Toast.makeText(getApplicationContext(), "Your black coffee order has been placed. Thank you!", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(CoffeeActivity.this, ProductsActivity.class);
        intent.putExtra("blackCoffee", blackNumber);
        startActivity(intent);
        finish();
    }

}

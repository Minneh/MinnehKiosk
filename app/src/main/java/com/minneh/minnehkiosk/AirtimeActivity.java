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

public class AirtimeActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String TAG = AirtimeActivity.class.getSimpleName();
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mAirtimeDatabaseReference;

    @Bind(R.id.phoneEditText) EditText mPhoneEditText;
    @Bind(R.id.airtimeEditText) EditText mAirtimeEditText;
    @Bind(R.id.airtimeButton) Button mAirtimeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airtime);
        ButterKnife.bind(this);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mAirtimeDatabaseReference = mFirebaseDatabase.getReference().child(Constants.FIREBASE_CHILD_AIRTIME_ORDERS);

        mAirtimeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mAirtimeButton) {
            String airtimeNumber = mAirtimeEditText.getText().toString().trim();
            String phoneNumber = mPhoneEditText.getText().toString().trim();

            Log.d("TAG: ", airtimeNumber);
            Log.e("LOGGING REFERENCE",""+mAirtimeDatabaseReference );
            saveAirtimeToFirebase(airtimeNumber, phoneNumber);

        }
    }

    public void saveAirtimeToFirebase(String airtimeNumber, String phoneNumber){

        mAirtimeDatabaseReference.push().setValue(airtimeNumber);
        mAirtimeDatabaseReference.push().setValue(phoneNumber);
        Toast.makeText(getApplicationContext(), "Your airtime order has been placed. Thank you!", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(AirtimeActivity.this, ProductsActivity.class);
        intent.putExtra("Airtime", airtimeNumber);
        intent.putExtra("Phone number", phoneNumber);
        startActivity(intent);
        finish();

    }
}

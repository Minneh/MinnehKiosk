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

public class GumActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String TAG = GumActivity.class.getSimpleName();
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mGumDatabaseReference;

    @Bind(R.id.gumEditText) EditText mGumEditText;
    @Bind(R.id.gumButton) Button mGumButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gum);
        ButterKnife.bind(this);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mGumDatabaseReference = mFirebaseDatabase.getReference().child(Constants.FIREBASE_CHILD_GUM_ORDERS);

        mGumButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mGumButton) {
            String gumNumber = mGumEditText.getText().toString().trim();
            Log.d("TAG: ", gumNumber);
            Log.e("LOGGING REFERENCE",""+mGumDatabaseReference );
            saveGumToFirebase(gumNumber);

        }
    }

    public void saveGumToFirebase(String gumNumber){

        mGumDatabaseReference.push().setValue(gumNumber);

        Toast.makeText(getApplicationContext(), "Your order for gum has been placed. Thank you!", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(GumActivity.this, ProductsActivity.class);
        intent.putExtra("Gum", gumNumber);
        startActivity(intent);
        finish();

    }
}

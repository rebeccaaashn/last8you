//package com.example.a8you;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Button;
//
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//
//public class Trophy extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_trophy);
//
//        // Initialize and assign variable
//        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
//
//        // Set Home selected
//        //bottomNavigationView.setSelectedItemId(R.id.home);
//
//        // Perform item selected listener
//        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener(){
//
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                switch(item.getItemId())
//                {
//                    case R.id.home:
//                        startActivity(new Intent(getApplicationContext(),Home.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.dashboard:
//                        startActivity(new Intent(getApplicationContext(),HistoryActivity.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.about:
//                        startActivity(new Intent(getApplicationContext(),Profile.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                }
//                return false;
//            }
//        });
//
//        Button testBtn = (Button)findViewById(R.id.testBtn);
//
//        testBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent a = new Intent(Trophy.this, Home.class);
//                startActivity(a);
//            }
//        });
//    }
//}
package com.example.a8you;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Trophy extends AppCompatActivity {
    private ImageView goal10,goal20, newmove, perweek;
    boolean b10;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trophy);

        mDatabase = FirebaseDatabase.getInstance().getReference("Users");
        FirebaseFirestore db = FirebaseFirestore.getInstance();


        // retrieve
        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                badge badge = (badge) snapshot.child("badge").getValue();

//                badge value = snapshot.getValue(badge.class);
//                String key = snapshot.getKey();


//                userDatas.add(value);
//                mKeys.add(key);
//                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
        goal10 = (ImageView) findViewById(R.id.goal10);
        goal20 = (ImageView) findViewById(R.id.goal20);
        newmove = (ImageView) findViewById(R.id.newmove);
        perweek = (ImageView) findViewById(R.id.perweek);

        // Set Home selected
        //bottomNavigationView.setSelectedItemId(R.id.home);

        // Perform item selected listener
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),Home.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(),HistoryActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(),Profile.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

//        testbadge = (Button) findViewById(R.id.testbdg);
//        testbadge.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                badgeCheck("20");
//            }
//        });

//        Button testBtn = (Button)findViewById(R.id.testBtn);
//
//        testBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent a = new Intent(Trophy.this, Home.class);
//                startActivity(a);
//            }
//        });


    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        // we will receive data updates in onReceive method.
        @Override
        public void onReceive(Context context, Intent intent) {
            // Get extra data included in the Intent
            String message = intent.getStringExtra("badgeKey");
            // on below line we are updating the data in our text view.
//            headingTV.setText(message);
            badgeCheck(message);
        }


    };

    //    public void badgeTest(View view){
//        badgeCheck("10");
//    }
    private void badgeCheck(String message){
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference("Users");
        switch (message) {
            case "10" :
                badge  badge = new badge("10steps",true);
                goal10.setImageResource(R.drawable.movegoal10);

                // TODO: 10/1/2022  save data to database
                mDatabase.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                        .child("badge").setValue(badge);
//                db.collection("badge").document("badge").set(badge);
                b10 = true;

                break;

            case "20" :
                badge badge20 = new badge("20steps",true);
                goal20.setImageResource(R.drawable.movegoal20);
                mDatabase.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                        .child("badge").setValue(badge20);
                break;

            case "1" :
                badge newmove1 = new badge("newmove",true);
                newmove.setImageResource(R.drawable.newmove);
                mDatabase.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                        .child("badge").setValue(newmove1);
                break;

            case "perweek" :
                badge perweek = new badge("perweek",true);
                newmove.setImageResource(R.drawable.perfectweek);
                break;

            default:
        }}}

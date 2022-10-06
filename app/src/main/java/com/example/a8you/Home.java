package com.example.a8you;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.time.LocalTime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class Home extends AppCompatActivity implements SensorEventListener{

    ImageButton exersiceBtn, dietBtn, mediBtn, trophyBtn;

    TextView tv_steps;

    SensorManager sensorManager;

    boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.home);

        // Perform item selected listener
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(),HistoryActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        return true;
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(),Profile.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });


        exersiceBtn = (ImageButton) findViewById(R.id.exercise);
        exersiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e = new Intent(Home.this, Exercise.class);
                startActivity(e);
            }
        });

        mediBtn = (ImageButton) findViewById(R.id.medi);
        mediBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m = new Intent(Home.this,  Meditation.class);
                startActivity(m);
            }
        });

        dietBtn = (ImageButton) findViewById(R.id.diet);
        dietBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d = new Intent(Home.this, Diet.class);
                startActivity(d);
            }
        });

        trophyBtn = (ImageButton) findViewById(R.id.trophy);
        trophyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t = new Intent(Home.this, Trophy.class);
                startActivity(t);
            }
        });

        tv_steps = (TextView) findViewById(R.id.tv_Steps);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

    }

    @Override
    protected void onResume() {
        super.onResume();
        running = true;
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if (countSensor != null){
            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
        }
        else{
            Toast.makeText(this, "Sensor not found!", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    protected void onPause() {
        super.onPause();
        running = false;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (running) {
            tv_steps.setText(String.valueOf(sensorEvent.values[0]));
        }
        else if (running){
            tv_steps.setText(String.valueOf(sensorEvent.values[1000]));
            Toast.makeText(this, "congratulation! you have reach 1000 steps", Toast.LENGTH_SHORT).show();
        }
        else if (LocalTime.now() == LocalTime.MIDNIGHT){
            tv_steps.setText(String.valueOf(sensorEvent.values[0] + ""));
        }
        else if (LocalTime.now() == LocalTime.NOON){
            tv_steps.setText(String.valueOf(sensorEvent.values[0] + ""));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

}
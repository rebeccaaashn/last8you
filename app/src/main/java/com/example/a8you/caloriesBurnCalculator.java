//package com.example.a8you;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//
//import java.text.DecimalFormat;
//import java.text.NumberFormat;
//
//public class caloriesBurnCalculator extends AppCompatActivity {
//
//    public class CalorieBurnedCalculator {
//
//
//// Fill with your data
//
//
//        static double weight = 67.0; // kg
//
//         static double height = 178.0; // cm
//
//         static double stepsCount = 4793;
//
////Don't edit below this
//
//
//        final static double walkingFactor = 0.57;
//
//         static double CaloriesBurnedPerMile;
//
//         static double strip;
//
//         static double stepCountMile; // step/mile
//
//         static double conversationFactor;
//
//         static double CaloriesBurned;
//
//         static NumberFormat formatter = new DecimalFormat("#0.00");
//
//         static double distance;
//
//
//        public static void main(String[] args) {
//
//            CaloriesBurnedPerMile = walkingFactor * (weight * 2.2);
//
//            strip = height * 0.415;
//
//            stepCountMile = 160934.4 / strip;
//
//            conversationFactor = CaloriesBurnedPerMile / stepCountMile;
//
//            CaloriesBurned = stepsCount * conversationFactor;
//
//            System.out.println("Calories burned: "
//                    + formatter.format(CaloriesBurned) + " cal");
//
//            distance = (stepsCount * strip) / 100000;
//
//            System.out.println("Distance: " + formatter.format(distance)
//                    + " km");
//
//        }
//    }
//    }

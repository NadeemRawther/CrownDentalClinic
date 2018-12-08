package com.example.bitsi34gb.crowndentalclinic;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

/*
* its the patient activity for
* */
public class PatientActivity extends AppCompatActivity {
    Report report;
    Review review;
    Home home;


   private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
       // transaction.addToBackStack(null);
        transaction.commit();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        home = new Home();
        loadFragment(home);
// creating bottom navigation bar and its associated fragments are given here
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    loadFragment(home);
                    return true;
                case R.id.navigation_dashboard:
                    report = new Report();
                    loadFragment(report);
                    return true;
                case R.id.navigation_notifications:
                    review = new Review();
                    loadFragment(review);
                    return true;
            }

            return false;

        }
    };

}

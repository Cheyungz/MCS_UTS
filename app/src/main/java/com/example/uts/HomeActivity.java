package com.example.uts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavView;

    NewsFragment newsFragment = new NewsFragment();
    MatchFragment matchFragment = new MatchFragment();
    TransactionFragment transactionFragment = new TransactionFragment();

    Integer userId;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        userId = LoginActivity.userId;


        bottomNavView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, newsFragment).commit();

        bottomNavView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.newsFragment:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, newsFragment).commit();
                    return true;

                case R.id.matchFragment:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, matchFragment).commit();
                    return true;

                case R.id.transactionFragment:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, transactionFragment).commit();
                    return true;
            }
            return false;
        });
    }
}
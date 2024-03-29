package com.example.latihannavbarbawah;


import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.latihannavbarbawah.DatarFragment;
import com.example.latihannavbarbawah.RuangFragment;
import com.example.latihannavbarbawah.AccountFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnItemSelectedListener(navListener);

        setFragment(new DatarFragment());
    }

    private void setFragment(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame, fragment);
        transaction.commit();
    }

    private BottomNavigationView.OnItemSelectedListener navListener =
            new BottomNavigationView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    if (item.getItemId() == R.id.menu_home) {
                        selectedFragment = new DatarFragment();
                    } else if (item.getItemId() == R.id.menu_messages) {
                        selectedFragment = new RuangFragment();
                    } else if (item.getItemId() == R.id.menu_profile) {
                        selectedFragment = new AccountFragment();
                    }

                    setFragment(selectedFragment);

                    return true;
                }
            };
}